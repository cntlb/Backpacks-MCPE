package com.ipeer.mcde.minecraft.items;



public class EnchantmentList {

	private static final String[] numerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

	public static String getEnchantment(short id, short lvl) {
		String enchantmentName = getName(id);
		String enchantmentNumeral = numerals[lvl-1];
		return enchantmentName+" "+enchantmentNumeral;
	}

	private static String getName(short id) {
		switch (id) {
			case 0:
				return "Protection";
			case 1:
				return "Fire protection";
			case 2:
				return "Feather Falling";
			case 3:
				return "Blast protection";
			case 4:
				return "Projectile protection";
			case 5:
				return "Respiration";
			case 6:
				return "Aqua Affinity";
			case 16:
				return "Sharpness";
			case 17: 
				return "Smite";
			case 18:
				return "Bane of Arthropods";
			case 19:
				return "Knockback";
			case 20:
				return "Fire Aspect";
			case 21:
				return "Looting";
			case 32:
				return "Efficiency";
			case 33:
				return "Silk Touch";
			case 34:
				return "Unbreaking";
			case 35:
				return "Fortune";
			case 48:
				return "Power";
			case 49:
				return "Punch";
			case 50:
				return "Flame";
			case 51:
				return "Infinity";
			default:
				return "Unknown "+id;
		}
	}

}
