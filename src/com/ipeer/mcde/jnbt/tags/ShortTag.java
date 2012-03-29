package com.ipeer.mcde.jnbt.tags;

public class ShortTag extends Tag {

	private final short value;
	
	public ShortTag(String name, short value) {
		super(name);
		this.value = value;
	}

	@Override
	public Short getValue() {
		return value;
	}

	@Override
	public int getID() {
		return TAG_Int;
	}
	
	@Override
	public String toString() {
		return Short.toString(value);
	}

}
