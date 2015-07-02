package net.frank.cms.velocity;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileWriter;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.web.taglib.content.ContentConstants;

import org.apache.commons.beanutils.PropertyUtils;

public class GenerateVelocityPropertiesFiles {
	private static final String templateRootFolder = "D:/java/code/repository/src/main/resources/net/frank/repository/web/ui/vm";
	private static final String propertiesRootFolder = "D:/java/code/repository/src/main/resources/net/frank/repository/web/ui/properties";

	private static String className = "net.frank.framework.bo.Image";

	private static Integer columnNumber = 1;

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName(className);
		String fileName = className.substring(className.lastIndexOf(".")+1);
		File propertiesFile = new File(propertiesRootFolder + "/" + fileName
				+ ".properties");
		File templateFile = new File(templateRootFolder + "/" + fileName
				+ ".html");
		if (propertiesFile.exists()) {
			propertiesFile.delete();
		}
		if (templateFile.exists()) {
			templateFile.delete();
		}
		propertiesFile.createNewFile();
		templateFile.createNewFile();

		FileWriter fw = new FileWriter(propertiesFile);
		PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(clazz);
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor pd = pds[i];
			if (!isIgnoreFile(pd.getName())) {
				fw.write(className
						+ "."
						+ processKey(pd)
						+ " = "
						+ processLabel(pd) + "\n");
			}
		}
		fw.flush();
		fw.close();
		
		/***
		 * 
		 template file output format
		 * <table>
		 * <tr>
		 * <td>#properties('person.birth.day')</td>
		 * <td>#render($fieldMap.get('birthDay'),$var,$isEdit)</td>
		 * </tr>
		 * </table>
		 */
		fw = new FileWriter(templateFile);
		fw.write("<table style=\"width:100%\">\n");
		fw.write("\t<tr>\n");
		for (int i = 0; i < columnNumber * 2; i++) {
			fw.write("\t\t<td>&nbsp;</td>\n");
		}
		fw.write("\t</tr>\n");
		int j = 0;
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor pd = pds[i];
			if (!isIgnoreFile(pd.getName())) {
				if (j % columnNumber == 0) {
					fw.write("\t<tr>\n");
					fw.write("\t\t<td>" + "#properties('"+className+"."+processKey(pd)+"')" + "</td>\n");
					fw.write("\t\t<td>" + "#render($fieldMap.get('"+pd.getName()+"'),$var,$isEdit)" + "</td>\n");
				} else if (j % columnNumber == (columnNumber - 1)) {
					fw.write("\t\t<td>" + "#properties('"+className+"."+processKey(pd)+"')" + "</td>\n");
					fw.write("\t\t<td>" + "#render($fieldMap.get('"+pd.getName()+"'),$var,$isEdit)" + "</td>\n");
					fw.write("\t</tr>\n");
				} else {
					fw.write("\t\t<td>" + "#properties('"+className+"."+processKey(pd)+"')" + "</td>\n");
					fw.write("\t\t<td>" + "#render($fieldMap.get('"+pd.getName()+"'),$var,$isEdit)" + "</td>\n");
				}
				j++;
			}
		}
		while(j%columnNumber !=0){
			if (j % columnNumber == (columnNumber - 1)) {
				fw.write("\t\t<td>&nbsp;</td>\n");
				fw.write("\t\t<td>&nbsp;</td>\n");
				fw.write("\t</tr>\n");
			} else {
				fw.write("\t\t<td>&nbsp;</td>\n");
				fw.write("\t\t<td>&nbsp;</td>\n");
			}
			j++;
		}
		fw.write("\t<tr>\n");
		fw.write("\t\t<td colspan="+columnNumber+">\n");
		fw.write("\t\t\t#renderHidden('id',$var,$isEdit)\n");
		fw.write("\t\t\t#renderResource($var)\n");
		fw.write("\t\t</td>\n");
		fw.write("\t</tr>\n");
		fw.write("</table>\n");
		fw.flush();
		fw.close();
	}

	private static boolean isIgnoreFile(String field) {
		boolean isResult = false;
		for (int i = 0; i < ContentConstants.IGRONE_PROPERTY_LIST.length; i++) {
			String compareField = ContentConstants.IGRONE_PROPERTY_LIST[i];
			if (compareField.equals(field)) {
				isResult = true;
				break;
			}
		}
		return isResult;
	}

	
	
	private static String processLabel(PropertyDescriptor pd) {
		StringBuffer sb = new StringBuffer(CommonConstants.EMPTY_STRING);
		String processValue = null;
		if (pd.getPropertyType().equals(Resource.class)) {
			processValue = pd.getName().substring(0,
					pd.getName().indexOf(CommonConstants.DATA_FIELD_REFER_SYMBOL_BEG));
		} else {
			processValue = pd.getName();
		}

		char firstChar = processValue.charAt(0);
		sb.append((firstChar + CommonConstants.EMPTY_STRING).toUpperCase());
		for (int i = 1; i < processValue.length(); i++) {
			char c = processValue.charAt(i);
			if (c < 97) {
				sb.append((CommonConstants.SPACE + c + CommonConstants.EMPTY_STRING)
						.toUpperCase());
			} else {
				sb.append(c);
			}
		}
		if ("java.util.Date".equals(className)) {
			sb.append(CommonConstants.LEFT_BRACKET);
			sb.append(CommonConstants.DEFAULT_DATE_FORMAT);
			sb.append(CommonConstants.RIGHT_BRACKET);
		}
		return sb.toString();
	}
	
	private static String processKey(PropertyDescriptor pd) {
		StringBuffer sb = new StringBuffer(CommonConstants.EMPTY_STRING);
		String processValue = null;
		if (pd.getPropertyType().equals(Resource.class)) {
			processValue = pd.getName().substring(0,
					pd.getName().indexOf(CommonConstants.DATA_FIELD_REFER_SYMBOL_BEG));
		} else {
			processValue = pd.getName();
		}

		char firstChar = processValue.charAt(0);
		sb.append((firstChar + CommonConstants.EMPTY_STRING).toLowerCase());
		for (int i = 1; i < processValue.length(); i++) {
			char c = processValue.charAt(i);
			if (c < 97) {
				sb.append((CommonConstants.POINT + c + CommonConstants.EMPTY_STRING)
						.toLowerCase());
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}
}