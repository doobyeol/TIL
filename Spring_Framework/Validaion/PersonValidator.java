public class PersonValidator implements Validator{
    /*
    * This Validator validates only Person instances
    */

    public boolean supports(Class clazz){
        return Person.class.equals(clazz);
    }

    public void validate(Object obj, Errors e){
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Person p = (Person) obj;
        if(p.getAge() < 0){
            e.rejectValue("age", "negativevalue");
        }else if(p.getAge() > 110){
            e.rejectiveValue("age", "too.darn.old");
        }
    }
}