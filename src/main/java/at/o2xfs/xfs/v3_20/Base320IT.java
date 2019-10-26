package at.o2xfs.xfs.v3_20;

import at.o2xfs.common.Library;
import at.o2xfs.xfs.BaseIT;

public class Base320IT extends BaseIT {

	static {
		Library.loadLibrary("o2xfs-xfs320-api-it");
	}
}
