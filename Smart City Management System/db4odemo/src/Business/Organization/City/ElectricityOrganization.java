/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.City;

import Business.Organization.Organization;
import Business.Role.ElectricityAdminRole;
import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author deepa
 */
public class ElectricityOrganization extends Organization{
    
      public ElectricityOrganization() {
        super(Organization.Type.Electricity.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new ElectricityAdminRole());
        return roles;
    }

}
