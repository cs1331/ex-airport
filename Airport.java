import java.util.ArrayList;

public class Airport {

    private ArrayList planesWaitingToTakeOff;


    public static void main(String[] args) {
        Airport dobbins = new Airport();
        dobbins.requestTakeOff(new Airliner(120, 245.95f));
        dobbins.requestTakeOff(new CargoPlane(1000));
        dobbins.requestTakeOff(new JetFighter(false));
        dobbins.requestTakeOff(new JetFighter(true));
        dobbins.requestTakeOff(new CargoPlane(2100));

        float profit;
        profit = dobbins.clearMostProfitablePlanes(2);
        System.out.println("Earned $" + profit + " for clearing the 2 most profitable planes.");

        profit = dobbins.clearAllPlanes();
        System.out.println("Earned $" + profit + " for clearing the rest of the planes.");
    }


    public Airport() {
        planesWaitingToTakeOff = new ArrayList();
    }


    public void requestTakeOff(Airplane plane) {
        planesWaitingToTakeOff.add(plane);
    }


    public float clearAllPlanes() {
        float profit = 0;

        for (Object o: planesWaitingToTakeOff) {
            System.out.println("A " + o + " takes off!");

            Airplane plane = (Airplane) o;
            profit += plane.getProfitFromFlying() - plane.getFuelUsedPerFlight();
        }
        planesWaitingToTakeOff.clear();

        return profit;
    }


    public float clearMostProfitablePlanes(int numToClear) {
        if (numToClear >= planesWaitingToTakeOff.size())
            return clearAllPlanes();

        Airplane[] mostProfitablePlanes = new Airplane[numToClear];

        for (Object o: planesWaitingToTakeOff) {
            Airplane plane = (Airplane) o;
            float profit = plane.getProfitFromFlying() - plane.getFuelUsedPerFlight();

            boolean done = false;
            for (int i = 0; i < numToClear && !done; ++i) {
                if (mostProfitablePlanes[i] == null
                    || profit > mostProfitablePlanes[i].getProfitFromFlying()
                        - mostProfitablePlanes[i].getFuelUsedPerFlight()) {

                    mostProfitablePlanes[i] = plane;
                    done = true;
                    }
            }
        }

        float profit = 0;
        for (Airplane plane: mostProfitablePlanes) {
            planesWaitingToTakeOff.remove(plane);
            System.out.println("A " + plane + " takes off!");
            profit += plane.getProfitFromFlying() - plane.getFuelUsedPerFlight();
        }
        return profit;
    }
}
