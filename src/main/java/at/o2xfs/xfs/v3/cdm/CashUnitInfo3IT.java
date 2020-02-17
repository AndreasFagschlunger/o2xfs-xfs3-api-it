package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Status;
import at.o2xfs.xfs.cdm.Type;
import at.o2xfs.xfs.util.StandardCurrencyIds;
import at.o2xfs.xfs.util.UnitId;
import at.o2xfs.xfs.v3.Base3IT;

public class CashUnitInfo3IT extends Base3IT {

	@Test
	public void test() {
		CashUnitInfo3 expected = new CashUnitInfo3.Builder().addCashUnits(
				new CashUnit3.Builder().number(1).type(Type.RETRACTCASSETTE).unitId(UnitId.of('9', '9', '9', '9', '9'))
						.status(Status.OK)
						.addPhysicalCashUnits(new PhysicalCashUnit3.Builder().physicalPositionName("COMPARTMENT1")
								.unitId(UnitId.of('9', '9', '9', '9', '9')).maximum(50L).status(Status.OK).build())
						.build(),
				new CashUnit3.Builder().number(2).type(Type.REJECTCASSETTE).unitId(UnitId.of('9', '9', '9', '9', '9'))
						.count(4L).status(Status.OK)
						.addPhysicalCashUnits(new PhysicalCashUnit3.Builder().physicalPositionName("COMPARTMENT2")
								.unitId(UnitId.of('9', '9', '9', '9', '9')).count(4L).maximum(200L).status(Status.OK)
								.build())
						.build(),
				new CashUnit3.Builder().number(3).type(Type.BILLCASSETTE).unitId(UnitId.of('0', '0', '0', '0', '1'))
						.currencyId(StandardCurrencyIds.EUR).values(10000L).initialCount(100L).count(98L).rejectCount(1)
						.status(Status.OK)
						.addPhysicalCashUnits(new PhysicalCashUnit3.Builder().physicalPositionName("SLOT1")
								.unitId(UnitId.of('0', '0', '0', '0', '1')).initialCount(100L).count(98L).rejectCount(1)
								.maximum(2200L).status(Status.OK).build())
						.build(),
				new CashUnit3.Builder().number(4).type(Type.BILLCASSETTE).unitId(UnitId.of('0', '0', '0', '0', '2'))
						.currencyId(StandardCurrencyIds.EUR).values(5000L).initialCount(100L).count(98L).rejectCount(1)
						.status(Status.OK)
						.addPhysicalCashUnits(new PhysicalCashUnit3.Builder().physicalPositionName("SLOT2")
								.unitId(UnitId.of('0', '0', '0', '0', '2')).initialCount(100L).count(98L).rejectCount(1)
								.maximum(2200L).status(Status.OK).build())
						.build(),
				new CashUnit3.Builder().number(5).type(Type.BILLCASSETTE).unitId(UnitId.of('0', '0', '0', '0', '3'))
						.currencyId(StandardCurrencyIds.EUR).values(2000L).initialCount(100L).count(98L).rejectCount(1)
						.status(Status.OK)
						.addPhysicalCashUnits(new PhysicalCashUnit3.Builder().physicalPositionName("SLOT3")
								.unitId(UnitId.of('0', '0', '0', '0', '3')).initialCount(100L).count(98L).rejectCount(1)
								.maximum(2200L).status(Status.OK).build())
						.build(),
				new CashUnit3.Builder().number(6).type(Type.BILLCASSETTE).unitId(UnitId.of('0', '0', '0', '0', '4'))
						.currencyId(StandardCurrencyIds.EUR).values(1000L).initialCount(100L).count(98L).rejectCount(1)
						.status(Status.OK)
						.addPhysicalCashUnits(new PhysicalCashUnit3.Builder().physicalPositionName("SLOT4")
								.unitId(UnitId.of('0', '0', '0', '0', '4')).initialCount(100L).count(98L).rejectCount(1)
								.maximum(2200L).status(Status.OK).build())
						.build())
				.build();

		Address address = Address.build(createDefault());
		CashUnitInfo3 actual = mapper.read(memorySystem.dereference(address), CashUnitInfo3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
