public enum SideEffects {

	DROWSINESS("May cause drowsiness"), DIZZINESS("May cause dizziness");

	private String description;

	private SideEffects(String aDescription) {
		this.description = aDescription;

	}

	public String toString() {
		String aString = "";
		aString = description;
		return aString;
	}

}
