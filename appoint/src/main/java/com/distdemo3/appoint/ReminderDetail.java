package com.distdemo3.appoint;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReminderDetail {
    private LocalDateTime dateTime;
    private String userId;
    private String serviceProviderId;
}
