import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AffterReturningExample {
    @AfterReturning("com.test.myapp.CommonPointcuts.dataAccessOperation()") 
    public void doAccessCheck(){
        // ...
    }
}
