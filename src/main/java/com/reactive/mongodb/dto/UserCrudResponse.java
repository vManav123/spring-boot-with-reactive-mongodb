package com.reactive.mongodb.dto;

import com.reactive.mongodb.model.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserCrudResponse {
    private long id;
    private User user;
}
