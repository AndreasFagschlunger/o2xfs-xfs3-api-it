package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.InputPosition;
import at.o2xfs.xfs.cdm.OutputPosition;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3.Base3IT;

public class TellerDetails3IT extends Base3IT {

	@Test
	public void test() {
		TellerDetails3 expected = new TellerDetails3.Builder().tellerId(1).inputPosition(InputPosition.FRONT)
				.outputPosition(OutputPosition.TOP)
				.addTellerTotal(new TellerTotals3.Builder().currencyId(StandardCurrencyIds.EUR).build()).build();
		Address address = Address.build(createDefault());
		TellerDetails3 actual = mapper.read(memorySystem.dereference(address), TellerDetails3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
