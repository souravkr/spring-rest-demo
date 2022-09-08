package com.trickspy.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandlerGlobal {

	 @ExceptionHandler	
	 public ResponseEntity<StudentResponseErrorModel> studentHandler(StudentExceptionHandler exc){
		 StudentResponseErrorModel error = new StudentResponseErrorModel();
		 error.setStatus(HttpStatus.NOT_FOUND.value());
		 error.setMessage(exc.getMessage());
		 error.setTimeStamp(System.currentTimeMillis());
		 
		 return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	 }
	 
	 @ExceptionHandler	
	 public ResponseEntity<StudentResponseErrorModel> studentHandler(RuntimeException exc){
		 StudentResponseErrorModel error = new StudentResponseErrorModel();
		 error.setStatus(HttpStatus.BAD_REQUEST.value());
		 error.setMessage(exc.getMessage());
		 error.setTimeStamp(System.currentTimeMillis());
		 
		 return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	 }
		
}
