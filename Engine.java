/**
 * Represents the engine of a train, powered by a fuel type, has a max fuel capacity, and tracks the current level
 * It can consume fuel and be refueled
 */
public class Engine {
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Constructor
     * @param fuel is hte type of fuel the engine uses
     * @param currentLevel is the starting fuel level
     * @param maxLevel is the maximum fuel capacity
     */
    public Engine(FuelType fuel, double currentLevel, double maxLevel){
        this.f = fuel;
        this.currentFuelLevel = currentLevel;
        this.maxFuelLevel = maxLevel;
    }

    /**
     * Returns the type of fuel the engine uses
     * @return the engine's fuel type
     */
    public FuelType getFuelType(){
        return this.f;
    } 

    /**
     * Returns the maximum fuel capacity of the engine
     * @return the maximum fuel level
     */
    public double getMaxFuel(){
        return this.maxFuelLevel;
    }

    /**
     * Returns the current fuel level of this engine
     * @return the current fuel level
     */
    public double getCurrentFuel(){
        return this.currentFuelLevel;
    } 

    /**
     * Sets the current fuel level to maximum capacity
     */
    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
    }

    /**
     * Simulates the engine running by consuming 10 gallons of fuel, prints the remaining fuel, returns whether the engine still has fuel left
     * @return true if the engine still has fuel after running; false if the engine is empty
     */
    public Boolean go(){
        this.currentFuelLevel -= 10.0;
        if (this.getCurrentFuel() > 0.0){
            System.out.println("The engine has " + this.currentFuelLevel + " gallons of fuel left.");
            return true;
        }
        else {
            System.out.println("The engine has no fuel left. Please refuel.");
            return false;
        }
    }  

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");

        myEngine.refuel();
        System.out.println("Fully refuled. Engine now has " + myEngine.currentFuelLevel + " gal out of " + myEngine.maxFuelLevel + " gal");
    }
}