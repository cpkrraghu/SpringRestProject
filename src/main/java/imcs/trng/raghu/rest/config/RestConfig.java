package imcs.trng.raghu.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import imcs.trng.raghu.dao.config.DbConfig;

@Configuration
@ComponentScan(basePackages="imcs.trng.raghu.rest")
@Import(DbConfig.class)
public class RestConfig {

}
