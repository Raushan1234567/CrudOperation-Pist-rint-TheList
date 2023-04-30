package Demo.masai;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String hobbies;
private String standard;
private int age;




public Student(String name, String hobbies, String standard, int age) {
	super();
	
	this.name = name;
	this.hobbies = hobbies;
	this.standard = standard;
	this.age = age;
}

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getHobbies() {
	return hobbies;
}

public void setHobbies(String hobbies) {
	this.hobbies = hobbies;
}

public String getStandard() {
	return standard;
}

public void setStandard(String standard) {
	this.standard = standard;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", hobbies=" + hobbies + ", standard=" + standard + ", age=" + age
			+ "]";
}



	
}
