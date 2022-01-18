
public class MemberCreationRequest {
    @Size(max=64, message="이름의 최대 길이는 64자 입니다.")
    private String name;
    @Min(0, "나이는 0보다 커야 합니다.")
    private int age;
    @Email("이메일 형식이 잘못되었습니다.")
    private int email;

    // the usual getters and setters...
}
