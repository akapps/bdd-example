package ch.antaes.kapps.demo.bdd.test.context;

import ch.antaes.kapps.demo.bdd.test.impl.BusinessAccountManipulation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Antoine Kapps
 */
@Configuration
public class BusinessTestContext {

    @Bean
    public BusinessAccountManipulation accountManipulation() {
        return new BusinessAccountManipulation();
    }

}
