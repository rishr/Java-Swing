/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization.City;

import Business.Organization.Organization;
import Business.Role.MonitoringRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rishabh
 */
public class MonitoringOrganization extends Organization{
       public MonitoringOrganization() {
        super(Organization.Type.Monitoring.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new MonitoringRole());
        return roles;
    }
}
