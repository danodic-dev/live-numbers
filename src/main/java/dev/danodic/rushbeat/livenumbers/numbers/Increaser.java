package dev.danodic.rushbeat.livenumbers.numbers;

import dev.danodic.rushbeat.livenumbers.LiveNumber;

/**
 * A number that can be set to a given value and it will increase until it
 * reaches its minium value. A maximum value can be defined, so it will be
 * clamped between minimum and maximum
 * @author danodic
 */
public class Increaser extends Number implements Comparable<LiveNumber>, LiveNumber {

    private Double value;
    private Double minimum;
    private Double maximum;
    private Double step;

    public Increaser() {
        this(0.1d);
    }
    
    public Increaser(Double step) {
        this(step, 1d);
    }
    
    public Increaser(Double step, Double maximum) {
        this(step, maximum, null);
    }
    
    public Increaser(Double step, Double maximum, Double minimum) {
        this.value = 0d;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Increaser setStep(Double step) {
        this.step = step;
        return this;
    }

    public Increaser add(Integer value) {
        add(value.doubleValue());
        return this;
    }

    public Increaser add(Float value) {
        add(value.doubleValue());
        return this;
    }

    public Increaser add(LiveNumber value) {
        add(value.doubleValue());
        return this;
    }

    public Increaser add(Double value) {
        if(minimum!=null) {
            this.value = clamp(this.value + value);
        } else {
            this.value += value;
        }
        return this;
    }

    public Increaser multiply(Integer value) {
        multiply(value.doubleValue());
        return this;
    }

    public Increaser multiply(Float value) {
        multiply(value.doubleValue());
        return this;
    }

    public Increaser multiply(LiveNumber value) {
        multiply(value.doubleValue());
        return this;
    }

    public Increaser multiply(Double value) {
        if(minimum!=null) {
            this.value = clamp(this.value * value);
        } else {
            this.value *= value;
        }
        return this;
    }

    public Increaser divide(Integer value) {
        divide(value.doubleValue());
        return this;
    }

    public Increaser divide(Float value) {
        divide(value.doubleValue());
        return this;
    }

    public Increaser divide(LiveNumber value) {
        divide(value.doubleValue());
        return this;
    }

    public Increaser divide(Double value) {
        if(minimum!=null) {
            this.value = clamp(this.value / value);
        } else {
            this.value /= value;
        }
        return this;
    }

    public Increaser set(Integer value) {
        set(value.doubleValue());
        return this;
    }

    public Increaser set(Float value) {
        set(value.doubleValue());
        return this;
    }

    public Increaser set(LiveNumber value) {
        set(value.doubleValue());
        return this;
    }

    public Increaser set(Double value) {
        this.value = clamp(this.value);
        return this;
    }

    private Double clamp(double value) {
        if (minimum != null) {
            return Math.min(maximum, Math.max(minimum, value));
        }
        return value;
    }

    @Override
    public void update() {
        value += step;
        if (Double.compare(value, maximum) > 0) {
            value = maximum;
        }
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

}
