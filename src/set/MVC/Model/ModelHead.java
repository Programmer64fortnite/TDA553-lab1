package set.MVC.Model;
import java.awt.Color;

import java.util.ArrayList;



import set.MVC.Observer;
// LAB 3


public class ModelHead {
    ArrayList<Vehicles> vehicles = new ArrayList<>();
    CarFactory factory = new CarFactory();
    ArrayList<Observer> observers = new ArrayList<>();
    
    public ModelHead(){
        
    }
    public void addScaniaToVehicles(){
        vehicles.add(factory.createScania(2, Color.black, 100, "null", 70 ,0,200 ));
    }
    public void addSaabToVehicles(){
        vehicles.add(factory.createSaab(4, Color.black, 100, "null", 0, 100));
    }
    public void addVolvoToVehicles(){
        vehicles.add(factory.createVolvo(4, Color.black, 100, "null", 0, 0));
    }
    public ArrayList<Vehicles> getVehicleList(){
        return vehicles;
    }
    public void addToObservers(Observer o){
        observers.add(o);
    }
    public void createStandardModel(){
        vehicles.clear();
        addScaniaToVehicles();
        addSaabToVehicles();
        addVolvoToVehicles();
    }
    public void sendObserverSignal(){
        for (Observer observer : observers){
            observer.updateVehiclesList(vehicles);
        }
    }

    

    public void gasVehicles(int amount){
        Double gas = ((double) amount) / 100;
        for (Vehicles vehicle : vehicles){
            vehicle.gas(gas);
        }
    }
    public void brakeVehicles(int amount){
        Double gas = ((double) amount) / 100;
        for (Vehicles vehicle : vehicles){
            vehicle.brake(gas);
        }
    }
    public void startEngines(){
        for (Vehicles vehicle : vehicles){
            vehicle.startEngine();
        }
    }
    public void stopEngines(){
        for (Vehicles vehicle : vehicles){
            vehicle.stopEngine();
        }
    }
    public void moveVehicles(){
        for (Vehicles vehicle : vehicles){
            vehicle.move();
        }
    }

    public void run(){
        while (true){
            sendObserverSignal();
            moveVehicles(); //ADDED NOW FOR TEST
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                
                System.out.println("Not work");
            }
        }
    }
    
}
