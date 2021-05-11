package Week11.src;

import java.io.Serializable;

//객체직렬화
public class Person implements Serializable {
    private String name;
    private int age;
    private String ssn;

    public Person(String name, int age, String tell) {
        this.name = name;
        this.age = age;
        this.ssn = tell;
    }

    @Override
    public String toString() {
        return name + ":" + age + ":" + ssn;
    }
}
