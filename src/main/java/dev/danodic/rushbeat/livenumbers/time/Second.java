package dev.danodic.rushbeat.livenumbers.time;

/**
 * A class that represents a second. Its value is stored in miliseconds.
 *
 * @author danodic
 */
public class Second implements TimeUnit {

    private static final Long TIME_FACTOR = 1000l;
    private Double value;

    public Second() {
        set(0);
    }

    public Second(TimeUnit value) {
        set(value);
    }

    public Second(Integer value) {
        set(value);
    }

    public Second(Float value) {
        set(value);
    }

    public Second(Double value) {
        set(value);
    }
    
    
    @Override
    public Long getRawValue() {
        return value;
    }

    @Override
    public Double doubleValue() {
        return value / TIME_FACTOR.doubleValue();
    }

    @Override
    public Float floatValue() {
        return value.floatValue() / TIME_FACTOR.floatValue();
    }

    @Override
    public Integer intValue() {
        return value.intValue() / TIME_FACTOR.intValue();
    }

    @Override
    public TimeUnit add(TimeUnit value) {
        this.value += value.longValue();
        return this;
    }

    @Override
    public TimeUnit add(Integer value) {
        this.value += (value * TIME_FACTOR.intValue());
        return this;
    }

    @Override
    public TimeUnit add(Float value) {
        this.value += (value * TIME_FACTOR.floatValue());
        return this;
    }

    @Override
    public TimeUnit add(Double value) {
        this.value += (value * TIME_FACTOR);
        return this;
    }

    @Override
    public TimeUnit subtract(TimeUnit value) {
        this.value -= value.doubleValue();
        return this;
    }

    @Override
    public TimeUnit subtract(Integer value) {
        this.value -= (value * TIME_FACTOR.intValue());
        return this;
    }

    @Override
    public TimeUnit subtract(Float value) {
        this.value -= (value * TIME_FACTOR.floatValue());
        return this;
    }

    @Override
    public TimeUnit subtract(Double value) {
        this.value -= (value * TIME_FACTOR);
        return this;
    }

    @Override
    public TimeUnit multiply(TimeUnit value) {
        this.value *= value.doubleValue();
        return this;
    }

    @Override
    public TimeUnit multiply(Integer value) {
        this.value *= (value * TIME_FACTOR.intValue());
        return this;
    }

    @Override
    public TimeUnit multiply(Float value) {
        this.value *= (value * TIME_FACTOR.floatValue());
        return this;
    }

    @Override
    public TimeUnit multiply(Double value) {
        this.value *= (value * TIME_FACTOR);
        return this;
    }

    @Override
    public TimeUnit divide(TimeUnit value) {
        this.value /= value.doubleValue();
        return this;
    }

    @Override
    public TimeUnit divide(Integer value) {
        this.value /= (value * TIME_FACTOR);
        return this;
    }

    @Override
    public TimeUnit divide(Float value) {
        this.value /= (value * TIME_FACTOR.floatValue());
        return this;
    }

    @Override
    public TimeUnit divide(Double value) {
        this.value /= (value * TIME_FACTOR);
        return this;
    }

    @Override
    public final TimeUnit set(TimeUnit value) {
        this.value = value.doubleValue();
        return this;
    }

    @Override
    public final TimeUnit set(Integer value) {
        this.value = (double) (value * TIME_FACTOR.intValue());
        return this;
    }

    @Override
    public final TimeUnit set(Float value) {
        this.value = (double) (value * TIME_FACTOR.floatValue());
        return this;
    }

    @Override
    public final TimeUnit set(Double value) {
        this.value = (value * TIME_FACTOR);
        return this;
    }

}
