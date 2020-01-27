package com.zikozee.sprinboot.consumingwebservices.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @Getter @Setter
public class UserList {
    private List<User> users;

}
