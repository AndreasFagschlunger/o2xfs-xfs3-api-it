package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.Status;
import at.o2xfs.xfs.util.UnitId;
import at.o2xfs.xfs.v3.Base3IT;

public class CountedPhysicalCashUnit3IT extends Base3IT {

	@Test
	public void test() {
		CountedPhysicalCashUnit3 expected = new CountedPhysicalCashUnit3.Builder().physicalPositionName("BIN1")
				.unitId(UnitId.of('E', 'U', 'R', ' ', 'A')).dispensed(1000L).counted(999L).status(Status.EMPTY).build();
		Address address = Address.build(createDefault());
		CountedPhysicalCashUnit3 actual = mapper.read(memorySystem.dereference(address),
				CountedPhysicalCashUnit3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
