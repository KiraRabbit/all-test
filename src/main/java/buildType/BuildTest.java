package buildType;

import common.Builder;
import domain.Person;

public class BuildTest {
    public static void main(String[] args) {
        Person build = Builder.of(Person::new)
                .with(Person::setAge, 10)
                .with(Person::setName, "oo")
                .with(Person::setSex, "nv")
                .build();
        System.out.println(build);
    }
}
