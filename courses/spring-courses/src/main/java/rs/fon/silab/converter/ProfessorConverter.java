package rs.fon.silab.converter;

import rs.fon.silab.dto.ProfessorDto;
import rs.fon.silab.model.Professor;

public class ProfessorConverter implements Converter<ProfessorDto, Professor>{

	@Override
	public ProfessorDto toDto(Professor e) {
		return new ProfessorDto(e.getId(),e.getFirstName(),e.getLastName(),e.getBithDate(),e.getDegreeLevel());
	}

	@Override
	public Professor toEntity(ProfessorDto d) {
		return new Professor(d.getId(), d.getFirstName(), d.getLastName(), d.getBirthDate(), d.getDegreeLevel());
	}

}
