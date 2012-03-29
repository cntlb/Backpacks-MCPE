package com.ipeer.mcde.jnbt.tags;

import java.util.Collections;
import java.util.List;

import com.ipeer.mcde.ipeer.nbt.NBTUtil;

public class ListTag extends Tag {
	
	private final List<Tag> value;
	private final Class<? extends Tag> type;

	public ListTag(String name, Class<? extends Tag> type, List<Tag> value) {
		super(name);
		this.value = Collections.unmodifiableList(value);
		this.type = type;
	}

	@Override
	public List<Tag> getValue() {
		return value;
	}
	
	public Class<? extends Tag> getType() {
		return type;
	}

	@Override
	public int getID() {
		return TAG_List;
	}
	
	@Override
	public String toString() {
		String name = getName();
		String str = "";
		StringBuilder s = new StringBuilder();
		if (!name.equals("") && name != null)
			name = "( "+this.getName()+" )";
		s.append("TAG_LIST "+str+" : "+value.size()+" entries of type "+NBTUtil.getType(type)+"\r\n{\r\n");
		for (Tag t : value) {
			s.append("\t"+(t.getName() != null && !t.getName().equals("") ? t.getName()+"=" : "")+t.toString().replaceAll("\r\n","\r\n\t")+"\r\n");
		}
		s.append("}");
		return s.toString();
	}

}
