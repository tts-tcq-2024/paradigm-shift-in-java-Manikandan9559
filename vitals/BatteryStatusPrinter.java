package vitals;

public class BatteryStatusPrinter {

	public static void printStatus(String status) {
		if(status.contains("TEMPERATURE")) {
			printTemperatureStatus(status);
		} else if(status.contains("SOC")) {
			printSocStatus(status);
		} else {
			printChargeRateStatus(status);
		}
	}

	private static void printTemperatureStatus(String status) {
		if(status.equals("LOW_TEMPERATURE_WARNING")) {
			System.out.println(Constants.LOW_TEMPERATURE_WARNING);
		} else if(status.equals("HIGH_TEMPERATURE_WARNING")) {
			System.out.println(Constants.HIGH_TEMPERATURE_WARNING);
		} else {
			System.out.println(Constants.TEMPERATURE_BREACH);
		}
	}

	private static void printSocStatus(String status) {
		if(status.equals("LOW_SOC_WARNING")) {
			System.out.println(Constants.LOW_SOC_WARNING);
		} else if(status.equals("HIGH_SOC_WARNING")) {
			System.out.println(Constants.HIGH_SOC_WARNING);
		} else {
			System.out.println(Constants.SOC_BREACH);
		}
	}

	private static void printChargeRateStatus(String status) {
		if(status.equals("LOW_CHARGERATE_WARNING")) {
			System.out.println(Constants.LOW_CHARGERATE_WARNING);
		} else if(status.equals("HIGH_CHARGERATE_WARNING")) {
			System.out.println(Constants.HIGH_CHARGERATE_WARNING);
		} else {
			System.out.println(Constants.CHARGERATE_BREACH);
		}
	}

}
