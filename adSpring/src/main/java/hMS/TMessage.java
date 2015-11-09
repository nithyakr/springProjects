package hMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by nivethika on 03/11/15.
 */
@Component
public class TMessage {

    @Autowired
    private Message mg;

    public TMessage(){
        System.out.println("Inside TMessage constructor." );
        this.mg=mg;

    }

  public void displayMessage(){
      System.out.println(mg.getGreeting());
  }

    @PostConstruct
    public void init(){
        System.out.println("Initalizing TMessage Class");

    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Destroying TMessage Class" );

    }

}
