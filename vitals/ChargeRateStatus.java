package vitals;

public class ChargeRateStatus {

	private StatusCalculator statusCalculator;

	public ChargeRateStatus() {
		List<RangeCalculator> chargeRateRanges = new ArrayList<>();
		chargeRateRanges.add(new RangeCalculator(Float.NEGATIVE_INFINITY, 0f, "LOW_CHARGERATE_BREACH"));
		chargeRateRanges.add(new RangeCalculator(0f, 0.04f, "LOW_CHARGERATE_WARNING"));
		chargeRateRanges.add(new RangeCalculator(0.04f, 0.76f, "NORMAL"));
		chargeRateRanges.add(new RangeCalculator(0.76f, 0.8f, "HIGH_CHARGERATE_WARNING"));
		chargeRateRanges.add(new RangeCalculator(0.81f, Float.POSITIVE_INFINITY, "HIGH_CHARGERATE_BREACH"));
		this.statusCalculator = new StatusCalculator(chargeRateRanges);
	}

	public String getChargeRateStatus(float inputValue) {
		return statusCalculator.getStatus(inputValue);
	}

}
