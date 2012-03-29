package com.ipeer.mcde.jnbt.tags;

public class IntArrayTag extends Tag {
	
	private final int[] value;

	public IntArrayTag(String name, int[] value) {
		super(name);
		this.value = value;
	}

	@Override
	public int[] getValue() {
		return value;
	}

	@Override
	public int getID() {
		return TAG_Int_Array;
	}

}
