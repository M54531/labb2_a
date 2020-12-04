import java.awt.*;

/**
 * special type of car,subclass of Car
 */
public class Saab95 extends PersonBil{
    /**
     * boolean variable true if saab95 has turbo
     * affects acceleration
     */
    private boolean turboOn;
    public void setTurbo(){
        turboOn=true    ;
    }
    public void setTurboOff(){
        turboOn=false    ;
    }

    public Saab95(){
        super(2, Color.red, 125,4, "Saab95");
        turboOn = false;
    }

    /**
     *
     * @return  maximum increase in speed per unit of time
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}




