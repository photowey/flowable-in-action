package com.phtowey.flowable.modeler;

import com.phtowey.flowable.modeler.annotation.EnableFlowableModeler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableFlowableModeler
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String port = environment.getProperty("server.port");
        String host = InetAddress.getLocalHost().getHostAddress();
        log.info("\n----------------------------------------------------------\n\t" +
                        "Bootstrap: '{}' is Success!\n\t" +
                        "Application: '{}' is running! Access URLs:\n\t" +
                        "Index: \t\t{}://{}:{}{}\n\t" +
                        "Profile(s): dev\n----------------------------------------------------------\n",
                // Bootstrap
                "Modeler" + " Context",
                // Application
                "Modeler Service",
                // Index
                "http", host, port, "/index.html"
        );
    }
}
