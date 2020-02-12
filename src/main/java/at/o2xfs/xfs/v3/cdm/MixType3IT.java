package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.MixType;
import at.o2xfs.xfs.v3.Base3IT;

public class MixType3IT extends Base3IT {

	@Test
	public void test() {
		MixType3 expected = new MixType3.Builder().mixNumber(1).mixType(MixType.ALGORITHM).subType(2).name("Foobar")
				.build();
		Address address = Address.build(createDefault());
		MixType3 actual = mapper.read(memorySystem.dereference(address), MixType3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
