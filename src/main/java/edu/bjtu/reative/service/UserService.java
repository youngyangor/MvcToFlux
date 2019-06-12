package edu.bjtu.reative.service;

import edu.bjtu.reative.entity.User;

public interface UserService {
    Iterable<User> getAllUsers();
    User saveUser(User user);
    void deleteUser(Integer id);
}
