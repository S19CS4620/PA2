/**
 * MeggyException.java
 *
 * Exception class to enable bounds checking in the Meggy methods.
 *
 * 1/4/11, MMS
 **/

package meggy;

public class MeggyException extends RuntimeException {
	public MeggyException(String msg)
	{
		super(msg);

	}

}
