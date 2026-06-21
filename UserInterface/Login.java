package UserInterface;

import javax.swing.*;
import java.sql.*;

public class Login extends JFrame {

    JTextField usernamepara;
    JPasswordField passwordpara;

    public Login() {

        setTitle("VaultX [LOGIN]");
        setSize(300, 220);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label1 = new JLabel("USERNAME");
        label1.setBounds(50, 10, 200, 25);
        add(label1);

        JLabel label2 = new JLabel("PASSWORD");
        label2.setBounds(50, 60, 200, 25);
        add(label2);

        usernamepara = new JTextField();
        usernamepara.setBounds(50, 30, 200, 25);
        add(usernamepara);

        passwordpara = new JPasswordField();
        passwordpara.setBounds(50, 80, 200, 25);
        add(passwordpara);

        JButton loginbtn = new JButton("LOGIN");
        loginbtn.setBounds(90, 130, 120, 30);
        add(loginbtn);

        loginbtn.addActionListener(e -> login());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void login() {

        String username = usernamepara.getText();
        String password = new String(passwordpara.getPassword());

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM users WHERE username=? AND master_pass=?"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                new Dash(rs.getInt("id"));
                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}