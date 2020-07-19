package cn.com.dhcc.edu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * <b>WebSocket 配置类</b>
 *
 * @author : WMF
 * @since : 2020/7/9 14:01
 */
@Configuration
@EnableWebSocketMessageBroker   //注解开启 STOMP 协议传输基于代理消息，此时的控制器支持 @MessageMapping
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 注册 Stomp 的节点
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册两个 WebSocket 访问端点，分别用于广播、点对点
        registry.addEndpoint("topicServer").setAllowedOrigins("*").withSockJS();
    }

    /**
     * 配置消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播使用 topic 消息代理， 点对点使用 user 代理
        registry.enableSimpleBroker( "/topic");
        //配置订阅前缀
        registry.setApplicationDestinationPrefixes("/app");
    }
}
