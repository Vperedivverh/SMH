package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UsersDAO;
import web.model.User;


import java.util.List;

@Service

public class UsersServiceImpl implements UsersService {
    private final UsersDAO usersDAO;

    @Autowired
    public UsersServiceImpl(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return usersDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        usersDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        usersDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(long id, User user) {
        usersDAO.updateUser(id, user);
    }
}