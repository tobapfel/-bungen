package programming.set11.enums;

public enum Length {

	ARSHIN("ar", 0.71), FINGER("fi", 0.022225), METRE("me", 1.0), HORSE_LENGTH("ho", 2.4), PARSEC("pa",
			30856776000000000.0), PLUTO_RADIUS("pl", 1186000);

	private String unit;
	private double value;

	private Length(String constantName, double unitLength) {
		unit = constantName;
		value = unitLength;
	}

	/**
	 * Returns how much one of this unit is in metres.
	 * 
	 * @return one unit in metres.
	 */
	public double getUnitLengthInMetres() {
		return this.value;

	}

	/**
	 * Converts the given amount measured in the current length unit to how much
	 * it would be in the target unit.
	 * 
	 * @param targetLength
	 *            the target unit of length.
	 * @param amount
	 *            the length to convert to the target length.
	 * @return the corresponding length in the target unit.
	 */
	public double convertTo(Length targetLength, double amount) {
		return (amount * this.getUnitLengthInMetres()) / targetLength.getUnitLengthInMetres();

	}

}
