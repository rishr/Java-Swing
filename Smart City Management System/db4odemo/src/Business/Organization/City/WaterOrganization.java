/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.City;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.WaterManagerRole;
import java.util.ArrayList;

/**
 *
 * @author Yashaswi Singh
 */
public class WaterOrganization extends Organization {
    public WaterOrganization() {
        super(Organization.Type.Water.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new WaterManagerRole());
        return roles;
    }
    
}
