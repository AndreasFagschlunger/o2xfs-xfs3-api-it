package at.o2xfs.xfs.v3_30.cdm;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.v3_30.Base330IT;

public class BlacklistElement330IT extends Base330IT {

	@Test
	public void test() {
		Address address = Address.build(createDefault());
		BlacklistElement330 actual = mapper.read(memorySystem.dereference(address), BlacklistElement330.class);
		System.out.println(actual);
	}

	private native byte[] createDefault();

}
