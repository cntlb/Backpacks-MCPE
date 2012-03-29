package com.ipeer.mcde.ipeer.nbt.tags;

public class ByteTag extends Tag {

	private final byte value;
	
	public ByteTag(String name, byte value) {
		super(name);
		this.value = value;
	}
	
	@Override
	public Byte getValue() {
		return value;
	}
	
	public int getID() {
		return TAG_Byte;
	}
	
	@Override
	public String toString() {
		return Byte.toString(value);
	}
	
}
