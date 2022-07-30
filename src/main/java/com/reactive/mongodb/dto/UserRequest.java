package com.reactive.mongodb.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRequest {
    public static final String SEQUENCE_NAME = "users_sequence";
    private Long user_id;
    private String full_name;
    private int age;
    private String contact_no;
    private String email_address;
    private String bank_name;
    private Long account_no;
    private String credit_card_no;
    private String cvv;
    private LocalDate expiry_date;
    private String roles;
    private int failed_attempts;
    private boolean account_non_locked;
    private LocalTime lock_time;
}
