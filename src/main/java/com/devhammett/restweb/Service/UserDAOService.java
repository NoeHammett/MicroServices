package com.devhammett.restweb.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.devhammett.restweb.Models.UserModel;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
    
    private static List<UserModel> users = new ArrayList<>();

    private static int countUsers = 2;

    static{
        users.add(new UserModel(1, "Noe", "Lopez", "noe@mail.com", new Date()));
        users.add(new UserModel(2, "Miguel", "Navarro", "miguel@test.com", new Date()));
    }

    public List<UserModel> getAllUsers(){
        return users;
    }

    public UserModel addUser(UserModel user){
        if(user.getId_user() == null){
            user.setId_user(++countUsers);
        }
        users.add(user);
        return user;
    }

    public UserModel getUser(int id){
        for(UserModel user : users){
            if(user.getId_user() == id){
                return user;
            }
        }
        return null;
    }

    public UserModel deleteUser(int id){
        UserModel user = getUser(id);
        if(user != null){
            users.remove(user);
        }
        return user;
    }
}
