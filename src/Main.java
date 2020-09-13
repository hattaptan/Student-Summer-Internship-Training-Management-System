import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static Department[] departments = new Department[11];
	public static Student[] students = new Student[6000];
	public static Internship[] internships = new Internship[18000];
	public static Company[] companies = new Company[18000];
	public static int deptIndex = 0, stuIndex = 0, intIndex = 0, compIndex = 0;

	public static void listDepartments() {
		for (int i = 0; i < deptIndex; i++) {
			System.out.println("-------------------------");
			departments[i].departmentInfo();
			System.out.println("-------------------------\n");
		}
	}

	public static void listInstructors() {
		for (int i = 0; i < deptIndex; i++) {
			System.out.println("-------------------------");
			System.out.println(departments[i].getName() + "\n");
			departments[i].committeeInfo();
			System.out.println("-------------------------\n");
		}
	}

	public static void listStudents() {
		for (int i = 0; i < stuIndex; i++) {
			System.out.println("-------------------------");
			students[i].studentInfo();
			System.out.println("-------------------------\n");
		}
	}

	public static void listCompanies() {
		for (int i = 0; i < compIndex; i++) {
			System.out.println("-------------------------");
			companies[i].companyInfo();
			System.out.println("-------------------------\n");
		}
	}

	public static void listInternships() {
		for (int i = 0; i < compIndex; i++) {
			System.out.println("-------------------------");
			internships[i].internshipInfo();
			System.out.println("-------------------------\n");
		}
	}

	public static void printTopCompany() {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < compIndex; i++) {
			if (companies[i].getInternshipCount() >= max) {
				max = companies[i].getInternshipCount();
			}
		}

		for (int i = 0; i < compIndex; i++) {
			if (companies[i].getInternshipCount() == max) {
				System.out.println("Company Name     : " + companies[i].getName());
				System.out.println("Internship Count : " + companies[i].getInternshipCount());
			}
		}
	}

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("ornek.txt"));

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] command = line.split(",");

				if (command[0].equals("Department")) {
					// Add Department
					departments[deptIndex] = new Department(line.split(","));
					deptIndex++;
				} else if (command[0].equals("Internship")) {
					String[] words = line.split(",");
					String[] temp;
					Student student = null;
					Company company;
					boolean departmentControl = false, studentControl = false;
					boolean startDate = false, endDate = false, contain = false;
					int index = 0;

					// Add Student
					for (int i = 0; i < departments.length; i++) {
						if (words[1].equals(departments[i].getCode())) {
							departmentControl = true;
						}
					}

					for (int i = 0; i < stuIndex; i++) {
						if (students[i].getNumber() == Integer.parseInt(words[2])
								&& students[i].getName().equals(words[3])) {
							studentControl = true;
							index = i;
						}
					}

					if (departmentControl && Date.isCorrectDate(words[4])) {

						if (studentControl) {
							student = students[index];
						} else {
							temp = new String[9];
							for (int i = 0; i < temp.length; i++) {
								temp[i] = words[1 + i];
							}
							student = new Student(temp);
							students[stuIndex] = student;
							stuIndex++;
						}

						// Add Internship
						startDate = Date.isCorrectDate(words[11]);
						endDate = Date.isCorrectDate(words[12]);

						if (startDate && endDate) {
							for (int i = 0; i < compIndex; i++) {
								if (companies[i].getName().equals(words[13]))
									contain = true;
							}

							if (contain) {
								index = 0;
								for (int i = 0; i < compIndex; i++) {
									if (companies[i].getName().equals(words[13]))
										index = i;
								}
								company = companies[index];
								company.addInternships();
								internships[intIndex] = new Internship(student, words[10], new Date(words[11]),
										new Date(words[12]), company);
								intIndex++;
							} else {
								temp = new String[11];
								for (int i = 0; i < temp.length; i++) {
									temp[i] = words[i + 13];
								}
								company = new Company(temp);
								companies[compIndex] = company;
								compIndex++;
								internships[intIndex] = new Internship(student, words[10], new Date(words[11]),
										new Date(words[12]), company);
								intIndex++;
							}

						} else {
							students[stuIndex] = null;
							stuIndex--;
						}
					}
				}
			}

			// listDepartments();
			// listInstructors();
			listStudents();
			// listCompanies();
			// listInternships();
			// printTopCompany();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			;
		}
	}

}
