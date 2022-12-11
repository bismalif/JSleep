package com.BismaAlifAlghifariJSleepMN;
/**
 * A functional interface that defines a method for evaluating an object and
 * returning a boolean result.
 *
 * @param <T> The type of object to be evaluated by this Predicate.
 * @author Bisma Alif Alghifari
 * @version 1.0
 */
public interface Predicate<T> {
    /**
     * Evaluates the given object and returns a boolean result.
     *
     * @param object The object to be evaluated.
     * @return The result of the evaluation.
     */
    public boolean predicate(T object);
}
