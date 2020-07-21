package com.zikozee.sprinboot.consumingwebservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class ConsumingwebservicesApplication{
    private static final Logger log = LoggerFactory.getLogger(ConsumingwebservicesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingwebservicesApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
//
//    //For Commandline logging as name implies
//    //Kick started before main app
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate){
//        return args -> {
//            //FOR SINGLE: Logging to console
//            User user = restTemplate.
//                    getForObject("https://jsonplaceholder.typicode.com/users/1", User.class);
//            log.info(user.toString());
//            //FOR All : Logging to console
//            ResponseEntity<List<User>> response = restTemplate.exchange(
//                    "https://jsonplaceholder.typicode.com/users/",
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<List<User>>(){});
//            List<User> user2 = response.getBody();
//            log.info(user2.toString());
//        };
//    }
}
