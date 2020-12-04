
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.awt.*;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class Testttt {
    @Before
    public void setup(){
        v1.stopEngine();
        s1.stopEngine();
    }
    @After
    public void teardown(){
        v1.move();
        s1.move();
        System.out.println("xposv: "+v1.getXPos()+" yposv: "+v1.getYPos());
    }
    Volvo240 v1 = new Volvo240(); // MyClass is tested
    Saab95 s1 = new Saab95();
    Scania ss1 = new Scania();
    @Test
    public void testBrake() {
        v1.brake(1);
        s1.brake(1);
        assertEquals(0, v1.getCurrentSpeed(), 0);
        assertEquals(0, s1.getCurrentSpeed(), 0);
        boolean error = false;
        try {
            v1.brake(2);
        } catch (IllegalArgumentException e) {
            error = true; }
        assertTrue(error);}
    @Test
    public void testGas() {
        v1.gas(1);
        s1.gas(1);
        assertEquals(1.25, v1.getCurrentSpeed(), 0);
        assertEquals(1.25, s1.getCurrentSpeed(), 0);
        boolean error = false;
        try {
            v1.gas(2);
        } catch (IllegalArgumentException e) {
            error = true;}
        assertTrue(error);
    }
    @Test
    public void testStartEngine(){
        v1.startEngine();
        s1.startEngine();
        assertEquals(0.1, v1.getCurrentSpeed(), 0);
        assertEquals(0.1, s1.getCurrentSpeed(), 0);
    }
    @Test
    public void testStopEngine(){
        s1.startEngine();
        v1.startEngine();
        v1.stopEngine();
        s1.stopEngine();
        assertEquals(0, v1.getCurrentSpeed(), 0);
        assertEquals(0, s1.getCurrentSpeed(), 0);
    }
    @Test
    public void testGet() {
        assertEquals(Color.black,v1.getColor());
        assertEquals(2,s1.getNrDoors());
    }
    @Test
    public void testLoadCar() {
        Biltransport big = new Biltransport();
        Volvo240 v2 = new Volvo240();
        big.loadCar(v2);
        System.out.println(big.getLoadedCar(0));
        assertEquals(big.getLoadedCar(0), v2);
    }
    @Test
    public void testUnloadCar() {
        Biltransport big = new Biltransport();
        Volvo240 v2 = new Volvo240();
        big.loadCar(v2);
        big.unload();
        assertEquals(big.getNrLoadedCars(),0);
    }
    @Test
    public void testMax(){
        Bilverkstad<Car> verk = new Bilverkstad();
        verk.loadCar(v1);
        verk.loadCar(s1);
        assertEquals(verk.getNrLoadedCars(),2);
    }
    @Test
    public void unloadverkstad(){
        Bilverkstad<Car> verk = new Bilverkstad();
        verk.loadCar(v1);
        verk.unloadCar(v1);
        assertEquals(verk.getNrLoadedCars(),0);
    }
    @Test
    public void testMove(){
        Volvo240 v2 =new Volvo240();
        Biltransport big = new Biltransport();
        big.loadCar(v2);
        big.setRamp();big.gas(1);big.move();
        assertEquals(v2.getXPos()+v2.getYPos(),big.getYPos()+big.getXPos(),0.1);
    }
    @Test
    public void testUnloadFarja(){
        BilFarja farja = new BilFarja();
        Volvo240 v2 =new Volvo240();
        Volvo240 v3 =new Volvo240();
        Volvo240 v4 =new Volvo240();
        farja.loadCar(v2);farja.loadCar(v3);farja.loadCar(v4);
        farja.unload();
        assertEquals(false,farja.contains1(v2));
    }
    @Test
    public void testSamecar(){
        Volvo240 v3= new Volvo240();
        Biltransport big = new Biltransport();
        big.loadCar(v3);big.loadCar(v3);
        assertEquals(1,big.getNrLoadedCars());
    }
}






