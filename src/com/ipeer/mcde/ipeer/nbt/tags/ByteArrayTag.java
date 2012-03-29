package com.ipeer.mcde.ipeer.nbt.tags;

public class ByteArrayTag extends Tag {

	private final byte[] value;
	
	public ByteArrayTag(String name, byte[] value) {
		super(name);
		this.value = value;
	}

	@Override
	public byte[] getValue() {
		return value;
	}

	@Override
	public int getID() {
		return TAG_Byte_Array;
	}

}
