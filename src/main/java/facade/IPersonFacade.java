/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Company;
import entities.Person;
import java.util.List;

/**
 *
 * @author HazemSaeid
 */
public interface IPersonFacade {
    Person getPerson(long id);
    List<Person> getPersons();
    List<Person> getPersonsFromZipcode(int zipCode);
    Company getCompany(String cvr);
}
