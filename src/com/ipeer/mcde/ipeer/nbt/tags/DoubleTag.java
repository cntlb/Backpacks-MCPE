package com.ipeer.mcde.ipeer.nbt.tags;

public class DoubleTag extends Tag {

	private final double value;
	
	public DoubleTag(String name, double value) {
		super(name);
		this.value = value;
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public int getID() {
		return TAG_Double;
	}
	
	@Override
	public String toString() {
		return Double.toString(value);
	}

}
