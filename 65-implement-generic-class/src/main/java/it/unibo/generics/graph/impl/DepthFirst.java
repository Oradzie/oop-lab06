package it.unibo.generics.graph.impl;

import java.util.Deque;

import it.unibo.generics.graph.api.FringeAccumulationStrategy;

public final class DepthFirst<S> implements FringeAccumulationStrategy<S> {

    private static final DepthFirst<?> INSTANCE = new DepthFirst<>();

    private DepthFirst() {
    }

    @SuppressWarnings("unchecked")
    public static <S> DepthFirst<S> getInstance() {
        return (DepthFirst<S>) INSTANCE;
    }

    @Override
    public void addToFringe(final Deque<? super S> fringe, final S step) {
        fringe.addFirst(step);
    }
}
