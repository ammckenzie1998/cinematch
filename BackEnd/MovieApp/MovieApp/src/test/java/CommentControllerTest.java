import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.revature.controllers.CommentController;
import com.revature.models.Comment;
import com.revature.services.CommentService;

public class CommentControllerTest {
	
	@Mock
	private CommentService commentService;
	
	@InjectMocks
	private CommentController commentController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
	}
	
	int userID = 1;
	int movieID =1;
	int id = 1;
	String comm = "comment";
	List<Comment> comments = new ArrayList<>();
	
	@Test
	public void testCommentByUserID() throws Exception{
		
		when(commentService.getCommentByUserID(userID)).thenReturn(comments);
		
		mockMvc.perform(get("/comment/userID?userID={userID}", userID))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void testCommentByMovieID() throws Exception{
		
		when(commentService.getCommentByMovieID(movieID)).thenReturn(comments);
		
		mockMvc.perform(get("/comment/movieID?movieID={movieID}", movieID))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"));
	}
	
//	@Test
//	public void testInsert() throws Exception{
//		Comment comment = new Comment(0,"comment",1,1);
//		
//		 ObjectMapper obj = new ObjectMapper();
//		 obj.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		 ObjectWriter ow = obj.writer().withDefaultPrettyPrinter();
//		 String requestJson = ow.writeValueAsString(comment);
//		 
//		when(commentService.insertComment(comment)).thenReturn(true);
//		
//		mockMvc.perform(post("/comment/insert",comment).contentType(MediaType.APPLICATION_JSON).content(requestJson))	
//			.andExpect(status().isCreated()).andReturn();
//	}
//	
//	@Test
//	public void testUpdateComment() throws Exception{
//		
//		when(commentService.updateComment(id,comm)).thenReturn(true);
//		
//		mockMvc.perform(put("/comment/update?id={id}&comment={comm}", id, comm).contentType("application/json"))
//			.andDo(print())
//			.andExpect(status().isOk());
//	}
//	
//	@Test
//	public void testRemoveComment() throws Exception{
//		
//		when(commentService.deleteComment(id)).thenReturn(true);
//		
//		mockMvc.perform(delete("/comment/delete?id={id}", id).contentType("application/json"))
//			.andDo(print())
//			.andExpect(status().isOk());
//	}

}
