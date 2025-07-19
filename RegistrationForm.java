
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;


public class RegistrationForm extends JPanel{
    private JPanel formPanel = regForm();
    private JPanel btnPanel = buttonPanel();
    private JLabel IC;
    private JTextField tfIC;
    private JLabel name;
    private JTextField tfName;
    private JLabel studID;
    private JTextField tfStudID;
    private JLabel phoneNum;
    private JTextField tfPhoneNum;
    private JLabel birthDate;
    private JTextField tfBirthDate;
    private JLabel bloodType;
    private JComboBox<String> tfBloodType;
    private JLabel allergies;
    private JTextField tfAllergies;
    private JLabel exitingMedicalCond;
    private JTextField tfExitingMedicalCond;
    private JLabel address1;
    private JTextField tfAddress1;
    private JLabel address2;
    private JComboBox<String> tfAddress2;
    private JLabel address3;
    private JComboBox<String> tfAddress3;
    private JLabel address4;
    private JTextField tfAddress4;
    private JLabel appointmentDate;
    private JTextField tfAppDate;
    private JLabel gender;
    private JRadioButton maleBtn;
    private JRadioButton femaleBtn;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnBack;
    private JFrame frame;
    private JPanel previousPage;
    public RegistrationForm(JFrame frame,JPanel previousPage){
        this.frame = frame;
        this.previousPage = previousPage;
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(15, 15, 15, 15);

        gbc.weightx = 1;
        gbc.weighty = 1;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        gbc.weighty = 0.05;
        JLabel title =new JLabel("TARUMT CLINIC");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.weighty = 0.8;
        add(queueManagement(), gbc);

        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.weighty = 0.75;
         add(formPanel, gbc);
         
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weighty = 0.05;
        add(patientEntryPanel(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        add(btnPanel, gbc);
      
    }
    
    private JPanel patientEntryPanel(){
        JPanel panel = new JPanel(new GridLayout(2,1,0,10));
        JButton walkIn = buttonFormat("Walk-in");
        JButton appointment = buttonFormat("Appointment");
   
        panel.add(walkIn);
        panel.add(appointment);
        add(panel);
        return panel;
    }
    
    private JPanel queueManagement(){
        JPanel panel = new JPanel(new GridLayout(2,1,0,100));
        JLabel queue = labelFormat("AA");
        queue.setOpaque(true);
        queue.setBackground(Color.WHITE);
        queue.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        queue.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel panel2 = new JPanel(new GridLayout(5,1,0,10));
        JLabel label1=new JLabel();
        JLabel label2=new JLabel();
        JButton detail = buttonFormat("More detail");
        
        panel2.add(label1);
        panel2.add(label2);
        panel2.add(detail);
        panel.add(queue);
        panel.add(panel2);
        add(panel);
        return panel;
    }
   
    
    private JPanel regForm(){
       JPanel form = new JPanel(new GridLayout(7, 4,0,10));
       form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       IC = labelFormat("IC Number : ");
       tfIC=textFieldFormat(false);
       
       name = labelFormat("Name : ");
       tfName=textFieldFormat(false);
       
       studID = labelFormat("Student ID : ");
       tfStudID=textFieldFormat(false);
       
       gender = labelFormat("Gender : ");
       maleBtn = new JRadioButton("Male");
       femaleBtn = new JRadioButton("Female");
       JPanel genderPanel = new JPanel(new GridLayout(1, 2));
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        maleBtn.setSelected(true); 
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);
        maleBtn.setEnabled(false);
        femaleBtn.setEnabled(false);
        
       phoneNum = labelFormat("Phone Number : ");
       tfPhoneNum=textFieldFormat(false);
       
       birthDate = labelFormat("Date of Birth : ");
       tfBirthDate=textFieldFormat(false);
       
       bloodType = labelFormat("Blood Type : ");
       String[] bloodTypeOptions = {"A", "B", "AB", "O", "A-", "B-", "AB-", "O-"};
       tfBloodType = new JComboBox<>(bloodTypeOptions);
       
       allergies = labelFormat("Allergies : ");
       tfAllergies=textFieldFormat(false);
       
       exitingMedicalCond = labelFormat("Existing Medical Conditions : ");
       exitingMedicalCond.setFont(new Font("Serif", Font.PLAIN, 24));
       tfExitingMedicalCond=textFieldFormat(false);
       
       address1 = labelFormat("Street Address : ");
       tfAddress1=textFieldFormat(false);
       
       address2 = labelFormat("Country : ");
       String[] address2Options = {"A", "B", "AB", "O", "A-", "B-", "AB-", "O-"};
       tfAddress2 = new JComboBox<>(address2Options);
       
       address3 = labelFormat("State : ");
       String[] address3Options = {"Johor", "Kedah", "Kelantan", "Malacca", "Negeri Sembilan", "Pahang", "Penang", "Perak", "Perlis", "Sabah", "Sarawak", "Selangor", "Terengganu"};
       tfAddress3 = new JComboBox<>(address2Options);
       
       address4 = labelFormat("Postcode : ");
       tfAddress4 =textFieldFormat(false);
       
       
       appointmentDate = labelFormat("Appointment Date : ");
       tfAppDate=textFieldFormat(false);
       
       
       form.add(IC);
       form.add(tfIC);
       form.add(name);
       form.add(tfName);
       form.add(studID);
       form.add(tfStudID);
       form.add(gender);
       form.add(genderPanel);
       form.add(phoneNum);
       form.add(tfPhoneNum);
       form.add(birthDate);
       form.add(tfBirthDate);
       form.add(bloodType);
       form.add(tfBloodType);
       form.add(allergies);
       form.add(tfAllergies);
       form.add(exitingMedicalCond);
       form.add(tfExitingMedicalCond);
       form.add(address1);
       form.add(tfAddress1);
       form.add(address2);
       form.add(tfAddress2);
       form.add(address3);
       form.add(tfAddress3);
       form.add(address4);
       form.add(tfAddress4);
       form.add(appointmentDate);
       form.add(tfAppDate);
       
       return form;
    }
    
    private JPanel buttonPanel(){
        JPanel btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); 
         btnUpdate = buttonFormat("Edit");
         btnDelete = buttonFormat("Delete");
         btnBack = buttonFormat("Back");
        
        btn.add(btnUpdate);
        btn.add(btnDelete);
        btn.add(btnBack);
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
                if(btnUpdate.getText().equals("Edit")){
                    tfIC.setEditable(true);
                    tfName.setEditable(true);
                    tfStudID.setEditable(true);
                    tfPhoneNum.setEditable(true);
                    tfBirthDate.setEditable(true);
                    tfBloodType.setEnabled(true);
                    tfAllergies.setEditable(true);
                    tfExitingMedicalCond.setEditable(true);
                    tfAddress1.setEditable(true);
                    tfAddress2.setEnabled(true);
                    tfAddress3.setEnabled(true);
                    tfAddress4.setEnabled(true);
                    tfAppDate.setEditable(true);
                    maleBtn.setEnabled(true);
                    femaleBtn.setEnabled(true);
                    btnUpdate.setText("Save");
                }else{
                    tfIC.setEditable(false);
                    tfName.setEditable(false);
                    tfStudID.setEditable(false);
                    tfPhoneNum.setEditable(false);
                    tfBirthDate.setEditable(false);
                    tfBloodType.setEditable(false);
                    tfAllergies.setEditable(false);
                    tfExitingMedicalCond.setEditable(false);
                    tfAddress1.setEditable(false);
                    tfAddress2.setEditable(false);
                    tfAddress3.setEditable(false);
                    tfAddress4.setEditable(false);
                    tfAppDate.setEditable(false);
                    maleBtn.setEnabled(false);
                    femaleBtn.setEnabled(false);
                    btnUpdate.setText("Edit");
                }
            }
        });
        
          btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
          });
          
            btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(previousPage);
                frame.revalidate();
                frame.repaint();
         }
          });
                
                
                return btn;
    }
    
    private JLabel labelFormat(String text) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("Serif", Font.PLAIN, 30));
    label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); 
    return label;
}
    
    private JTextField textFieldFormat(boolean editable) {
    JTextField tf = new JTextField(20);
    tf.setFont(new Font("Serif", Font.PLAIN, 18));
    tf.setBorder(BorderFactory.createCompoundBorder(
        tf.getBorder(),                          
        BorderFactory.createEmptyBorder(5, 10, 5, 10) 
    ));
    tf.setEditable(editable);                       
    return tf;
}
    
    private JButton buttonFormat(String text) {
    JButton button = new JButton(text);
    button.setPreferredSize(new Dimension(200, 50));
    button.setFont(new Font("Serif", Font.BOLD, 16));
    button.setFocusPainted(false); 
    return button;
}
    
    public static void main(String[] args){
        JFrame frame=new JFrame();
        JPanel previousPage = new JPanel();
        JPanel regForm = new RegistrationForm(frame,previousPage);
        frame.add(regForm);
        frame.setVisible(true);
    }
}
