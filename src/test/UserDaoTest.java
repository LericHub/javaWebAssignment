package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void testUserdao(){
        User user = new User(0,"test",18);
        user.setPassword("123456");
        user.setUsername("matsuri");
        UserDao dao = new UserDao();
        System.out.println(dao.login(user));
    }

    @Test
    public void findAllTest(){
        UserDao dao = new UserDao();
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
    @Test
    public void addUserTest(){
        User user = new User();
        user.setUsername("risu");
        user.setGender("女");
        user.setAge(Integer.parseInt("18"));
        user.setBirthplace("马来西亚");
        user.setQq("0000");
        user.setMail("0000");

        UserDao dao = new UserDao();
        dao.adduser(user);
        dao.findAll();
    }

    @Test
    public void findTest(){
        int id = 2;
        UserDao dao = new UserDao();
        User user = dao.find(1);
        System.out.println(user.toString());
    }

    @Test
    public void updateTest(){
        User user = new User();
        user.setId(1);
        user.setGender("女");
        user.setAge(Integer.parseInt("00"));
        user.setBirthplace("马来西亚");
        user.setQq("0000");
        user.setMail("0000");

        UserDao dao = new UserDao();
        dao.update(user);
    }

    @Test
    public void fidByPage(){
        UserDao dao = new UserDao();
        List<User> users = dao.fidByPage(0, 10);
        for (User user : users) {
            System.out.printf(user.toString());
        }
    }
    @Test
    public void conditionsearchTest(){
        UserDao dao = new UserDao();
        List<User> conditionsearch = dao.conditionsearch("", "日本",1,5);
        System.out.println(conditionsearch.size());
    }
}
