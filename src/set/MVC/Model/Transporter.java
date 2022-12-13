// Module to hold the subclass Transporter
// - Note that this class inherits from its superclass Truck

// --- Packages --- //

package set.MVC.Model;

// ---- Imports ---- //

import java.awt.*;
import java.util.ArrayList;

import set.MVC.Model.Loadable;

import java.math.*;

// ----- Class ----- //

 public class Transporter extends Truck{

    private LiftRamp ramp;
    private Loadable loadingSpace;

    
    // --- Constructor --- //
    
    public Transporter(int nrDoors, Color color, int enginePower, String modelName, int carCapacity){
        super(nrDoors, color, enginePower, modelName);
        this.ramp = new LiftRamp();    
        loadingSpace = new Loadable(carCapacity);
    }

    // ----- Methods ----- //

    

    // Method to raise Transporter object's ramp
    // - Note that this is only allowed while current speed is 0
    public void raiseRamp(){
        if (this.getCurrentSpeed() == 0){
            ramp.raiseRamp();
        }
    }

    // Method to lower Transporter object's ramp
    // - Note that this is only allowed while current speed is 0
    public void lowerRamp(){
        if (this.getCurrentSpeed() == 0){
            ramp.lowerRamp();
        }
    }

    @Override
    public void gas(double amount) {
        if (ramp.getRampPositionDown() == false) super.gas(amount);
    }        

    // Method to load cars
    // - Note that you can only load if:
    //   > Transporter is below capacity
    //   > Transporter's ramp is down
    //   > Distance to transporter is below 15m
    public void loadCar(Car car){
        if (ramp.getRampPositionDown() == true){
            car.setCoordinates(this.getXPosition(),this.getYPosition());
            loadingSpace.loadCar(car, this.getXPosition(), this.getYPosition());
        }
    }
    
    // Method to unload cars
    public void unloadCar(){
        if (ramp.getRampPositionDown() == true){
        loadingSpace.unloadCar();
         }
    }
    
    // Method overloaded to include moving loaded cars coordinates as well
    @Override
    public void move() {
        super.move();
        for (Car car: loadingSpace.getListOfCars()){
            car.setCoordinates(this.getXPosition(), this.getYPosition());
        }
    }
    
    // Method to get ramp position
    public boolean getRampPosition(){
        return ramp.getRampPositionDown();
    }

    // Method to get amount of cars loaded
    public int getAmountOfCarsLoaded(){
        return loadingSpace.getAmountOfCarsLoaded();
    }
    
        
}