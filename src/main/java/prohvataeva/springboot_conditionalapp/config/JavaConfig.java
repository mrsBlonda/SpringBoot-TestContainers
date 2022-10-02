package prohvataeva.springboot_conditionalapp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prohvataeva.springboot_conditionalapp.module.DevProfile;
import prohvataeva.springboot_conditionalapp.module.ProductionProfile;
import prohvataeva.springboot_conditionalapp.module.SystemProfile;

@Configuration
public class JavaConfig {
    
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false")
    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true")
    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

}
