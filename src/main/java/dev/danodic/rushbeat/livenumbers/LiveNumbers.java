package dev.danodic.rushbeat.livenumbers;

import dev.danodic.rushbeat.livenumbers.numbers.Adder;
import dev.danodic.rushbeat.livenumbers.numbers.Clamper;
import dev.danodic.rushbeat.livenumbers.numbers.Interpolator;
import dev.danodic.rushbeat.livenumbers.numbers.Decreaser;
import dev.danodic.rushbeat.livenumbers.numbers.Increaser;
import dev.danodic.rushbeat.livenumbers.numbers.Multiplier;
import java.util.ArrayList;
import java.util.List;

/**
 * A factory class for providing instances of Live Numbers. If you have many
 * instances of values that have to be updated every loop, use this factory
 * instead of instantiating the numbers directly. Call the update() method in
 * your main loop to interpolate / decrease / etc all values.
 *
 * @author danodic
 */
public class LiveNumbers {

    private List<LiveNumber> numbers;

    public LiveNumbers() {
        numbers = new ArrayList<>();
    }

    public Clamper getClamper() {
        Clamper c = new Clamper();
        numbers.add(c);
        return c;
    }

    public Decreaser getDecreaser() {
        Decreaser d = new Decreaser();
        numbers.add(d);
        return d;
    }

    public Interpolator getInterpolator() {
        Interpolator i = new Interpolator();
        numbers.add(i);
        return i;
    }

    public Increaser getIncreaser() {
        Increaser i = new Increaser();
        numbers.add(i);
        return i;
    }
    
    public Adder getAdder() {
        Adder a = new Adder();
        numbers.add(a);
        return a;
    }

    public Multiplier getMultiplier() {
        Multiplier m = new Multiplier();
        numbers.add(m);
        return m;
    }

    public void update() {
        numbers.forEach(n -> n.update());
    }

}
