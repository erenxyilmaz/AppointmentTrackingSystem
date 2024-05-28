package com.distdemo3.appoint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    private String name;
    private String surname;
    private String no;
    private String type;
    private String kurum;
    private String kullaniciName;
    private String kulSifre;
}
