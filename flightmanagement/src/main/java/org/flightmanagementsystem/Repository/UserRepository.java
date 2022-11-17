package org.flightmanagementsystem.Repository;

import java.math.BigInteger;

import org.flightmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger>{

}