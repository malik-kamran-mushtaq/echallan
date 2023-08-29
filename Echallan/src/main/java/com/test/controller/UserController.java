package com.test.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import com.test.entity.UserEntity;
import com.test.entity.UserEntity;
//import com.test.exceptions.ApiResponse;
import com.test.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

import com.test.exceptions.ApiRespo;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@EnableWebMvc

@Api(value="", description="This end-point manages the user. Through this you can view, add, update and delete a user.")
public class UserController {
	
	
	
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	
	@ApiOperation(value="Adding the user. This part is used to add the user.",
	notes="You can add the user from here",
	response=UserEntity.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
            @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
            @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
            @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
            @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors"),
	})
		
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
		UserEntity saveUser = this.userService.addUser(user);
		return new ResponseEntity<UserEntity>(saveUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	@ApiOperation(value="Getting all the users. This part is used to retrieve all the users.",
	notes="You can retrieve all the users from here",
	response=UserEntity.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
            @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
            @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
            @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
            @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors"),
	})
	public ResponseEntity<List<UserEntity>> getAllUsers(){
		List<UserEntity> allUsers = this.userService.getAllUsers();
		return new ResponseEntity<List<UserEntity>>(allUsers,HttpStatus.OK);
	}
	
	@GetMapping("/{lic_no}")
	@ApiOperation(value="You can get the details of a user by its licence number",
	notes="Get the details of a user by licence number",
	response=UserEntity.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
            @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
            @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
            @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
            @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors"),
	})
	public ResponseEntity<UserEntity> getUserById(@PathVariable("lic_no") int lic_no){
		UserEntity userById = this.userService.getUserById(lic_no);
		return new ResponseEntity<UserEntity>(userById,HttpStatus.OK);
	}
	
	@PutMapping("/{lic_no}")
	@ApiOperation(value="You can update the details of a user by its licence number",
	notes="Update the details of a user by licence number",
	response=UserEntity.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
            @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
            @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
            @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
            @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors"),
	})
	public ResponseEntity<UserEntity> updateUserById(@RequestBody UserEntity user,@PathVariable int lic_no) {
		UserEntity updatedUser = userService.updateUserById(user, lic_no);
		return new ResponseEntity<UserEntity>(updatedUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/{lic_no}")
	@ApiOperation(value="You can delete the details of a user by its licence number",
	notes="Delete the details of a user by licence number",
	response=UserEntity.class)

	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
            @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
            @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
            @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
            @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors"),
	})
	public ResponseEntity<ApiRespo> deleteUserById(@PathVariable("lic_no") int lic_no) {
		this.userService.deleteUserById(lic_no);
		ApiRespo response=new ApiRespo();
		response.setMessage("User record is deleted successfully with Licence number:"+lic_no);
		
		return new ResponseEntity<ApiRespo>(response,HttpStatus.OK);
	}
	@GetMapping("/check")
	@ApiOperation(value="You can login using username and password",
	notes="For login",
	response=UserEntity.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "The HTTP 200 OK success status response code indicates that the request has succeeded.\", response = ResponseWrapperVO.class"),
            @ApiResponse(code = 201, message = "The 201 Created status code indicates that the request was successfully fulfilled, resulting in the creation of one or more new resources."),
            @ApiResponse(code = 401, message = "The HTTP code “401 Unauthorized Access” is a client-side error."),
            @ApiResponse(code = 403, message = " The most common reason for a 403 error is a mistyped URL"),
            @ApiResponse(code = 404, message = "If the URL is not given correctly with valid required parameters then we will get 404 Not Found Errors"),
	})
	
	public ResponseEntity<UserEntity> checkLogin(@RequestParam("username") String username,@RequestParam("password") String password){
		
		UserEntity userLogin=this.userService.userLogin(username, password);
		if(userLogin!=null) {
			return new ResponseEntity<UserEntity>(userLogin,HttpStatus.OK);
		}
		else {
			return null;
		}
	}

}
