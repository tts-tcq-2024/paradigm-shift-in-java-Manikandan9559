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
    		printStatus("Temperature is out of range!");
            return false;
        }
    	return true;
    }
    
    private static boolean checkMaxTemperature(float temperature, float soc, float chargeRate) {
    	if(temperature > 45) {
    		printStatus("Temperature is out of range!");
            return false;
        }
    	return checkMinSoc(soc, chargeRate);
    }
    
    private static boolean checkMinSoc(float soc, float chargeRate) {
    	if(soc < 20) {
    		printStatus("State of Charge is out of range!");
    		return false;
    	}
    	return checkMaxSoc(soc, chargeRate);
    }
    
    private static boolean checkMaxSoc(float soc, float chargeRate) {
    	if(soc > 80) {
    		printStatus("State of Charge is out of range!");
    		return false;
    	}
    	return checkChargeRate(chargeRate);
    }
    
    private static boolean checkChargeRate(float chargeRate) {
    	if(chargeRate > 0.8) {
    		printStatus("Charge Rate is out of range!");
            return false;
        }
    	return true;
    }
    
    private static void printStatus(String status) {
    	 System.out.println(status);
    }

    public static void main(String[] args) {
        batteryIsOk(25, 70, 0.7f);
        batteryIsOk(50, 85, 0.0f);
        printStatus("Some more tests needed");
    }
}
