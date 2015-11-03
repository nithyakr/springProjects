package hMS;


/**
 * Created by nivethika on 03/11/15.
 */
public class Message {


    public Message(){
        System.out.println("Inside Message constructor." );
   }


    public void init(){
        System.out.println("Initalizing Message Class" );

    }
    public void cleanUp(){
        System.out.println("Destroying Message Class" );

    }

    public void getMessage() {
        System.out.println("Inside getMessage Method in Message Class." );
           }



}

