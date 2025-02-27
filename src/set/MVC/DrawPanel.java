// --- Package --- //

package set.MVC;


// --- Imports --- //

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.swing.*;

import set.MVC.Model.Saab95;
import set.MVC.Model.Scania;
import set.MVC.Model.Vehicles;
import set.MVC.Model.Volvo240;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    ArrayList<Vehicles> vehicles = new ArrayList<Vehicles>();
    

    
    
    // To keep track of a singel cars position
    
    public void updateVehiclesList(ArrayList<Vehicles> vehicles){
        this.vehicles = vehicles;
    }
    // TODO: Make this genereal for all cars
    
    

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
           // volvoImage = ImageIO.read(new File("../pics/Volvo240.jpg"));
            //saabImage = ImageIO.read(new File("../pics/Saab95.jpg"));
            //scaniaImage =  ImageIO.read(new File("../pics/Scania.jpg"));
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    // Does not follow the open closed principle, better if every type of vehicle was matched with an image in
    // a hashmap or a tuple, so that you do not have to check the instance of every car.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicles vehicle : vehicles){
            if (vehicle instanceof Saab95){
                g.drawImage(saabImage, (int)vehicle.getXPosition(), (int)vehicle.getYPosition(), null);
            } else if(vehicle instanceof Scania){
                g.drawImage(scaniaImage, (int)vehicle.getXPosition(), (int)vehicle.getYPosition(), null);
            } else if (vehicle instanceof Volvo240){
                g.drawImage(volvoImage,  (int)vehicle.getXPosition(), (int)vehicle.getYPosition(), null);
            } 
        this.repaint();
        }

        
        
         // see javadoc for more info on the parameters
    }
}
