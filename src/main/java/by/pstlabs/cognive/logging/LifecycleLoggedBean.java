package by.pstlabs.cognive.logging;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public interface LifecycleLoggedBean {

    String separationLine = "\n=====================================================================================\n";
    String template = separationLine + "%s" + separationLine;

    default void say(String message){
        System.out.println(String.format(template, message));
    }

    default void saySelf(String message){
        say(this.getClass().getName() + " " + message);
    }

    @PostConstruct
    default void postConstruct(){
        saySelf("has been constructed!");
    }

    @PreDestroy
    default void preDestroy(){
        saySelf("is to be destroyed!");
    }

}
