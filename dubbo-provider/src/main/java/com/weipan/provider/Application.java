package com.weipan.provider;

import com.weipan.provider.bootstrap.EmbeddedZookeeper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

/**
 * Dubbo Registry ZooKeeper Provider Bootstrap
 *
 * @ClassName Application
 * @Author weipan
 * @Date 2019/7/9 11:54
 * @Version V1.0.0
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
            Environment environment = event.getEnvironment();
            int port = environment.getProperty("embedded.zookeeper.port", int.class);
            new EmbeddedZookeeper(port, false).start();
        }).run(args);
    }
}
