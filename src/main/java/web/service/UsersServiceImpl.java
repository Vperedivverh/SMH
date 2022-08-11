package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UsersDAO;
import web.model.User;


import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private final UsersDAO usersDAO;

    @Autowired
    public UsersServiceImpl(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }


    @Override

    public List<User> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override

    public User getUserById(long id) {
        return usersDAO.getUserById(id);
    }

    @Override

    public void saveUser(User user) {
        usersDAO.saveUser(user);
    }

    @Override

    public void deleteById(long id) {
        usersDAO.deleteById(id);
    }

    @Override

    public void updateUser(long id, User user) {
        usersDAO.updateUser(id, user);
    }


}