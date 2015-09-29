public class CargoPlane implements Airplane {

    private static final float CARGO_REVENUE = 1.50f;

    private float poundsCargo;


    public CargoPlane(float poundsCargo) {
        this.poundsCargo = poundsCargo;
    }


    @Override
    public float getProfitFromFlying() {
        return poundsCargo * CARGO_REVENUE;
    }


    @Override
    public float getFuelUsedPerFlight() {
        return 85f + 0.1f * poundsCargo;
    }


    @Override
    public String toString() {
        return "Cargo Plane";
    }
}
