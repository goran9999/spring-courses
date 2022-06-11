package rs.fon.silab.converter;

import org.springframework.stereotype.Component;

import rs.fon.silab.dto.GroupDto;
import rs.fon.silab.model.Course;
import rs.fon.silab.model.Group;

@Component
public class GroupConverter implements Converter<GroupDto, Group> {

	@Override
	public GroupDto toDto(Group e) {
		return new GroupDto(e.getId(),e.getName(),e.getCourse().getId());
	}

	@Override
	public Group toEntity(GroupDto d) {
		Group g=new Group();
		g.setName(d.getGroupName());
		Course c=new Course();
		c.setId(d.getCourseId());
		g.setCourse(c);
		return g;
	}

}
