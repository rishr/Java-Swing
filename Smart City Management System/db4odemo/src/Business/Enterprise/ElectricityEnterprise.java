/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author deepa
 */
public class ElectricityEnterprise extends Enterprise{
    
       public ElectricityEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Electricity);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
