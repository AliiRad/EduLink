package com.EduLink.EduLink.model.service;

import com.EduLink.EduLink.model.entity.User;
import com.EduLink.EduLink.model.repositroy.UserRepository;
import com.EduLink.EduLink.model.service.impl.ServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements ServiceImpl<User,Long> {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public User insert(User user) {
        try {
            userRepository.save(user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public User delete(User user) {
        userRepository.delete(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).isPresent() ? userRepository.findByUsername(username).get() : null;
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).isPresent() ? userRepository.findByUsername(username).get() : null;
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password).isPresent() ? userRepository.findByEmailAndPassword(email,password).get() : null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAll(String condition) {
        return null;
    }

    @Override
    public List<User> findAll(String condition, String order) {
        return null;
    }
}
