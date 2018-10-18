package com.example.josue.practicalogin;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> list() {
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    //AGREGAR USUARIO
    public static void create(String fullname, String email, String password){
        User user = new User(fullname, email, password);
        SugarRecord.save(user);
    }

    //LEER USUARIO
    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }


    //MODIFICAR USUARIO
    //ESTO NOS SERVIRA PARA CUANDO LE DES EN FAVORITO CON UN RECICLER VIEW LO ENVIES EZZZ XD
    public static void update(String fullname, String email, String password, Long id){
        User user = SugarRecord.findById(User.class, id);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        SugarRecord.save(user);
    }

    // ELIMINAR USUARIO
    //ESTO TE SERVIRA PARA QUE LO ARCHIVES EZZ XD noob
    public static void delete(Long id){
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }

    public static User getUser(String username){
        //Verificar el usuario si existe
        for(User user:list()) {
            if (user.getFullname().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }


    public static User log(String username, String password){
        //Verificar el usuario si existe
        for(User user:list()) {
            if (user.getFullname().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}

