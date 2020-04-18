package at.o2xfs.xfs.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;

public class WfsVersionIT extends BaseApiIT {

	@Test
	public void test() {
		WfsVersion expected = new WfsVersion.Builder().version(XfsVersion.V3_10).lowVersion(XfsVersion.V2_00)
				.highVersion(XfsVersion.V3_30).description("XFS API v2.00 to v3.30").systemStatus("Impl 1.0").build();
		WfsVersion actual = mapper.read(memorySystem.dereference(Address.build(createDefault())), WfsVersion.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();
}
