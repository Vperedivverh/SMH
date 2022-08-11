package web.service;

import web.model.User;


import java.util.List;

public interface UsersService {
    List<User> getAllUsers ();

    User getUserById(long id);

    void saveUser (User user);

    void deleteById(long id);
    void updateUser(long id, User user);

}