package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.ItemLocation;
import at.o2xfs.xfs.cdm.Level;
import at.o2xfs.xfs.cdm.OnBlacklist;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.v3_30.Base330IT;

public class AllItemsInfo330IT extends Base330IT {

	@Test
	public void test() {
		AllItemsInfo330 expected = new AllItemsInfo330.Builder().addItemsList(
				new ItemInfoAll330.Builder().level(Level.LEVEL_2).currencyId(StandardCurrencyIds.EUR).value(10)
						.release(2).imageFileName(Optional.of("C:\\Temp\\test.jpg"))
						.onBlacklist(OnBlacklist.NOTONBLACKLIST).itemLocation(ItemLocation.CASHUNIT).number(2).build(),
				new ItemInfoAll330.Builder().level(Level.LEVEL_3).currencyId(StandardCurrencyIds.USD).value(100)
						.release(3).serialNumber(Optional.of("123456789")).onBlacklist(OnBlacklist.NOTONBLACKLIST)
						.itemLocation(ItemLocation.CASHUNIT).number(2).build())
				.build();
		Address address = Address.build(createDefault());
		AllItemsInfo330 actual = mapper.read(memorySystem.dereference(address), AllItemsInfo330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
