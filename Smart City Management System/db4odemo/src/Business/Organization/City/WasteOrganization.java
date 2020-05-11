/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization.City;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.WasteManagerRole;
import java.util.ArrayList;

/**
 *
 * @author rishabh
 */
public class WasteOrganization extends Organization{
    
    public WasteOrganization() {
        super(Organization.Type.Waste.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new WasteManagerRole());
        return roles;
    }
    
}
