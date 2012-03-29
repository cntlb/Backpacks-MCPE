package com.ipeer.mcde.ipeer.nbt;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import com.ipeer.mcde.ipeer.nbt.tags.ByteArrayTag;
import com.ipeer.mcde.ipeer.nbt.tags.ByteTag;
import com.ipeer.mcde.ipeer.nbt.tags.CompoundTag;
import com.ipeer.mcde.ipeer.nbt.tags.DoubleTag;
import com.ipeer.mcde.ipeer.nbt.tags.EndTag;
import com.ipeer.mcde.ipeer.nbt.tags.FloatTag;
import com.ipeer.mcde.ipeer.nbt.tags.IntTag;
import com.ipeer.mcde.ipeer.nbt.tags.ListTag;
import com.ipeer.mcde.ipeer.nbt.tags.LongTag;
import com.ipeer.mcde.ipeer.nbt.tags.ShortTag;
import com.ipeer.mcde.ipeer.nbt.tags.StringTag;
import com.ipeer.mcde.ipeer.nbt.tags.Tag;

public class NBTInputStream implements Closeable {
	
	DataInputStream in;

	public NBTInputStream(InputStream in) throws IOException {
		this.in = new DataInputStream(new GZIPInputStream(in));
	}
	
	public Tag readTag() throws IOException {
		return readTag(0);
	}
	
	public Tag readTag(int d) throws IOException {
		int type = in.readByte() & 0xFF;
		String tagName;
		if (type != Tag.TAG_End) {
			int nameLen = in.readShort() & 0xFFFF;
			byte[] bytes = new byte[nameLen];
			in.readFully(bytes);
			tagName = new String(bytes, Tag.CHARSET);
		}
		else {
			tagName = "";
		}
		return readTag(type, tagName, d);
	}
	
	public Tag readTag(int type, String name, int depth) throws IOException {
		switch (type) {
		case 0: // END tag
			if (depth == 0) {
				throw new IOException("Unexpected End tag.");
			}
			else {
				return new EndTag();
			}
		case 1: // Byte
			return new ByteTag(name, in.readByte());
		case 2: // Short
			return new ShortTag(name, in.readShort());
		case 3: // Int
			return new IntTag(name, in.readInt());
		case 4: // Long
			return new LongTag(name, in.readLong());
		case 5: // Float
			return new FloatTag(name, in.readFloat());
		case 6: // Double
			return new DoubleTag(name, in.readDouble());
		case 7: // Byte Array
			int l = in.readInt();
			byte[] b = new byte[l];
			in.readFully(b);
			return new ByteArrayTag(name, b);
		case 8: // String
			short s = in.readShort();
			b = new byte[s];
			in.readFully(b);
			return new StringTag(name, new String(b, Tag.CHARSET));
		case 9: // List
			int child = in.readByte();
			l = in.readInt();
			List<Tag> t = new ArrayList<Tag>();
			for (int x = 0; x < l; x++) {
				Tag tag = readTag(child, "", depth + 1);
				if (tag instanceof EndTag)
					throw new IOException("Unexpected end tag");
				t.add(tag);	
			}
			return new ListTag(name, NBTUtil.getType(child), t);
		case 10: // Compound
			Map<String, Tag> map = new HashMap<String, Tag>();
			while (true) {
				Tag tag = readTag(depth + 1);
				if (tag instanceof EndTag)
					break;
				else
					map.put(tag.getName(), tag);
			}
			return new CompoundTag(name, map);
		default:
			throw new IOException("Invalid tag type "+type);
		}
	}

	@Override
	public void close() throws IOException {
		in.close();
	}

}
