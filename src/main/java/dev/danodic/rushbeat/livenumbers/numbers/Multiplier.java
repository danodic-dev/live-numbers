package dev.danodic.rushbeat.livenumbers.numbers;

import dev.danodic.rushbeat.livenumbers.LiveNumber;

/**
 * A number that keeps multiplying its value by its step value. A multiplier has
 * no limit value.
 *
 * @author danodic
 */
public class Multiplier extends Number implements Comparable<LiveNumber>, LiveNumber {

    private Double value;
    private Double step;

    public Multiplier() {
        this(1d);
    }

    public Multiplier(Double step) {
        this(step, 0d);
    }

    public Multiplier(Double step, Double value) {
        this.value = value;
        this.step = step;
    }

    public Multiplier setStep(Integer step) {
        setStep(step.doubleValue());
        return this;
    }

    public Multiplier setStep(Float step) {
        setStep(step.doubleValue());
        return this;
    }

    public Multiplier setStep(LiveNumber step) {
        setStep(step.doubleValue());
        return this;
    }

    public Multiplier setStep(Double step) {
        this.step = step;
        return this;
    }

    public Multiplier add(Integer value) {
        add(value.doubleValue());
        return this;
    }

    public Multiplier add(Float value) {
        add(value.doubleValue());
        return this;
    }

    public Multiplier add(LiveNumber value) {
        add(value.doubleValue());
        return this;
    }

    public Multiplier add(Double value) {
        this.value += value;
        return this;
    }

    public Multiplier multiply(Integer value) {
        multiply(value.doubleValue());
        return this;
    }

    public Multiplier multiply(Float value) {
        multiply(value.doubleValue());
        return this;
    }

    public Multiplier multiply(LiveNumber value) {
        multiply(value.doubleValue());
        return this;
    }

    public Multiplier multiply(Double value) {
        this.value *= value;
        return this;
    }

    public Multiplier divide(Integer value) {
        divide(value.doubleValue());
        return this;
    }

    public Multiplier divide(Float value) {
        divide(value.doubleValue());
        return this;
    }

    public Multiplier divide(LiveNumber value) {
        divide(value.doubleValue());
        return this;
    }

    public Multiplier divide(Double value) {
        this.value /= value;
        return this;
    }

    public Multiplier set(Integer value) {
        set(value.doubleValue());
        return this;
    }

    public Multiplier set(Float value) {
        set(value.doubleValue());
        return this;
    }

    public Multiplier set(LiveNumber value) {
        set(value.doubleValue());
        return this;
    }

    public Multiplier set(Double value) {
        this.value = value;
        return this;
    }

    @Override
    public int intValue() {
        return value.intValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public int compareTo(LiveNumber other) {
        return Double.compare(value, other.doubleValue());
    }

    @Override
    public void update() {
        value *= step;
    }

    @Override
    public boolean isDone() {
        return true;
    }

}
