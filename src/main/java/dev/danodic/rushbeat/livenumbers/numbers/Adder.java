package dev.danodic.rushbeat.livenumbers.numbers;

import dev.danodic.rushbeat.livenumbers.LiveNumber;

/**
 * A number that keeps summing up its step value to its actual value. An adder
 * has no maximum limit value.
 *
 * @author danodic
 */
public class Adder extends Number implements Comparable<LiveNumber>, LiveNumber {

    private Double value;
    private Double step;
    private Boolean allowNegative;

    public Adder() {
        this(1d);
    }

    public Adder(Double step) {
        this(step, 0d);
    }

    public Adder(Double step, Double value) {
        this(step, value, true);
    }

    public Adder(Double step, Double value, Boolean allowNegative) {
        this.value = value;
        this.step = step;
        this.allowNegative = allowNegative;
    }

    public Adder setAllowNegative(Boolean allowNegative) {
        this.allowNegative = allowNegative;
        return this;
    }

    public Adder setStep(Integer step) {
        setStep(step.doubleValue());
        return this;
    }

    public Adder setStep(Float step) {
        setStep(step.doubleValue());
        return this;
    }

    public Adder setStep(LiveNumber step) {
        setStep(step.doubleValue());
        return this;
    }

    public Adder setStep(Double step) {
        this.step = step;
        return this;
    }

    public Adder add(Integer value) {
        add(value.doubleValue());
        return this;
    }

    public Adder add(Float value) {
        add(value.doubleValue());
        return this;
    }

    public Adder add(LiveNumber value) {
        add(value.doubleValue());
        return this;
    }

    public Adder add(Double value) {
        this.value += value;
        return this;
    }

    public Adder multiply(Integer value) {
        multiply(value.doubleValue());
        return this;
    }

    public Adder multiply(Float value) {
        multiply(value.doubleValue());
        return this;
    }

    public Adder multiply(LiveNumber value) {
        multiply(value.doubleValue());
        return this;
    }

    public Adder multiply(Double value) {
        this.value *= value;
        return this;
    }

    public Adder divide(Integer value) {
        divide(value.doubleValue());
        return this;
    }

    public Adder divide(Float value) {
        divide(value.doubleValue());
        return this;
    }

    public Adder divide(LiveNumber value) {
        divide(value.doubleValue());
        return this;
    }

    public Adder divide(Double value) {
        this.value /= value;
        return this;
    }

    public Adder set(Integer value) {
        set(value.doubleValue());
        return this;
    }

    public Adder set(Float value) {
        set(value.doubleValue());
        return this;
    }

    public Adder set(LiveNumber value) {
        set(value.doubleValue());
        return this;
    }

    public Adder set(Double value) {
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
        value += step;
        if (!allowNegative && value < 0f) {
            value = 0d;
        }
    }

    @Override
    public boolean isDone() {
        return true;
    }

}
