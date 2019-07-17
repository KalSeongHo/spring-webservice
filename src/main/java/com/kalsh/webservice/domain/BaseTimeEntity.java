package com.kalsh.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}

/** BaseTimeEntity class 를 모든 Entity 들의 상위 클래스로 지정 **/
/* Entity 들의 createdDate, modifiedDate 를 자동으로 관리하는 역할로 하게함.
 *
 * @MappedSuperclass : JPA Entity 들이 BaseTimeEntity 를 상속할 경우, 위의 필드들을 컬럼으로 인식하게 한다.
 * @EntityListeners(AuditingEntityListener.class) : BaseTimeEntity 클래스에 Auditing 기능 포함 시킴.
 * @CreatedDate : Entity 가 생성되어 저장될 때, 시간이 자동 저장됨.
 * @LastModifiedDate : 조회한 Entity 의 값을 변경할때, 시간이 자동 저장됨.
 */