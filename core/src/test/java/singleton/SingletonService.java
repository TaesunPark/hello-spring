package singleton;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자로 막아야함!! 객체 생성을 못하게 막아야함!!
    private SingletonService(){

    }
    public void logic(){
        System.out.printf("싱글톤 객체 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = getInstance();
        SingletonService singletonService2 = getInstance();
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }
}
