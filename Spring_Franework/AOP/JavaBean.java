public class JavaBean {
    private String id; // private : 접근 제어자
    private Integer count;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public Integer getCount(){
        return count;
    }

    public void setCount(Integer count){
        this.count = count;
    }
}
