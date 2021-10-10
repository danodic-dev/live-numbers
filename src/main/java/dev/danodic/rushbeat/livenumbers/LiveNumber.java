package dev.danodic.rushbeat.livenumbers;

/**
 * A live number is expected to update itself every time the update function is
 * called. All live numbers are expected to represent itself as a double in
 * its internal logic. Also, a live number is expected to finish updating at
 * a given time.
 */
public interface LiveNumber {

    /**
     * Updates this live number.
     */
    public void update();

    /**
     * Returns the double representation of this live number.
     * @return the double value of this live number.
     */
    public double doubleValue();

    /**
     * Returns wheter the number is done updating.
     * @return true if the number has finished updating.
     */
    public boolean isDone();
}
