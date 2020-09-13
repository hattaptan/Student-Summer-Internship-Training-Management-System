
public class Department {
	// Inner Class
	static class Instructor {
		private static int id = 0;
		private int instructorId;
		private String title, name;

		// Constructor
		public Instructor(String title, String name) {
			this.title = title;
			this.name = name;
			instructorId = id;
			id++;
		}

		// Getters and setters
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getInstructorId() {
			return instructorId;
		}

		public void setInstructorId(int instructorId) {
			this.instructorId = instructorId;
		}
	}

	private String code, name;
	private Instructor[] committee;
	private Object[][] internship;

	// Constructors
	public Department(String code, String name, Instructor[] committee, Object[][] internship) {
		this.code = code;
		this.name = name;
		this.committee = committee;
		this.internship = internship;
	}

	public Department(String[] words) {
		code = words[1];
		name = words[2];
		committee = new Instructor[3];
		for (int i = 0; i < 3; i++) {
			committee[i] = new Instructor(words[3 + 2 * i], words[4 + 2 * i]);
		}
		internship = new Object[3][2];
		for (int i = 0; i < 3; i++) {
			internship[i][0] = words[9 + 2 * i];
			internship[i][1] = words[10 + 2 * i];
		}
	}

	// Class functions
	public void departmentInfo() {
		System.out.println("Department Code : " + code);
		System.out.println("Department Name : " + name);
		for (int i = 0; i < internship.length; i++) {
			System.out.println((i + 1) + "." + internship[i][0] + " - " + internship[i][1]);
		}
	}

	public void committeeInfo() {
		for (int i = 0; i < committee.length; i++) {
			System.out.println((i + 1) + "." + committee[i].getTitle() + committee[i].getName());
		}
	}

	// Getters and setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instructor[] getCommittee() {
		return committee;
	}

	public void setCommittee(Instructor[] committee) {
		this.committee = committee;
	}
}
