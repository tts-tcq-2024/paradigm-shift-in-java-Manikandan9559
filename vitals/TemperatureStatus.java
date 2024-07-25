package vitals;

import java.util.ArrayList;
import java.util.List;

public class TemperatureStatus {

	private StatusCalculator statusCalculator;

	public TemperatureStatus() {
		List<RangeCalculator> temperatureRanges = new ArrayList<>();
		temperatureRanges.add(new RangeCalculator(Float.NEGATIVE_INFINITY, 0f, "LOW_TEMPERATURE_BREACH"));
		temperatureRanges.add(new RangeCalculator(0f, 2.25f, "LOW_TEMPERATURE_WARNING"));
		temperatureRanges.add(new RangeCalculator(2.26f, 42.75f, "NORMAL"));
		temperatureRanges.add(new RangeCalculator(42.76f, 45f, "HIGH_TEMPERATURE_WARNING"));
		temperatureRanges.add(new RangeCalculator(46f, Float.POSITIVE_INFINITY, "HIGH_TEMPERATURE_BREACH"));
		this.statusCalculator = new StatusCalculator(temperatureRanges);
	}

	public String getTemperatureStatus(float inputValue) {
		return statusCalculator.getStatus(inputValue);
	}

}
