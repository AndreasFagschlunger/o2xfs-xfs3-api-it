package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3.Base3IT;

public class Denomination3IT extends Base3IT {

	@Test
	public void test() {
		Denomination3 expected = new Denomination3.Builder().currencyId(StandardCurrencyIds.EUR).amount(1234L)
				.values(1, 2, 3).cashBox(456L).build();
		Address address = Address.build(createDefault());
		Denomination3 actual = mapper.read(memorySystem.dereference(address), Denomination3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void valuesShouldBeEmpty() {
		Denomination3 expected = new Denomination3.Builder().amount(1234L).cashBox(456L).build();
		Address address = Address.build(createValuesNull());
		Denomination3 actual = mapper.read(memorySystem.dereference(address), Denomination3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

	private native byte[] createValuesNull();

}
