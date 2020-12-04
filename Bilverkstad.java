import java.util.ArrayList;

public class Bilverkstad <carType extends Car> {

    private int maxNrCars;
    private int nrLoadedCars;
    private ArrayList<Car> carsInside;
    private String name;
    private double xPos;
    private double yPos;
    private static final double maxDistance = 1;


    public Bilverkstad(){
        maxNrCars = 1;
        name = "default";
    }

    public Bilverkstad(String name, int maxNrCars, double xPos, double yPos){
        this.name = name;
        this.maxNrCars = maxNrCars;
        this.xPos=xPos;
        this.yPos=yPos;
        carsInside = new ArrayList<>();
    }



    public void loadCar(carType car) {
        double distance = Math.sqrt(Math.pow(xPos-car.getXPos(),2)+Math.pow(yPos-car.getYPos(),2));
        if( distance < maxDistance && carsInside.size() < maxNrCars){
            carsInside.add(car);
            car.setXPos(xPos);
            car.setYPos(yPos);
        }
    }

    public void unloadCar(carType car) {
        if(carsInside.contains(car)) {
            int index = carsInside.indexOf(car);
            carsInside.get(index).setXPos(car.getXPos()-Math.cos(car.getTheta()));
            carsInside.get(index).setYPos(car.getYPos()-Math.sin(car.getTheta()));
            carsInside.remove(index);
            System.out.println("Bilen " + car + " hämtades ut.");
        }
    }
    public int getNrLoadedCars(){
        return nrLoadedCars;
    }



}
