
public class Student {
	private int number, classNumber;
	private String name, departmentCode, gender;
	private Date birthday;
	private Phone phone;

	// Constructor
	public Student(int number, int classNumber, String name, String departmentCode, String gender, Date birthday,
			Phone phone) {
		this.number = number;
		this.classNumber = classNumber;
		this.name = name;
		this.departmentCode = departmentCode;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
	}

	public Student(String[] word) {
		this.departmentCode = word[0];
		this.number = Integer.parseInt(word[1]);
		this.name = word[2];
		this.birthday = new Date(word[3]);
		this.gender = word[4];
		this.classNumber = Integer.parseInt(word[5]);
		this.phone = new Phone(word[6], word[7], word[8]);
	}

	// Class Function
	public void studentInfo() {
		System.out.println("Department Code  : " + departmentCode);
		System.out.println("Student Number   : " + number);
		System.out.println("Student Name     : " + name);
		System.out.println("Student Birthday : " + birthday.stringDate());
		System.out.println("Student Gender   : " + gender);
		System.out.println("Student Class    : " + classNumber);
		System.out.println("Student Phone    : " + phone.stringPhone());
	}

	// Getters and setters
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
}
