package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.InputPosition;
import at.o2xfs.xfs.cdm.OutputPosition;
import at.o2xfs.xfs.cdm.TellerUpdateAction;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3.Base3IT;

public class TellerUpdate3IT extends Base3IT {

	@Test
	public void test() {
		TellerUpdate3 expected = new TellerUpdate3.Builder().action(TellerUpdateAction.CREATE)
				.tellerDetails(new TellerDetails3.Builder().tellerId(1).inputPosition(InputPosition.FRONT)
						.outputPosition(OutputPosition.BOTTOM)
						.addTellerTotal(
								new TellerTotals3.Builder().currencyId(StandardCurrencyIds.EUR).coinsDispensed(123L)
										.build(),
								new TellerTotals3.Builder().currencyId(StandardCurrencyIds.USD).coinsDispensed(1000L)
										.build())
						.build())
				.build();
		Address address = Address.build(createDefault());
		TellerUpdate3 actual = mapper.read(memorySystem.dereference(address), TellerUpdate3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
