package mg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChronicDisease extends JFrame implements ActionListener {

    JComboBox<String> roleBox;
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;

    // ================= MODERN THEME =================
    private void applyModernTheme() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}

        UIManager.put("Button.background", new Color(41,128,185));
        UIManager.put("Button.foreground", Color.WHITE);

        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 14));
        UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 14));
    }

    // Styled Button
    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(41,128,185));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return btn;
    }

    public ChronicDiseas() {

        applyModernTheme();

        setTitle("Chronic Disease Management - Login");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Gradient Background
        JPanel panel = new JPanel(){
            protected void paintComponent(Graphics g){
                Graphics2D g2=(Graphics2D)g;
                GradientPaint gp=new GradientPaint(
                        0,0,new Color(52,152,219),
                        0,getHeight(),new Color(155,89,182));
                g2.setPaint(gp);
                g2.fillRect(0,0,getWidth(),getHeight());
            }
        };

        setContentPane(panel);
        panel.setLayout(null);

        JLabel title=new JLabel("Chronic Disease Management",JLabel.CENTER);
        title.setFont(new Font("Segoe UI",Font.BOLD,20));
        title.setForeground(Color.WHITE);
        title.setBounds(40,20,320,30);
        add(title);

        JLabel roleLbl=new JLabel("Login As:");
        roleLbl.setForeground(Color.WHITE);
        roleLbl.setBounds(70,70,100,25);
        add(roleLbl);

        roleBox=new JComboBox<>(new String[]{"Doctor","Patient"});
        roleBox.setBounds(180,70,140,25);
        add(roleBox);

        JLabel userLbl=new JLabel("User ID:");
        userLbl.setForeground(Color.WHITE);
        userLbl.setBounds(70,110,100,25);
        add(userLbl);

        userField=new JTextField();
        userField.setBounds(180,110,140,25);
        add(userField);

        JLabel passLbl=new JLabel("Password:");
        passLbl.setForeground(Color.WHITE);
        passLbl.setBounds(70,150,100,25);
        add(passLbl);

        passField=new JPasswordField();
        passField.setBounds(180,150,140,25);
        add(passField);

        loginBtn=createStyledButton("Login");
        loginBtn.setBounds(150,200,100,30);
        loginBtn.addActionListener(this);
        add(loginBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String role=roleBox.getSelectedItem().toString();
        String user=userField.getText();
        String pass=new String(passField.getPassword());

        if(role.equals("Doctor") && user.equals("doctor") && pass.equals("doc123")){
            new DoctorDashboard();
            dispose();
        }
        else if(role.equals("Patient") && user.equals("patient") && pass.equals("pat123")){
            new PatientDashboard();
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Invalid credentials!");
        }
    }

    // ================= DOCTOR DASHBOARD =================

    class DoctorDashboard extends JFrame implements ActionListener {

        JButton addBtn,updateBtn,deleteBtn,viewBtn,searchBtn,logoutBtn;

        DoctorDashboard(){

            setTitle("Doctor Dashboard");
            setSize(500,400);
            setLayout(new GridLayout(3,2,20,20));
            setLocationRelativeTo(null);
            getContentPane().setBackground(new Color(236,240,248));

            addBtn=createStyledButton("Add Patient");
            updateBtn=createStyledButton("Update Patient");
            deleteBtn=createStyledButton("Delete Patient");
            viewBtn=createStyledButton("View Patient");
            searchBtn=createStyledButton("Search Patient");
            logoutBtn=createStyledButton("Logout");

            add(addBtn);
            add(updateBtn);
            add(deleteBtn);
            add(viewBtn);
            add(searchBtn);
            add(logoutBtn);

            addBtn.addActionListener(this);
            updateBtn.addActionListener(this);
            deleteBtn.addActionListener(this);
            viewBtn.addActionListener(this);
            searchBtn.addActionListener(this);
            logoutBtn.addActionListener(e->dispose());

            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==addBtn) new AddPatientForm();
            else if(e.getSource()==updateBtn) new UpdatePatientForm();
            else if(e.getSource()==deleteBtn) new DeletePatientForm();
            else if(e.getSource()==viewBtn) viewAllPatients();
            else if(e.getSource()==searchBtn) new SearchPatientForm();
        }

        private void viewAllPatients(){

            try{

                BufferedReader br=new BufferedReader(new FileReader("patients.csv"));

                String[] columns={"Patient ID","Name","Age","Gender","Disease","Stage","BP","HR","Weight","Height","Medication"};

                List<String[]> data=new ArrayList<>();

                String line;

                while((line=br.readLine())!=null){

                    String[] d=line.split(",");

                    if(d.length==11) data.add(d);
                }

                br.close();

                String[][] tableData=new String[data.size()][11];

                for(int i=0;i<data.size();i++)
                    tableData[i]=data.get(i);

                JTable table=new JTable(tableData,columns);

                JScrollPane scrollPane=new JScrollPane(table);

                JFrame tableFrame=new JFrame("All Patients");

                tableFrame.setSize(800,400);

                tableFrame.add(scrollPane);

                tableFrame.setLocationRelativeTo(null);

                tableFrame.setVisible(true);

            }catch(Exception ex){

                JOptionPane.showMessageDialog(null,"Error reading CSV");
            }
        }
    }

    // ================= ADD PATIENT =================

    class AddPatientForm extends JFrame implements ActionListener {

        JTextField idField,nameField,ageField,genderField,diseaseField,stageField;
        JTextField bpField,hrField,weightField,heightField;
        JTextArea medicationArea;
        JButton submitBtn,resetBtn;

        AddPatientForm(){

            setTitle("Add Patient");
            setSize(400,650);
            setLayout(null);
            setLocationRelativeTo(null);
            getContentPane().setBackground(Color.WHITE);

            int y=20;

            idField=addField("Patient ID:",y); y+=40;
            nameField=addField("Patient Name:",y); y+=40;
            ageField=addField("Age:",y); y+=40;
            genderField=addField("Gender:",y); y+=40;
            diseaseField=addField("Disease Name:",y); y+=40;
            stageField=addField("Disease Stage:",y); y+=40;
            bpField=addField("Blood Pressure:",y); y+=40;
            hrField=addField("Heart Rate:",y); y+=40;
            weightField=addField("Weight:",y); y+=40;
            heightField=addField("Height:",y); y+=40;

            JLabel medLbl=new JLabel("Medication:");
            medLbl.setBounds(20,y,150,25);
            add(medLbl);

            medicationArea=new JTextArea();

            JScrollPane sp=new JScrollPane(medicationArea);

            sp.setBounds(180,y,180,60);

            add(sp);

            y+=80;

            submitBtn=createStyledButton("Submit");
            submitBtn.setBounds(80,y,100,30);
            submitBtn.addActionListener(this);
            add(submitBtn);

            resetBtn=createStyledButton("Reset");
            resetBtn.setBounds(200,y,100,30);
            resetBtn.addActionListener(this);
            add(resetBtn);

            setVisible(true);
        }

        private JTextField addField(String label,int y){

            JLabel l=new JLabel(label);
            l.setBounds(20,y,150,25);
            add(l);

            JTextField tf=new JTextField();
            tf.setBounds(180,y,180,25);
            add(tf);

            return tf;
        }

        @Override
        public void actionPerformed(ActionEvent e){

            if(e.getSource()==submitBtn){

                try(FileWriter fw=new FileWriter("patients.csv",true)){

                    fw.write(idField.getText()+","+nameField.getText()+","+ageField.getText()+","+
                            genderField.getText()+","+diseaseField.getText()+","+stageField.getText()+","+
                            bpField.getText()+","+hrField.getText()+","+weightField.getText()+","+
                            heightField.getText()+","+medicationArea.getText().replace(","," ")+"\n");

                    JOptionPane.showMessageDialog(this,"Patient added successfully!");

                    dispose();

                }catch(Exception ex){

                    JOptionPane.showMessageDialog(this,"Error saving data!");
                }
            }

            if(e.getSource()==resetBtn){

                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                genderField.setText("");
                diseaseField.setText("");
                stageField.setText("");
                bpField.setText("");
                hrField.setText("");
                weightField.setText("");
                heightField.setText("");
                medicationArea.setText("");
            }
        }
    }

    // Remaining classes (Update, Delete, Search, Patient Dashboard)
    // remain EXACTLY the same as your original code

    public static void main(String[] args) {
        new ChronicDisease();
    }
}
