package it.unibo.generics.graph.impl;

import java.util.Deque;

import it.unibo.generics.graph.api.FringeAccumulationStrategy;

public final class BreadthFirst<S> implements FringeAccumulationStrategy<S> {

    private static final BreadthFirst<?> INSTANCE = new BreadthFirst<>();

    private BreadthFirst() {
    }

    @SuppressWarnings("unchecked")
    public static <S> BreadthFirst<S> getInstance() {
        return (BreadthFirst<S>) INSTANCE;
    }

    public void addToFringe(final Deque<? super S> fringe, final S step) {
        fringe.addLast(step);
    }

}
