package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.PositionStatus;
import at.o2xfs.xfs.cdm.Shutter;
import at.o2xfs.xfs.cdm.Transport;
import at.o2xfs.xfs.cdm.TransportStatus;
import at.o2xfs.xfs.v3.Base3IT;

public class OutputPosition3IT extends Base3IT {

	@Test
	public void test() {
		OutputPosition3 expected = new OutputPosition3.Builder().position(Position.FRONT).shutter(Shutter.CLOSED)
				.positionStatus(PositionStatus.EMPTY).transport(Transport.OK).transportStatus(TransportStatus.EMPTY)
				.build();
		Address address = Address.build(createDefault());
		OutputPosition3 actual = mapper.read(memorySystem.dereference(address), OutputPosition3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
