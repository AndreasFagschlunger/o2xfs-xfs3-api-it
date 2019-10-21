package at.o2xfs.xfs.v3_10;

import at.o2xfs.common.Library;
import at.o2xfs.memory.databind.MemoryMapper;
import at.o2xfs.memory.impl.win32.Win32MemorySystem;

public abstract class Base310IT {

	static {
		Library.loadLibrary("o2xfs-xfs310-api-it");
	}

	protected final Win32MemorySystem memorySystem;
	protected final MemoryMapper mapper;

	public Base310IT() {
		memorySystem = Win32MemorySystem.INSTANCE;
		mapper = new MemoryMapper();
	}

}
