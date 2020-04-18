package at.o2xfs.xfs.v3_10.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.v3_10.Base310IT;

public class PowerSaveChange310IT extends Base310IT {

	@Test
	public void test() {
		PowerSaveChange310 expected = new PowerSaveChange310.Builder().powerSaveRecoveryTime(5).build();
		Address address = Address.build(createDefault());
		PowerSaveChange310 actual = mapper.read(memorySystem.dereference(address), PowerSaveChange310.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
