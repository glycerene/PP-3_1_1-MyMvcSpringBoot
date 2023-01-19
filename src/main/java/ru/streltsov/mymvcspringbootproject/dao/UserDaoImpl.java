package ru.streltsov.mymvcspringbootproject.dao;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.streltsov.mymvcspringbootproject.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.merge(user);
    }

    @Override
    public void updateUser(User user) {
        User updated = getUser(user.getId());
        updated.setName(user.getName());
        updated.setSurname(user.getSurname());
        updated.setAge(user.getAge());
        updated.setEmail(user.getEmail());
        em.merge(updated);
    }

    @Override
    public void deleteUser(int id) {
        User foundUser = em.find(User.class, id);
        em.remove(foundUser);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }
}
