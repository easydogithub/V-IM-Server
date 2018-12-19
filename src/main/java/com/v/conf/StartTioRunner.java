package com.v.conf;

import com.v.tio.ShowcaseServerConfig;
import com.v.tio.ShowcaseWebsocketStarter;
import com.v.tio.ShowcaseWsMsgHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zkp
 */
@Component
public class StartTioRunner implements CommandLineRunner {

    @Autowired
    private ShowcaseWsMsgHandler showcaseWsMsgHandler;

    private ShowcaseWebsocketStarter appStarter;

    @Override
    public void run(String... args) throws Exception {
        this.appStarter = new ShowcaseWebsocketStarter(ShowcaseServerConfig.SERVER_PORT, showcaseWsMsgHandler);
        appStarter.getWsServerStarter().start();
    }

    public ShowcaseWebsocketStarter getAppStarter() {
        return appStarter;
    }

    public void setAppStarter(ShowcaseWebsocketStarter appStarter) {
        this.appStarter = appStarter;
    }
}
