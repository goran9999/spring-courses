package rs.fon.silab.converter;

import rs.fon.silab.dto.StudentDto;
import rs.fon.silab.model.Student;

public class StudentConverter implements Converter<StudentDto, Student>{

	@Override
	public StudentDto toDto(Student e) {
		return new StudentDto(e.getId(), e.getFirstName(),e.getLastName(),e.getBirthDate(),e.getStudentStatus());
	}

	@Override
	public Student toEntity(StudentDto d) {
		return new Student(d.getId(), d.getFirstName(), d.getLastName(), d.getBirthDate(), d.getStudentStatus());
	}

}
