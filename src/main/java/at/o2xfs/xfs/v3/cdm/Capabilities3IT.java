package at.o2xfs.xfs.v3.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.core.Address;
import at.o2xfs.xfs.api.XfsServiceClass;
import at.o2xfs.xfs.cdm.CdmType;
import at.o2xfs.xfs.cdm.ExchangeType;
import at.o2xfs.xfs.cdm.MoveItem;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.RetractArea;
import at.o2xfs.xfs.cdm.RetractStackerAction;
import at.o2xfs.xfs.cdm.RetractTransportAction;
import at.o2xfs.xfs.v3.Base3IT;

public class Capabilities3IT extends Base3IT {

	@Test
	public void test() {
		Capabilities3 expected = new Capabilities3.Builder().serviceClass(XfsServiceClass.CDM)
				.type(CdmType.SELFSERVICEBILL).maxDispenseItems(40).shutter(true)
				.addRetractArea(RetractArea.RETRACT, RetractArea.TRANSPORT, RetractArea.REJECT)
				.addRetractTransportAction(RetractTransportAction.PRESENT, RetractTransportAction.RETRACT,
						RetractTransportAction.REJECT)
				.addRetractStackerAction(RetractStackerAction.PRESENT, RetractStackerAction.RETRACT,
						RetractStackerAction.REJECT)
				.intermediateStacker(true).itemsTakenSensor(true).addPosition(Position.FRONT)
				.addMoveItem(MoveItem.FROMCU, MoveItem.TOTRANSPORT).addExchangeType(ExchangeType.BYHAND)
				.putExtra("Key1", "Value1").putExtra("Key2", "Value2").build();
		Address address = Address.build(createDefault());
		Capabilities3 actual = mapper.read(memorySystem.dereference(address), Capabilities3.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
