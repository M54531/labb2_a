public class BilFarja {


    private Biltransport transport = new Biltransport(); // Komposition: Klassen BilFarja har en instansvariabel av typ BilTransport som heter transport.
                                    // Instansvariabeln kan sedan användas för att anropa Biltransportens metoder.

    public BilFarja() { // Konstruktor

    }


    public void setRamp() {
        transport.setRamp();
    }

    public void loadCar(Car c) {
        transport.loadCar(c);
    }

    /**
     * unload first car
     */

    public void unload(){ // Eftersom bilfärjan inte lastar av bilar på samma sätt som biltransporten definierar vi om den
        if (transport.getRampDown()){
            if(transport.getNrLoadedCars()!=0) {
                System.out.println("asdasdsads");
                int i = 0;  // hitta indexet på den bil som ska lastas ut, d.v.s. den bil som har stått i kön under längst tid
                while(transport.getLoadedCar(i) == null) i++;

                transport.getLoadedCar(i).setXPos(transport.getLoadedCar(i).getXPos() - Math.cos(transport.getLoadedCar(i).getTheta()));
                transport.getLoadedCar(i).setYPos(transport.getLoadedCar(i).getYPos() - Math.sin(transport.getLoadedCar(i).getTheta()));
                transport.setNrLoadedCars(transport.getNrLoadedCars()-1);
                transport.setLoadedCar(i, null);
            }
        }
    }

    public void move() {
        transport.move();
    }

    public boolean driveable() {
        return transport.driveable();
    }

    /**
     * check if Bilfarja contains car a.
     * @param a
     * @return
     */
    public boolean contains1(Car a){
        return transport.cars.contains(a);
    }


}


