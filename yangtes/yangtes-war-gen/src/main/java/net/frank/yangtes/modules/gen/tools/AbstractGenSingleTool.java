package net.frank.yangtes.modules.gen.tools;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.frank.yangtes.commons.utils.StringUtils;
import net.frank.yangtes.modules.gen.entity.GenConfig;
import net.frank.yangtes.modules.gen.entity.GenScheme;
import net.frank.yangtes.modules.gen.entity.GenTable;
import net.frank.yangtes.modules.gen.entity.GenTableColumn;
import net.frank.yangtes.modules.gen.entity.GenTemplate;
import net.frank.yangtes.modules.gen.service.GenTableService;
import net.frank.yangtes.modules.gen.util.GenUtils;
import net.frank.yangtes.modules.sys.entity.Area;
import net.frank.yangtes.modules.sys.entity.Office;
import net.frank.yangtes.modules.sys.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({ @ContextConfiguration(name = "parent", locations = "classpath:spring/spring-context.xml") })
public abstract class AbstractGenSingleTool {
	
	
protected transient Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private GenTableService genTableService;
	
	public abstract String getGenTableName();
	
	public abstract String getCategory();
	
	public abstract String getFunctionAuthor();
	
	public abstract String getPakcageName();
	
	public abstract String getModuleName();
	
	public abstract String[] getListFields();
	
	public abstract String[] getQueryFields();
	
	
	protected void generate(){
		
		
		GenTable queryGenTable = new GenTable();
		queryGenTable.setName(getGenTableName());
		List<GenTable> tableList = genTableService.findTableListFormDb(queryGenTable);
		
		
		
		
		if(tableList!=null 
				&& !tableList.isEmpty()){
			log.info(tableList.size() + "");
			GenTable genTable = tableList.get(0);
			genTable = genTableService.getTableFormDb(genTable);
			if(genTable.getColumnList()!=null && 
					!genTable.getColumnList().isEmpty()){
				for(int j=0;j<genTable.getColumnList().size();j++){
					GenTableColumn column = genTable.getColumnList().get(j);
					fillColumn(column,genTable);
					log.info(
						column.getSimpleJavaType());
				}
				GenScheme scheme = new GenScheme();
				scheme.setCategory(getCategory()); //
				scheme.setFlag("1");
				scheme.setDelFlag("0");
				scheme.setFunctionAuthor(getFunctionAuthor());
				scheme.setPackageName(getPakcageName());
				scheme.setModuleName(getModuleName());
				scheme.setSubModuleName("");
				scheme.setFunctionName(genTable.getComments());
				scheme.setFunctionNameSimple(genTable.getComments());
				scheme.setGenTable(genTable);
				scheme.setReplaceFile(Boolean.TRUE);
				try{
					generateCode(scheme);
				}catch(Exception e){
					log.error("Generat Error, the table is " + genTable.getName(),e);
				}
			}
		}else{
			log.error("Generat Error, the table["+getGenTableName()+"] not exists.");
		}
	}
	
	protected void fillColumn(GenTableColumn column,GenTable genTable){
		column.setGenTable(genTable);
		// 设置字段说明
		if (StringUtils.isBlank(column.getComments())){
			column.setComments(column.getName());
		}
		// 设置java类型
		if (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "CHAR")
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "VARCHAR")
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "NARCHAR")
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "TEXT")){
			column.setJavaType("String");
			column.setShowType("input");
		}else if (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "DATETIME")
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "DATE")
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "TIMESTAMP")){
			column.setJavaType("java.util.Date");
			column.setShowType("dateselectYmd");
		}else if (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "BIGINT")
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "INT")
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "NUMBER")
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "DECIMAL")
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "TINYINT") 
				|| StringUtils.startsWithIgnoreCase(column.getJdbcType(), "SMALLINT") ){
			// 如果是浮点型
			String[] ss = StringUtils.split(StringUtils.substringBetween(column.getJdbcType(), "(", ")"), ",");
			if (ss != null && ss.length == 2 && Integer.parseInt(ss[1])>0){
				column.setJavaType("BigDecimal");
			}
			// 如果是整形
			else if (ss != null && ss.length == 1 && Integer.parseInt(ss[0])<=10){
				if(Integer.parseInt(ss[0])<=3){
					column.setJavaType("Byte");
				}else{
					column.setJavaType("Integer");
				}
			}
			// 长整形
			else{
				column.setJavaType("Long");
			}
			column.setShowType("input");
		}
		// 设置java字段名
		column.setJavaField(StringUtils.toCamelCase(column.getName()));
		
		// 是否是主键
		column.setIsPk(genTable.getPkList().contains(column.getName())?"1":"0");

		// 插入字段
		column.setIsInsert("1");
		
		// 编辑字段
		if (!StringUtils.equalsIgnoreCase(column.getName(), "id")
				&& !StringUtils.equalsIgnoreCase(column.getName(), "create_by")
				&& !StringUtils.equalsIgnoreCase(column.getName(), "create_date")
				&& !StringUtils.equalsIgnoreCase(column.getName(), "del_flag")){
			column.setIsEdit("1");
		}
		
		if(ArrayUtils.contains(getListFields(), column.getName())){
			column.setIsList("1");
		}
		
		if(ArrayUtils.contains(getQueryFields(), column.getName())){
			column.setIsList("1");
		}
		// 查询字段类型
		if (ArrayUtils.contains(getQueryFields(), column.getName())){
			if(StringUtils.equalsIgnoreCase(column.getName(), "name")
				|| StringUtils.equalsIgnoreCase(column.getName(), "title")){
				column.setQueryType("like");
			}else{
				column.setQueryType("=");
			}
		}

		// 设置特定类型和字段名
		
		// 用户
		if (StringUtils.startsWithIgnoreCase(column.getName(), "user_id")){
			column.setJavaType(User.class.getName());
			column.setJavaField(column.getJavaField().replaceAll("Id", ".id|name"));
			column.setShowType("userselect");
		}
		// 部门
		else if (StringUtils.startsWithIgnoreCase(column.getName(), "office_id")){
			column.setJavaType(Office.class.getName());
			column.setJavaField(column.getJavaField().replaceAll("Id", ".id|name"));
			column.setShowType("officeselect");
		}
		// 区域
		else if (StringUtils.startsWithIgnoreCase(column.getName(), "area_id")){
			column.setJavaType(Area.class.getName());
			column.setJavaField(column.getJavaField().replaceAll("Id", ".id|name"));
			column.setShowType("areaselect");
		}
		// 创建者、更新者
		else if (StringUtils.startsWithIgnoreCase(column.getName(), "create_by")
				|| StringUtils.startsWithIgnoreCase(column.getName(), "update_by")){
			column.setJavaType(User.class.getName());
			column.setJavaField(column.getJavaField() + ".id");
		}
		// 创建时间、更新时间
		else if (StringUtils.startsWithIgnoreCase(column.getName(), "create_date")
				|| StringUtils.startsWithIgnoreCase(column.getName(), "update_date")){
			column.setShowType("dateselect");
		}
		// 备注、内容
		else if (StringUtils.equalsIgnoreCase(column.getName(), "remarks")
				|| StringUtils.equalsIgnoreCase(column.getName(), "content")){
			column.setShowType("textarea");
		}
		// 父级ID
		else if (StringUtils.equalsIgnoreCase(column.getName(), "parent_id")){
			column.setJavaType("This");
			column.setJavaField("parent.id|name");
			column.setShowType("treeselect");
		}
		// 所有父级ID
		else if (StringUtils.equalsIgnoreCase(column.getName(), "parent_ids")){
			column.setQueryType("like");
		}
		// 删除标记
		else if (StringUtils.equalsIgnoreCase(column.getName(), "del_flag")){
			column.setShowType("radiobox");
			column.setDictType("del_flag");
		}
	}
	
	protected String generateCode(GenScheme genScheme){
		StringBuilder result = new StringBuilder();
		GenConfig config = GenUtils.getConfig();
		List<GenTemplate> templateList = GenUtils.getTemplateList(config, genScheme.getCategory(), false);
		// 生成主表模板代码
		genScheme.setGenTable(genScheme.getGenTable());
		Map<String, Object> model = GenUtils.getDataModel(genScheme);
		for (GenTemplate tpl : templateList){
			result.append(GenUtils.generateToFile(tpl, model, genScheme.getReplaceFile()));
		}
		return result.toString();
	}
	
}
