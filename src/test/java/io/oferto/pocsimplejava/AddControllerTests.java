package io.oferto.pocsimplejava;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class AddControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void affIntegers() throws Exception {
		 MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		 params.add("a", "2");
		 params.add("b", "2");
		 
		this.mockMvc.perform(get("/add").params(params))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result").value("4"));
	}
}
