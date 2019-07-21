package com.kalsh.webservice.web;

import com.kalsh.webservice.domain.posts.PostsRepository;
import com.kalsh.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private PostsService postsService;

//    @GetMapping("/hello")
//    public String hello() {
//        return "HelloWorld";
//    }

//    @PostMapping("/posts")
//    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
//        /*
//         * Bean을 주입받는 방식인 @Autowired 가 없는 것을 확인할 것..
//         * 스프링에선 Bean 주입 방식에 3가지가 있다. (@Autowired, setter, 생성자)
//         * 이중, 가장 권장하는 방식은 생성자로 주입받는 방식이며,
//         * 이 소스내에선, lombok - @AllargsConstructor 이 생성자를 대신 생성해준다.
//         */
//         postsRepository.save(dto.toEntity());
//    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }

}