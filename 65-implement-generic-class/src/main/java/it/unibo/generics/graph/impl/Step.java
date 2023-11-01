package it.unibo.generics.graph.impl;

import java.util.LinkedList;
import java.util.List;

class Step<N> {
    private final Step<N> prevStep;
    private final N position;

    Step(final N position) {
        this(null, position);
    }

    Step(final Step<N> previousStep, final N currentPosition) {
        this.prevStep = previousStep;
        this.position = currentPosition;
    }

    public List<N> getPath() {
        final List<N> result = new LinkedList<>();
        Step<N> curr = this;
        do {
            result.add(0, curr.position);
            curr = curr.prevStep;
        } while (curr != null);

        return result;
    }

    public N getPosition() {
        return position;
    }

    public String toString() {
        final List<String> elements = new LinkedList<>();
        for (final N node : getPath()) {
            elements.add(node.toString());
        }

        return String.join(" -> ", elements);
    }

}
