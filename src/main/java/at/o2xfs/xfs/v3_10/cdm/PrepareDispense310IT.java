package at.o2xfs.xfs.v3_10.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.Action;
import at.o2xfs.xfs.v3_10.Base310IT;

public class PrepareDispense310IT extends Base310IT {

	@Test
	public void test() {
		PrepareDispense310 expected = new PrepareDispense310.Builder().action(Action.START).build();
		Address address = Address.build(createDefault());
		PrepareDispense310 actual = mapper.read(memorySystem.dereference(address), PrepareDispense310.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
