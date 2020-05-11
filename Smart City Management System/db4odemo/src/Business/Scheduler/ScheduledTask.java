/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Scheduler;

import Business.EcoSystem;
import Business.Organization.City.MonitoringOrganization;
import Business.UserAccount.UserAccount;
import java.util.Date;
import javax.swing.JPanel;
import userinterface.MonitoringRole.MonitoringWorkAreaJPanel;

/**
 *
 * @author deepa
 */
public class ScheduledTask {
    
     private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private MonitoringOrganization monitoringOrganization;
    Date now; 

    public ScheduledTask(JPanel userProcessContainer, UserAccount account, MonitoringOrganization monitoringOrganization, EcoSystem business) {
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.monitoringOrganization = monitoringOrganization;
        }
         

	public void run() {
	MonitoringWorkAreaJPanel monitoringWorkAreaJPanel=new MonitoringWorkAreaJPanel(userProcessContainer, userAccount, monitoringOrganization, business);
        monitoringWorkAreaJPanel.populateTable();
       
	}
}
