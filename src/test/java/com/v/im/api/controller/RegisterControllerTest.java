package com.v.im.api.controller;

import com.VServerApplication;
import com.v.im.user.entity.TLoginuser;
import com.v.im.user.service.ITLoginuserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VServerApplication.class)
public class RegisterControllerTest {

    @Autowired
    private RegisterController registerController;

    @Autowired
    @Qualifier(value = "tLoginuserService")
    private ITLoginuserService tLoginuserService;

    @Test
    public void register() {
        List<TLoginuser> list = tLoginuserService.list(null);
        for (TLoginuser user: list) {
            registerController.register(user.getUsername(),"1",user.getLogname());
        }
        System.out.println(list.size());
        //registerController.register("test","1","test");
    }
}