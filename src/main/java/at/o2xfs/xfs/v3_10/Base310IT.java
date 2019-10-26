package at.o2xfs.xfs.v3_10;

import at.o2xfs.common.Library;
import at.o2xfs.xfs.BaseIT;

public abstract class Base310IT extends BaseIT {

	static {
		Library.loadLibrary("o2xfs-xfs310-api-it");
	}
}
