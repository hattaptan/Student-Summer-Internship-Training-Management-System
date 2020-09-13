
public class Company {
	private static int id = 0;
	private int companyId, internshipCount;
	private String name, contactPerson, facilityArea;
	private Phone phone;
	private Address address;

	// Constructors;
	public Company(String name, String contactPerson, String facilityArea, Phone phone, Address adress) {
		companyId = id;
		id++;
		internshipCount = 1;
		this.name = name;
		this.contactPerson = contactPerson;
		this.facilityArea = facilityArea;
		this.phone = phone;
		this.address = adress;
	}

	public Company(String[] words) {
		companyId = id;
		id++;
		internshipCount = 1;
		name = words[0];
		address = new Address(words[1], words[2], words[3], words[4], words[5]);
		phone = new Phone(words[6], words[7], words[8]);
		facilityArea = words[9];
		contactPerson = words[10];
	}

	// Class functions
	public void companyInfo() {
		System.out.println("Company Name : " + name);
		System.out.println("Contact Person : " + contactPerson);
		System.out.println("Facility Area : " + facilityArea);
		System.out.println("Company Phone : " + phone.stringPhone());
		System.out.println("Company Adress : " + address.stringAddres());
	}

	public void addInternships() {
		internshipCount++;
	}

	// Getters and setters
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getInternshipCount() {
		return internshipCount;
	}

	public void setInternshipCount(int internshipCount) {
		this.internshipCount = internshipCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getFacilityArea() {
		return facilityArea;
	}

	public void setFacilityArea(String facilityArea) {
		this.facilityArea = facilityArea;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAdress() {
		return address;
	}

	public void setAdress(Address adress) {
		this.address = adress;
	}
}
