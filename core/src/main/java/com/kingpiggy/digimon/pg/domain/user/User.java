package com.kingpiggy.digimon.pg.domain.user;

import javax.persistence.*;

import com.kingpiggy.digimon.pg.domain.entity.BaseTimeEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String refreshToken;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

}
