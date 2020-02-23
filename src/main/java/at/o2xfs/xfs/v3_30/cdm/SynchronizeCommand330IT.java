package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.databind.ReadableMemory;
import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.cdm.CdmExecuteCommand;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.databind.deser.XfsEnum32Deserializer;
import at.o2xfs.xfs.v3_30.Base330IT;

public class SynchronizeCommand330IT extends Base330IT {

	@Test
	public void test() {
		SynchronizeCommand330 expected = new SynchronizeCommand330.Builder()
				.command(CdmExecuteCommand.PRESENT.getValue()).cmdData(Position.FRONT).build();
		Address address = Address.build(createDefault());
		ReadableMemory memory = memorySystem.dereference(address);
		SynchronizeCommand330 actual = new SynchronizeCommand330.Builder().command(memory.nextUnsignedLong())
				.cmdData(new XfsEnum32Deserializer(Position.class).deserialize(memory.nextReference(), null)).build();
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
