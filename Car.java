import java.awt.*;

/**
 * Abstract class Car
 */
public abstract class Car implements Movable{
    //public final static double trimFactor = 1.25;
    /**
     * Number of doors
     */
    private int nrDoors; // Number of doors on the car
    /**
     * cars engine power
     */
    private double enginePower; // Engine power of the car
    /**
     * cars current speed
     */
    private double currentSpeed; // The current speed of the car
    /**
     * Cars color
     */
    private Color color; // Color of the car
    /**
     * Cars model name
     */
    private String modelName; // The car model name
    /**
     * Cars current x coordinate
     *
     */

    private double xPos = 0;// x position
    /**
     * cars current y coordinate
     */
    private double yPos = 0;// y position
    /**
     * current direction of the car [0.2pi]
     */
    private double theta;

    private double size;

    protected boolean driveable;

    /**
     * Creates car
     * @param nrDoors number of doors to set
     * @param color color to set
     * @param enginePower cars engine power to set
     * @param modelName name to set for car
     */
    public Car(int nrDoors, Color color, int enginePower, double size, String modelName, double theta) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.size = size;
        this.modelName = modelName;
        this.theta = theta;
        stopEngine();
    }
    public Car(){

    }

    public double getSize(){
        return size;
    }
    /**
     * NrDoors getter
     * @return nrDoors: number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * enginePower getter
     * @return enginePower: power of the engine
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     *  currentSpeed getter
     * @return currentSpeed: current speed of Car
     */

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * XPos getter
     * @return xPos: x coordinate
     */
    public double getXPos() {
        return xPos;
    }

    /**
     * yPos getter
     * @return yPos: y coordinate
     */
    public double getYPos() {
        return yPos;
    }

    /**
     * color getter
     * @return color: cars color
     */

    public Color getColor() {
        return color;
    }
    public double getTheta() {
        return theta;
    }
    public void setSize(double s){
        size=s;
    }

    public void setXPos(double x){
        xPos=x;
    }
    public void setYPos(double y){
        yPos=y;
    }

    /**
     * color setter
     * @param clr: set Color to clr
     */

    private void setColor(Color clr) {
        color = clr;
    }

    /**
     * nrDoors setter
     * @param n: set NrDoors to n
     */
    private void setNrDoors(int n) {
        nrDoors=n;
    }

    /**
     * enginePower setter
     * @param n: set enginePower to n
     */
    private void setEnginePower(int n) {
        this.enginePower=n;
    }

    /**
     * Model name setter
     * @param modelName: set modelName to modelName
     */

    private void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * sets the current Speed to 0.1
     */

    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * sets the current Speed to 0
     */
    protected void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * abstract method speedFactor (different for different models)
     * @return
     */
    public abstract double speedFactor();

    /**
     * Increases speed of the car
     * @param amount proportion of speedFactor
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);

    }

    /**
     * Decreases speed of car
     * @param amount proportion of speedFactor
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);

    }

    /**
     * accelerate
     * @param amount acceleration factor [0,1]
     */
    public void gas(double amount) {
        if (amount > 1 || amount < 0) {
            throw new IllegalArgumentException("argument needs to be between zero and one");
        }
        incrementSpeed(amount);
    }

    /**
     * decelerate
     * @param amount deceleration factor [0,1]
     */
    public void brake(double amount) {
        if (amount > 1 || amount < 0) {
            throw new IllegalArgumentException("argument needs to be between zero and one");
        }
        decrementSpeed(amount);
    }

    /**
     * move the car in the current direction with the current speed for 1 unit of time
     */

    @Override
    public void move() {
        if(true) {
            setXPos(Math.cos(getTheta()) * getCurrentSpeed() + getXPos());
            setYPos(Math.sin(getTheta()) * getCurrentSpeed() + getYPos());
        }
    }

    /**
     * Rotate counterclockwise with 90degrees
     */
    @Override
    public void turnLeft() {
        theta=theta+Math.PI/2;
        theta=theta%(2*Math.PI);


    }

    /**
     * Rotate clockwise with 90degrees
     */
    @Override
    public void turnRight() {
        theta=theta+Math.PI*3/2;
        theta=theta%(2*Math.PI);

    }

}

