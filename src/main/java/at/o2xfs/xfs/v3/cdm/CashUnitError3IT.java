package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Failure;
import at.o2xfs.xfs.cdm.Status;
import at.o2xfs.xfs.cdm.Type;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.util.UnitId;
import at.o2xfs.xfs.v3.Base3IT;

public class CashUnitError3IT extends Base3IT {

	@Test
	public void test() {
		CashUnitError3 expected = new CashUnitError3.Builder().failure(Failure.ERROR).cashUnit(new CashUnit3.Builder()
				.number(1).type(Type.BILLCASSETTE).unitId(UnitId.of('0', '0', '0', '0', '1'))
				.currencyId(StandardCurrencyIds.EUR).values(10000L).initialCount(100).count(98).rejectCount(1)
				.status(Status.INOP)
				.addPhysical(
						new PhysicalCashUnit3.Builder().physicalPositionName("SLOT1")
								.unitId(UnitId.of('0', '0', '0', '0', '1')).maximum(50).status(Status.OK).build(),
						new PhysicalCashUnit3.Builder().physicalPositionName("SLOT2")
								.unitId(UnitId.of('0', '0', '0', '0', '1')).maximum(50).status(Status.OK).build())
				.build()).build();
		Address address = Address.build(createDefault());
		CashUnitError3 actual = mapper.read(memorySystem.dereference(address), CashUnitError3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
