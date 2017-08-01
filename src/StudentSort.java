import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class StudentSort {

	private static final String FILENAME = "students.txt";
	public static void main(String[] args) throws Exception{
		
		FileReader fr = new FileReader(FILENAME);
		BufferedReader br = new BufferedReader(fr);
		String currentLine;
		List<Student> studentList = new ArrayList<>(); 
		/*read from given file and add them in a List of Student*/
		while ((currentLine = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(currentLine);
				Student aStudent = new Student();
				while(st.hasMoreTokens()) {
					aStudent.setId(Integer.valueOf(st.nextToken()));
					aStudent.setName((String)st.nextToken());
					aStudent.setGpa(Float.valueOf(st.nextToken()));
					studentList.add(aStudent);
				}
		}
		br.close();
		fr.close();
		System.out.println("========= Sample Input ========");
		studentList.forEach(s->System.out.println(s));
		
		/* sort by GPA. if GPA is same sort by Name. If GPA and Name are same sort by ID*/
		Collections.sort(studentList, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.getGpa().floatValue() == s2.getGpa().floatValue()) {
					if(s1.getName().equalsIgnoreCase(s2.getName())) return s1.getId().compareTo(s2.getId());
					return s1.getName().compareTo(s2.getName());
				}
				return s2.getGpa().compareTo(s1.getGpa());
			}
			
		});
		
		System.out.println("========= Sorted List =========");
		studentList.forEach(s->System.out.println(s));
	}
}

/* This is to hold given sample data*/
class Student{
	private Integer Id;
	private String name;
	private Float gpa;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getGpa() {
		return gpa;
	}
	public void setGpa(Float gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return this.getId() + " " +this.getName()+" "+this.getGpa();
	}
}