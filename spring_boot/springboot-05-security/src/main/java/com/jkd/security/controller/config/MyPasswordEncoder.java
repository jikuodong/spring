package com.jkd.security.controller.config;

        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.stereotype.Component;

/**
 * 密码编码器
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return  s.equals(charSequence.toString());
    }
}
