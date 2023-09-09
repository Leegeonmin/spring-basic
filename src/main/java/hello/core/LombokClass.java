package hello.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LombokClass {
    private String name;
    private int age;

    public static void main(String[] args) {
        LombokClass lombokClass = new LombokClass();
        lombokClass.setName("test");
        System.out.println(lombokClass.toString());
    }
}
