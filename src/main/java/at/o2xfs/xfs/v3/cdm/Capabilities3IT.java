package at.o2xfs.xfs.v3.cdm;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.v3.BaseIT;

public class Capabilities3IT extends BaseIT {

	@Test
	public void test() {
		Address address = Address.build(createDefault());
		Capabilities3 actual = mapper.read(memorySystem.dereference(address), Capabilities3.class);
		System.out.println(actual);
	}

	private native byte[] createDefault();
}
