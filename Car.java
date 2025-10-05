import java.util.ArrayList;

/**
 * Represents a single train car that can hold a limited number of Passenger objects
 * Each car tracks its maximum capacity, current passengers onboard, and provides methods to add/remove passengers and display a passenger manifest
 */
public class Car {
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    /**
     * Constructor
     * @param maxCap is the maximum number of passengers this car can hold
     */
    public Car(int maxCap){
        this.maxCapacity = maxCap;
        this.passengersOnboard = new ArrayList<>(maxCap);
    }

    /**
     * Returns the current number of passengers onboard
     * @return the number of passengers currently in the car
     */
    public int getCapacity(){
        return this.passengersOnboard.size();
    }
    
    /**
     * Retusn the number of seats still available in this car
     * @return the number of remaining seats
     */
    public int seatsRemaining(){
        return this.maxCapacity - this.passengersOnboard.size();
    }

    /**
     * Attempts to add a passenger to the car
     * @param p the passenger to be added
     * @return true if the passenger was successfully added; false if the car is already full
     */
    public Boolean addPassenger(Passenger p){
        if (this.getCapacity() < maxCapacity){
            this.passengersOnboard.add(p);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Attempts to remove a passenger from the car
     * @param p is the passenger to be removed
     * @return true if the passenger was successfully removed; false if the passenger was not found
     */
    public Boolean removePassenger(Passenger p){
        if (passengersOnboard.contains(p)){
            passengersOnboard.remove(p);
            return true;
        }
        else{
            return false;
        }
    } 
   
    /**
     * Prints a manifest of passengers currently onboard and if the car is empty, it prints a message
     */
    public void printManifest(){
        if (this.passengersOnboard.isEmpty()){
            System.out.println("This car is EMPTY.");
        }
        else {
            for (Passenger p : passengersOnboard) {
                System.out.println(p);
            }
        }
    } 

}