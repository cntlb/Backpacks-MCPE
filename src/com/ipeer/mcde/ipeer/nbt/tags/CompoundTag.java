package com.ipeer.mcde.ipeer.nbt.tags;

import java.util.Collections;
import java.util.Map;

public class CompoundTag extends Tag {
	
	private final Map<String, Tag> value;

	public CompoundTag(String name, Map<String, Tag> value) {
		super(name);
		this.value = Collections.unmodifiableMap(value);
	}

	@Override
	public Map<String, Tag> getValue() {
		return value;
	}

	@Override
	public int getID() {
		return TAG_Compound;
	}

	@Override
	public String toString() {
		String name = getName();
		String str = "";
		StringBuilder s = new StringBuilder();
		if (name != null && !name.equals(""))
			str = "( "+this.getName()+" ) ";
		s.append("TAG_COMPOUND "+str+": "+value.size() + " entries \r\n{\r\n");
		for (Map.Entry<String, Tag> t : value.entrySet()) {
			s.append("\t"+t.getValue().getName()+"="+t.getValue().toString().replaceAll("\r\n","\r\n\t") + "\r\n");
		}
		s.append("}");
		return s.toString();
	}
	

}
