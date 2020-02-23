package at.o2xfs.xfs.v3_30.cdm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumSet;

import org.junit.jupiter.api.Test;

import at.o2xfs.memory.impl.win32.Address;
import at.o2xfs.xfs.XfsServiceClass;
import at.o2xfs.xfs.cdm.CdmExecuteCommand;
import at.o2xfs.xfs.cdm.CdmType;
import at.o2xfs.xfs.cdm.ExchangeType;
import at.o2xfs.xfs.cdm.GuidLight;
import at.o2xfs.xfs.cdm.ItemInfoType;
import at.o2xfs.xfs.cdm.MoveItem;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.cdm.RetractArea;
import at.o2xfs.xfs.cdm.RetractStackerAction;
import at.o2xfs.xfs.cdm.RetractTransportAction;
import at.o2xfs.xfs.v3_30.Base330IT;

public class Capabilities330IT extends Base330IT {

	@Test
	public void test() {
		Capabilities330 expected = new Capabilities330.Builder().serviceClass(XfsServiceClass.CDM)
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
				.prepareDispense(true).antiFraudModule(true)
				.addItemInfoTypes(ItemInfoType.IMAGEFILE, ItemInfoType.SERIALNUMBER).blacklist(true)
				.addSynchronizableCommands(CdmExecuteCommand.DISPENSE, CdmExecuteCommand.PRESENT,
						CdmExecuteCommand.REJECT, CdmExecuteCommand.RETRACT)
				.build();
		Address address = Address.build(createDefault());
		Capabilities330 actual = mapper.read(memorySystem.dereference(address), Capabilities330.class);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	private native byte[] createDefault();

}
