package at.o2xfs.xfs.v3_10.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.v3_10.Base310IT;

public class PowerSaveControl310IT extends Base310IT {

	@Test
	public void test() {
		PowerSaveControl310 expected = new PowerSaveControl310.Builder().maxPowerSaveRecoveryTime(10).build();
		Address address = Address.build(createDefault());
		PowerSaveControl310 actual = mapper.read(memorySystem.dereference(address), PowerSaveControl310.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
