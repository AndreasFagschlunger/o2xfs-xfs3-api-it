package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.v3.Base3IT;

public class CountsChanged3IT extends Base3IT {

	@Test
	public void test() {
		CountsChanged3 expected = new CountsChanged3.Builder().cashUnitNumbers(1, 2, 3).build();
		Address address = Address.build(createDefault());
		CountsChanged3 actual = mapper.read(memorySystem.dereference(address), CountsChanged3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
