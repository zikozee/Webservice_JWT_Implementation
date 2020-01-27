package com.zikozee.sprinboot.consumingwebservices.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter @NoArgsConstructor @ToString
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
