package net.frank.yangtes.modules.gen.tools;

import org.junit.Test;


public class SimpleYangtesGenTool extends AbstractGenTool {

	@Override
	public String getGenTablePrefix() {
		return "bank_entp";
	}

	@Override
	public String getCategory() {
		return "yangtes";
	}

	@Override
	public String getFunctionAuthor() {
		return "heinqiDev";
	}

	@Override
	public String getPakcageName() {
		return "com.heinqi.yangtes.demo";
	}

	@Override
	public String getModuleName() {
		return "entp";
	}
	
	@Test
	public void initProjectCode(){
		generate();
	}
	
}
