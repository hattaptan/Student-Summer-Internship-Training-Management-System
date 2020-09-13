
public class Internship {
	private static int id = 0;
	private String type;
	private Date startDate, endDate;
	private int internshipId;
	private Student student;
	private Company company;

	// Constructors
	public Internship(Student student, String type, Date startDate, Date endDate, Company company) {
		this.student = student;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.company = company;
		internshipId = id;
		id++;
	}

	// Class function
	public void internshipInfo() {
		System.out.println("Student Number      : " + student.getNumber());
		System.out.println("Company Name        : " + company.getName());
		System.out.println("Internship Type     : " + type);
		System.out.println("The number of weeks : " + Date.calculateWeekCount(startDate, endDate));
	}

	// Getters and setters
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getInternshipId() {
		return internshipId;
	}

	public void setInternshipId(int internshipId) {
		this.internshipId = internshipId;
	}
}
