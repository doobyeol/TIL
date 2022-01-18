import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeExaple {
    @Before("com.test.myapp.CommonPointcuts.dataAccessOperation()")
    public void doAccessCheck(){
        // ...
    }
}
