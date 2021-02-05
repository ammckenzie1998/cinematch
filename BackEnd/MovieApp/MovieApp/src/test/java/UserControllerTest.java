import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserControllerTest {
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	int userID = 1;
	int movieID =1;
	List<User> user = new ArrayList<>();

	@Test
	public void testInsert() throws Exception{
		User user = new User(0,"username","password","first","last");
		
		 ObjectMapper obj = new ObjectMapper();
		 obj.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		 ObjectWriter ow = obj.writer().withDefaultPrettyPrinter();
		 String requestJson = ow.writeValueAsString(user);
		 
		when(userService.registerUser(user)).thenReturn(true);
		
		mockMvc.perform(post("/user/register",user).contentType(MediaType.APPLICATION_JSON).content(requestJson))	
			.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testLogin() throws Exception{
		User user = new User(0,"username","password","first","last");
		
		 ObjectMapper obj = new ObjectMapper();
		 obj.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		 ObjectWriter ow = obj.writer().withDefaultPrettyPrinter();
		 String requestJson = ow.writeValueAsString(user);
		 
		when(userService.login(user.getUsername(), user.getPassword())).thenReturn(user);
		
		mockMvc.perform(post("/user/login",user).contentType(MediaType.APPLICATION_JSON).content(requestJson))	
			.andExpect(status().isOk()).andReturn();
	}
}
