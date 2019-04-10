package io.parkey19.dto;

import io.parkey19.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * Created by parkey19 on 2019. 4. 10..
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private UserRole userRole = UserRole.USER;

}
