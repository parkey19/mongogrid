package io.parkey19.valid;

import io.parkey19.common.CommonUtils;
import io.parkey19.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * Created by parkey19 on 2019. 4. 10..
 */
@Component
public class UserValidator {

    public void validate(UserDto userDto, Errors errors) {
        String wrongValue = "wrongValue";
        if (!CommonUtils.emailCheck(userDto.getUsername())) {
            errors.rejectValue("username", wrongValue, "user email is wrong");
        }

        if (!CommonUtils.emailCheck(userDto.getUsername())) {
            errors.rejectValue("username", wrongValue, "user email is wrong");
        }

    }
}
