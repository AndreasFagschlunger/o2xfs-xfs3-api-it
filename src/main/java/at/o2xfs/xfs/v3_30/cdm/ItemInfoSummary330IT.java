package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.Level;
import at.o2xfs.xfs.v3_30.Base330IT;

public class ItemInfoSummary330IT extends Base330IT {

	@Test
	public void test() {
		ItemInfoSummary330 expected = new ItemInfoSummary330.Builder().level(Level.LEVEL_3).numOfItems(3).build();
		Address address = Address.build(createDefault());
		ItemInfoSummary330 actual = mapper.read(memorySystem.dereference(address), ItemInfoSummary330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
