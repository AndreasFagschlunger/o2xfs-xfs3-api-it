package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.RetractArea;
import at.o2xfs.xfs.v3.Base3IT;

public class Itemposition3IT extends Base3IT {

	@Test
	public void test() {
		ItemPosition3 expected = new ItemPosition3.Builder().number(1).retractArea(Optional.of(new Retract3.Builder()
				.outputPosition(Position.FRONT).retractArea(RetractArea.RETRACT).index(1).build()))
				.outputPosition(Position.FRONT).build();
		Address address = Address.build(createDefault());
		ItemPosition3 actual = mapper.read(memorySystem.dereference(address), ItemPosition3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void retractAreaShouldBeEmpty() {
		ItemPosition3 expected = new ItemPosition3.Builder().build();
		Address address = Address.build(createRetractAreaNull());
		ItemPosition3 actual = mapper.read(memorySystem.dereference(address), ItemPosition3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
		assertNotNull(actual.getRetractArea());
		assertFalse(actual.getRetractArea().isPresent());
	}

	private native byte[] createDefault();

	private native byte[] createRetractAreaNull();

}
