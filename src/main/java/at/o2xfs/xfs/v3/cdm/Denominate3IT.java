package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3.Base3IT;

public class Denominate3IT extends Base3IT {

	@Test
	public void test() {
		Denominate3 expected = new Denominate3.Builder().denomination(new Denomination3.Builder()
				.currencyId(StandardCurrencyIds.EUR).amount(1234L).values(1, 2, 3).cashBox(456L).build()).build();
		Address address = Address.build(createDefault());
		Denominate3 actual = mapper.read(memorySystem.dereference(address), Denominate3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
