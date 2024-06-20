package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        boolean temperatureFlag = checkTemperature(temperature);
    	boolean socFlag = checkSoc(soc, temperatureFlag);
    	checkChargeRate(chargeRate, socFlag);
        return true;
    }

    private static boolean checkTemperature(float temperature) {
    	if(temperature < 0 || temperature > 45) {
            System.out.println("Temperature is out of range!");
            return false;
        }
    	return true;
    }
    
    private static boolean checkSoc(float soc, boolean temperatureFlag) {
    	if(temperatureFlag && (soc < 20 || soc > 80)) {
            System.out.println("State of Charge is out of range!");
            return false;
        }
    	return true;
    }
    
    private static boolean checkChargeRate(float chargeRate, boolean socFlag) {
    	if(socFlag && chargeRate > 0.8) {
            System.out.println("Charge Rate is out of range!");
            return false;
        }
    	return true;
    }

    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("Some more tests needed");
    }
}
