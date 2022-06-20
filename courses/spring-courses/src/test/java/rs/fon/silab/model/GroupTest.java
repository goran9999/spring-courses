package rs.fon.silab.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroupTest {

	Group g;
	
	@BeforeEach
	void createInstance() {
		g=new Group();
	}
	
	@Test
	void shouldSetId() {
		g.setId(Long.valueOf(1));
		assertEquals(g.getId(), Long.valueOf(1));
	}
	
	@Test
	void shouldNotAllowNullId() {
		assertThrows(NullPointerException.class, ()->{g.setId(null);});
	}
	
	@Test
	void shouldNotAllowNegativeId() {
		assertThrows(IllegalArgumentException.class, ()->{g.setId(Long.valueOf(-1));});
	}
	
	@Test
	void shouldSetGroupName() {
		g.setName("group1");
		assertEquals(g.getName(), "group1");
	}
	
	@Test
	void shouldNotAllowEmptyStringAsGroupName() {
		assertThrows(IllegalArgumentException.class, ()->{g.setName("");});
	}
	
	@Test
	void shouldNotAllowNullAsGroupName() {
		assertThrows(NullPointerException.class, ()->{g.setName(null);});
	}
	
	@Test
	void shouldNotAllowNegativeStudentsCount() {
		assertThrows(IllegalArgumentException.class, ()->{g.setStudentsCount(-23);});
	}
	
	@Test
	void shouldNotAllowCourseWithNullId() {
		Course c=new Course();
		assertThrows(NullPointerException.class, ()->{g.setCourse(c);});
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,name,12,1,name,12,true",
		"2,name1,15,1,name1,15,false",
		"3,name2,15,3,name4,15,false",
		"4,name3,10,4,name3,12,false"
	})
	void testEqualsMethod(Long id1,String name1,int studentsCount1,Long id2,String name2,int studentsCount2,boolean equals) {
		g.setId(id1);
		g.setName(name1);
		g.setStudentsCount(studentsCount1);
		
		Group g2=new Group();
		g2.setId(id2);
		g2.setStudentsCount(studentsCount2);
		g2.setName(name2);
		
		assertEquals(equals, g.equals(g2));
	}
	
	@Test
	void testToString() {
		g.setName("groupName1");
		g.setStudentsCount(25);
		
		String s=g.toString();
		
		assertTrue(s.contains("groupName1"));
		assertTrue(s.contains("25"));
	}
	
}
