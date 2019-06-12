package edu.bjtu.reative.dao;

import edu.bjtu.reative.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
