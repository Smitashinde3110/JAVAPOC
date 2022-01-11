package com.neo.Service;


	

	
			
	
	

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neo.Repository.UserRepository;
import com.neo.model.User;
 
@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository repo;
    
    private List<User> users = new ArrayList<User>(Arrays.asList(
			new User()
			));
     
    public List<User> listAll() {
        return repo.findAll();
    }
     
    public void save(User user) {
        repo.save(user);
    }
     
    public User get(Long id) {
        return repo.findById(id).get();
    }
     
    public void delete(Long id) {
        repo.deleteById(id);
    }

public List<User> sortByUsername(){

		
		Comparator<User> byNameComparator = Comparator.comparing(User::getfirstname);
		return users.stream().sorted(byNameComparator).collect(Collectors.toList());
	}

public List<User> sortByDOB(){
	
	Comparator<User> byDOBComparator = Comparator.comparing(User::getDOB);
	return users.stream().sorted(byDOBComparator).collect(Collectors.toList());
}

public List<User> sortByDOJ(){
	
	Comparator<User> byDOJComparator = Comparator.comparing(User::getDOJ);
	return users.stream().sorted(byDOJComparator).collect(Collectors.toList());
}


	

}
	


