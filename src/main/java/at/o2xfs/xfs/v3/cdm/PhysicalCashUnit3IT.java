package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.Status;
import at.o2xfs.xfs.util.UnitId;
import at.o2xfs.xfs.v3.Base3IT;

public class PhysicalCashUnit3IT extends Base3IT {

	@Test
	public void test() {
		PhysicalCashUnit3 expected = new PhysicalCashUnit3.Builder().physicalPositionName("PhysicalPositionName")
				.unitId(UnitId.of('E', 'U', 'R', ' ', 'A')).initialCount(100L).count(230L).rejectCount(1L)
				.maximum(2000L).status(Status.OK).hardwareSensor(true).build();
		Address address = Address.build(createDefault());
		PhysicalCashUnit3 actual = mapper.read(memorySystem.dereference(address), PhysicalCashUnit3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
