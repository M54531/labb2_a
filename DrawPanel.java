import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage SaabImage;
    BufferedImage ScaniaIMage;
    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    ArrayList<Car> cars11= new ArrayList<>();
    ArrayList<BufferedImage> carImg= new ArrayList<>();
    public void setCars11(ArrayList<Car> cars11){
        this.cars11=cars11;
    }

    public void setImages(){
        for(Car car:cars11){
            if(car instanceof Volvo240){
                carImg.add(volvoImage);
            }else if(car instanceof Saab95){
                carImg.add(SaabImage);
            }else if(car instanceof Scania){
                carImg.add(ScaniaIMage);
            }
        }
    }

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
            volvoPoint.x = x;
            volvoPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            ScaniaIMage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            SaabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int count=0;
        int next=0;
        for(Car car:cars11) {
            try {
                g.drawImage(carImg.get(count), (int) car.getXPos(), (int) car.getYPos() + next, null); // see javadoc for more info on the parameters
            } catch (Exception e) {
                e.printStackTrace();
            }
            count++;
            next=next+100;

        }
    }
}
