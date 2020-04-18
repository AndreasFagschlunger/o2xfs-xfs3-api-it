package at.o2xfs.xfs.v3_10.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.DevicePosition;
import at.o2xfs.xfs.v3_10.Base310IT;

public class DevicePosition310IT extends Base310IT {

	@Test
	public void test() {
		DevicePosition310 expected = new DevicePosition310.Builder().position(DevicePosition.NOTINPOSITION).build();
		Address address = Address.build(createDefault());
		DevicePosition310 actual = mapper.read(memorySystem.dereference(address), DevicePosition310.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
