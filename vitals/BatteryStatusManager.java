package vitals;

public class BatteryStatusManager {
	private static final boolean IS_TEMPERATURE_WARNING = true;
	private static final boolean IS_SOC_WARNING = true;
	private static final boolean IS_CHARGE_RATE_WARNING = true;
	static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
		boolean checkTemperatureFlag = checkTemperature(temperature);
		boolean checkSocFlag = checkSoc(soc);
		boolean checkChargeRate = checkChargeRate(chargeRate);
		return checkTemperatureFlag && checkSocFlag && checkChargeRate;
	}

	private static boolean checkTemperature(float temperature) {
		TemperatureStatus temperatureStatus = new TemperatureStatus();
		String temperatureValue = temperatureStatus.getTemperatureStatus(temperature);
		boolean isWarning = temperatureValue.endsWith("WARNING") && IS_TEMPERATURE_WARNING;
		if(isWarning || temperatureValue.endsWith("BREACH")) {
			BatteryStatusPrinter.printStatus(temperatureValue);
			return false;
		}
		return true;
	}

	private static boolean checkSoc(float soc) {
		SocStatus socStatus = new SocStatus();
		String socValue = socStatus.getSocStatus(soc);
		boolean isWarning = socValue.endsWith("WARNING") && IS_SOC_WARNING;
		if(isWarning || socValue.endsWith("BREACH")) {
			BatteryStatusPrinter.printStatus(socValue);
			return false;
		}
		return true;
	}

	private static boolean checkChargeRate(float chargeRate) {
		ChargeRateStatus chargeRateStatus = new ChargeRateStatus();
		String chargeRateValue = chargeRateStatus.getChargeRateStatus(chargeRate);
		boolean isWarning = chargeRateValue.endsWith("WARNING") && IS_CHARGE_RATE_WARNING;
		if(isWarning || chargeRateValue.endsWith("BREACH")) {
			BatteryStatusPrinter.printStatus(chargeRateValue);
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		batteryIsOk(25, 70, 0.9f);
		batteryIsOk(50, 85, 0.78f);
		System.out.println("Some more tests needed");
	}
}
