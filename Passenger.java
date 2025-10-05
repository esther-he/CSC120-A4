/**
 * Represents a passenger who can board and leave train cars. Each passenger has a name, and can interact with objects by boarding or getting off.
 */

public class Passenger {
    
    // Attributes
    private String name;

    /**
     * Constructor
     * @param name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the passenger
     * @return the passenger's name
     */
    public String toString(){
        return name;
    }

    /**
     * Boards the passenger onto the given car and prints a message indicating whether the boarding was successful
     * @param c is the car to board
     */
    public void boardCar(Car c){
        if (c.addPassenger(this)){
            System.out.println(name + " boarded successfully.");
        }
        else {
            System.out.println(name + " could not board. This car is full.");
        }
    }

    /**
     * Removes the passenger from the given car and prints a message indicating whether the removal was successful
     * @param c is the car to leave
     */
    public void getOffCar(Car c){
        if (c.removePassenger(this)){
            System.out.println(name + " was removed successfully.");
        }
        else {
            System.out.println(name + " could not be found in this car.");
        }
    } 
}
