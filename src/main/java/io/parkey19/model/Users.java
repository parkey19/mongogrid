package io.parkey19.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

/**
 * Created by parkey19 on 2018. 11. 19..
 */

@Getter
@Setter
@EqualsAndHashCode(of = "_id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Users {

    @Id
    private String _id;
    private String username;
    private String password;

    private List<UserRole> roles;

}
