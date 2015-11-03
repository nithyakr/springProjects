package hMS;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


/**
 * Created by nivethika on 03/11/15.
 */


@Configuration
public class Config {


    @Bean(initMethod = "init", destroyMethod = "cleanUp" )
    public Message message(){
        Message message = new Message();
        //message.setmes(env.getProperty("testbean.name"));
        return message;
    }

    @Bean(initMethod = "init", destroyMethod = "cleanUp" )
    public TMessage tMessage(){
        return new TMessage(message());
    }




}
