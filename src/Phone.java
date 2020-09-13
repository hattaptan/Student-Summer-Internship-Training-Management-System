
public class Phone {
	private String countryCode, areaCode, number;

	// Constructor
	public Phone(String countryCode, String areaCode, String number) {
		super();
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.number = number;
	}

	// Class Function
	public String stringPhone() {
		return countryCode + " " + areaCode + " " + number;
	}

	// Getters and setters
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
