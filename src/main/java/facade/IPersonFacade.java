/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.List;

/**
 *
 * @author HazemSaeid
 */
public interface IPersonFacade {
    
    List<CityInfo> getCities();

    Person getPerson(long id);

    List<Person> getPersons();

    List<Person> getPersonsFromZipcode(int zipCode);

    Person getPersonOnPhone(String number);

    List<Person> getPersonsWithHobby(String name);

    Person addPerson(Person person);
    
    long getNumberOfPersonsWithHobby(String name);

    Person addHobbyToPerson(Hobby hobby, long id);

    Hobby addHobby(Hobby hobby);

    Person addPhoneToPerson(Phone phone, long id);

    Person addAddressToPerson(Address address, long id);

    Person deletePerson(long id);

    Person editPerson(Person person, long id);
}
