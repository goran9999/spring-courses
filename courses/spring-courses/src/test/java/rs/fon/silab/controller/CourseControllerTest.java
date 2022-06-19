package rs.fon.silab.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import rs.fon.silab.repository.AreaRepository;
import rs.fon.silab.service.impl.AreaServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CourseControllerTest.class)
public class CourseControllerTest {

	private final String URL = "http://localhost:8080/api/v1/course";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AreaRepository areaRepository;
	
	@MockBean
	private AreaServiceImpl areaServiceImpl;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void shouldReturnAllCourses() throws Exception {
		RequestBuilder request=MockMvcRequestBuilders.get(URL+"all");
		MvcResult response=this.mockMvc.perform(request).andReturn();
		assertEquals(response.getResponse().getContentLength(), 0);
	}

}
