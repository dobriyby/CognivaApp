package by.pstlabs.cognive.microservices.notifications.scheduling;

import by.pstlabs.cognive.microservices.notifications.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling
@EnableAsync
public class PushScheduling {

    @Autowired
    PushService pushService;

    @Async
    @Scheduled (fixedDelay = 10000)
    public void checkUnsendPushes(){
        pushService.checkSendTimePush();
    }
}
