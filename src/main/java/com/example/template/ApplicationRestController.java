package com.example.template;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationRestController {

    private static final Logger LOGGER = Logger.getLogger(ApplicationRestController.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${welcome-text}")
    private String welcomeText;

    @RequestMapping("/")
    public String index() {
        return welcomeText + "<br/><a href=\"/shutdown\">Shutdown the application</a><br/>";
    }

    @RequestMapping("/shutdown")
    public void shutdown() throws InterruptedException {
        LOGGER.info("Shutting down application");

        SpringApplication.exit(applicationContext);
    }
}
