package connect_db.controller;

import com.google.gson.Gson;
import connect_db.dao.PersonDAO;
import connect_db.model.Person;

import java.util.List;

public class PersonController {
    PersonDAO personDAO = new PersonDAO();
    List<Person> list;
    Person person;

    public boolean createNewPerson(Person person) {
        return personDAO.insertNewPerson(person);
    }

    public List<Person> listAllPerson() {
        return list = personDAO.getAllPersons();
    }

    public Person findPersonById(int id) {
        return person = personDAO.getPersonById(id);

    }

    public List<Person> findPersonByName(String name) {
        return list = personDAO.getPersonByName(name);

    }

    public boolean updatePersonById(int id, String lastName, String firstName, int age) {
        Person person = personDAO.getPersonById(id);
        if (person == null) {
            return false;
        } else {
            personDAO.updateNewPerson(new Person(id, lastName, firstName, age));
            return true;
        }
    }

    public boolean deletePerson(int id) {
        return personDAO.deletePersonById(id);
    }

    public String getJsonFormat() {
        Gson gson = new Gson();
        List<Person> personList = personDAO.getAllPersons();;
        String jsonFormat = gson.toJson(personList);
        return jsonFormat;
    }

}
