package com.revature.aspects;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("SessionAspect")
@Aspect
public class SessionAspect {

	//Validates the User's Session before allowing them to use get methods in the controller layer
	@Around("execution(* com.revature.controllers.UserController.*get*(..)) && args(req, ..)")
	public Object checkSessionBeforeUserControllerGetMethods(ProceedingJoinPoint jp, HttpServletRequest req) throws Throwable{
		Object result = null;
		try {
			if(req.getSession(false) != null) {
				result = jp.proceed();
			}
			return result;
		} catch (Throwable t){
			throw t;
		}	
	}
	
	//Validates the User's Session before allowing them to use get methods in the controller layer
	@Around("execution(* com.revature.controllers.ListsController.*get*(..)) && args(req, ..)")
	public Object checkSessionBeforeListsControllerGetMethods(ProceedingJoinPoint jp, HttpServletRequest req) throws Throwable{
		Object result = null;
		try {
			if(req.getSession(false) != null) {
				result = jp.proceed();
			}
			return result;
		} catch (Throwable t){
			throw t;
		}	
	}
	
	//Validates the User's Session before allowing them to use get methods in the controller layer
	@Around("execution(* com.revature.controllers.MovieController.*get*(..)) && args(req, ..)")
	public Object checkSessionBeforeCommentControllerGetMethods(ProceedingJoinPoint jp, HttpServletRequest req) throws Throwable{
		Object result = null;
		try {
			if(req.getSession(false) != null) {
				result = jp.proceed();
			}
			return result;
		} catch (Throwable t){
			throw t;
		}	
	}

	//Validates the User's Session before allowing them to use insert methods in the controller layer
	@Around("execution(* com.revature.controllers.*.*insert*(..)) && args(req, ..)")
	public Object checkSessionBeforeControllerInsertMethods(ProceedingJoinPoint jp, HttpServletRequest req) throws Throwable{
		Object result = null;
		try {
			if(req.getSession(false) != null) {
				result = jp.proceed();
			}
			return result;
		} catch (Throwable t){
			throw t;
		}	
	}
	
	//Validates the User's Session before allowing them to use update methods in the controller layer
	@Around("execution(* com.revature.controllers.*.*update*(..)) && args(req, ..)")
	public Object checkSessionBeforeControllerUpdateMethods(ProceedingJoinPoint jp, HttpServletRequest req) throws Throwable{
		Object result = null;
		try {
			if(req.getSession(false) != null) {
				result = jp.proceed();
			}
			return result;
		} catch (Throwable t){
			throw t;
		}	
	}
	
	//Validates the User's Session before allowing them to use delete methods in the controller layer
	@Around("execution(* com.revature.controllers.*.*delete*(..)) && args(req, ..)")
	public Object checkSessionBeforeControllerDeleteMethods(ProceedingJoinPoint jp, HttpServletRequest req) throws Throwable{
		Object result = null;
		try {
			if(req.getSession(false) != null) {
				result = jp.proceed();
			}
			return result;
		} catch (Throwable t){
			throw t;
		}	
	}
}
