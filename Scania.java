import java.awt.*;

/**
 *special type of car,subclass of Car
 */
public class Scania extends Truck{
    /**
     * Angle of truck platform [0,70]
     */
    private int platfromAngle;


    public Scania() {
        super(2, Color.blue, 90, 10, "Scania", 0);
        platfromAngle=0;

    }

    /**
     *
     * @return
     */
    public int getPlatfromAngle(){
        return platfromAngle;
    }


    public void increaseAngle(int increment){
        if (increment<0)
            throw new IllegalArgumentException("Argument cannot be less then zero.");
        if (this.getCurrentSpeed()==0)
            platfromAngle=Math.min(platfromAngle+increment,70);
    }

    public void decreaseAngle(int decrement){
        if (decrement<0)
            throw new IllegalArgumentException("Argument cannot be less then zero.");
        if (getCurrentSpeed()==0)
            platfromAngle=Math.max(platfromAngle-decrement,0);
    }
    @Override
    public boolean driveable(){
        if (platfromAngle==0)
            return true;
        else
            return false;
    }
}