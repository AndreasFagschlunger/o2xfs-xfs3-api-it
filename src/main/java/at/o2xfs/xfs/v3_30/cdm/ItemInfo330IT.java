package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3_30.Base330IT;

public class ItemInfo330IT extends Base330IT {

	@Test
	public void test() {
		ItemInfo330 expected = new ItemInfo330.Builder().currencyId(StandardCurrencyIds.EUR).value(100).release(1)
				.serialNumber(Optional.of("HD9083276112"))
				.signature(Optional.of(new Signature330.Builder().data("TEST".getBytes()).build()))
				.imageFileName(Optional.of("C:\\Temp\\cash123456.jpg")).build();
		Address address = Address.build(createDefault());
		ItemInfo330 actual = mapper.read(memorySystem.dereference(address), ItemInfo330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
