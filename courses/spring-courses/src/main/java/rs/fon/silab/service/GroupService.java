package rs.fon.silab.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.fon.silab.dto.GroupDto;
import rs.fon.silab.model.Group;

public interface GroupService{

	List<GroupDto> getAllGroups();
	GroupDto saveGroup(GroupDto group);
	GroupDto getGroup(Long id);
}
