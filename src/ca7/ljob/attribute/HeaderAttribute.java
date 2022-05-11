package ca7.ljob.attribute;

/**
 * This enum stores keys and tokens for all information located in the header of the LJob report.
 *
 * This is a child of the LJobAttribute using itself as the generic type.
 *
 * Below is an example of what the header section looks like.
 *
 *   JOB    ----JCL----   SYSTEM  USR MAIN PROSE  SCHED  --NUMBER OF-   LAST-RUN
 *   NAME    ID  MEMBER   -NAME-  -ID -ID- DSNBR  DSNBR  STP DDS RUNS   DATE/TIME
 *
 * @author michael.baljet
 * @see ca7.ljob.attribute.LJobAttribute
 *
 */
public enum HeaderAttribute implements LJobAttribute {

    JOB_NAME("JOB NAME"), // Identifies the name defined in the database for this job.
    JCL_ID("JCL ID"), // Identifies the numeric INDEX assigned to the JCL statement that defines the data set in which this member resides. ID=255 indicates that a symbolic INDEX is assigned to the JCL statement that defines the data set in which this member resides.
    JCL_MEMBER("JCL MEMBER"), // Identifies the member name of the JCL that is executed by this job.
    SYSTEM_NAME("SYSTEM NAME"), // Identifies the value from the SYSTEM field on the DB.1 panel.
    USR_ID("USR ID"), // Identifies the value from the UID field on the DB.1 panel.
    MAIN_ID("MAIN ID"), // Identifies the value from the MAINID field on the DB.1 panel.
    PROSE_DSNBR("PROSE DSNBR"), // Identifies the CA 7 generated DSNBR for the job documentation defined for this job.
    SCHED_DSNBR("SCHED DSNBR"), // Identifies the CA 7 generated DSNBR for the schedule member defined for this job.
    NUMBER_OF_STP("NUMBER OF STP"), // Identifies the number of steps executed within this job.
    NUMBER_OF_DDS("NUMBER OF DDS"), // Identifies the number of DDs referenced by this job.
    NUMBER_OF_RUNS("NUMBER OF RUNS"), // Identifies the number of times this job has successfully executed under CA 7.
    LAST_RUN_DT("LAST RUN DT"); // Identifies the last date/time (start date/time) that the job ran successfully under CA 7. A plus sign displayed immediately after the field indicates that job's last run date/time is normalized to the time zone of the running CA 7.

    /**
     * Matches the given token to an enum entry, or null if the entry does not exits.
     * @param token Token to be matched. NOT case-sensitive.
     * @return The matched entry, or null if such entry does not exist.
     */
    public static HeaderAttribute getMatch(String token) {
        for (HeaderAttribute at : values())
            if (at.token.equalsIgnoreCase(token))
                return at;
        return null;
    }

    private String token;

    /**
     * Constructs the HeaderAttribute with the token.
     * @param token Token of this attribute.
     */
    HeaderAttribute(String token) {
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
