package com.zikozee.sprinboot.consumingwebservices.jwt.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @AllArgsConstructor
public class  JwtTokenRequest implements Serializable {

  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;

//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aWtvemVlIiwiZXhwIjoxNTk1OTM5NzU0LCJpYXQiOjE1OTUzMzQ5NTR9.93UJEtBSM3LDPnAVWGdJ-txQstGesWbTwqasTnlpeiCYNzxho_ZJFeP3td2xGNQxU_KUvViscXfwnMVQTf0XFA"
//    }
    public JwtTokenRequest() {
        super();
    }
}
