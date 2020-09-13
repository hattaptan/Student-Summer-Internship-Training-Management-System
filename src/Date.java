public class Date {
	private int day;
	private int month;
	private int year;

	// Constructors
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date(String date) {
		this.day = Integer.parseInt(date.substring(0, 2));
		this.month = Integer.parseInt(date.substring(3, 5));
		this.year = Integer.parseInt(date.substring(6, 10));
	}

	// Class Function
	public static int calculateWeekCount(Date first, Date second) {
		long firstDate = first.toDayCount();
		long secondDate = second.toDayCount();

		return (int) (Math.abs(secondDate - firstDate) / 7);
	}

	public static boolean isCorrectDate(String date) {
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(3, 5));
		int year = Integer.parseInt(date.substring(6, 10));

		int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (month > 13 || month < 0)
			return false;

		if (year % 4 == 0)
			months[1]++;

		if (day < 0 || day > months[month - 1])
			return false;

		return true;
	}

	public static boolean isCorrectDate(int day, int month, int year) {
		int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (month > 13 || month < 0)
			return false;

		if (year % 4 == 0)
			months[1]++;

		if (day < 0 || day > months[month - 1])
			return false;

		return true;
	}

	/**
	 * Total days from 1900. For example, 0 is 1/1/1900 and 1 is 2/1/1900
	 */
	public long toDayCount() {
		int year = this.year, month = this.month, day = this.day;
		long dayCount = 0;

		while (year > 1900) {
			if (year % 4 == 0)
				dayCount += 366;
			else
				dayCount += 365;
			year--;
		}

		int[] months = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i < month - 1; i++) {
			dayCount += months[i];
		}

		dayCount += day;
		dayCount--;

		return dayCount;
	}

	public String stringDate() {
		return day + "." + month + "." + year;
	}

	// Getters and setters
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
