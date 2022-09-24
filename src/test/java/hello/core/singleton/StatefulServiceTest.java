package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statfulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int useraPrice = statefulService1.order("userA", 10000);
        //ThreadB: B사용자 10000원 주문
        int userbPrice = statefulService2.order("userB", 20000);

        //ThreadA: A사용자 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + useraPrice);

        Assertions.assertThat(useraPrice).isNotEqualTo(userbPrice);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}