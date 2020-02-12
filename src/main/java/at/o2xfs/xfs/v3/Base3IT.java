package at.o2xfs.xfs.v3;

import at.o2xfs.common.Library;
import at.o2xfs.xfs.BaseIT;

public abstract class Base3IT extends BaseIT {

	static {
		Library.loadLibrary("o2xfs-xfs3-api-it-bin");
	}

}
