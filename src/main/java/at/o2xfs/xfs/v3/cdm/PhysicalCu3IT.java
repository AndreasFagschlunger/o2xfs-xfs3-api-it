package at.o2xfs.xfs.v3.cdm;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.v3.Base3IT;

public class PhysicalCu3IT extends Base3IT {

	@Test
	public void test() {
		Address address = Address.build(createDefault());
		PhysicalCu3 actual = mapper.read(memorySystem.dereference(address), PhysicalCu3.class);
		System.out.println(actual);
	}

	private native byte[] createDefault();

}
