package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3.Base3IT;

public class TellerTotals3IT extends Base3IT {

	@Test
	public void test() {
		TellerTotals3 expected = new TellerTotals3.Builder().currencyId(StandardCurrencyIds.USD).itemsReceived(1L)
				.itemsDispensed(2L).coinsReceived(3L).coinsDispensed(4L).cashBoxReceived(5L).cashBoxDispensed(6L)
				.build();
		Address address = Address.build(createDefault());
		TellerTotals3 actual = mapper.read(memorySystem.dereference(address), TellerTotals3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
