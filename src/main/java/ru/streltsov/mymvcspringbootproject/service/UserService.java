package ru.streltsov.mymvcspringbootproject.service;

import ru.streltsov.mymvcspringbootproject.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
    User getUser(int id);
}
