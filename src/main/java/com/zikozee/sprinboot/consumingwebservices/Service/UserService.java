package com.zikozee.sprinboot.consumingwebservices.Service;

import com.zikozee.sprinboot.consumingwebservices.Entity.Address;
import com.zikozee.sprinboot.consumingwebservices.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    List<User> alternativeUserList();
    User getUser(int userId);
    List<Address> getAddressList();
    Address getUserAddress(int userId);

    void saveUser(User user);
    void deleteUser(int userId);

}
