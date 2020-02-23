package at.o2xfs.xfs.v3_20.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3_20.Base320IT;

public class ItemNumberList320IT extends Base320IT {

	@Test
	public void test() {
		ItemNumberList320 expected = new ItemNumberList320.Builder().addItemNumbers(
				new ItemNumber320.Builder().currencyId(StandardCurrencyIds.EUR).values(100).release(1).count(1234)
						.number(4).build(),
				new ItemNumber320.Builder().currencyId(StandardCurrencyIds.USD).values(10).release(5).count(100)
						.number(1).build(),
				new ItemNumber320.Builder().currencyId(StandardCurrencyIds.GBP).values(1).release(1).count(10).number(2)
						.build())
				.build();
		Address address = Address.build(createDefault());
		ItemNumberList320 actual = mapper.read(memorySystem.dereference(address), ItemNumberList320.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
