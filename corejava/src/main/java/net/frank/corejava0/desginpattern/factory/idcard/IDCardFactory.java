package net.frank.corejava0.desginpattern.factory.idcard;

import java.util.ArrayList;
import java.util.List;

import net.frank.corejava0.desginpattern.factory.framework.Factory;
import net.frank.corejava0.desginpattern.factory.framework.Product;

public class IDCardFactory extends Factory {
	public List<String> owners = new ArrayList<String>();
	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}

	@Override
	protected void registerProduct(Product product) {
		owners.add(((IDCard)product).getOwner());
	}
	
	public List<String> getOwners(){
		return owners;
	}
}
