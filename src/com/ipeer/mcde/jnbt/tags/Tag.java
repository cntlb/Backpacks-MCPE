package com.ipeer.mcde.jnbt.tags;

import java.nio.charset.Charset;

public abstract class Tag {

	private final String name;
	
    public static final byte TAG_End = 0;
    public static final byte TAG_Byte = 1;
    public static final byte TAG_Short = 2;
    public static final byte TAG_Int = 3;
    public static final byte TAG_Long = 4;
    public static final byte TAG_Float = 5;
    public static final byte TAG_Double = 6;
    public static final byte TAG_Byte_Array = 7;
    public static final byte TAG_String = 8;
    public static final byte TAG_List = 9;
    public static final byte TAG_Compound = 10;
    public static final byte TAG_Int_Array = 11;
    
    public static final Charset CHARSET = Charset.forName("UTF-8");
	
	public Tag(String name) {
		this.name = name;
	}
	
	public final String getName() {
		return name;
	}
	
	public abstract Object getValue();
	public abstract int getID();
	//public abstract String toString();
	
}
