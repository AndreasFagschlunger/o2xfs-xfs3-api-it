package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.JammedShutterPosition;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.PositionStatus;
import at.o2xfs.xfs.cdm.Shutter;
import at.o2xfs.xfs.cdm.Transport;
import at.o2xfs.xfs.cdm.TransportStatus;
import at.o2xfs.xfs.v3_30.Base330IT;

public class OutputPosition330IT extends Base330IT {

	@Test
	public void test() {
		OutputPosition330 expected = new OutputPosition330.Builder().position(Position.FRONT).shutter(Shutter.OPEN)
				.positionStatus(PositionStatus.NOTEMPTY).transport(Transport.OK)
				.transportStatus(TransportStatus.NOTEMPTY).jammedShutterPosition(JammedShutterPosition.NOTJAMMED)
				.build();
		Address address = Address.build(createDefault());
		OutputPosition330 actual = mapper.read(memorySystem.dereference(address), OutputPosition330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
