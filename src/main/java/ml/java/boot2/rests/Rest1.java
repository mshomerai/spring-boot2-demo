package ml.java.boot2.rests;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest1 {

    @RequestMapping("/helloWorld")
    String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    String hello(){
        return "Hello!";
    }

}
