package com.distdemo3.appoint;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointDetail {
    private String service;
    private String time;
    private String date;
    private String userId;
    private String serviceProviderId;



    @Override
    public String toString() {
        return "Service: " + service + ", Time: " + time + ", Date: " + date;
    }
}
