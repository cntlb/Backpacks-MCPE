package com.ipeer.mcde.ipeer.nbt.tags;

public final class EndTag extends Tag {

	public EndTag() {
		super("");
	}
	
	public final Object getValue() {
		return null;
	}

	@Override
	public int getID() {
		return TAG_End;
	}

}
