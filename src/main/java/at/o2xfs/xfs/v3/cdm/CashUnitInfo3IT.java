package at.o2xfs.xfs.v3.cdm;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.v3.Base3IT;

public class CashUnitInfo3IT extends Base3IT {

	@Test
	public void test() {
		Address address = Address.build(createDefault());
		CashUnitInfo3 actual = mapper.read(memorySystem.dereference(address), CashUnitInfo3.class);
		System.out.println(actual);
	}

	private native byte[] createDefault();

}
