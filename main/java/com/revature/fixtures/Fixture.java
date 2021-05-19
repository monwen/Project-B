package com.revature.fixtures;

public class Fixture {
	private String name;
	private String shortDescription;
	private String longDescription;
	
	Fixture(){
		super();
	}
	
	Fixture(String name, String s, String l){
		this.name = name;
		this.shortDescription = s;
		this.longDescription = l;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	public String getLongDescription() {
		return this.longDescription;
	}
	

	@Override
	public String toString() {
		return "Fixture [name=" + name + ", shortDescription=" + shortDescription + ", longDescription="
				+ longDescription + "]";
	}
	
	
}
