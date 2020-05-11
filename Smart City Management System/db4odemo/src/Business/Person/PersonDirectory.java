/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Address.Address;
import Business.Organization.City.CitizenOrganization;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author Yashaswi Singh
 */
public class PersonDirectory {
        private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
     
   
     public Person createPerson(String fname, String lname,String emailId, String sex,int age, Address address, String phoneNo, int pincode){
        Person p = new Person();
            p.setFirstName(fname);
            p.setFirstName(fname);
            p.setLastName(lname);
            p.setAddress(address);
            p.setAge(age);
            p.setPhone(phoneNo);
            p.setSex(sex);
            personList.add(p);
            return p;
    }
    
    public void removePerson(Person p) {
        personList.remove(p);
    }
    
        public Person createEmployee(String fname, String lname,String emailId, String sex,int age, Address address, String phoneNo, int pincode, Organization o){
           
    if (o instanceof CitizenOrganization)
          {CitizenOrganizationEmployee  citizenOrganizationEmployee = new CitizenOrganizationEmployee();
         
            citizenOrganizationEmployee.setFirstName(fname);
            citizenOrganizationEmployee.setLastName(lname);
            citizenOrganizationEmployee.setEmailID(emailId);
            citizenOrganizationEmployee.setAddress(address);
            citizenOrganizationEmployee.setAge(age);
            citizenOrganizationEmployee.setPhone(phoneNo);
            citizenOrganizationEmployee.setSex(sex);
          personList.add(citizenOrganizationEmployee);
          return citizenOrganizationEmployee;  
    }  
     return null;
    }
}
