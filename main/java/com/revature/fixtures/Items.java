package com.revature.fixtures;

public class Items extends Fixture{
	
	private boolean isInteractable;
	
	public Items() {
		super();
		this.isInteractable = false;
	}
	public Items(String name, String s, String l) {
		super(name, s, l);
		this.isInteractable = false;
	}
	public boolean isInteractable() {
		return isInteractable;
	}
	public void setInteractable(boolean isInteractable) {
		this.isInteractable = isInteractable;
	}
	@Override
	public String toString() {
		return "Items [name=" + this.getName()+ "]";
	}
}
