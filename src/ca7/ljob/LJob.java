package ca7.ljob;

import ca7.ljob.attribute.*;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an LJob with all of its attributes. Needs to be parsed after constructed to be used.
 *
 * @author michael.baljet
 * @see LJobParser
 *
 */
public class LJob {

    /**
     * Raw LJob string. This is taken straight from the input file. Yet to be parsed.
     */
    private String lJobComplex;

    /**
     * Map that associates all tokens with their attributes.
     */
    private Map<LJobAttribute, String> attributes;

    /**
     * Constructs the object with the given String complex.
     * @param lJobComplex This object, in its raw text form.
     */
    public LJob(String lJobComplex) {
        this.lJobComplex = lJobComplex;
        attributes = new HashMap<>();
    }

    /**
     * Creates the parse task.
     * @return The parse task.
     */
    public Task<WorkerStateEvent> createParseTask() {
        return new LJobParser(lJobComplex, attributes);
    }

    /**
     * Gets the attribute associated with the given enum entry, or null if such entry is not defined.
     * @param attribute Attribute to get.
     * @return Attribute associated with the given entry.
     */
    public String getAttribute(LJobAttribute attribute) {
        return getAttribute(attribute.token());
    }

    /**
     * Gets the attribute associated with the given token, or null if such token is not defined.
     * @param token Token to search. NOT case-sensitive.
     * @return Attribute associated with the given token.
     */
    public String getAttribute(String token) {
        if (attributes.isEmpty())
            return null; // Map is still empty.
        if (HeaderAttribute.getMatch(token) != null)
            return attributes.get(HeaderAttribute.getMatch(token));
        if (JobInformationAttribute.getMatch(token) != null)
            return attributes.get(JobInformationAttribute.getMatch(token));
        if (AgentInformationAttribute.getMatch(token) != null)
            return attributes.get(AgentInformationAttribute.getMatch(token));
        if (ProseAttribute.getMatch(token) != null)
            return attributes.get(ProseAttribute.getMatch(token));
        // TODO: Add maps as they are implemented.
        return null;
    }

}
