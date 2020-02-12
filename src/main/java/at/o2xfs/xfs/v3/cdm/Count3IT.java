package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Status;
import at.o2xfs.xfs.util.UnitId;
import at.o2xfs.xfs.v3.Base3IT;

public class Count3IT extends Base3IT {

	@Test
	public void test() {
		Count3 expected = new Count3.Builder().addCountedPhysicalCashUnits(
				new CountedPhysicalCashUnit3.Builder().physicalPositionName("SLOT1")
						.unitId(UnitId.of('0', '0', '0', '0', '1')).dispensed(10L).counted(12L).status(Status.OK)
						.build(),
				new CountedPhysicalCashUnit3.Builder().physicalPositionName("SLOT2")
						.unitId(UnitId.of('0', '0', '0', '0', '2')).dispensed(10L).counted(12L).status(Status.FULL)
						.build())
				.build();
		Address address = Address.build(createDefault());
		Count3 actual = mapper.read(memorySystem.dereference(address), Count3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
