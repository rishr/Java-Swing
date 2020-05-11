/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.CitizenEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.City.CitizenOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author deepa
 */
public class ManageRequestDataJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageRequestDataJPanel
     */
    
    private JPanel userProcessContainer;
    private EcoSystem system;
    private static int electricityRequestCount=0;
    private static int waterRequestCount=0;
    private static int wasteRequestCount=0;
    public ManageRequestDataJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
    }
    
     public void populateTable() {
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if(enterprise instanceof CitizenEnterprise){
                    for(Organization o:enterprise.getOrganizationDirectory().getOrganizationList()){
                        if(o instanceof CitizenOrganization){
                        for(UserAccount ua:o.getUserAccountDirectory().getUserAccountList()){
                            for(WorkRequest wr:ua.getWorkQueue().getWorkRequestList()){
                                if(wr.getRequestType().equals(WorkRequest.WorkRequestType.ElectricityWorkRequest.getValue())){
                                    electricityRequestCount++;
                                } else if(wr.getRequestType().equals(WorkRequest.WorkRequestType.WaterSupplyWorkRequest.getValue())){
                                    waterRequestCount++;
                                } else if (wr.getRequestType().equals(WorkRequest.WorkRequestType.WasteWorkRequest.getValue())) {
                                    wasteRequestCount++;
                                }
                            }
                        }
                    }
                    }
                }
                
            }
        }
        
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue("Electricity Requests", electricityRequestCount);
      dataset.setValue("Water Requests", waterRequestCount );
      dataset.setValue("Waste Requests", wasteRequestCount );

      JFreeChart chart = ChartFactory.createPieChart(
         "Analyze Requests by Enterprise Type",   // chart title
         dataset,          // data
         true,             // include legend
         true,
         false);
         
      int width = 640;   /* Width of the image */
      int height = 480;  /* Height of the image */ 
      File pieChart = new File( "PieChart.jpeg" ); 
        try {
            ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
        } catch (IOException ex) {
            Logger.getLogger(ManageRequestDataJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        PiePlot pa = (PiePlot) chart.getPlot();
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        pa.setLabelGenerator(gen);

        ChartPanel CP = new ChartPanel(chart);
        ManageRequestDataJPanel manageRequestDataJPanel1=new ManageRequestDataJPanel(userProcessContainer, system);
        manageRequestDataJPanel1.add(CP);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(110, 89, 222));

        backJButton.setBackground(new java.awt.Color(51, 51, 51));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(971, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(615, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    // End of variables declaration//GEN-END:variables
}