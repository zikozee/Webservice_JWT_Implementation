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

//  {
//    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU4MDczMzUxMCwiaWF0IjoxNTgwMTI4NzEwfQ.Mm-UjZBXwRCsrtsO4gnv3nb4h2IdwvK7ogRupgYQ0pIfmeO2ooLHIzFTewL5BlALWzrFOCL6N1u5VHj8r5eb7g"
//  }
//
    public JwtTokenRequest() {
        super();
    }
}
