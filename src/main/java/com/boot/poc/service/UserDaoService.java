package com.boot.poc.service;

import com.boot.poc.models.User;
import org.springframework.stereotype.Component;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.Iterator;
        import java.util.List;

@Component
public class UserDaoService {
    private static int usersCount=3;
    private static List<User> users=new ArrayList<User>();
    static {
        users.add(new User(1,"Adam", new Date()));
        users.add(new User(2,"Ravi", new Date()));
        users.add(new User(3,"Patttnaik", new Date()));
    }

    public List<User> findAll() {
        if(users==null || users.isEmpty()){
            //throw new EmptyUserListException("No user exist");
        }
        return users;
    }
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public User findOne(int id){
        for(User user:users){
            if(id==user.getId())
                return user;
        }
        return null;
    }
    public User deleteUser(int id){
        Iterator<User> iterator=users.iterator();
        while(iterator.hasNext()){
            User user=iterator.next();
            if(id==user.getId()){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User update(int id,User user) {
        User updatedUser=null;
        for(User tempuser:users){
            if(id==tempuser.getId()) {
                tempuser.setName(user.getName());
                tempuser.setBirthDate(user.getBirthDate());
                updatedUser= user;
            }
        }
        return updatedUser;
    }
}