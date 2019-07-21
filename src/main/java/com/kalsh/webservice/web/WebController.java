package com.kalsh.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    // @GetMapping = @RequestMapping(value="/", method = RequestMethod.GET) 과 동일함.
    // "handlebars" 사용으로 컨트롤러에서 문자열 반환시,
    // 앞의 path 와 뒤의 확장자는 자동으로 지정됨.
    // ( prefix : src/main/resources/templates, suffix: .hbs )
    @GetMapping("/")
    public String main() {
        return "main";
    }
}
