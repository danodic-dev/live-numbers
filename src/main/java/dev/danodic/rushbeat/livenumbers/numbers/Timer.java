package dev.danodic.rushbeat.livenumbers.numbers;

import dev.danodic.rushbeat.livenumbers.LiveNumber;
import dev.danodic.rushbeat.livenumbers.support.clock.IClock;
import dev.danodic.rushbeat.livenumbers.support.clock.RealTimeClock;
import java.time.Instant;

/**
 * A basic real-time timer.
 *
 * @author danodic
 */
public class Timer implements Comparable<Timer>, LiveNumber {

    private static final Double SECOND_FACTOR = 1000d;
    private static final Double MINUTE_FACTOR = 60000d;
    private static final Double HOUR_FACTOR = 3600000d;

    private Long start;
    private Long duration;
    private Long current;
    private Long pauseInstant;
    private Long pausedTime;
    private Boolean running;
    private Boolean paused;

    private IClock clock;

    public Timer(Double time) {
        this(time, new RealTimeClock());
    }

    public Timer(Double time, IClock clock) {
        running = false;
        paused = false;
        duration = time.longValue() * 1000l;
        this.clock = clock;
    }

    public Timer start() {

        if (!running && !paused) {
            current = 0l;
            start = clock.now();
            running = true;
        }

        if (running && paused) {
            start += pausedTime;
            pausedTime = 0l;
            pauseInstant = 0l;
            paused = false;
        }

        return this;
    }

    public Timer stop() {
        running = false;
        paused = false;
        return this;
    }

    public Timer pause() {
        if (running) {
            pausedTime = 0l;
            pauseInstant = Instant.now().toEpochMilli();
            paused = true;
        }
        return this;
    }

    public void update() {
        if (running && !paused) {
            current = Instant.now().toEpochMilli() - start;
        } else if (running && paused) {
            pausedTime = Instant.now().toEpochMilli() - pauseInstant;
        }

        if (Double.compare(current, duration) >= 0) {
            running = false;
            paused = false;
            current = duration;
        }
    }

    public Double getSecond() {
        return current / SECOND_FACTOR;
    }

    public Double getRemainingSecond() {
        return (duration - current) / MINUTE_FACTOR;
    }

    public Double getMinute() {
        return current / SECOND_FACTOR;
    }

    public Double getRemainingMinute() {
        return (duration - current) / MINUTE_FACTOR;
    }

    public Double getHour() {
        return current / HOUR_FACTOR;
    }

    public Double getRemainingHour() {
        return (duration - current) / HOUR_FACTOR;
    }

    @Override
    public int compareTo(Timer other) {
        return Double.compare(current, other.doubleValue());
    }

    @Override
    public double doubleValue() {
        return current.floatValue();
    }

    @Override
    public boolean isDone() {
        return Double.compare(current, duration) == 0;
    }

}
