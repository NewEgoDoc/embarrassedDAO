package spring.user;

import spring.user.dao.DaoFactory;
import spring.user.dao.PconnectionMaker;
import spring.user.dao.UserDao;
import spring.user.domain.User;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext ac = new AnnotationApplicationContext(DaoFactory.class);

        UserDao dao = ac.getBean("userDao",UserDao.class);
        
        User user = new User();
        user.setId("white");
        user.setName("백기선");
        user.setPassword("married");
        
        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println("user2 name = " + user2.getName());
    }
}
