package at.o2xfs.xfs.v3_20.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3_20.Base320IT;

public class ItemNumber320IT extends Base320IT {

	@Test
	public void test() {
		ItemNumber320 expected = new ItemNumber320.Builder().currencyId(StandardCurrencyIds.EUR).values(100).release(1)
				.count(1234).number(4).build();
		Address address = Address.build(createDefault());
		ItemNumber320 actual = mapper.read(memorySystem.dereference(address), ItemNumber320.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
