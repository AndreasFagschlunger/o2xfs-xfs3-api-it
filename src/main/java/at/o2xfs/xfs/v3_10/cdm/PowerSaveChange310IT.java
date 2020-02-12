package at.o2xfs.xfs.v3_10.cdm;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.v3_10.Base310IT;

public class PowerSaveChange310IT extends Base310IT {

	@Test
	public void test() {
		Address address = Address.build(createDefault());
		PowerSaveChange310 actual = mapper.read(memorySystem.dereference(address), PowerSaveChange310.class);
		System.out.println(actual);
	}

	private native byte[] createDefault();

}