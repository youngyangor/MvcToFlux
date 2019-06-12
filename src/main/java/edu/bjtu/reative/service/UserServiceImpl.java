package edu.bjtu.reative.service;

import edu.bjtu.reative.dao.UserRepository;
import edu.bjtu.reative.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private UserRepository UserRepository;

    @Autowired
    public void setUserRepository(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return this.UserRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return this.UserRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        this.UserRepository.deleteById(id);
    }


}
