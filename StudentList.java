
import java.util.ArrayList;

public class StudentList {

	private ArrayList<Student> studentList;
	
	public StudentList() {
		loadFromDataBase();
	}
	
	private void loadFromDataBase() {
		DBManager db = new DBManager();
		setStudentList(db.readStudentFromDataBase());
	}
	
	public void setStudentList(ArrayList <Student> studentList) {
		this.studentList = studentList;
	}
	
	private Student findStudent(int id) {
		
		for(Student x : studentList) {
			if(x.getStudentId() == id) {
				return x;
			}
		}
		System.out.println("Student with id " + id + " could not be found");
		return null;
	}
	
	public void registerStudent(int id, CourseOffering cOff) {
		
		Student target = findStudent(id);
		
		if(target != null) {
			
			Registration r = new Registration(target, cOff);
			
		}
	}
	
	public void removeCourseReg(int id, Course course) {
		
		Student target = findStudent(id);
		
		if(target != null) {
			if(target.removeCourse(course)) {
				System.out.println("The Course Was Successfully Removed");
				return;
			}
		}
		System.out.println("The Course Could Not Be Removed");
	}
	
	public String viewStudentCourse(int id) {
		
		Student target = findStudent(id);
		String str = "";
		if(target != null) {
			str += target.regListToString();
		}
		
		return str;
	}
	
	public void listStudents() {
		System.out.println("\nThe students are:");
		System.out.println("---------------------------------------");
		for(Student i : studentList) {
			System.out.println(i);
		}
		System.out.println("---------------------------------------");
	}
	
	@Override
	public String toString() {
		String str = "\nThe students are:\n"
				 + "---------------------------------------\n";
		int k = 0;
		for(Student i : studentList) {
			str += i;
			if(k < studentList.size() - 1)
				str += "\n";
			k++;
		}
		str += "---------------------------------------";
		return str;
	}
	
	
}
