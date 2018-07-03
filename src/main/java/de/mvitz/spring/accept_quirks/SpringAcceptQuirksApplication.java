package de.mvitz.spring.accept_quirks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@SpringBootApplication
@Controller
public class SpringAcceptQuirksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAcceptQuirksApplication.class, args);
    }

    @GetMapping(produces = TEXT_HTML_VALUE)
    @ResponseBody
    public String index() {
        System.out.println("SpringAcceptQuirksApplication.index");
        throw new IllegalStateException("Some exception from controller");
    }
}
