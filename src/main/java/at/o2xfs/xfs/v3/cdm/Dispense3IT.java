package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3.Base3IT;

public class Dispense3IT extends Base3IT {

	@Test
	public void test() {
		Dispense3 expected = new Dispense3.Builder().position(Position.FRONT).denomination(new Denomination3.Builder()
				.currencyId(StandardCurrencyIds.EUR).amount(150L).values(1, 2, 1).cashBox(10L).build()).build();
		Address address = Address.build(createDefault());
		Dispense3 actual = mapper.read(memorySystem.dereference(address), Dispense3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
