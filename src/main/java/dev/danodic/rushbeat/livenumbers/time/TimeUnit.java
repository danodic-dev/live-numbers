package dev.danodic.rushbeat.livenumbers.time;

/**
 * Represents a single unit of time like Minute, Second or Hour. Used to deal
 * with time-based live numbers.
 *
 * @author danodic
 */
public interface TimeUnit {
    
    public Long getRawValue();
    
    public Double doubleValue();

    public Float floatValue();

    public Integer intValue();

    public TimeUnit set(TimeUnit value);

    public TimeUnit set(Integer value);

    public TimeUnit set(Float value);

    public TimeUnit set(Double value);

    public TimeUnit add(TimeUnit value);

    public TimeUnit add(Integer value);

    public TimeUnit add(Float value);

    public TimeUnit add(Double value);

    public TimeUnit subtract(TimeUnit value);

    public TimeUnit subtract(Integer value);

    public TimeUnit subtract(Float value);

    public TimeUnit subtract(Double value);

    public TimeUnit multiply(TimeUnit value);

    public TimeUnit multiply(Integer value);

    public TimeUnit multiply(Float value);

    public TimeUnit multiply(Double value);

    public TimeUnit divide(TimeUnit value);

    public TimeUnit divide(Integer value);

    public TimeUnit divide(Float value);

    public TimeUnit divide(Double value);

}
