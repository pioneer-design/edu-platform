package cn.com.dhcc.edu.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <b></b>
 *
 * @author : WMF
 * @since : 2020/7/15 8:52
 */
@Component
public class SendMsg {
    private String message;

    public SendMsg(String message) {
        this.message = message;
    }

    public SendMsg() {
    }

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void sendMessage(String message) {
        simpMessagingTemplate.convertAndSend("/topic/getResponse", message);
    }
}
