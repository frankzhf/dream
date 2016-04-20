package net.frank.yuanbao.tortoise;

import net.frank.yuanbao.prototype.PrototypeActivty;
import net.frank.yuanbao.prototype.R;

public class MainActivty extends PrototypeActivty {
	@Override
	public int getSystemMainView() {
		return R.layout.activity_main;
	}

	@Override
	public String getDbConfig() {
		return "data/net.frank.yuanbao.tortoise/db";
	}
}
