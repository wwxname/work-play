package cn.plus.framework.excetion;

/**
 * @author plus me
 * @date 2018/7/2
 */
public class PlusLockException extends  RuntimeException {

    private static final long serialVersionUID = 3993800462589137228L;

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Constructors.
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    public PlusLockException(String msg) {
        super(msg);
    }

    public PlusLockException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
