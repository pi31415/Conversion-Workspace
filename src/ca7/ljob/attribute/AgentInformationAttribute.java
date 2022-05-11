package ca7.ljob.attribute;

/**
 * This enum stores keys and tokens for all information located in the Agent Information section of the LJob report.
 *
 * This is a child of the LJobAttribute using itself as the generic type.
 *
 * Below is an example of what the Agent Information section looks like.
 *
 *        ------------------------- AGENT INFORMATION  -------------------------
 *        Job Type: NT_JOB
 *        Agent   : USER023ESP
 *        Userid  : usero23
 *
 * @author michael.baljet
 * @see ca7.ljob.attribute.LJobAttribute
 *
 */
public enum AgentInformationAttribute implements LJobAttribute {

    JOB_TYPE("Job Type"), // Type of the Job.
    AGENT("Agent"), // Agent name.
    USERID("Userid"); // User ID of the agent.

    /**
     * Matches the given token to an enum entry, or null if the entry does not exits.
     * @param token Token to be matched. NOT case-sensitive.
     * @return The matched entry, or null if such entry does not exist.
     */
    public static AgentInformationAttribute getMatch(String token) {
        for (AgentInformationAttribute at : values())
            if (at.token.equalsIgnoreCase(token))
                return at;
        return null;
    }

    private String token;

    /**
     * Constructs the AgentInformationAttribute with the token.
     * @param token Token of this attribute.
     */
    AgentInformationAttribute(String token) {
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
