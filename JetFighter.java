public class JetFighter implements Airplane {

    private boolean isSuperSonic;


    public JetFighter(boolean isSuperSonic) {
        this.isSuperSonic = isSuperSonic;
    }


    @Override
    public float getProfitFromFlying() {
        return 1000f; // fixed fee the gov't pays us
    }


    @Override
    public float getFuelUsedPerFlight() {
        float fuelUsed;
        if (isSuperSonic) {
            fuelUsed = 300f;
        } else {
            fuelUsed = 230f;
        }
        return fuelUsed;
    }


    @Override
    public String toString() {
        return "Jet Figher";
    }
}
