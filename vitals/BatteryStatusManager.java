package vitals;

public class BatteryStatusManager {
	//Value for the global flags should be set based on requirement from config file
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
		if(getWarningStatus(temperatureValue, IS_TEMPERATURE_WARNING) || temperatureValue.endsWith("BREACH")) {
			BatteryStatusPrinter.printStatus(temperatureValue);
			return false;
		}
		return true;
	}

	private static boolean checkSoc(float soc) {
		SocStatus socStatus = new SocStatus();
		String socValue = socStatus.getSocStatus(soc);
		if(getWarningStatus(socValue, IS_SOC_WARNING) || socValue.endsWith("BREACH")) {
			BatteryStatusPrinter.printStatus(socValue);
			return false;
		}
		return true;
	}

	private static boolean checkChargeRate(float chargeRate) {
		ChargeRateStatus chargeRateStatus = new ChargeRateStatus();
		String chargeRateValue = chargeRateStatus.getChargeRateStatus(chargeRate);
		if(getWarningStatus(chargeRateValue, IS_CHARGE_RATE_WARNING) || chargeRateValue.endsWith("BREACH")) {
			BatteryStatusPrinter.printStatus(chargeRateValue);
			return false;
		}
		return true;
	}
	
	private static boolean getWarningStatus(String status, boolean warningFlag) {
		return status.endsWith("WARNING") && warningFlag;
	}

	public static void main(String[] args) {
		batteryIsOk(25, 70, 0.9f);
		batteryIsOk(50, 85, 0.78f);
		System.out.println("Some more tests needed");
	}
}
