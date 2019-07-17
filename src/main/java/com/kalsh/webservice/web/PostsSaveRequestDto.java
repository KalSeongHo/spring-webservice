package com.kalsh.webservice.web;

import com.kalsh.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
/* Controller 에서 @RequestBody 로 외부에서 데이터를 받는 경우에
 * 기본생성자 + set 메소드를 통해서만 값이 할당됨.
 */

@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
