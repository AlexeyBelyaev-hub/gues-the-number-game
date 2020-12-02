package academy.learnprogramming.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class DecoupledLogicSetup {

    // == fields ==
    public final SpringResourceTemplateResolver templateResolver;

    // == constructor ==
    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    // == init ==
    @PostConstruct
    public void init(){
        templateResolver.setUseDecoupledLogic(true);
        log.info("Decouple template logic enabled");
    }

}
