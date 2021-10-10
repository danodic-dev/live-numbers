package dev.danodic.rushbeat.livenumbers.numbers;

import dev.danodic.rushbeat.livenumbers.LiveNumber;

/**
 * A number that can be set to a given value and it will decrease until it
 * reaches its minium value. A maximum value can be defined, so it will be
 * clamped between minimum and maximum.
 *
 * @author danodic
 */
public class Decreaser extends Number implements Comparable<LiveNumber>, LiveNumber {

    private Double value;
    private Double minimum;
    private Double maximum;
    private Double step;

    public Decreaser() {
        this(0.1d);
    }

    public Decreaser(Double step) {
        this(step, 0d);
    }

    public Decreaser(Double step, Double minimum) {
        this(step, minimum, null);
    }

    public Decreaser(Double step, Double minimum, Double maximum) {
        this.step = step;
        this.value = 0d;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Decreaser setStep(Integer step) {
        setStep(step.doubleValue());
        return this;
    }

    public Decreaser setStep(Float step) {
        setStep(step.doubleValue());
        return this;
    }

    public Decreaser setStep(LiveNumber step) {
        setStep(step.doubleValue());
        return this;
    }

    public Decreaser setStep(Double step) {
        this.step = step;
        return this;
    }

    public Decreaser setMinimum(Integer minimum) {
        setMinimum(minimum.doubleValue());
        return this;
    }

    public Decreaser setMinimum(Float minimum) {
        setMinimum(minimum.doubleValue());
        return this;
    }

    public Decreaser setMinimum(LiveNumber minimum) {
        setMinimum(minimum.doubleValue());
        return this;
    }

    public Decreaser setMinimum(Double minimum) {
        this.minimum = minimum;
        return this;
    }

    public Decreaser setMaximum(Integer maximum) {
        setMaximum(maximum.doubleValue());
        return this;
    }

    public Decreaser setMaximum(Float maximum) {
        setMaximum(maximum.doubleValue());
        return this;
    }

    public Decreaser setMaximum(LiveNumber maximum) {
        setMaximum(maximum.doubleValue());
        return this;
    }

    public Decreaser setMaximum(Double maximum) {
        this.maximum = maximum;
        return this;
    }

    public Decreaser add(Integer value) {
        add(value.doubleValue());
        return this;
    }

    public Decreaser add(Float value) {
        add(value.doubleValue());
        return this;
    }

    public Decreaser add(LiveNumber value) {
        add(value.doubleValue());
        return this;
    }

    public Decreaser add(Double value) {
        if (maximum != null) {
            this.value = clamp(this.value + value);
        } else {
            this.value += value;
        }
        return this;
    }

    public Decreaser multiply(Integer value) {
        multiply(value.doubleValue());
        return this;
    }

    public Decreaser multiply(Float value) {
        multiply(value.doubleValue());
        return this;
    }

    public Decreaser multiply(LiveNumber value) {
        multiply(value.doubleValue());
        return this;
    }

    public Decreaser multiply(Double value) {
        if (maximum != null) {
            this.value = clamp(this.value * value);
        } else {
            this.value *= value;
        }
        return this;
    }

    public Decreaser divide(Integer value) {
        divide(value.doubleValue());
        return this;
    }

    public Decreaser divide(Float value) {
        divide(value.doubleValue());
        return this;
    }

    public Decreaser divide(LiveNumber value) {
        divide(value.doubleValue());
        return this;
    }

    public Decreaser divide(Double value) {
        if (maximum != null) {
            this.value = clamp(this.value / value);
        } else {
            this.value /= value;
        }
        return this;
    }

    public Decreaser set(Integer value) {
        set(value.doubleValue());
        return this;
    }

    public Decreaser set(Float value) {
        set(value.doubleValue());
        return this;
    }

    public Decreaser set(LiveNumber value) {
        set(value.doubleValue());
        return this;
    }

    public Decreaser set(Double value) {
        this.value = clamp(value);
        return this;
    }

    private Double clamp(double value) {
        if (maximum != null) {
            return Math.min(maximum, Math.max(minimum, value));
        }
        return value;
    }

    @Override
    public void update() {
        value -= step;
        if (Double.compare(value, minimum) < 0) {
            value = minimum;
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

    @Override
    public boolean isDone() {
        return Double.compare(value, minimum) == 0;
    }

}
