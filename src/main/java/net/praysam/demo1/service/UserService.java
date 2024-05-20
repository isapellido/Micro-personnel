package net.praysam.demo1.service;

import net.praysam.demo1.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     public User getUser(int i){
         //业务逻辑
         return new User("peter","m","18");
     }
}
