package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//      basePackages = "hello.core.member", // 이 경로 아래의 파일에서만 컴포넌트 스캔을 수행한다.
//      basePackageClasses = AutoAppConfig.class, // 해당 클레스가 컴포넌트스캔의 시작위치가 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // @Configuration 어노테이션이 붙은 클래스는 빈으로 등록하지 않는다.
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository") // 수동으로 등록한 빈과 자동으로 등록한 빈의 이름이 같다면
//    MemberRepository memberRepository() { // 수동으로 등록한빈이 자동으로 등록한빈을 오버라이딩한다. (but 현재 스프링부트는 이러면 오류가 발생하게 바뀜)
//        return new MemoryMemberRepository();
//    }

}
