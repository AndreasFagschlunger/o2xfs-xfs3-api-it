package at.o2xfs.xfs.v3_30;

import at.o2xfs.common.Library;
import at.o2xfs.xfs.BaseIT;

public class Base330IT extends BaseIT {

	static {
		Library.loadLibrary("o2xfs-xfs330-api-it-bin");
	}
}
