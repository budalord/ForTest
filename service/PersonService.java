package service;
import dao.PersonDaoo;
import person.Person;

public class PersonService {
    private PersonDaoo personDaoo=new PersonDaoo();

    public boolean isExists(String id) {
        return false;
    }
}
