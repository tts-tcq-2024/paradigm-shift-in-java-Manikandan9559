package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
    	if(checkMinTemperature(temperature)) {
    		return checkMaxTemperature(temperature, soc, chargeRate);
    	} else {
    		return false;
    	}
    }
    
    private static boolean checkMinTemperature(float temperature) {
    	if(temperature < 0) {
            System.out.println("Temperature is out of range!");
            return false;
        }
    	return true;
    }
    
    private static boolean checkMaxTemperature(float temperature, float soc, float chargeRate) {
    	if(temperature > 45) {
            System.out.println("Temperature is out of range!");
            return false;
        }
    	return checkMinSoc(soc, chargeRate);
    }
    
    private static boolean checkMinSoc(float soc, float chargeRate) {
    	if(soc < 20) {
    		System.out.println("State of Charge is out of range!");
    		return false;
    	}
    	return checkMaxSoc(soc, chargeRate);
    }
    
    private static boolean checkMaxSoc(float soc, float chargeRate) {
    	if(soc > 80) {
    		System.out.println("State of Charge is out of range!");
    		return false;
    	}
    	return checkChargeRate(chargeRate);
    }
    
    private static boolean checkChargeRate(float chargeRate) {
    	if(chargeRate > 0.8) {
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
