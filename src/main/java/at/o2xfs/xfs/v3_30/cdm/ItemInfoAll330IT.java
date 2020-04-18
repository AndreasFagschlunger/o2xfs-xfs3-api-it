package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.ItemLocation;
import at.o2xfs.xfs.cdm.Level;
import at.o2xfs.xfs.cdm.OnBlacklist;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3_30.Base330IT;

public class ItemInfoAll330IT extends Base330IT {

	@Test
	public void test() {
		ItemInfoAll330 expected = new ItemInfoAll330.Builder().level(Level.LEVEL_2).currencyId(StandardCurrencyIds.EUR)
				.value(50).release(1).serialNumber(Optional.of("HD9083276112"))
				.imageFileName(Optional.of("C:\\Temp\\cash123456.jpg")).onBlacklist(OnBlacklist.ONBLACKLIST)
				.itemLocation(ItemLocation.CASHUNIT).number(1).build();
		Address address = Address.build(createDefault());
		ItemInfoAll330 actual = mapper.read(memorySystem.dereference(address), ItemInfoAll330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
