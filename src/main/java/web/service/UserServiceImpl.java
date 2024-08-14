package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.entity.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> index() {
        return userDao.getAllUsers();
    }

    @Override
    public User show(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        userDao.updateUser(user, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.deleteUser(id);
    }
}
