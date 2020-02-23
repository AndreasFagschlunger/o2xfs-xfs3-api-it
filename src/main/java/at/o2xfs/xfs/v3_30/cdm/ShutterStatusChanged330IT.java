package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.Shutter;
import at.o2xfs.xfs.v3_30.Base330IT;

public class ShutterStatusChanged330IT extends Base330IT {

	@Test
	public void test() {
		ShutterStatusChanged330 expected = new ShutterStatusChanged330.Builder().position(Position.FRONT)
				.shutter(Shutter.CLOSED).build();
		Address address = Address.build(createDefault());
		ShutterStatusChanged330 actual = mapper.read(memorySystem.dereference(address), ShutterStatusChanged330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
