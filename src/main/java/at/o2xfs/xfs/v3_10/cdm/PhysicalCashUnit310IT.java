package at.o2xfs.xfs.v3_10.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Status;
import at.o2xfs.xfs.util.UnitId;
import at.o2xfs.xfs.v3_10.Base310IT;

public class PhysicalCashUnit310IT extends Base310IT {

	@Test
	public void test() {
		PhysicalCashUnit310 expected = new PhysicalCashUnit310.Builder().physicalPositionName("PhysicalPositionName")
				.unitId(UnitId.of('E', 'U', 'R', ' ', 'A')).initialCount(100L).count(230L).rejectCount(1L)
				.maximum(2000L).status(Status.OK).hardwareSensor(true).dispensedCount(56L).presentedCount(55L).build();
		Address address = Address.build(createDefault());
		PhysicalCashUnit310 actual = mapper.read(memorySystem.dereference(address), PhysicalCashUnit310.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
