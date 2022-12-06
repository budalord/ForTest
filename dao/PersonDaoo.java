package dao;

import person.Person;

import java.util.ArrayList;

public class PersonDaoo  implements PersonDao{

    private static ArrayList<Person> list=new ArrayList<>();


    @Override
    public boolean addPerson(Person person) {
        return false;
    }
}
