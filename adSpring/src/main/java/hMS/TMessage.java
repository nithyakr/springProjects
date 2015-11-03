package hMS;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by nivethika on 03/11/15.
 */
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

    public void init(){
        System.out.println("Initalizing TMessage Class");

    }
    public void cleanUp(){
        System.out.println("Destroying TMessage Class" );

    }

}
