package dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtil;

import javax.sql.DataSource;
import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    public User login(User login) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User log_user = template.queryForObject(sql
                    , new BeanPropertyRowMapper<>(User.class)
                    , login.getUsername(), login.getPassword());
            return log_user;
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return null;
        }
    }

    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    public void adduser(User user) {
        String sql = "INSERT INTO USER VALUES (null,?,null,?,?,?,?,?)";
//        INSERT INTO USER VALUES (NULL,"risu",NULL,16,"女","吗来西亚","0000","0000");

        template.update(sql, user.getUsername(), user.getAge(), user.getGender(), user.getBirthplace(), user.getQq(), user.getMail());

    }

    public void delete(int int_id) {
        String sql = "delete from user where id = ?";
        template.update(sql, int_id);
    }

    public User find(int id) {
        String sql = "select * from user where id = ?";
        User find_user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),
                id);
        return find_user;
    }

    public void update(User user) {
        String sql = "update USER set age = ?,gender = ?,birthplace = ?,qq=?,mail=? where id = ? ";
//        INSERT INTO USER VALUES (NULL,"risu",NULL,16,"女","吗来西亚","0000","0000");

        template.update(sql, user.getAge(), user.getGender(), user.getBirthplace(), user.getQq(), user.getMail(), user.getId());

    }

    public List<User> fidByPage(int page, int row) {
        int begin = page * row;
        String sql = "select * from user limit ?,?";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class), begin, row);
        return users;
    }

    public int conditionsearch(String name, String address){
        int size;

        if (name != "") {
            String search_name = "%"+name+"%";
            String sql = "select * from user where username like ?";
            size= template.query(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    search_name).size();
            return size;
        } else if (address != "") {
            System.out.println("==========address==========");
            String sql = "select * from user where birthplace = ?";
            size= template.query(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    address).size();
            return size;
        } else if (name != "" && address != "") {
            System.out.println("==========name & address==========");
            String search_name = "%"+name+"%";
            String sql = "select * from user where username like ? and birthplace = ?";
            size = template.query(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    search_name).size();
            return size;
        }else {
            System.out.println("==========null==========");
            return size = 0;
        }
    }

    public List<User> conditionsearch(String name, String address,int page ,int row) {
        int begin = page * row;
        if (name != "") {
            System.out.println("==========name==========");
            String search_name = "%"+name+"%";
            String sql = "select * from user where username like ? limit ?,?";
            List<User> users = template.query(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    search_name,begin,row);
            return users;
        } else if (address != "") {
            System.out.println("==========address==========");
            String sql = "select * from user where birthplace = ?  limit ?,?";
            List<User> users = template.query(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    address,begin,row);
            return users;
        } else if (name != "" && address != "") {
            System.out.println("==========name & address==========");
            String search_name = "%"+name+"%";
            String sql = "select * from user where username like ? and birthplace = ?  limit ?,?";
            List<User> users = template.query(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    search_name, address,begin,row);
            return users;
        }else {
            System.out.println("==========null==========");
            return null;
        }
    }
}
