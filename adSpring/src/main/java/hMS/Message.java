package hMS;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by nivethika on 03/11/15.
 */
@Component
public class Message {

    private String greeting;


    public Message(){
   }

    public void init(){
        System.out.println("Initalizing Message Class" );

    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Destroying Message Class" );

    }

    public void getMessage() {
        System.out.println("Inside getMessage Method in Message Class." );
           }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}

