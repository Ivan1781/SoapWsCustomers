package main.org.application;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ServiceCustomer {

    @WebMethod
    public String addCustomer(int id, String surname, String first_name);

    @WebMethod
    public String getSurname(int id);

    @WebMethod
    public String findCustomer(String nameOfPass);

}
