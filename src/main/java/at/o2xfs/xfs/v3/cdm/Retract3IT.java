package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.RetractArea;
import at.o2xfs.xfs.v3.Base3IT;

public class Retract3IT extends Base3IT {

	@Test
	public void test() {
		Retract3 expected = new Retract3.Builder().outputPosition(Position.FRONT).retractArea(RetractArea.RETRACT)
				.index(1).build();
		Address address = Address.build(createDefault());
		Retract3 actual = mapper.read(memorySystem.dereference(address), Retract3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
