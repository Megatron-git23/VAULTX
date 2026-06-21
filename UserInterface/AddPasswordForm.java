package UserInterface;

import javax.swing.*;
import java.sql.*;

public class AddPasswordForm extends JFrame {

    JTextField website, username;
    JPasswordField password;

    int userId;

    public AddPasswordForm(int userId) {

        this.userId = userId;

        setTitle("Add Password");
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("Website");
        l1.setBounds(50, 10, 200, 25);
        add(l1);

        website = new JTextField();
        website.setBounds(50, 30, 200, 25);
        add(website);

        JLabel l2 = new JLabel("Username");
        l2.setBounds(50, 60, 200, 25);
        add(l2);

        username = new JTextField();
        username.setBounds(50, 80, 200, 25);
        add(username);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(50, 110, 200, 25);
        add(l3);

        password = new JPasswordField();
        password.setBounds(50, 130, 200, 25);
        add(password);

        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(90, 170, 120, 30);
        add(saveBtn);

        saveBtn.addActionListener(e -> savePassword());

        setVisible(true);
    }

    private void savePassword() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO passwords(user_id, website, site_username, site_password) VALUES(?,?,?,?)"
            );

            ps.setInt(1, userId);
            ps.setString(2, website.getText());
            ps.setString(3, username.getText());
            ps.setString(4,
                    new String(password.getPassword()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Password Saved Successfully");

            dispose();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}