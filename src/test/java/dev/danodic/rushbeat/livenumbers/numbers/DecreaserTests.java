package dev.danodic.rushbeat.livenumbers.numbers;

import org.testng.annotations.Test;

public class DecreaserTests {

    @Test
    public void testSetValueDouble() {
        Decreaser d = new Decreaser(1d, 0d, 10d);
        d.set(5.0);
        d.update();
        assert Double.compare(d.doubleValue(), 4d) == 0;
    }
    
    @Test
    public void testSetStepDouble() {
        Decreaser d = new Decreaser(1d, 0d, 10d);
        d.set(5.0);
        d.setStep(2.0);
        d.update();
        assert Double.compare(d.doubleValue(), 3d) == 0;
    }

}
