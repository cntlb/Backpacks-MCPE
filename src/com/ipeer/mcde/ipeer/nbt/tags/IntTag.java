package com.ipeer.mcde.ipeer.nbt.tags;

public class IntTag extends Tag {
	
	private final int value;

	public IntTag(String name, int value) {
		super(name);
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public int getID() {
		return TAG_Int;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}

}
