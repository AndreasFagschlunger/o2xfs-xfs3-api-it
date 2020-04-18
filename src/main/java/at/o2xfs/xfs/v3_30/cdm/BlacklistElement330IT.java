package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3_30.Base330IT;

public class BlacklistElement330IT extends Base330IT {

	@Test
	public void test() {
		BlacklistElement330 expected = new BlacklistElement330.Builder().serialNumber("S8H9231654")
				.currencyId(StandardCurrencyIds.GBP).value(500).build();
		Address address = Address.build(createDefault());
		BlacklistElement330 actual = mapper.read(memorySystem.dereference(address), BlacklistElement330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
