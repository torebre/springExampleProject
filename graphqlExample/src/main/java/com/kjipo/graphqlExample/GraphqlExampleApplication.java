package com.kjipo.graphqlExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GraphqlExampleApplication extends SpringBootServletInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphqlExampleApplication.class);


//    @EventListener
//    public void handleContextRefresh(ContextRefreshedEvent event) {
//        ApplicationContext applicationContext = event.getApplicationContext();
//        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
//                .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
//        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
//                .getHandlerMethods();
//        map.forEach((key, value) -> LOGGER.info("Test50: {} {}", key, value));
//    }

    public static void main(String[] args) {
        SpringApplication.run(GraphqlExampleApplication.class, args);
    }

}
