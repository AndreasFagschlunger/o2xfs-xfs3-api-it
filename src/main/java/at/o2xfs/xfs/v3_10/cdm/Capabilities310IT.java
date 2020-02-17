package at.o2xfs.xfs.v3_10.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumSet;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.XfsServiceClass;
import at.o2xfs.xfs.cdm.CdmType;
import at.o2xfs.xfs.cdm.ExchangeType;
import at.o2xfs.xfs.cdm.GuidLight;
import at.o2xfs.xfs.cdm.MoveItem;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.RetractArea;
import at.o2xfs.xfs.cdm.RetractStackerAction;
import at.o2xfs.xfs.cdm.RetractTransportAction;
import at.o2xfs.xfs.v3_10.Base310IT;

public class Capabilities310IT extends Base310IT {

	@Test
	public void test() {
		Capabilities310 expected = new Capabilities310.Builder().serviceClass(XfsServiceClass.CDM)
				.type(CdmType.SELFSERVICEBILL).maxDispenseItems(40).shutter(true)
				.addRetractArea(RetractArea.RETRACT, RetractArea.TRANSPORT, RetractArea.REJECT)
				.addRetractTransportAction(RetractTransportAction.PRESENT, RetractTransportAction.RETRACT,
						RetractTransportAction.REJECT)
				.addRetractStackerAction(RetractStackerAction.PRESENT, RetractStackerAction.RETRACT,
						RetractStackerAction.REJECT)
				.intermediateStacker(true).itemsTakenSensor(true).addPosition(Position.FRONT)
				.addMoveItem(MoveItem.FROMCU, MoveItem.TOTRANSPORT).addExchangeType(ExchangeType.BYHAND)
				.putExtra("Key1", "Value1").putExtra("Key2", "Value2")
				.setGuidLights(0,
						EnumSet.of(GuidLight.SLOW_FLASH, GuidLight.QUICK_FLASH, GuidLight.RED, GuidLight.GREEN))
				.setGuidLights(31, EnumSet.of(GuidLight.SLOW_FLASH, GuidLight.MEDIUM_FLASH, GuidLight.CONTINUOUS))
				.prepareDispense(true).build();
		Address address = Address.build(createDefault());
		Capabilities310 actual = mapper.read(memorySystem.dereference(address), Capabilities310.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
