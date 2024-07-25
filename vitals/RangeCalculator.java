package vitals;

public class RangeCalculator {
	
	private float minimumValue;
    private float maximumValue;
    String status;

    public RangeCalculator(float minimumValue, float maximumValue, String status) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.status = status;
    }

    public boolean isInRange(float inputValue) {
        return inputValue >= minimumValue && inputValue <= maximumValue;
    }

}
