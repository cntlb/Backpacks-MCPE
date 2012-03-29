package com.ipeer.mcde.minecraft.items;

import java.util.List;

public class Item {

	private final short id, damage;
	private final String name;
	private final byte count, slot;
	private final List<Enchantment> enchantments;
	
	public Item(short id, String name, byte slot, short damage, byte count, List<Enchantment> enchantments) {
		this.id = id;
		this.name = name;
		this.slot = slot;
		this.damage = damage;
		this.count = count;
		this.enchantments = enchantments;
	}
	
	public byte getCount() {
		return count;
	}
	
	public byte getSlot() {
		return slot;
	}
	
	public short getDamage() {
		return damage;
	}
	
	public String getName() {
		return name;
	}
	
	public short getID() {
		return id;
	}
	
	public List<Enchantment> getEnchantments() {
		return enchantments;
	}
	
	@Override
	public String toString() {
		String itemData = name+", I:"+id+", S:"+slot+", D:"+damage+", C:"+count;
		StringBuilder a = new StringBuilder();
		for (int x = 0; x < enchantments.size(); x++) {
			Enchantment e = enchantments.get(x);
			a.append(EnchantmentList.getEnchantment(e.getID(), e.getLvl())+"\r\n\t");
		}
		String b = a.toString();
		if (b.length() == 0)
			return itemData;
		else
			return itemData+"\r\n\t"+b;
	}
	
}
