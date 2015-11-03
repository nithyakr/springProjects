package hMS;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by nivethika on 03/11/15.
 */
public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        TMessage te = ctx.getBean(TMessage.class);

        te.displayMessage();
        ctx.registerShutdownHook();

    }



}
