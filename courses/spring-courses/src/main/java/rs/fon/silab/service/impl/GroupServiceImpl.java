package rs.fon.silab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.fon.silab.converter.CourseConverter;
import rs.fon.silab.converter.GroupConverter;
import rs.fon.silab.dto.CourseDto;
import rs.fon.silab.dto.GroupDto;
import rs.fon.silab.model.Course;
import rs.fon.silab.model.Group;
import rs.fon.silab.repository.GroupRepository;
import rs.fon.silab.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{
	
	private final GroupRepository groupRepository;
	private final CourseServiceImpl courseServiceImpl;
	private final CourseConverter courseConverter;
	@Autowired
	public GroupServiceImpl(final GroupRepository groupRepository,final CourseServiceImpl courseServiceImpl,final CourseConverter courseConverter) {
		this.groupRepository=groupRepository;
		this.courseServiceImpl=courseServiceImpl;
		this.courseConverter=courseConverter;
	}
	
	@Autowired
	GroupConverter groupConverter;
	

	@Override
	public List<GroupDto> getAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto saveGroup(GroupDto group) {
		
		try {
			CourseDto courseDto=this.courseServiceImpl.getOneCourse(group.getCourseId());
			System.out.println(this.courseConverter);
			//Course course=this.courseConverter.toEntity(courseDto);
			Group g=this.groupConverter.toEntity(group);
			//g.setCourse(course);
			g.setCourse(new Course(courseDto.getId(),
					courseDto.getCourseName(),
					courseDto.getSemester(),courseDto.getStartDate(),courseDto.getEndDate(),courseDto.getGroupCount(),courseDto.getLevel()));
			Group savedGroup=this.groupRepository.save(g);
			return this.groupConverter.toDto(savedGroup);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public GroupDto getGroup(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
