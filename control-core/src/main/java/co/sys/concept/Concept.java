package co.sys.concept;

import co.sys.concept.adt.context.Context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Concept {

    private Map<Concept, Map<Context, Concept>> concept;

    public Concept(Map<Concept, Map<Context, Concept>> concept) {
        this.concept = concept;
    }

    public Concept() {
        this.concept = new ConcurrentHashMap<>();
    }

    public Map<Concept, Map<Context, Concept>> getConcept() {
        return concept;
    }

    public void setConcept(Map<Concept, Map<Context, Concept>> concept) {
        this.concept = concept;
    }
}
