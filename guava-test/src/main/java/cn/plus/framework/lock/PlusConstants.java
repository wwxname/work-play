package cn.plus.framework.lock;

public interface PlusConstants {

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * PlusConstants.
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */


    String TABLE_LOCKS = "LOCKS";



    String COL_SCHEDULER_NAME = "SCHED_NAME";



    // TABLE_LOCKS columns names
    String COL_LOCK_NAME = "LOCK_NAME";


    // MISC CONSTANTS
    String DEFAULT_TABLE_PREFIX = "plus-";


    /**
     * @deprecated Whether a trigger has misfired is no longer a state, but
     * rather now identified dynamically by whether the trigger's next fire
     * time is more than the misfire threshold time in the past.
     */
    String STATE_MISFIRED = "MISFIRED";





}
