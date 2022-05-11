package ca7.ljob.attribute;

/**
 * This enum stores keys and tokens for all information located under the Job Information section in the LJob report.
 *
 * This is a child of the LJobAttribute using itself as the generic type.
 *
 * Below is an example of what the Job Information section looks like.
 *
 *        --------------------------- JOB INFORMATION ---------------------------
 *        N -- SCHD RESOLUTION REQUIRED      Y -- LOAD STEP TO BE EXECUTED
 *        N -- OVERRIDE OF JCL REQUIRED      N -- JOB MARKED AS MAINT ONLY
 *        N -- MANUAL VERIFICATION REQD      N -- JOB SET FOR HOLD IN REQQ
 *        Y -- REQUIREMNTS TO BE LISTED      N -- COMP TRIGGERS OTHER JOBS
 *        Y -- AUTO-GENERATION OF 7 RMS      Y -- JOB ELIGIBLE FOR PROMPTS
 *        Y -- ERRORS FOR RQMT NOT USED      Y -- JOB SET FOR EXEC on MAIN
 *        Y -- ERRORS FOR DSN NOT FOUND      N -- JCL TO BE KEPT IN PRRN/Q
 *        . LAST RUN: CA 7=YY.DDD 13:30:24  EXEC=YY.DDD 14:30:24  EXEC TZO=-05:00
 *        . OWNER= USERID  JCLLIB= *NUMERIC JCLID*  ARFSET= *NONE*
 *        . LAST MAINTENANCE on YY.DDD AT HH:MM:SS VIA DBM BY OPERATOR:USERID
 *        . JCL SET FOR RETRIEVAL FROM OVERRIDE LIB FOR NEXT RUN
 *        . CLASS=,MSGCLASS=B,REGION=040K,PRTY=02,CPUTM=00001,ELAPTM=0009
 *        . TAPE1: CALC=000,MANL=000,TAPE2: CALC=000,MANL=000,DRCLASS= *NONE*
 *        . LTERM=CONTROL,JOBNET=PAYWEEK1,NXTCYC=SKP
 *        . DONT SCHEDULE BEFORE YYDDD AT 0800 AND AFTER YYDDD AT 2300
 *        . CONSIDER ABNORMAL END IF ..text..
 *        . SATISFACTION LEAD TIME (HRS): JOB=01    DSN=00
 *        . # OF TIMES LATE = 0000    # OF TIMES RESTARTED = 0000
 *
 * @author michael.baljet
 * @see ca7.ljob.attribute.LJobAttribute
 *
 */
public enum JobInformationAttribute implements LJobAttribute {

    // Y/N attributes. [Y/N] -- (attribute token)
    SCHD_RESOLUTION_REQUIRED("SCHD RESOLUTION REQUIRED"), // Identifies whether this job's schedule information entered through the DB.2.1 panel needs to be RESOLVed.
    OVERRIDE_OF_JCL_REQUIRED("OVERRIDE OF JCL REQUIRED"), // Identifies whether the QJCL requires modifying before job submission (see JCL-OVRD field on the DB.1 panel).
    MANUAL_VERIFICATION_REQD("MANUAL VERIFICATION REQD"), // Identifies whether this job has an initial requirement in the request queue for verification (see VERIFY field on the DB.1 panel).
    REQUIREMNTS_TO_BE_LISTED("REQUIREMNTS TO BE LISTED"), // Identifies whether this job's requirements should be written to the LTERM indicated on the DB.1 panel upon initial queue entry.
    AUTO_GENERATION_OF_7_RMS("AUTO-GENERATION OF 7 RMS"), // Identifies whether CA 7 is to insert the RMS step (see INSERT-RMS field on the DB.1 panel).
    ERRORS_FOR_RQMT_NOT_USED("ERRORS FOR RQMT NOT USED"), // Identifies whether an error message should be produced and sent to the LTERM specified on the DB.1 panel if this job shows to use a data set, but while the job was executing, CA 7 did not receive SMF data indicating its use (see RQMTS NOT USED field on the DB.1 panel).
    ERRORS_FOR_DSN_NOT_FOUND("ERRORS FOR DSN NOT FOUND"), // Identifies whether an error message should be produced and sent to the LTERM specified on the DB.1 panel if CA 7 receives SMF data from this job's execution for a data set that is not referenced by the job's database record (see DSN NOT FOUND field on the DB.1 panel).
    LOAD_STEP_TO_BE_EXECUTED("LOAD STEP TO BE EXECUTED"), // Identifies whether this job should go through load processing the next time it is to be executed.
    JOB_MARKED_AS_MAINT_ONLY("JOB MARKED AS MAINT ONLY"), // Identifies whether this job is to run as a maintenance job (see MAINT field on the DB.1 panel).
    JOB_SET_FOR_HOLD_IN_REQQ("JOB SET FOR HOLD IN REQQ"), // Identifies whether the job should enter the request queue with an initial hold requirement (see HOLD field on the DB.1 panel).
    COMP_TRIGGERS_OTHER_JOBS("COMP TRIGGERS OTHER JOBS"), // Identifies whether this job's successful completion triggers other jobs into CA 7.
    JOB_ELIGIBLE_FOR_PROMPTS("JOB ELIGIBLE FOR PROMPTS"), // Identifies whether the LTERM (from the DB.1 panel) is notified on a timer basis should this job become late or need restarting (see PROMPTS field on the DB.1 panel).
    JOB_SET_FOR_EXEC_ON_MAIN("JOB SET FOR EXEC ON MAIN"), // Identifies whether this is an executable job (see EXEC field on the DB.1 panel).
    JCL_TO_BE_KEPT_IN_PRRN_Q("JCL TO BE KEPT IN PRRN/Q"), // Identifies whether on successful completion should a copy of the JCL that was submitted for this job be kept (see RETAIN-JCL field on the DB.1 panel).
    UNIX_SWITCH_USER_CMD_SU_("UNIX SWITCH USER CMD SU-"), // Identifies whether to execute the UNIX Switch User command (see SUTYPE on the DB.10 panel).
    PRM_TO_BE_KEPT_IN_PRRN_Q("PRM TO BE KEPT IN PRRN/Q"), // Identifies whether on successful completion to keep a copy of the data sent to the destination node (see RETAIN on the DB.10 panel).
    // Text attributes. IN MOST CASES: (attribute token)= [attribute text]
    LAST_RUN("LAST RUN"), // Last date/time (start time) the job ran successfully under CA 7. This line is generated only if job EXEC time is different from CA7 time.
    LAST_RUN_CA_7("CA 7"), // The date/time is normalized to the time zone of the running CA 7.
    LAST_RUN_EXEC("EXEC"), // The execution time zone date/time.
    LAST_RUN_EXEC_TZO("EXEC TZO"), // Time zone offset (TZO) from UCT of the site where the job ran. To determine the TZO of the local CA 7, issue a /DISPLAY,ST=CA7 command.
    OWNER("OWNER"), // The security user ID associated with this job (see OWNER field on the DB.1 panel).
    JCLLIB("JCLLIB"), // The symbolic INDEX assigned to the JCL statement that defines the data set in which this member resides. JCLLIB= *NUMERIC JCLID* indicates that a numeric INDEX is assigned to the JCL statement that defines the data set in which this member resides.
    ARFSET("ARFSET"), // The name of the ARFSET used on this job.
    LAST_MAINTENANCE_ON("--PLACEHOLDER--"), // TODO: This is actually 3 separate things.
    JCL_SET_FOR("--PLACEHOLDER--"), // TODO: Figure out what information in this line is actually relevant.
    CLASS("CLASS"), // Workload balancing class to be used for job submission (see CLASS field on the DB.1 panel).
    MSGCLASS("MSGCLASS"), // JES class that is used by this job (information only).
    REGION("REGION"), // Region used by this job (information only).
    PRTY("PRTY"), // Initial workload balancing priority that is assigned to this job upon initial queue entry.
    CPUTM("CPUTM"), // CPU time (weighted average) for this job.
    ELAPTM("ELAPTM"), // Time (weighted average) between job submission and job termination.
    TAPE1_CALC("TAPE1 CALC"), // High-water mark number of TYPE1 tape drives used by any step within this job as calculated by CA 7.
    TAPE1_MANL("TAPE1 MANL"), // Override of the CA 7 calculated number of TYPE1 tape drives used by this job (see TAPE DRIVES TYPE1 M field on DB.1 panel).
    TAPE2_CALC("TAPE2 CALC"), // High-water mark number of TYPE2 tape drives used by any step within this job as calculated by CA 7.
    TAPE2_MANL("TAPE2 MANL"), // Override of the CA 7 calculated number of TYPE2 tape drives used by this job (see TAPE DRIVES TYPE2 M field on DB.1 panel).
    DRCLASS("DRCLASS"), // The disaster recovery class assigned to this job.
    LTERM("LTERM"), // The logical terminal (STATION) that is to receive various messages regarding this job.
    JOBNET("JOBNET"), // Value entered in the JOBNET field on the DB.1 panel.
    NXTCYC("NXTCYC"), // If the normally scheduled processing cycles of the job have been suspended by the NXTCYC command, this value is SKP (for single cycle) or OFF (for all cycles until reset by the NXTCYC command).
    DONT_SCHEDULE_BEFORE("DONT SCHEDULE BEFORE"), // Dates and times to be resolved at the time a job record is to be brought into the request queue by schedule scan or a trigger (see the DONT SCHEDULE -- BEFORE and AFTER fields on the DB.1 panel). A job is not brought in automatically if it is a true condition.
    CONSIDER_ABNORMAL_END_IF("CONSIDER ABNORMAL END IF"), // Condition code tests to be performed to determine if the job has completed successfully.
    SATISFACTION_LEAD_TIME("SATISFACTION LEAD TIME"), // Initial satisfaction lead time values for job and data set requirements. (See the SATISFACTION LEAD TIME field on the DB.1 panel.)
    TIMES_LATE("# OF TIMES LATE"), // Number of times the job has been considered late, and the number of times the job has been restarted.
    TIMES_RESTARTED("# OF TIMES RESTARTED"); //Number of times the job has been considered late, and the number of times the job has been restarted.

    /**
     * Matches the given token to an enum entry, or null if the entry does not exits.
     * @param token Token to be matched. NOT case-sensitive.
     * @return The matched entry, or null if such entry does not exist.
     */
    public static JobInformationAttribute getMatch(String token) {
        for (JobInformationAttribute at : values())
            if (at.token.equalsIgnoreCase(token))
                return at;
        return null;
    }

    /*
     * The token represents the description in the Job Information section. This
     * is usually very similar to the name of the enum entry.
     */
    private String token;

    /**
     * Constructs the JobInformationAttribute with the token.
     * @param token Token of this attribute.
     */
    JobInformationAttribute(String token) {
        this.token = token;
    }

    /**
     * Returns the token of this attribute.
     * @return token of this attribute.
     */
    public String token() {
        return token;
    }

}
