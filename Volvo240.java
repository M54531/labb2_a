import java.awt.*;

/**
 *special type of car,subclass of Car
 */
public class Volvo240 extends Car{
    /**
     * Trim factor affects acceleration
     */
    private final static double trimFactor = 1.25;


    public Volvo240(){
        super(4, Color.black, 100, 5, "Volvo240", 0);
    }
    /**
     *
     * @return  maximum increase in speed per unit of time
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}

