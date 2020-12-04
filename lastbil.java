public abstract class lastbil extends Car {
    protected double tilt=0;
    public double getTilt(){
        return tilt;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void startEngine() {
        if(driveAble()) {
            super.startEngine();
        }else{
            System.out.println("asdasd");
        }
    }
    public abstract void changeTilt(double vinkel);
    public abstract boolean driveAble();
}
