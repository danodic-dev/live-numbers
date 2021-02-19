package dev.danodic.rushbeat.livenumbers.numbers;

import dev.danodic.rushbeat.livenumbers.LiveNumber;

/**
 * A number that can be set to a given target value and its actual value will
 * interpolate from the current value up to the target value.
 * @author danodic
 */
public class Interpolator extends Number implements Comparable<LiveNumber>, LiveNumber {

    private Double value;
    private Double targetValue;
    private Double step;

    public Interpolator() {
        this(0.1d);
    }

    public Interpolator(Double step) {
        this(step, 1d, 0d);
    }

    public Interpolator(Double step, Double targetValue, Double currentValue) {
        this.value = currentValue;
        this.targetValue = targetValue;
        this.step = step;
    }

    public void interpolate() {
        value = value + step * (targetValue - value);
    }

    public Interpolator add(Integer value) {
        add(value.doubleValue());
        return this;
    }

    public Interpolator add(Float value) {
        add(value.doubleValue());
        return this;
    }

    public Interpolator add(LiveNumber value) {
        add(value.doubleValue());
        return this;
    }

    public Interpolator add(Double value) {
        this.targetValue += value;
        return this;
    }

    public Interpolator multiply(Integer value) {
        multiply(value.doubleValue());
        return this;
    }

    public Interpolator multiply(Float value) {
        multiply(value.doubleValue());
        return this;
    }

    public Interpolator multiply(LiveNumber value) {
        multiply(value.doubleValue());
        return this;
    }

    public Interpolator multiply(Double value) {
        this.targetValue *= value;
        return this;
    }

    public Interpolator divide(Integer value) {
        divide(value.doubleValue());
        return this;
    }

    public Interpolator divide(Float value) {
        divide(value.doubleValue());
        return this;
    }

    public Interpolator divide(LiveNumber value) {
        divide(value.doubleValue());
        return this;
    }

    public Interpolator divide(Double value) {
        this.targetValue /= value;
        return this;
    }

    public Interpolator set(Integer value) {
        set(value.doubleValue());
        return this;
    }

    public Interpolator set(Float value) {
        set(value.doubleValue());
        return this;
    }

    public Interpolator set(LiveNumber value) {
        set(value.doubleValue());
        return this;
    }

    public Interpolator set(Double value) {
        this.targetValue = value;
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
        if (Double.compare(value, targetValue) != 0) {
            if(targetValue > value) {
                value += step;
            }
            
            if(targetValue < value) {
                value -= step;
            }
            
            if(Math.abs(value - targetValue) < step) {
                value = targetValue;
            }
        }
    }
}
