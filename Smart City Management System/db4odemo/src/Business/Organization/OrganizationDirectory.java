/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.City.CitizenOrganization;
import Business.Organization.City.ElectricityOrganization;
import Business.Organization.City.MonitoringOrganization;
import Business.Organization.City.WasteOrganization;
import Business.Organization.City.WaterOrganization;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Waste.getValue())){
            organization = new WasteOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Water.getValue())){
            organization = new WaterOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Electricity.getValue())){
            organization = new ElectricityOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Citizen.getValue())){
            organization = new CitizenOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Monitoring.getValue())){
            organization = new MonitoringOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}