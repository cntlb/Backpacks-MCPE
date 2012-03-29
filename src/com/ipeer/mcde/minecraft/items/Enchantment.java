package com.ipeer.mcde.minecraft.items;

public class Enchantment {

	private final short id, lvl;
	
	public Enchantment (short id, short lvl) {
		this.id = id;
		this.lvl = lvl;
	}
	
	public short getID() {
		return id;
	}
	
	public short getLvl() {
		return lvl;
	}
	

	public short getLevel() {
		return getLvl();
	}
	
}
