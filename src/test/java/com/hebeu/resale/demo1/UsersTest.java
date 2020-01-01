package com.hebeu.resale.demo1;

import com.hebeu.resale.demo1.domain.Users;
import com.hebeu.resale.demo1.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTest {
    @Resource
    private UsersService usersService;

    @Test
    public void t1() {
        Users users = usersService.queryOneByUsernameAndPasswordAndCharacter("yww", "ywwyww", "admin");
        if (users != null) {
            System.out.println(users);
        }
    }
}
