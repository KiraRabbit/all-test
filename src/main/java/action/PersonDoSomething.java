package action;

import domain.Person;
import interfaceOfPerson.PersonAction;

public class PersonDoSomething implements PersonAction {


    @Override
    public void getfun() {

        System.out.println("1111");



        }


    @Override
    public int calculate() {
        int x = 5;
        int y =7;
        return x + y;
    }
}
