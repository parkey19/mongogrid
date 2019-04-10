package io.parkey19.common;

/**
 * Created by parkey19 on 2019. 4. 10..
 */
public class CommonUtils {

    final static String EMAIL_REGEX = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
    public static boolean emailCheck(String email) {
        Boolean b = email.matches(EMAIL_REGEX);
        return b;
    }

}
