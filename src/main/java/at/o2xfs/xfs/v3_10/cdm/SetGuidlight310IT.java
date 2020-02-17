package at.o2xfs.xfs.v3_10.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.GuidLight;
import at.o2xfs.xfs.v3_10.Base310IT;

public class SetGuidlight310IT extends Base310IT {

	@Test
	public void test() {
		SetGuidlight310 expected = new SetGuidlight310.Builder().guidLight(6)
				.addCommand(GuidLight.MEDIUM_FLASH, GuidLight.GREEN).build();
		Address address = Address.build(createDefault());
		SetGuidlight310 actual = mapper.read(memorySystem.dereference(address), SetGuidlight310.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
