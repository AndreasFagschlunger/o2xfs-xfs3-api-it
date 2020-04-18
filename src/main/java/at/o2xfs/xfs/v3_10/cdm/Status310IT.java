package at.o2xfs.xfs.v3_10.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumSet;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.Device;
import at.o2xfs.xfs.cdm.Dispenser;
import at.o2xfs.xfs.cdm.GuidLight;
import at.o2xfs.xfs.cdm.IntermediateStacker;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.PositionStatus;
import at.o2xfs.xfs.cdm.SafeDoor;
import at.o2xfs.xfs.cdm.Shutter;
import at.o2xfs.xfs.cdm.Transport;
import at.o2xfs.xfs.cdm.TransportStatus;
import at.o2xfs.xfs.v3.cdm.OutputPosition3;
import at.o2xfs.xfs.v3_10.Base310IT;

public class Status310IT extends Base310IT {

	@Test
	public void test() {
		Status310 expected = new Status310.Builder().device(Device.ONLINE).safeDoor(SafeDoor.CLOSED)
				.dispenser(Dispenser.OK).intermediateStacker(IntermediateStacker.EMPTY)
				.addPositions(new OutputPosition3.Builder().position(Position.FRONT).shutter(Shutter.CLOSED)
						.positionStatus(PositionStatus.EMPTY).transport(Transport.OK)
						.transportStatus(TransportStatus.EMPTY).build())
				.putExtra("Key1", "Value1").putExtra("Key2", "Value2")
				.setGuidLights(5, EnumSet.of(GuidLight.CONTINUOUS, GuidLight.SLOW_FLASH, GuidLight.MEDIUM_FLASH))
				.build();
		Address address = Address.build(createDefault());
		Status310 actual = mapper.read(memorySystem.dereference(address), Status310.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
