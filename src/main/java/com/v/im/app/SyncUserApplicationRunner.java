package com.v.im.app;

import com.v.im.api.controller.RegisterController;
import com.v.im.api.entity.RegisterResult;
import com.v.im.user.entity.TLoginuser;
import com.v.im.user.service.ITLoginuserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SyncUserApplicationRunner implements ApplicationRunner {

    private static final Log logger = LogFactory.getLog(SyncUserApplicationRunner.class);

    @Autowired
    private RegisterController registerController;

    @Autowired
    @Qualifier(value = "tLoginuserService")
    private ITLoginuserService tLoginuserService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("开始生成IM用户...");
        List<TLoginuser> list = tLoginuserService.list(null);
        RegisterResult result;
        int ctn = 0;
        for (TLoginuser user: list) {
            result = registerController.register(user.getUsername(),"1",user.getLogname());
            if (null != result && RegisterResult.SUCCESS.equals(result.getResultCode())) {
                ctn++;
            }
        }
        logger.info(String.format("共%s个用户，成功生成%s个IM用户.",list.size(),ctn));
    }
}
