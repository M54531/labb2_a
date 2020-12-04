import java.awt.*;

public abstract class Truck extends Car{

    public Truck(int nrDoors, Color color, int enginePower, double size, String modelName, double theta) {
        super(nrDoors, color, enginePower, size, modelName, theta);
    }

    public abstract boolean driveable(); // Abstract method which returns 1 if the truck can drive and 0 otherwise.

    @Override
    public double speedFactor(){
        return getEnginePower()*0.01;
    }

    @Override
    public void startEngine(){
        if (driveable()) {
            super.startEngine();
        }


    }
    @Override
    public void gas(double amount) {
        if (driveable()) {
            super.gas(amount);
        }
    }


}
