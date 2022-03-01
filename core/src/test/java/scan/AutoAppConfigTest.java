package scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
    @Test
    public void contextLoads() throws Exception{
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        if (ac != null) {
            String[] beans = ac.getBeanDefinitionNames();

            for (String bean : beans) {
                System.out.println(bean);
            }
        }
    }
}
