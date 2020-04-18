package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.ItemInfoType;
import at.o2xfs.xfs.cdm.Level;
import at.o2xfs.xfs.v3_30.Base330IT;

public class GetItemInfo330IT extends Base330IT {

	@Test
	public void test() {
		GetItemInfo330 expected = new GetItemInfo330.Builder().level(Level.LEVEL_3).index(1)
				.addItemInfoType(ItemInfoType.SIGNATURE, ItemInfoType.IMAGEFILE).build();
		Address address = Address.build(createDefault());
		GetItemInfo330 actual = mapper.read(memorySystem.dereference(address), GetItemInfo330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
