/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utility;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author deepa
 */
public class Validation {
    
      public static boolean validateTableSelection(JTable table, int noOfRows)
    {
        if(table.getSelectedRowCount()==noOfRows)
        return true;
        else return false;
    }
    
    public static Timestamp getTimeStamp()
    {
         Date date = new Date();
    Timestamp timeStamp = new Timestamp(date.getTime());

        
        return timeStamp;
    }
        
    public static boolean validateTextAreaForNonEmpty(JTextArea txtArea )
    {
        if(txtArea.getText().trim().equalsIgnoreCase(""))
        {
            return false;
        }
        else return true;
    }
    
    public static boolean validateTextFieldsForNonEmpty(JTextField textField)
    {
        if(textField.getText().trim().equalsIgnoreCase(""))
        {
            return false;
        }
        else return true;
    }
    
    public static boolean validateTextFieldsForString(JTextField textField)
    {
        return true;
    }
   
    public static boolean validateTextFieldsForInteger(JTextField textField)
    {
        try
        {
            int a=Integer.parseInt(textField.getText().trim());
            if(a<0)
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
        
    public static boolean validateTextFieldsForNumber(JTextField textField)
    {
        return true;
    }
    
    public static boolean validateTextFieldsForPhoneNumber(JTextField textField)
    {
        Pattern patternMobileNumber = Pattern.compile("\\d{10}");
        Matcher matcher = patternMobileNumber.matcher(textField.getText().trim());
        return matcher.matches();
    }
    
    public static boolean validateTextFieldsForEmailId(JTextField textField)
    {
        try
        {
        String patternEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Boolean flag = textField.getText().trim().matches(patternEmail);
        return flag;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public static boolean validateTextFieldsForUserName(JTextField txtUserName)
    {
        return true;
    }
            
    public static boolean validateComboBoxForSelection(JComboBox comboBox)
    {
        if(comboBox.getSelectedIndex()!=-1)
        return true;
        else 
        return false;
        
    }
    
    public static boolean validateTextFieldForPassword(JTextField txtPassowrd)
    {
       return true;
    }
    
     public static boolean checkUniquenessOfUserName(String userName, EcoSystem system) {
        boolean flag = false;
        
        for(UserAccount ua:system.getUserAccountDirectory().getUserAccountList()){
        
        if (ua.getUsername().equals(userName)) {
                        flag = true;
                        break;
                    }        
        }              
        for (Network n : system.getNetworkList()) {
 
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount ue : e.getUserAccountDirectory().getUserAccountList()) {
                    if (ue.getUsername().equals(userName)) {
                        flag = true;
                        break;
                    }
                }
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount u : o.getUserAccountDirectory().getUserAccountList()) {
                        if (u.getUsername().equals(userName)) {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }
     
     public static boolean checkUniquenessOfPhoneNumber(String phone, EcoSystem system) {
        
        boolean flag = false;
        
        for(UserAccount ua:system.getUserAccountDirectory().getUserAccountList()){
        if(ua.getEmployee().getPhone()!=null){
        if (ua.getEmployee().getPhone().equals(phone)) {
                        flag = true;
                        break;
                    }
        }
        }
        for (Network n : system.getNetworkList()) {
 
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount ue : e.getUserAccountDirectory().getUserAccountList()) {
                    if(ue.getEmployee().getPhone()!=null){
                    if (ue.getEmployee().getPhone().equals(phone)) {
                        flag = true;
                        break;
                    }
                    }
                }
                 
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount u : o.getUserAccountDirectory().getUserAccountList()) {
                        if(u.getEmployee().getPhone()!=null){
                        if (u.getEmployee().getPhone().equals(phone)) {
                            flag = true;
                        }
                        }
                    }
                }
            }
        }
        return flag;
    }
}
