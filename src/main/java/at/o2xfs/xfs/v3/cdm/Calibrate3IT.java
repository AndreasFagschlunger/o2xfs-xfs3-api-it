package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.RetractArea;
import at.o2xfs.xfs.v3.Base3IT;

public class Calibrate3IT extends Base3IT {

	@Test
	public void test() {
		Calibrate3 expected = new Calibrate3.Builder().number(1).numOfBills(8)
				.position(new ItemPosition3.Builder().number(1)
						.retractArea(
								Optional.of(new Retract3.Builder().retractArea(RetractArea.REJECT).index(1).build()))
						.outputPosition(Position.REAR).build())
				.build();
		Address address = Address.build(createDefault());
		Calibrate3 actual = mapper.read(memorySystem.dereference(address), Calibrate3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
