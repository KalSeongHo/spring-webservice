package com.kalsh.webservice.domain.posts;

import com.kalsh.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
/* NoArgsConstructor
 * 기본 생성자 자동 추가
 * access = AccessLevel.PROTECTED : 기본 생성자의 접근권한을 protected 로 제한. => protected Posts() {} 와 같음.
 * protected 로 제한하면, 프로젝트 코드 상에서 기본생성자로 생성되는것은 되지않으나,
 * JPA 에서 Entity 클래스를 생성하는것은 허용됨
 */

@Getter // 클래스내 모든 필드의 Getter 메소드 자동 생성
@Entity // 테이블과 링크될 클래스임을 나타냄.

public class Posts extends BaseTimeEntity {
    /* 실제 DB의 테이블과 매칭될 클래스 = Entity 클래스
     * JPA 를 사용하면, DB데이터에 어떤 작업을 할 경우,
     * 실제 쿼리를 날리기보다는 이 Entity 클래스의 수정을 통해 작업함.
     */

    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue // PK의 생성규칙. 기본값은 auto. (mysql의 auto_increment 와 같이 자동증가하는 정수형 값)
    private Long id;

    /* Column
     * 테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도, 해당 클래스의 필드는 모두 컬럼이 됨.
     * 기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용.
     * 예로, 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(밑의 title)
     *       타입을 TEXT 로 변경하고 싶거나(밑의 content) 등의 경우에 사용됨.
     */

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column()
    private String author;

    @Builder
    /** 해당 클래스의 빌더패턴 클래스 생성
     ** 상단에 생성자 선언시, 생성자에 포함된 필드만 빌더에 포함됨.
     **/

    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
