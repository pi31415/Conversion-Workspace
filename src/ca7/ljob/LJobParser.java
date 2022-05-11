package ca7.ljob;

import ca7.ljob.attribute.LJobAttribute;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;

import java.util.Map;

/**
 * Parses LJob objects. This is a child of Task and should be run on a separate thread as
 * to not interrupt the main jfx thread.
 *
 * @author michael.baljet
 * @see LJob
 *
 */
public class LJobParser extends Task<WorkerStateEvent> {

    // String complex argument.
    private String lJobComplex;

    // Map that gets populated as this parses.
    private Map<LJobAttribute, String> attributes;

    /**
     * Constructs the parser with the given arguments.
     * @param lJobComplex Complex to be parsed.
     * @param attributes Map to populate.
     */
    public LJobParser(String lJobComplex, Map<LJobAttribute, String> attributes) {
        this.lJobComplex = lJobComplex;
        this.attributes = attributes;
    }

    @Override
    protected WorkerStateEvent call() throws Exception {
        // TODO: parsing logic.
        return null;
    }

}
