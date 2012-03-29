package com.ipeer.mcde.ipeer.nbt.tags;

public class StringTag extends Tag {

	private final String value;
	
	public StringTag(String name, String value) {
		super(name);
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public int getID() {
		return TAG_String;
	}
	
	@Override
	public String toString() {
		return new String(value);
	}

}
