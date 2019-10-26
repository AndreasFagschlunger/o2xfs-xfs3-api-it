package at.o2xfs.xfs.v3.cdm;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.v3.Base3IT;

public class PhysicalCashUnit3IT extends Base3IT {

	@Test
	public void test() {
		Address address = Address.build(createDefault());
		PhysicalCashUnit3 actual = mapper.read(memorySystem.dereference(address), PhysicalCashUnit3.class);
		System.out.println(actual);
	}

	private native byte[] createDefault();

}
