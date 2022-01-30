package beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest
{
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionsNames = ac.getBeanDefinitionNames();
        // iter 탭
        for (String beanDefinitionsName : beanDefinitionsNames) {
            Object bean = ac.getBean(beanDefinitionsName); // 타입을 지정 안해서 Object가 꺼내짐
            System.out.println("beanDefinitionsName = " + beanDefinitionsName + "object = "+ bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionsNames = ac.getBeanDefinitionNames();
        // iter 탭
        for (String beanDefinitionsName : beanDefinitionsNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionsName);

            // Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRA_STRUCTURE : SPRING 
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionsName);
                System.out.println("beanDefinitionsName = " + beanDefinitionsName + "object = "+ bean);
            }
        }
    }
}
