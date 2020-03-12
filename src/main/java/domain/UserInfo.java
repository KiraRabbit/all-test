package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String name;
    private int age;
    private int id;
    private String classRoom;


    public UserInfo(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public UserInfo(String name, int age, String classRoom) {
        this.name = name;
        this.age = age;
        this.classRoom = classRoom;
    }
}
