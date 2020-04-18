package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.Status;
import at.o2xfs.xfs.cdm.Type;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.util.UnitId;
import at.o2xfs.xfs.v3.Base3IT;

public class CashUnit3IT extends Base3IT {

	@Test
	public void test() {
		CashUnit3 expected = new CashUnit3.Builder().number(3).type(Type.BILLCASSETTE)
				.unitId(UnitId.of('E', 'U', 'R', ' ', 'B')).currencyId(StandardCurrencyIds.EUR).values(10L)
				.initialCount(1000L).count(376L).rejectCount(6).status(Status.OK)
				.addPhysicalCashUnits(
						new PhysicalCashUnit3.Builder().physicalPositionName("BIN1")
								.unitId(UnitId.of('E', 'U', 'R', ' ', 'B')).initialCount(500).count(0).rejectCount(1)
								.status(Status.LOW).hardwareSensor(true).build(),
						new PhysicalCashUnit3.Builder().physicalPositionName("BIN2")
								.unitId(UnitId.of('E', 'U', 'R', ' ', 'B')).initialCount(500).count(376).rejectCount(5)
								.status(Status.OK).hardwareSensor(true).build())
				.build();
		Address address = Address.build(createDefault());
		CashUnit3 actual = mapper.read(memorySystem.dereference(address), CashUnit3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
