package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Level;
import at.o2xfs.xfs.v3_30.Base330IT;

public class GetAllItemsInfo330IT extends Base330IT {

	@Test
	public void test() {
		GetAllItemsInfo330 expected = new GetAllItemsInfo330.Builder().level(Level.LEVEL_2).build();
		Address address = Address.build(createDefault());
		GetAllItemsInfo330 actual = mapper.read(memorySystem.dereference(address), GetAllItemsInfo330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
