package com.example.AttendanceManage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AttendanceManageApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testIndex() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/attendance"))
				.andExpect(status().is(200))
				.andExpect(content().string(containsString("出勤")));
	}

	@Test
	public void testYourEndpoint() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/attendanceList"))
				.andExpect(content().string(containsString("09:30:00")))
				.andExpect(content().string(containsString("12:15:00")));
	}

//	@Test
//	public void testUserList() throws Exception{
//		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/user"))
//				.andExpect(content().string(containsString("09:30:00")))
//				.andExpect(content().string(containsString("12:15:00")));
//	}
}
