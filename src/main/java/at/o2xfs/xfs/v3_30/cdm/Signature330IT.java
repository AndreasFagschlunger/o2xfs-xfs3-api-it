package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.v3_30.Base330IT;

public class Signature330IT extends Base330IT {

	@Test
	public void test() {
		Signature330 expected = new Signature330.Builder().data("TEST".getBytes()).build();
		Address address = Address.build(createDefault());
		Signature330 actual = mapper.read(memorySystem.dereference(address), Signature330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
