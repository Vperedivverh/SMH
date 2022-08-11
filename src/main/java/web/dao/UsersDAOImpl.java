package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UsersDAOImpl implements UsersDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select a from User a", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(long id, User user) {
        user.setId(id);
        entityManager.merge(user);
        //делал временную переменную  по подобию примера у Алишева или кого то ещё, точно не помню.
        // если просто положить user  в merge, ему присваивается новый id и мы получаем в таблицу нового юзера.
        //я добавил сеттер для id и тут его применил.
    }
}