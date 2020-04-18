package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.IncompleteRetractReason;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3_20.cdm.ItemNumber320;
import at.o2xfs.xfs.v3_20.cdm.ItemNumberList320;
import at.o2xfs.xfs.v3_30.Base330IT;

public class IncompleteRetract330IT extends Base330IT {

	@Test
	public void test() {
		IncompleteRetract330 expected = new IncompleteRetract330.Builder()
				.itemNumberList(new ItemNumberList320.Builder().addItemNumbers(
						new ItemNumber320.Builder().currencyId(StandardCurrencyIds.EUR).values(100L).release(1)
								.count(23).number(2).build(),
						new ItemNumber320.Builder().currencyId(StandardCurrencyIds.USD).values(10L).release(2).count(10)
								.number(3).build())
						.build())
				.reason(IncompleteRetractReason.RETRACTFAILURE).build();
		Address address = Address.build(createDefault());
		IncompleteRetract330 actual = mapper.read(memorySystem.dereference(address), IncompleteRetract330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
