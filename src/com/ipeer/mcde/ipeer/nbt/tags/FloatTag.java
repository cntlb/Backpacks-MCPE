package com.ipeer.mcde.ipeer.nbt.tags;

public class FloatTag extends Tag {
	
	private final float value;

	public FloatTag(String name, float value) {
		super(name);
		this.value = value;
	}

	@Override
	public Float getValue() {
		return value;
	}

	@Override
	public int getID() {
		return TAG_Float;
	}
	
	@Override
	public String toString() {
		return Float.toString(value);
	}

}
