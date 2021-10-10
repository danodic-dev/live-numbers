package dev.danodic.rushbeat.livenumbers.support.clock;

import java.time.Instant;

/**
 * A simple implementation of a real-time clock. Mostly a wrapper for the
 * Instant class.
 *
 * @author danodic
 */
public class RealTimeClock implements IClock {

    @Override
    public Long now() {
        return Instant.now().toEpochMilli();
    }
    
}
