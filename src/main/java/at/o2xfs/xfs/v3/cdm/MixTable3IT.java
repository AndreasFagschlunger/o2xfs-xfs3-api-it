package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.v3.Base3IT;

public class MixTable3IT extends Base3IT {

	@Test
	public void test() {
		Address address = Address.build(createDefault());
		MixTable3 expected = new MixTable3.Builder().mixNumber(1).name("Test").mixHeader(10, 20, 50)
				.addMixRows(new MixRow3.Builder().amount(100).mixture(1, 2, 1).build(),
						new MixRow3.Builder().amount(150).mixture(3, 2, 1).build())
				.build();
		MixTable3 actual = mapper.read(memorySystem.dereference(address), MixTable3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
