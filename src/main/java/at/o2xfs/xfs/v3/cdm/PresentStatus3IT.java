package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.PresentState;
import at.o2xfs.xfs.util.CurrencyId;
import at.o2xfs.xfs.v3.Base3IT;

public class PresentStatus3IT extends Base3IT {

	@Test
	public void test() {
		PresentStatus3 expected = new PresentStatus3.Builder()
				.denomination(
						new Denomination3.Builder().currencyId(CurrencyId.empty()).amount(150L).values(1, 2, 2).build())
				.presentState(PresentState.PRESENTED).putExtra("Key1", "Value1").putExtra("Key2", "Value2").build();
		Address address = Address.build(createDefault());
		PresentStatus3 actual = mapper.read(memorySystem.dereference(address), PresentStatus3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
