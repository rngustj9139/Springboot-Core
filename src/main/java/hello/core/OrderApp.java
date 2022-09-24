package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
    //    MemberService memberService = new MemberServiceImpl(); (version 1)
    //    OrderService orderService = new OrderServiceImpl(); (version 1)

    //    AppConfig appConfig = new AppConfig(); (version 2)
    //    MemberService memberService = appConfig.memberService(); (version 2)
    //    OrderService orderService = appConfig.orderService(); (version 2)

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "Koo", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }

}
