package ru.streltsov.mymvcspringbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.streltsov.mymvcspringbootproject.dao.UserDao;
import ru.streltsov.mymvcspringbootproject.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDaoImpl;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Transactional
    public UserDao getUserDaoImpl() {
        return userDaoImpl;
    }

    @Transactional
    public void setUserDaoImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDaoImpl.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDaoImpl.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDaoImpl.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoImpl.getAllUsers();
    }

    @Override
    public User getUser(int id) {
        return userDaoImpl.getUser(id);
    }
}
