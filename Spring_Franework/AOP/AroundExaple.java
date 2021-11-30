import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class AroundExaple {
    @AfterReturning("com.test.myapp.CommonPointcuts.businessService()") 
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop 
        return retVal;
    }
}
