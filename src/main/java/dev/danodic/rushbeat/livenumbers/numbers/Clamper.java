package dev.danodic.rushbeat.livenumbers.numbers;

import dev.danodic.rushbeat.livenumbers.LiveNumber;

/**
 * It is a mutable number class that Holds a value clamped within two values. If
 * you set a value that is outside the range, it will be clamped to either the
 * maximum or minimum value.
 *
 * @author danodic
 */
public class Clamper extends Number implements Comparable<LiveNumber>, LiveNumber {

    private Double value;
    private Double minimum;
    private Double maximum;

    public Clamper() {
        this(0d, 1d);
    }

    public Clamper(LiveNumber minimum, LiveNumber maximum) {
        this(minimum.doubleValue(), maximum.doubleValue());
    }

    public Clamper(Float minimum, Float maximum) {
        this(minimum.doubleValue(), maximum.doubleValue());
    }

    public Clamper(Integer minimum, Integer maximum) {
        this(minimum.doubleValue(), maximum.doubleValue());
    }

    public Clamper(Double minimum, Double maximum) {
        this.value = 0d;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Clamper setMinimum(Integer minimum) {
        setMinimum(minimum.doubleValue());
        return this;
    }

    public Clamper setMinimum(Float minimum) {
        setMinimum(minimum.doubleValue());
        return this;
    }

    public Clamper setMinimum(LiveNumber minimum) {
        setMinimum(minimum.doubleValue());
        return this;
    }

    public Clamper setMinimum(Double minimum) {
        this.minimum = minimum;
        return this;
    }

    public Clamper setMaximum(Integer maximum) {
        setMaximum(maximum.doubleValue());
        return this;
    }

    public Clamper setMaximum(Float maximum) {
        setMaximum(maximum.doubleValue());
        return this;
    }

    public Clamper setMaximum(LiveNumber maximum) {
        setMaximum(maximum.doubleValue());
        return this;
    }

    public Clamper setMaximum(Double maximum) {
        this.maximum = maximum;
        return this;
    }

    public Clamper add(Integer value) {
        add(value.doubleValue());
        return this;
    }

    public Clamper add(Float value) {
        add(value.doubleValue());
        return this;
    }

    public Clamper add(LiveNumber value) {
        add(value.doubleValue());
        return this;
    }

    public Clamper add(Double value) {
        this.value = clamp(this.value + value);
        return this;
    }

    public Clamper multiply(Integer value) {
        multiply(value.doubleValue());
        return this;
    }

    public Clamper multiply(Float value) {
        multiply(value.doubleValue());
        return this;
    }

    public Clamper multiply(LiveNumber value) {
        multiply(value.doubleValue());
        return this;
    }

    public Clamper multiply(Double value) {
        this.value = clamp(this.value * value);
        return this;
    }

    public Clamper divide(Integer value) {
        divide(value.doubleValue());
        return this;
    }

    public Clamper divide(Float value) {
        divide(value.doubleValue());
        return this;
    }

    public Clamper divide(LiveNumber value) {
        divide(value.doubleValue());
        return this;
    }

    public Clamper divide(Double value) {
        this.value = clamp(this.value / value);
        return this;
    }

    public Clamper set(Integer value) {
        set(value.doubleValue());
        return this;
    }

    public Clamper set(Float value) {
        set(value.doubleValue());
        return this;
    }

    public Clamper set(LiveNumber value) {
        set(value.doubleValue());
        return this;
    }

    public Clamper set(Double value) {
        this.value = clamp(value);
        return this;
    }

    private Double clamp(double value) {
        return Math.min(maximum, Math.max(minimum, value));
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
    }

    @Override
    public boolean isDone() {
        return true;
    }

}
