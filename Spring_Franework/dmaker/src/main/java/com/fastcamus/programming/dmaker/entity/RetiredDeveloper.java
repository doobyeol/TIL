package com.fastcamus.programming.dmaker.entity;

import com.fastcamus.programming.dmaker.type.DeveloperLevel;
import com.fastcamus.programming.dmaker.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor // Builder와 함께 사용 권장
@AllArgsConstructor // Builder와 함께 사용 권장
@Entity
@EntityListeners(AuditingEntityListener.class)
public class RetiredDeveloper {

    // Entity 규약
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String memberId;
    private String name;

    @CreatedDate // Spirng JPA 내부 기능 중 자동으로 셋팅해주는 기능 ODT
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;
}
