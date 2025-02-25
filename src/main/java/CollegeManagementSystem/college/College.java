package CollegeManagementSystem.college;

import java.util.List;

import CollegeManagementSystem.student.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class College {
	
	
	//Fields
	
	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Student> students;

	@Id
	@GeneratedValue
	private int id;
	@Column
    private String collegeName;
	@Column
	private String address;
	@Column
	private Long contantNumber;
	
	
	//Default Constructor
	
    public College() {
		
	}
    
	
    //Constructor
    
	public College(List<Student> students, int id, String collegeName, String address, Long contantNumber) {
		super();
		this.students = students;
		this.id = id;
		this.collegeName = collegeName;
		this.address = address;
		this.contantNumber = contantNumber;
	}

	
    //Setters
	
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setContantNumber(Long contantNumber) {
		this.contantNumber = contantNumber;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
    //Getters
	
	public Long getContantNumber() {
		return contantNumber;
	}
	
	public String getAddress() {
		return address;
	}

	public int getId() {
		return id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getCollegeName() {
		return collegeName;
	}


	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", address=" + address + ", contantNumber="
				+ contantNumber + "]";
	}
}
