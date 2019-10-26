package at.o2xfs.xfs;

import at.o2xfs.memory.databind.MemoryMapper;
import at.o2xfs.memory.impl.win32.Win32MemorySystem;

public abstract class BaseIT {

	protected final Win32MemorySystem memorySystem;
	protected final MemoryMapper mapper;

	public BaseIT() {
		memorySystem = Win32MemorySystem.INSTANCE;
		mapper = new MemoryMapper();
	}
}
