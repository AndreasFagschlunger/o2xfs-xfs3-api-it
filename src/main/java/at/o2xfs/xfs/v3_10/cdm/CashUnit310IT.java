package at.o2xfs.xfs.v3_10.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Status;
import at.o2xfs.xfs.cdm.Type;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.util.UnitId;
import at.o2xfs.xfs.v3_10.Base310IT;

public class CashUnit310IT extends Base310IT {

	@Test
	public void test() {
		CashUnit310 expected = new CashUnit310.Builder().number(3).type(Type.BILLCASSETTE)
				.unitId(UnitId.of('E', 'U', 'R', ' ', 'B')).currencyId(StandardCurrencyIds.EUR).values(10L)
				.initialCount(1000L).count(376L).rejectCount(6).status(Status.OK)
				.addPhysicalCashUnits(new PhysicalCashUnit310.Builder().physicalPositionName("BIN1")
						.unitId(UnitId.of('E', 'U', 'R', ' ', 'B')).initialCount(500).count(0).rejectCount(0)
						.status(Status.LOW).hardwareSensor(true).dispensedCount(100).presentedCount(100).build(),
						new PhysicalCashUnit310.Builder().physicalPositionName("BIN2")
								.unitId(UnitId.of('E', 'U', 'R', ' ', 'B')).initialCount(500).count(376).rejectCount(1)
								.status(Status.OK).hardwareSensor(true).dispensedCount(100).presentedCount(99).build())
				.dispensedCount(200L).presentedCount(199).retractedCount(1L).build();
		Address address = Address.build(createDefault());
		CashUnit310 actual = mapper.read(memorySystem.dereference(address), CashUnit310.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
