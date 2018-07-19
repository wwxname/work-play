package cn.plus.framework.lock;

/**
 * @author plus me
 * @date 2018/7/2
 */
public class LockException extends  RuntimeException {

    private static final long serialVersionUID = 3993800462589137228L;

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Constructors.
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    public LockException(String msg) {
        super(msg);
    }

    public LockException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
