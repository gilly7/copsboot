package com.example.copsboot.repository;



import com.example.copsboot.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;
public interface UserRepository extends CrudRepository<User, UUID> {


    
}