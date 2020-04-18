package at.o2xfs.xfs.api;

import at.o2xfs.common.Library;
import at.o2xfs.xfs.BaseIT;

public abstract class BaseApiIT extends BaseIT {

	static {
		Library.loadLibrary("o2xfs-xfs-api-it-bin");
	}
}
