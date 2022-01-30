package hello.core;

import hello.core.order.OrderService;
import member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

	MemberService memberService;
	OrderService orderService;

	@BeforeEach
	public void beforeEach(){
		AppConfig appConfig = new AppConfig();
		memberService =  appConfig.memberService();
		orderService = appConfig.orderService();
	}

	@Test
	void contextLoads() {
	}

}
