package at.o2xfs.xfs.v3_20.cdm;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.v3_20.Base320IT;

public class Capabilities320IT extends Base320IT {

	@Test
	public void test() {
		Address address = Address.build(createDefault());
		Capabilities320 actual = mapper.read(memorySystem.dereference(address), Capabilities320.class);
		System.out.println(actual);
	}

	private native byte[] createDefault();

}