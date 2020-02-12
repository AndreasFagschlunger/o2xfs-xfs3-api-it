package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3.Base3IT;

public class CurrencyExp3IT extends Base3IT {

	@Test
	public void test() {
		CurrencyExp3 expected = new CurrencyExp3.Builder().currencyId(StandardCurrencyIds.EUR).exponent(-2).build();
		Address address = Address.build(createDefault());
		CurrencyExp3 actual = mapper.read(memorySystem.dereference(address), CurrencyExp3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
