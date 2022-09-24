package hello.core.web;

import hello.core.common.MyLogger;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;  //요청이 안와서 request bean이 생성이 안되었는데 생성자 주입하려하면 오류발생 이떄 Provider사용해야함
//    private final ObjectProvider<MyLogger> myLoggersProvider;

    @RequestMapping("log-demo") // localhost:8080/log-demo
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requstURL = request.getRequestURI().toString();
//      MyLogger myLogger = myLoggersProvider.getObject(); // http request가 온 뒤 request scope를 DL함 이때는 오류 발생하지 않음
        myLogger.setRequestURL(requstURL);

        myLogger.log("Controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}
