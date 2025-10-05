import java.util.ArrayList;

/**
 * Represents a train composed of an Engine and multiple Car objects.
 * Can report its seating capacity, remaining seats, and passenger manifests
 */
public class Train {
    private Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructor
     * @param fuelType is the type of fuel the train's engine uses
     * @param fuelCapacity is the maximum fuel capacity of the engine
     * @param nCars is the number of cars attached to the train
     * @param passengerCapacity is the passenger capcity of each car
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        this.cars = new ArrayList<>(nCars);

        for (int i = 0; i < nCars; i++){
           this.cars.add(new Car(passengerCapacity));
        }
    }
    
    /**
     * Returns the engine powering this train.
     * @return the train's engine
     */
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Returns the car at the specified index
     * If the index is invalid, an error message is printed and returns null
     * @param i is the index of the desired car
     * @return the Car at the given index or null
     */
    public Car getCar(int i){
        if (i > -1 && i < this.cars.size()){
            return this.cars.get(i);
        }
        else {
            System.out.println("Car could not be found.");
            return null;
        }
    } 

    /**
     * Returns the total passenger capacity across all cars in the train
     * @return the maximum number of passengers this train can hold
     */
    public int getMaxCapacity(){
        int max = 0;
        for (Car c : this.cars){
            max += c.getCapacity();
        }
        return max;
    }

    /**
     * Returns the total number of available seats across all cars
     * @return the number of seats remaing in the train
     */
    public int seatsRemaining(){
        int seats = 0;
        for (Car c : this.cars){
            seats += c.seatsRemaining();
        }
        return seats;

    }

    /**
     * Prints the passenger manifest for each car in the train
     * Each car is labeled with its index number
     */
    public void printManifest(){
        for (int i = 0; i < cars.size(); i++){
            System.out.println("\nCar " + (i + 1) + ":");
            cars.get(i).printManifest();
        }
    }

    public static void main(String[] args) {
        // Create a train
        Train myTrain = new Train(FuelType.ELECTRIC, 100.0, 3, 5);

        // Print engine fuel info
        System.out.println("Engine fuel: " + myTrain.getEngine().getCurrentFuel() + " gal out of " + myTrain.getEngine().getMaxFuel() + " gal");

        // Create some passengers
        Passenger p1 = new Passenger("Zoe");
        Passenger p2 = new Passenger("Maya");
        Passenger p3 = new Passenger("Erin");
        Passenger p4 = new Passenger("Esther");

        // Board passengers into the cars
        Car firstCar = myTrain.getCar(0);
        p1.boardCar(firstCar);
        p2.boardCar(firstCar);
        
        Car secondCar = myTrain.getCar(1);
        p3.boardCar(secondCar);
        p4.boardCar(secondCar);

        // Print total seats and seats remaining
        System.out.println("Total max capacity on train: " + myTrain.getMaxCapacity());
        System.out.println("Total seats remaining on train: " + myTrain.seatsRemaining());

        // Print manifest of train
        System.out.println("\nTrain manifest:");
        myTrain.printManifest();

        // Remove passengers from the cars
        p1.getOffCar(firstCar);
        p3.getOffCar(secondCar);

        // Print manifest of train
        System.out.println("\nTrain manifest:");
        myTrain.printManifest();
    }
}
