package BILLINGSYSTEM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class connection {
    public Connection conn;

    connection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingproject", "root", "");
            this.conn = conn;
        } catch (Exception e) {
            e.toString();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "alert", "alert",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void connectSaveData(String arg1, int arg2) {
        boolean flag = false;
        flag = checkPuductExist(arg1);
        if (flag == false) {
            try {
                Statement st = this.conn.createStatement();
                String sql = "INSERT INTO productlist" +
                        "(ProductName,Price)" + "VALUES('" + arg1 + "','" + arg2
                        + "')";
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Product added Sucess Fully.", "Alert",
                        JOptionPane.WARNING_MESSAGE);

            } catch (Exception e) {
                e.toString();
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, e, "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public boolean checkPuductExist(String arg1) {
        boolean flag = false;
        try {
            Statement st = this.conn.createStatement();
            String sql = "SELECT * FROM productlist WHERE ProductName='" + arg1 + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                while (rs.next()) {
                    int price = rs.getInt("Price");
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "" + arg1 + " is already exist with price of:" + price + "Rs.",
                            "Alert", JOptionPane.ERROR_MESSAGE);
                    flag = true;
                }
            } else
                flag = false;
        } catch (Exception e) {
            e.toString();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }

    public String getProductName(int arg) {
        String name = "Invalid Product Code";
        try {
            Statement st = this.conn.createStatement();
            String sql = "SELECT * FROM productlist WHERE id='" + arg
                    + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString("ProductName");
                return name;
            }
        } catch (Exception e) {
            e.toString();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
        return name;
    }

    public int getProductPrice(int arg) {
        int price = 0;
        try {
            Statement st = this.conn.createStatement();
            String sql = "SELECT * FROM productlist WHERE id='" + arg
                    + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                price = rs.getInt("Price");
                return price;
            }
            conn.close();
        } catch (Exception e) {
            e.toString();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
        return price;
    }

    public void savesells(int arg, int tsid) {
        try {
            String productName = getProductName(arg);
            int price = getProductPrice(arg);

            Statement st = this.conn.createStatement();
            String sql = "INSERT INTO sells" +
                    "(productname,price,transID)" + "VALUES('" + productName + "','" +
                    price
                    + "','" + tsid + "')";
            st.execute(sql);

        } catch (Exception e) {
            e.toString();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public int getTransctionId() {
        int tsid = 0;
        try {
            Statement st = this.conn.createStatement();
            String sql = "SELECT MAX(id) FROM totalsell";
            st.executeQuery(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tsid = rs.getInt(1);
            }

            rs.close();
        } catch (Exception e) {
            e.toString();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
        return tsid;
    }

    public void savetotalSell(int arg1, int arg2) {

        try {

            Statement st = this.conn.createStatement();
            String sql = "INSERT INTO totalsell" + "(transactionId,price)" +
                    "VALUES('" + arg1 + "','" + arg2 + "')";
            st.execute(sql);

        } catch (Exception e) {
            e.toString();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public int gettodaysSell() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        int totalAmount = 0;

        try {

            Statement st = this.conn.createStatement();

            String sql = "SELECT * FROM sells WHERE Date(date)='" + date + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int total = rs.getInt("price");
                totalAmount += total;

            }
        } catch (Exception e) {
            e.toString();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.WARNING_MESSAGE);
        }

        return totalAmount;
    }

    public void getTotalSell() {
        int totalAmount = 0;

        try {

            Statement st = this.conn.createStatement();

            String sql = "SELECT * FROM totalsell";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int total = rs.getInt("price");
                totalAmount += total;

            }

            String showDialog = "Total Sell of Today Till Now is " +
                    totalAmount + "Rs.";
            JOptionPane.showMessageDialog(null, showDialog, "Alert",
                    JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            e.toString();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e, "Error",
                    JOptionPane.WARNING_MESSAGE);
        }

    }
}
