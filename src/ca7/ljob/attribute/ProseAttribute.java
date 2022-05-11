package ca7.ljob.attribute;

/**
 * This enum store the one entry for the prose section.
 *
 * This is a child of the LJobAttribute using itself as the generic type.
 *
 * Below is an example of what the prose section looks like.
 *
 *       THIS IS THE FIRST JOB IN THE TESTNTWK TO BE EXECUTED AND IS A
 *       SCHEDULED JOB.  IT CONSISTS OF TWO STEPS.  THE FIRST STEP RECEIVES
 *       A SET OF CONTROL CARDS AS INPUT, CREATES A DATASET CA7.TEST1 AS
 *       OUTPUT AND DEMANDS THE NEXT JOB DUSAXX02 TO BE STARTED.
 *
 * @author michael.baljet
 * @see ca7.ljob.attribute.LJobAttribute
 *
 */
public enum ProseAttribute implements LJobAttribute {

    PROSE("PROSE"); // Only ever one attribute in the prose section, so we just call it "prose".

    /**
     * Matches the given token to an enum entry, or null if the entry does not exits.
     * @param token Token to be matched. NOT case-sensitive.
     * @return The matched entry, or null if such entry does not exist.
     */
    public static ProseAttribute getMatch(String token) {
        for (ProseAttribute at : values())
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
     * Constructs the ProseAttribute with the token.
     * @param token Token of this attribute.
     */
    ProseAttribute(String token) {
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
