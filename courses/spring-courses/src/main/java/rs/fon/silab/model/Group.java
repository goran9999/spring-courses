package rs.fon.silab.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author goran
 *
 */
@Entity
@Table(name = "course_group")
public class Group {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int studentsCount;
	
	private Date createdAt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course")
	Course course;
	
	@ManyToMany
	List<Professor>professors;
	
	@ManyToMany
	List<Student>students;

	public Group() {
		super();
	}

	public Group(Long id, String name, int studentsCount, Date createdAt, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.studentsCount = studentsCount;
		this.createdAt = createdAt;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentsCount() {
		return studentsCount;
	}

	public void setStudentsCount(int studentsCount) {
		this.studentsCount = studentsCount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, createdAt, id, name, studentsCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(course, other.course) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& studentsCount == other.studentsCount;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", studentsCount=" + studentsCount + ", createdAt=" + createdAt
				+ ", course=" + course + "]";
	}


	
	
	
	
}
