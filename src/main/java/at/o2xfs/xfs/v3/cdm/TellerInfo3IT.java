package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3.Base3IT;

public class TellerInfo3IT extends Base3IT {

	@Test
	public void test() {
		TellerInfo3 expected = new TellerInfo3.Builder().tellerId(1).currencyId(StandardCurrencyIds.EUR).build();
		Address address = Address.build(createDefault());
		TellerInfo3 actual = mapper.read(memorySystem.dereference(address), TellerInfo3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
