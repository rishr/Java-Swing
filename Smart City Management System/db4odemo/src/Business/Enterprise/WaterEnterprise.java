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
 * @author Yashaswi Singh
 */
public class WaterEnterprise extends Enterprise{
    public WaterEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Water);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
