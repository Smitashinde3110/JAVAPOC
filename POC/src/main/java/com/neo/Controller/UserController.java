package com.neo.Controller;
import java.util.*;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.annotations.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

import com.neo.Repository.UserRepository;
import com.neo.Service.UserService;
import com.neo.model.User;





 
@RestController
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repo;
    
    @GetMapping("/users")
    public List<User> list() {
        return service.listAll();
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        try {
        	   User user = service.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        } 
    }
        
        @PostMapping("/users")
        public void add(@RequestBody User user)
        {
            service.save(user);
        }
        
        @PutMapping("/users/{id}")
        public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
            try {
               User existuser = service.get(id);
                service.save(user);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }      
        }
        
        @DeleteMapping("/users/{id}")
        public void delete(@PathVariable Long id) {
            service.delete(id);
        }
        
        
        
        @GetMapping("/searchuser/{id}")
    	public ResponseEntity<Object> getUsertById(@PathVariable long id) {
       Optional<User> user = Optional.of(service.get(id));
    		if (user.isPresent()) {
    			logger.info("Found user at :: "+new java.util.Date().toString());
    			return new ResponseEntity<Object>(user, HttpStatus.OK);
    		} else {
    			logger.warn("User not found :: "+new java.util.Date().toString());
    			return new ResponseEntity<Object>("No such ID : " + id, HttpStatus.NOT_FOUND);
    		}

    	}
        
       @GetMapping("/users/name")
       public ResponseEntity<List<User>> getUserByName(@RequestParam String name)	
       {
      	return new  ResponseEntity<List<User>>(repo.findByFirstname(name),HttpStatus.OK);
       }
       
       
       @GetMapping("users/or/{firstname}/{lastname}/{pincode}")
   	public List<User> getTrainerByFnamOrLnameOrPcode(@PathVariable String firstname,@PathVariable String lastname,@PathVariable String pincode) {
   		return repo.findByFirstnameOrLastnameOrPincode(firstname, lastname, pincode);
   	}
       
       @GetMapping("/myuser")
   	public List<User> getAll (@RequestParam String field) {
   		return repo.findAll(Sort.by(Direction.ASC, field));
   	}
       
       @GetMapping("users/sortBydob")
   	public List<User> getUsersSortedByDOB(){
   		
   		return service.sortByDOB();
   	}
       @GetMapping("users/sortBydoj")
      	public List<User> getUsersSortedByDOJ(){
      		
      		return service.sortByDOJ();
      	}
       
      
	}