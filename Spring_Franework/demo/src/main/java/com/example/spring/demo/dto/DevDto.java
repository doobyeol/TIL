package com.example.spring.demo.dto;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Setter //setter 메소드 자동생성
@Getter // getter 메소드 자동생성
@ToString // 해당 인스턴스의 해시코드가 아닌 하위 오브젝트 값을 프린트 해준다.
@NoArgsConstructor // 아규먼트가 없는 기본 생성자 생성
@AllArgsConstructor // 모든 아규먼트가 있는 생성자 생성
@RequiredArgsConstructor // 필수 데이터 아규먼트가 있는 생성자 생성
@Data // 이거 하나면 위에 어노테이션들은 필요없다. 실무에선 불필요한 경우가 생겨서 잘 쓰지 않음.
@Builder // 자바 디자인 패턴,
        // setter와는 차이가 있다.
        // setter를 여러군데에서 쓰면 코드의 응집력이 떨어지고
        // 이후 처리 중 데이터에 따라 동작이 달라지므로 코드의 퀄리티가 떨어지며
        // 테스트가 어려워지는등. 빌더를 사용하여 한번에 셋팅하는 것이 좋음.
@Slf4j // 로그를 편리하게 작성
public class DevDto {
    @NonNull
    String name;
    @NonNull
    Integer age;
    Integer experienceYears;
    LocalDateTime startAt;

    public void printLog(){
        log.info(getName());
    }
}
