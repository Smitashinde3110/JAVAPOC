package com.neo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

List<User>findByFirstname(String name);
//List<User>findByLast_name(String Last_name);

List<User> findByFirstnameOrLastnameOrPincode(String firstname, String lastname,String pincode);





	
}
	

