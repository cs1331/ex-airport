import java.util.ArrayList;

public class Airport {

    private ArrayList waitingPlanes;


    public static void main(String[] args) {
        Airport dobbins = new Airport();
        dobbins.requestTakeOff(new Airliner(120, 245.95f));
        dobbins.requestTakeOff(new CargoPlane(1000));
        dobbins.requestTakeOff(new JetFighter(false));
        dobbins.requestTakeOff(new JetFighter(true));
        dobbins.requestTakeOff(new CargoPlane(2100));

        float profit;
        profit = dobbins.clearMostProfitablePlanes(2);
        System.out.println("Earned $" + profit
                + " for clearing the 2 most profitable planes.");

        profit = dobbins.clearAllPlanes();
        System.out.println("Earned $" + profit
                + " for clearing the rest of the planes.");
    }


    public Airport() {
        waitingPlanes = new ArrayList();
    }


    public void requestTakeOff(Airplane plane) {
        waitingPlanes.add(plane);
    }


    public float clearAllPlanes() {
        float profit = 0;

        for (Object o: waitingPlanes) {
            System.out.println("A " + o + " takes off!");

            Airplane plane = (Airplane) o;
            profit += plane.getProfit() - plane.getFuelUsed();
        }
        waitingPlanes.clear();

        return profit;
    }


    public float clearMostProfitablePlanes(int numToClear) {
        if (numToClear >= waitingPlanes.size()) {
            return clearAllPlanes();
        }

        Airplane[] profitablePlanes = new Airplane[numToClear];

        for (Object o: waitingPlanes) {
            Airplane plane = (Airplane) o;
            float profit = plane.getProfit() - plane.getFuelUsed();

            boolean done = false;
            for (int i = 0; i < numToClear && !done; ++i) {
                if (profitablePlanes[i] == null
                    || profit > profitablePlanes[i].getProfit()
                        - profitablePlanes[i].getFuelUsed()) {

                    profitablePlanes[i] = plane;
                    done = true;
                }
            }
        }

        float profit = 0;
        for (Airplane plane: profitablePlanes) {
            waitingPlanes.remove(plane);
            System.out.println("A " + plane + " takes off!");
            profit += plane.getProfit()
                - plane.getFuelUsed();
        }
        return profit;
    }
}
