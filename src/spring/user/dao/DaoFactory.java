package spring.user.dao;

public class DaoFactory {
    public UserDao userDao(){
        return new UserDao(new PconnectionMaker());
    }

    public AccountDao accountDao(){
        return new AccountDao(new PconnectionMaker());
    }

    public MessageDao messageDao(){
        return new MessageDao(new PconnectionMaker());
    }
}
