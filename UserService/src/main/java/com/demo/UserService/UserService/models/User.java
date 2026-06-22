package com.demo.UserService.UserService.models;

import jakarta.persistence.*;
import lombok.*;

//import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name="ID")
    private String userId;
    @Column(name = "NAME", length = 20)
    private String name;
    private String email;
    private String about;
    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
