package vitals;
import java.util.ArrayList;
import java.util.List;

public class SocStatus {

	private StatusCalculator statusCalculator;

	public SocStatus() {
		List<RangeCalculator> socRanges = new ArrayList<>();
		socRanges.add(new RangeCalculator(0f, 19f, "LOW_SOC_BREACH"));
		socRanges.add(new RangeCalculator(21f, 24f, "LOW_SOC_WARNING"));
		socRanges.add(new RangeCalculator(25f, 75f, "NORMAL"));
		socRanges.add(new RangeCalculator(76f, 80f, "HIGH_SOC_WARNING"));
		socRanges.add(new RangeCalculator(81f, Float.POSITIVE_INFINITY, "HIGH_SOC_BREACH"));
		this.statusCalculator = new StatusCalculator(socRanges);
	}

	public String getSocStatus(float inputValue) {
		return statusCalculator.getStatus(inputValue);
	}

}
