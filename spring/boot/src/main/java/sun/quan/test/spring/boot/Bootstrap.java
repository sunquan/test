package sun.quan.test.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.resource.AppCacheManifestTransformer;

/**
 * Created by sunquan on 2016/10/21.
 */

@Configuration
@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args){
        SpringApplication app = new SpringApplication(Bootstrap.class);
        app.run(args);
    }
}
