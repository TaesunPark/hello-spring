package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
      excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 자동으로 Bean 등록 Filter한 이유는 지금까지 만든 Configuration한 AppConfig와 겹쳐서 이것 저것 bean으로 등록함 ..
  // 보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지는 않지만, 기존 예제 코드를 최대한 남기기 위해 이렇게 선택함.
  // 컴포넌트 스캔은 이름 그대로 @Componet 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.
public class AutoAppConfig {
}
