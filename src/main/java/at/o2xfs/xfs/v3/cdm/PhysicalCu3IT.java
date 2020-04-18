package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.v3.Base3IT;

public class PhysicalCu3IT extends Base3IT {

	@Test
	public void test() {
		PhysicalCu3 expected = new PhysicalCu3.Builder().emptyAll(true).position(Position.TOP)
				.physicalPositionName("BIN3").build();
		Address address = Address.build(createDefault());
		PhysicalCu3 actual = mapper.read(memorySystem.dereference(address), PhysicalCu3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
