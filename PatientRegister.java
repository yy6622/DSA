/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

        

public class PatientRegister extends JPanel{
   
    public PatientRegister(JFrame frame){
    JMenuBar menuBar=new JMenuBar();
        JMenu menu1=new JMenu("Patient");
        JMenuItem item1= new JMenuItem("Patient Registration");
        item1.addActionListener(e -> {
            frame.getContentPane().removeAll();
            JPanel panel =new PatientRegister(frame);
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        });
        JMenuItem item2=new JMenuItem("Record Maintainance");
        item2.addActionListener(e -> {
            frame.getContentPane().removeAll();
            JPanel panel =new RecordMaintenance(frame);
            frame.add(panel);
            frame.revalidate();
            frame.repaint();
        });
        JMenuItem item3=new JMenuItem("Queue Management");
        JMenuItem item4=new JMenuItem("Report");
        JMenu menu2=new JMenu("Doctor");
        JMenu menu3=new JMenu("Consultation");
        JMenu menu4=new JMenu("Medical Treatment");
        JMenu menu5=new JMenu("Pharmacy");
        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        menu1.addSeparator();
        menu1.add(item4);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        frame.setJMenuBar(menuBar);
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel(new GridLayout(3, 1,0, 20));
        JLabel patientIC = new JLabel("Patient IC : ");
        patientIC.setFont(new Font("Serif", Font.PLAIN, 40));
        JTextField tfIC = new JTextField(20);
        tfIC.setFont(new Font("Serif", Font.PLAIN, 40));
        JButton submit =new JButton("Submit");
        submit.setFont(new Font("Serif", Font.PLAIN, 40));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ic = tfIC.getText();
                if (ic.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "IC cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    tfIC.setText("");
                    return;
                }else if (!ic.matches("\\d{12}")) {
                    JOptionPane.showMessageDialog(null, "IC must be exactly 12 digits (numbers only).", "Format Error", JOptionPane.ERROR_MESSAGE);
                    tfIC.setText("");
                    return;
                }else{
                if(ic.equals("123456789012")){
                    int result = JOptionPane.showConfirmDialog(null, "The patient name is : " + ic,"Confirmation",JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        frame.getContentPane().removeAll();
                        JPanel regPage = new RegistrationForm(frame,PatientRegister.this); 
                        frame.add(regPage);
                        frame.revalidate();
                        frame.repaint();
                    } else if (result == JOptionPane.NO_OPTION) {
                        System.out.println("User clicked NO");
                    }
                }else{
                   int result = JOptionPane.showConfirmDialog(null, "No such patient.\n Do you want do add this patient?","Add Patient",JOptionPane.YES_NO_OPTION);
                   if (result == JOptionPane.YES_OPTION) {
                        System.out.println("User clicked YES");
                    } else if (result == JOptionPane.NO_OPTION) {
                        System.out.println("User clicked NO");
                    }
                }
                } 
            }
        });
        
        panel.add(patientIC);
        panel.add(tfIC);
        panel.add(submit);
        
        add(panel);
    //setVisible(true);
    }
    
 
    public static void main(String[] args){
        JFrame frame=new JFrame();
        frame.setTitle("TARUMT Clinic");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel patientReg = new PatientRegister(frame);
        frame.add(patientReg);
        frame.setVisible(true);
    }
}
