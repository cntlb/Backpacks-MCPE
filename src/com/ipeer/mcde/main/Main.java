package com.ipeer.mcde.main;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ipeer.mcde.ipeer.nbt.NBTInputStream;
import com.ipeer.mcde.ipeer.nbt.tags.ByteTag;
import com.ipeer.mcde.ipeer.nbt.tags.CompoundTag;
import com.ipeer.mcde.ipeer.nbt.tags.ShortTag;
import com.ipeer.mcde.ipeer.nbt.tags.Tag;
import com.ipeer.mcde.minecraft.items.Enchantment;
import com.ipeer.mcde.minecraft.items.Item;
import com.ipeer.mcde.minecraft.items.ItemTable;

public class Main implements Runnable {
	
	private static List<CompoundTag> playerInventory;
	private static List<Item> playerItems = new ArrayList<Item>();

	public Main() { }
	
	public static void main(String[] args) {
		if (args.length < 1)
			throw new IllegalArgumentException("Must give at least 1 argument!\n<path-to-jar>.jar \"path\\to\\level.dat\"");
		try {
			System.out.println("Reading...");
			InputStream in = new FileInputStream(args[0]);
			NBTInputStream nbt = new NBTInputStream(in);
			CompoundTag compoundTag = (CompoundTag)nbt.readTag();
			Map<String, Tag> a = compoundTag.getValue();
			loadInventory(a);
			loadPlayerItems();
		}
		catch (Exception e) {
			System.out.println("Unable to load file:");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void loadInventory(Map<String, Tag> a) {
		Tag player = a.get("Data");
		Map<String, Tag> player1 = (Map<String, Tag>)player.getValue();
		player = (Tag)player1.get("Player");
		player1 = (Map<String, Tag>)player.getValue();
		player = (Tag)player1.get("Inventory");
		playerInventory = (List<CompoundTag>)player.getValue();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void loadPlayerItems() {
		List<CompoundTag> i = playerInventory;
		List<Enchantment> eList = new ArrayList<Enchantment>();
		for (int x = 0; x < i.size(); x++) {
			eList.clear();
			Tag t = (Tag)i.get(x);
			Map<String, Tag> tag = ((Map<String, Tag>)t.getValue());
			short id = ((ShortTag)tag.get("id")).getValue();
			String name = (String)ItemTable.getItem(id);
			byte slot = ((ByteTag)tag.get("Slot")).getValue(); 
			short damage = ((ShortTag)tag.get("Damage")).getValue();
			byte count = ((ByteTag)tag.get("Count")).getValue();
			try {
				tag = (Map<String, Tag>)((Tag)tag.get("tag")).getValue();
				List enchantments = (List)((Tag)tag.get("ench")).getValue();
				for (int x1 = 0; x1 < enchantments.size(); x1++) {
					Map<String, Tag> t1 = ((Map<String, Tag>)((Tag)enchantments.get(x1)).getValue());
					short eid = ((ShortTag)t1.get("id")).getValue();
					short lvl = ((ShortTag)t1.get("lvl")).getValue();
					eList.add(new Enchantment(eid, lvl));
				}
			}
			catch (NullPointerException n) { }
			t = (Tag)tag.get("ench");
			Item item = new Item(id, name, slot, damage, count, eList);
			System.out.println(item.toString());
			playerItems.add(item);
		}
	}
	
	

	@Override
	public void run() {
		
	}

}
