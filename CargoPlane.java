public class CargoPlane implements Airplane {

    private static final float payPerPoundCargo = 1.50f;

    private float poundsCargo;


    public CargoPlane(float poundsCargo) {
        this.poundsCargo = poundsCargo;
    }


    @Override
    public float getProfitFromFlying() {
        return poundsCargo * payPerPoundCargo;
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
