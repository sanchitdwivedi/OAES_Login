package com.example.oaes_login.service;

import com.example.oaes_login.entity.Coordinator;
import com.example.oaes_login.entity.Student;
import com.example.oaes_login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserService userService;

    public LoginService(){
        userService = new UserService();
    }

    public String authenticate(User user, String password) throws Exception {
        if(user instanceof Student) return authenticateStudent((Student) user, password);
        else return authenticateCoordinator((Coordinator) user, password);
    }

    public Object authenticateByUserID(long userID, String password) throws Exception {
        User user = userService.getUserById(userID);
        if(user==null) return "Invalid details";
        String res = authenticate(user, password);
        if(!res.equals("valid")) return res;
        else return user;
    }

    public String authenticateStudent(Student student, String password){
        if(student.getLocked()==1){
            return "Exception: The student account is currently locked. Please contact your exam coordinator.";
        }
        if(!student.getPassword().equals(password)){
            if(student.getTriesLeft()==1){
                student.setLocked(1);
                student.setTriesLeft(0);
                try {
                    userService.updateUser(student);
                } catch(Exception e){
                    System.out.println(e);
                    return "Error";
                }
                return "Invalid password. Your account has been locked because of too many wrong attempts. Please contact exam coordinator";
            }
            student.setTriesLeft(student.getTriesLeft()-1);
            try {
                userService.updateUser(student);
            } catch(Exception e){
                System.out.println(e);
                return "Error";
            }
            return ("Password is not valid. Please try again. " + student.getTriesLeft() + " attempt(s) left!");
        }
        return "valid";
    }

    public String authenticateCoordinator(Coordinator coordinator, String password){
        if(coordinator.getPassword().equals(password)) return "valid";
        else return "Invalid details";
    }
}
