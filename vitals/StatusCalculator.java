package vitals;

import java.util.List;

public class StatusCalculator {
	private List<RangeCalculator> ranges;

	public StatusCalculator(List<RangeCalculator> ranges) {
		this.ranges = ranges;
	}

	public String getStatus(float inputValue) {
		for(RangeCalculator range : ranges) {
			if (range.isInRange(inputValue)) {
				return range.status;
			}
		}
		return "UNKNOWN";
	}
}
