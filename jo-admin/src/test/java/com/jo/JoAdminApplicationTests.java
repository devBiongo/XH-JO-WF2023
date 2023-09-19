package com.jo;

import com.jo.common.utils.JwtUtils;
import com.jo.system.service.ISysMenuService;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class JoAdminApplicationTests {

    @Autowired
    private ISysMenuService service;

    @Test
    void contextLoads() {
        Map<String, Object> claims = new HashMap<>() {{
            put("userId", "1");
            put("username", "username");
        }};
        String jwt = JwtUtils.createJWT(claims);

        Claims claims1 = JwtUtils.parseJWT(jwt);
        System.out.println(claims1);

    }

}
