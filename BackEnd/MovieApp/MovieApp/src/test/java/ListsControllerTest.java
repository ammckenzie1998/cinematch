import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

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
import com.revature.controllers.ListsController;
import com.revature.models.Lists;
import com.revature.services.ListsService;

public class ListsControllerTest {
	
	@Mock
	private ListsService listsService;
	
	@InjectMocks
	private ListsController listsController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(listsController).build();
	}
	
	int userID = 1;
	int movieID =1;
	List<Lists> lists = new ArrayList<>();
	
	@Test
	public void testListsByMovieID() throws Exception{
		lists.add(new Lists());
		lists.add(new Lists());
		
		when(listsService.getListsByUserID(movieID)).thenReturn(lists);
		
		mockMvc.perform(get("/lists/movieID?movieID={movieID}", movieID))
		//	.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"));
		//	.andReturn();
	}

	@Test
	public void testListsByUserID() throws Exception{
		lists.add(new Lists());
		lists.add(new Lists());
		
		when(listsService.getListsByUserID(userID)).thenReturn(lists);
		
		mockMvc.perform(get("/lists/userID?userID={userID}", userID))
		//	.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andReturn();
	}
	
//	@Test
//	public void testInsert() throws Exception{
//		Lists list = new Lists(0,1,false,false,1);
//		
//		 ObjectMapper obj = new ObjectMapper();
//		 obj.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		 ObjectWriter ow = obj.writer().withDefaultPrettyPrinter();
//		 String requestJson = ow.writeValueAsString(list);
//		 
//		when(listsService.insertList(list)).thenReturn(true);
//		
//		mockMvc.perform(post("/lists/insert",list).contentType(MediaType.APPLICATION_JSON).content(requestJson))	
//		//	.andDo(print())
//			.andExpect(status().isCreated()).andReturn();
//	}
	
	@Test
	public void testLikedByUserID() throws Exception{
		lists.add(new Lists());
		lists.add(new Lists());
		
		when(listsService.getLikedByUserID(userID)).thenReturn(lists);
		
		mockMvc.perform(get("/lists/user/likedlist?userID={userID}", userID))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andReturn();
	}
	
	@Test
	public void testLikedByMovieID() throws Exception{
		lists.add(new Lists());
		lists.add(new Lists());
		
		when(listsService.getWatchListByUserID(userID)).thenReturn(lists);
		
		mockMvc.perform(get("/lists/user/watchlist?userID={userID}", userID))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andReturn();
	}
	
//	@Test
//	public void testInsertLike() throws Exception{
//		lists.add(new Lists());
//		lists.add(new Lists());
//		
//		when(listsService.insertLike(userID,movieID)).thenReturn(true);
//		
//		mockMvc.perform(post("/lists/like?userID={userID}&movieID={movieID}", userID, movieID).contentType("application/json"))
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andReturn();
//	}
	
//	@Test
//	public void testInsertWatch() throws Exception{
//		lists.add(new Lists());
//		lists.add(new Lists());
//		
//		when(listsService.insertWatchList(userID,movieID)).thenReturn(true);
//		
//		mockMvc.perform(post("/lists/watch?userID={userID}&movieID={movieID}", userID, movieID).contentType("application/json"))
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andReturn();
//	}
	
//	@Test
//	public void testRemoveLike() throws Exception{
//		lists.add(new Lists());
//		lists.add(new Lists());
//		
//		when(listsService.removeLike(userID,movieID)).thenReturn(true);
//		
//		mockMvc.perform(post("/lists/removelike?userID={userID}&movieID={movieID}", userID, movieID).contentType("application/json"))
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andReturn();
//	}
	
//	@Test
//	public void testRemoveWatch() throws Exception{
//		lists.add(new Lists());
//		lists.add(new Lists());
//		
//		when(listsService.removeWatchList(userID,movieID)).thenReturn(true);
//		
//		mockMvc.perform(post("/lists/removewatch?userID={userID}&movieID={movieID}", userID, movieID).contentType("application/json"))
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andReturn();
//	}
//	
	
	
	
}
