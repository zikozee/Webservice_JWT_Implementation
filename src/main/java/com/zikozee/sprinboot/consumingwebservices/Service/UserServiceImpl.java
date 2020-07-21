package com.zikozee.sprinboot.consumingwebservices.Service;

import com.zikozee.sprinboot.consumingwebservices.Entity.Address;
import com.zikozee.sprinboot.consumingwebservices.Entity.User;
import com.zikozee.sprinboot.consumingwebservices.Entity.UserList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    private final RestTemplate restTemplate;

//    //Field Injection
//    @Value("${crm.rest.url}")
    private String url;

    @Autowired //we used constructor injection
    public UserServiceImpl(RestTemplate myRestTemplate, @Value("${crm.rest.url}")String crmRestUrl){
        restTemplate = myRestTemplate;
        url= crmRestUrl;
        log.info("loaded property: crm.rest,url=" + crmRestUrl);
    }

    @Override
    public List<User> getUserList(){
        log.info("in userList: Calling REST API " + url);
        //make REST call

        //Start
        //Set the headers you need send
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aWtvemVlIiwiZXhwIjoxNTk1OTM5NzU0LCJpYXQiOjE1OTUzMzQ5NTR9.93UJEtBSM3LDPnAVWGdJ-txQstGesWbTwqasTnlpeiCYNzxho_ZJFeP3td2xGNQxU_KUvViscXfwnMVQTf0XFA");

        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, entity,
                        new ParameterizedTypeReference<List<User>>(){});

        //End
        // get the list  of users from response
        List<User> users = responseEntity.getBody();
        log.info("in userList: users => " + users);
        return users;
    }

    @Override
    public List<User> alternativeUserList() {
       //Some APIs will return a top-level object that contains the list of employees instead of returning the list directly.
        UserList response = restTemplate.getForObject(
                url,
                UserList.class);
        List<User> users = response.getUsers();
        return users;
    }

    @Override
    public User getUser(int id) {
        log.info("in getUser: Calling REST API " + url);

        //make REST call
        User user = restTemplate.
                getForObject(url + "/" + id, User.class);

        log.info("in getUser: users => " + user);
        return user;
    }

    @Override
    public List<Address> getAddressList() {
        log.info("in getAddressList: Calling REST API " + url);
        List<Address> addresses = new ArrayList<>();
        
        for(User user : getUserList()){
            addresses.add(user.getAddress());
        }
        log.info("in getAddressList: addresses" + addresses);
        return addresses;
    }

    @Override
    public Address getUserAddress(int userId) {
        log.info("in getUserAddress: Calling REST API " + url);
        Address myAddress = null;
        for(User user : getUserList()){
            if(user.getId() == userId){
                myAddress=  getUserList().get(userId).getAddress();
            }
        }
        log.info("in getUserAddress: myAddress " + myAddress);
        return myAddress;
    }

    @Override
    public void saveUser(User user) {
        log.info("in saveUser: Calling REST API " + url);

        int userId = user.getId();

        //make REST call
        if(userId ==0){
            //add user
            restTemplate.postForEntity(url, user, String.class);
        }else{
            //update user
            restTemplate.put(url, user);
        }
        log.info("in saveUser(): success");
    }

    @Override
    public void deleteUser(int userId) {
        log.info("in deleteUser: Calling REST API " + url);
        //make REST call
        restTemplate.delete(url + "/" + userId);
        log.info("in deleteUser(): deleted customer userId = " + userId);
    }


}
