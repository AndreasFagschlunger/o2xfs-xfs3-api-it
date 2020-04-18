package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.ExchangeType;
import at.o2xfs.xfs.v3.Base3IT;

public class StartExchange3IT extends Base3IT {

	@Test
	public void test() {
		StartExchange3 expected = new StartExchange3.Builder().exchangeType(ExchangeType.BYHAND).tellerId(0)
				.cashUnitNumbers(1, 2, 3).build();
		Address address = Address.build(createDefault());
		StartExchange3 actual = mapper.read(memorySystem.dereference(address), StartExchange3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
