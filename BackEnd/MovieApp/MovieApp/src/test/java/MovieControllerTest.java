import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.revature.controllers.MovieController;
import com.revature.models.Movie;
import com.revature.services.MovieService;

public class MovieControllerTest {

	@Mock
	private MovieService movieService;
	
	@InjectMocks
	private MovieController movieController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
	}
	
	int userID = 1;
	int movieID =1;
	List<Movie> movie = new ArrayList<>();
	
	@Test
	public void testInsert() throws Exception{
		Movie movie = new Movie(0,"url","title","description","release date", "director",5,"genre");
		
		 ObjectMapper obj = new ObjectMapper();
		 obj.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		 ObjectWriter ow = obj.writer().withDefaultPrettyPrinter();
		 String requestJson = ow.writeValueAsString(movie);
		 
		when(movieService.insertMovie(movie)).thenReturn(true);
		
		mockMvc.perform(post("/movie/insert",movie).contentType(MediaType.APPLICATION_JSON).content(requestJson))	
		//	.andDo(print())
			.andExpect(status().isCreated()).andReturn();
	}
	
	@Test
	public void testMovieByID() throws Exception{
		
		when(movieService.getMovieByMovieID(movieID)).thenReturn(movie);
		
		mockMvc.perform(get("/movie/ID?movieID={movieID}", movieID))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andReturn();
	}
	
	@Test
	public void testAllMovies() throws Exception{
		
		when(movieService.getAllMovies()).thenReturn(movie);
		
		mockMvc.perform(get("/movie/all"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andReturn();
	}
	
	
	
}
