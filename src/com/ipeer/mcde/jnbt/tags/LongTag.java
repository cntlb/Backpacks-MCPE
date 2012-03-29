package com.ipeer.mcde.jnbt.tags;

public class LongTag extends Tag {

	private final long value;
	
	public LongTag(String name, long value) {
		super(name);
		this.value = value;
	}

	@Override
	public Long getValue() {
		return value;
	}

	@Override
	public int getID() {
		return TAG_Long;
	}
	
	@Override
	public String toString() {
		return Long.toString(value);
	}

}
