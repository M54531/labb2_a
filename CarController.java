import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());
        cc.cars.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.setCars11(cc.cars);
        cc.frame.drawPanel.setImages();
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Car car : cars) {
                double xx = car.getXPos()+car.getCurrentSpeed()*Math.cos(car.getTheta());
                double yy =car.getYPos()+car.getCurrentSpeed()*Math.sin(car.getTheta());
                if (xx > 700 || xx < 0 || yy > 560 || yy < 0) {
                    car.turnRight();
                    car.turnRight();
                    car.stopEngine();
                    car.startEngine();
                }
                car.move();
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }

    }
    void start() {
        for (Car car : cars
        ) {
            car.startEngine();
        }
    }
    void stop(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.stopEngine();
        }
    }
    void turboOb(){
        for(Car car:cars){
            if(car instanceof Saab95)((Saab95) car).setTurbo();
        }
    }
    void turboOffb(){
        for(Car car:cars){
            if(car instanceof Saab95)((Saab95) car).setTurboOff();
        }
    }
    void lift(){
        for(Car car:cars){
            car.turnRight();
            if(car instanceof Scania) {
                ((Scania) car).increaseAngle(70);
                System.out.println(((Scania) car).getPlatfromAngle());
            }
        }
    }
    void lower(){
        for(Car car:cars){
            if(car instanceof Scania) {
                ((Scania) car).decreaseAngle(70);
            }
        }
    }
}


