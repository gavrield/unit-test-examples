package testingil.unittesting.examples.demos.d05.spring.d05.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ContextConfiguration(classes = { ItemConfiguration.class })
public class ControllerTests{

	@MockBean(answer = Answers.RETURNS_DEEP_STUBS)
	@Autowired
    ItemRepository mockrepository;

	@Autowired
    ItemController controller;

	MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void when_no_items_returns_error() throws Exception {
		setupRepositoryToReturn(0);
		String result = callGetAllItems_error();
		assertEquals(result, "Error");
	}

	private String callGetAllItems_error() throws Exception {
		MvcResult result = mockMvc.perform(
				get("/items/"))
				.andExpect(status().isServiceUnavailable())
				.andReturn();
		return result.getResponse().getContentAsString();
	}

	private void setupRepositoryToReturn(int i) {
		when(mockrepository.findTotal()).thenReturn(0);
	}
}
