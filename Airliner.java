public class Airliner implements Airplane {

    private int numPassengers;
    private float ticketPrice;


    public Airliner(int numPassengers, float ticketPrice) {
        this.numPassengers = numPassengers;
        this.ticketPrice = ticketPrice;
    }


    @Override
    public float getProfit() {
        return numPassengers * ticketPrice;
    }


    @Override
    public float getFuelUsed() {
        return 100f + 0.5f * numPassengers;
    }


    @Override
    public String toString() {
        return "Airliner";
    }
}
