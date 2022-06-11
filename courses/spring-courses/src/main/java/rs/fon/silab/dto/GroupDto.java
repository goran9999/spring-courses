package rs.fon.silab.dto;

import java.util.Objects;

public class GroupDto {

	private Long id;
	private String groupName;
	private Long courseId;

	public GroupDto() {
		super();
	}

	public GroupDto(Long id,String groupName,Long courseId) {
		super();
		this.id=id;
		this.groupName = groupName;
		this.courseId=courseId;
	}

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName);
	}
	
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupDto other = (GroupDto) obj;
		return Objects.equals(groupName, other.groupName);
	}

	@Override
	public String toString() {
		return "GroupDto [groupName=" + groupName + "]";
	}
	
	
	
}
