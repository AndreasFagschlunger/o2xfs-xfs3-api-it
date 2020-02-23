package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3_30.Base330IT;

public class Blacklist330IT extends Base330IT {

	@Test
	public void test() {
		Blacklist330 expected = new Blacklist330.Builder().version(Optional.of("1.0"))
				.addBlacklistElements(
						new BlacklistElement330.Builder().serialNumber("S8H9231654").currencyId(StandardCurrencyIds.EUR)
								.value(20).build(),
						new BlacklistElement330.Builder().serialNumber("HD9083276112")
								.currencyId(StandardCurrencyIds.USD).value(100).build())
				.build();
		Address address = Address.build(createDefault());
		Blacklist330 actual = mapper.read(memorySystem.dereference(address), Blacklist330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
