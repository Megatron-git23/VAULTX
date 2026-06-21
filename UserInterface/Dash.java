package UserInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.sql.*;

public class Dash extends JFrame {

    JTable table;
    int userid;

    public Dash(int userid) {

        this.userid = userid;

        setTitle("VaultX Dashboard");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        table = new JTable();

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton addBtn = new JButton("Add Password");
        add(addBtn, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {
            new AddPasswordForm(userid);
        });

        loadData();

        setVisible(true);
    }

    private void loadData() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM passwords WHERE user_id=?"
            );

            ps.setInt(1, userid);

            ResultSet rs = ps.executeQuery();

            DefaultTableModel model =
                    new DefaultTableModel(
                            new String[]{
                                    "ID",
                                    "Website",
                                    "Username",
                                    "Password"
                            }, 0);

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("website"),
                        rs.getString("site_username"),
                        rs.getString("site_password")
                });
            }

            table.setModel(model);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}