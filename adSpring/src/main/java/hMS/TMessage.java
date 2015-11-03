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
    private Message mg;

    @Autowired
    public TMessage(Message mg){
        System.out.println("Inside TMessage constructor." );
        this.mg=mg;

    }

  public void displayMessage(){
      mg.getMessage();
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
