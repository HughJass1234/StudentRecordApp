

public class Registration {
	
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;
	
	public Registration(Student st, CourseOffering of) {
		completeRegistration(st, of);
		grade = '-';
	}
	
	public void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration ();
	}
	
	private void addRegistration () {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
	}
	
	
	public Student getTheStudent() {
		return theStudent;
	}
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString () {
		String n = theOffering.getTheCourse().getCourseName();
		int m = theOffering.getTheCourse().getCourseNum();
		
		String st = n + " " + m;
		st += "\nThe Offering: " + getTheOffering () ;
		st += "Grade: " + getGrade() + "\n";
		return st;
	}
	
	public String printRegList() {
		String st = "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade() + "\n";
		return st;
	}
	
}
