//package com.revature;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.revature.models.Comment;
//import com.revature.models.Lists;
//import com.revature.models.User;
//import com.revature.repositories.CommentRepoImp;
//import com.revature.repositories.ListsRepoImp;
//import com.revature.repositories.UserRepoImp;
//
//public class Driver {
//	
//	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//	private static UserRepoImp uRepoImp = appContext.getBean("UserRepoImp", UserRepoImp.class);
//	private static CommentRepoImp cRepoImp = appContext.getBean("CommentRepoImp", CommentRepoImp.class);
//	private static ListsRepoImp mRepoImp = appContext.getBean("ListsRepoImp", ListsRepoImp.class);
//	
//	public static void main(String[] args) {
//		
//		User user1 = new User(0, "username1", "password1","user1", "name1" );
//		uRepoImp.insertUser(user1);
//		
//		User user2 = new User(0, "username2", "password2","user2", "name2" );
//		uRepoImp.insertUser(user2);
//
//		System.out.println("\nUser Table = " + uRepoImp.selectAllUsers());
//		
//		System.out.println("User Object for user2: " + uRepoImp.getUserByUsername("username2"));
//
//		/*uRepoImp.updateUser(user1);
//		
//		System.out.println(uRepoImp.selectAllUsers());
//		
//		uRepoImp.deleteUser(user1);
//		
//		System.out.println(uRepoImp.selectAllUsers());*/
//		
////		Comment comment1 = new Comment(0, "comment1 user1", 1, 1);
////		cRepoImp.insertComment(comment1);
////		
////		Comment comment2 = new Comment(0, "comment2 user1", 2, 1);
////		cRepoImp.insertComment(comment2);
////
////		Comment comment3 = new Comment(0, "comment1 user2", 1, 2);
////		cRepoImp.insertComment(comment3);
////
////		Comment comment4 = new Comment(0, "comment2 user2", 2, 2);
////		cRepoImp.insertComment(comment4);
//		
//		System.out.println("\nComment Table = " + cRepoImp.selectAllComments());
//
//		System.out.println("Comments By movieID 1: " + cRepoImp.getCommentByMovieId(1));
//
//		System.out.println("Comments By userID 2: " + cRepoImp.getCommentByUserId(2));
//				
//		/*Comment comment1 = new Comment(2, "comments", 1, 1);
//		cRepoImp.updateComment(comment1);
//		
//		System.out.println(cRepoImp.selectAllComments());
//		
//		cRepoImp.deleteComment(comment1);*/
//				
//		Lists m1 = new Lists(0, 1, true, true, 1);
//		mRepoImp.insertList(m1);
//		
//		Lists m2 = new Lists(0, 2, false, true, 1);
//		mRepoImp.insertList(m2);
//		
//		Lists m3 = new Lists(0, 1, true, true, 2);
//		mRepoImp.insertList(m3);
//		
//		Lists m4= new Lists(0, 2, false, true, 2);
//		mRepoImp.insertList(m4);
//		
//		System.out.println("\nMovie Table: " + mRepoImp.selectAllLists());
//		
//		System.out.println("Movie By movieID 2: " + mRepoImp.getListsByMovieId(2));
//		
//		System.out.println("Movie By userID 1: " + mRepoImp.getListsByUserId(1));
//			
//	}
//	
//}
