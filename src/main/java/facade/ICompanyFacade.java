package facade;

import entities.Address;
import entities.Company;
import entities.Phone;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface ICompanyFacade {
    
    List<Company> getCompaniesEmployeesMoreThan(int employeeNumber);

    Company addCompany(Company company);

    Company getCompanyOnCvr(String cvr);

    Company getCompanyOnId(long id);

    Company getCompanyOnPhone(String number);

    List<Company> getCompanies();

    Company addPhoneToCompany(Phone phone, long id);

    Company addAddressToCompany(Address address, long id);

    Company editCompany(Company company, long id);

    Company deleteCompany(long id);

}
