import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component // Conponent를 붙인 것은 해당 Aspect를 스프링의 Bean으로 등록해서 사용하기 위함
public class UsefulAspect{
    @Pointcut("execution(* transfer(..))")
    private void anyOldTransfer(){} // public 메서드 대상 포인트 컷
    
    @Pointcut("widthin(com.test.myapp.trading..*)")
    private void inTrading(){} // 특정 패키지 대상 포인트 컷

    @Pointcut("anyPublicOperation() && inTrading()*")
    private void tradomgOperation(){} // 위의 두 조건을 and 조건으로 결합한 포인트 컷

}