package com.ipeer.mcde.ipeer.nbt;

import com.ipeer.mcde.jnbt.tags.ByteArrayTag;
import com.ipeer.mcde.jnbt.tags.ByteTag;
import com.ipeer.mcde.jnbt.tags.CompoundTag;
import com.ipeer.mcde.jnbt.tags.DoubleTag;
import com.ipeer.mcde.jnbt.tags.EndTag;
import com.ipeer.mcde.jnbt.tags.FloatTag;
import com.ipeer.mcde.jnbt.tags.IntArrayTag;
import com.ipeer.mcde.jnbt.tags.IntTag;
import com.ipeer.mcde.jnbt.tags.ListTag;
import com.ipeer.mcde.jnbt.tags.LongTag;
import com.ipeer.mcde.jnbt.tags.ShortTag;
import com.ipeer.mcde.jnbt.tags.StringTag;
import com.ipeer.mcde.jnbt.tags.Tag;

public class NBTUtil {

	public NBTUtil () { }
	
	public static Class<? extends Tag> getType(int type) {
		switch (type) {
			case 0:
				return EndTag.class;
			case 1:
				return ByteTag.class;
			case 2:
				return ShortTag.class;
			case 3:
				return IntTag.class;
			case 4:
				return LongTag.class;
			case 5:
				return FloatTag.class;
			case 6:
				return DoubleTag.class;
			case 7:
				return ByteArrayTag.class;
			case 8:
				return StringTag.class;
			case 9:
				return ListTag.class;
			case 10:
				return CompoundTag.class;
			case 11:
				return IntArrayTag.class;
			default:
				throw new IllegalArgumentException("Unknown tag type "+type);
		}
	}

	public static String getType(Class<? extends Tag> clazz) {
		if(clazz.equals(ByteArrayTag.class))
			return "TAG_Byte_Array";
		else if(clazz.equals(ByteTag.class))
			return "TAG_Byte";
		else if(clazz.equals(CompoundTag.class))
			return "TAG_Compound";
		else if(clazz.equals(DoubleTag.class))
			return "TAG_Double";
		else if(clazz.equals(EndTag.class))
			return "TAG_End";
		else if(clazz.equals(FloatTag.class))
			return "TAG_Float";
		else if(clazz.equals(IntTag.class))
			return "TAG_Int";
		else if(clazz.equals(ListTag.class))
			return "TAG_List";
		else if(clazz.equals(LongTag.class))
			return "TAG_Long";
		else if(clazz.equals(ShortTag.class))
			return "TAG_Short";
		else if(clazz.equals(StringTag.class))
			return "TAG_String";
		else 
			throw new IllegalArgumentException("Invalid tag class (" + clazz.getName() + ").");
		
	}
	
}
