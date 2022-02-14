package BILLINGSYSTEM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

class billingSystem {
    connection connect = new connection();
    String productName;
    int productPrice;
    JFrame frame;
    JPanel container;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btnAdd, btnPrint, btnDelete, btnAddQun,
            btnReset, btnAddProduct, btnCheckSell, btnTotalSell;
    JTextArea inputBox, msgBox;
    Font font = new Font("Calibri Bold", Font.BOLD, 24);
    List<Integer> productCode = new ArrayList<Integer>();

 public void mainpage() {
 frame = new JFrame("Billing System");
 container = new JPanel();
 inputBox = new JTextArea("Enter Product Code");
 // Font font = new Font("Calibri Bold", Font.BOLD, 24);
 inputBox.setFont(font);
 inputBox.setEditable(false);
 
inputBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
 inputBox.setBounds(600, 70, 200, 30);
 inputBox.setFont(font);
 msgBox = new JTextArea("ProductName");
 msgBox.setEditable(false);
 
msgBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
 msgBox.setBounds(600, 30, 200, 30);
 msgBox.setFont(font);
 container.setBounds(600, 100, 200, 350);
 // Button Are Here
 btn1 = new JButton("1");
 btn1.setLocation(0, 0);
 btn1.setPreferredSize(new Dimension(50, 50));
 
btn1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0),
 "1");
 btn2 = new JButton("2");
 btn2.setPreferredSize(new Dimension(50, 50));
 
btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0),
 "2");
 btn3 = new JButton("3");
 btn3.setPreferredSize(new Dimension(50, 50));
 
btn3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0),
 "3");
 btn4 = new JButton("4");
 btn4.setPreferredSize(new Dimension(50, 50));
 
btn4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0),
 "4");
 btn5 = new JButton("5");
 btn5.setPreferredSize(new Dimension(50, 50));
 
btn5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0),
 "5");
 btn6 = new JButton("6");
 btn6.setPreferredSize(new Dimension(50, 50));
 
btn6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0),
 "6");
 btn7 = new JButton("7");
 btn7.setPreferredSize(new Dimension(50, 50));
 
btn7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0),
 "7");
 btn8 = new JButton("8");
 btn8.setPreferredSize(new Dimension(50, 50));
 
btn8.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0),
 "8");
 btn9 = new JButton("9");
 btn9.setPreferredSize(new Dimension(50, 50));
 
btn9.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0),
 "9");
 btnAdd = new JButton("Add");
 btnAdd.setPreferredSize(new Dimension(60, 50));
 
btnAdd.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0),
 "addBtn");
 btn0 = new JButton("0");
 btn0.setPreferredSize(new Dimension(50, 50));
 
btn0.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0),
 "0");
 btnDelete = new JButton("DEL");
 btnDelete.setPreferredSize(new Dimension(60, 50));
 
btnDelete.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
 
.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), 
"btnDelete");
 btnPrint = new JButton("Print");
 btnPrint.setPreferredSize(new Dimension(200, 50));
 
btnPrint.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
 
.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "btnPrint");
 btnReset = new JButton("Reset");
 btnReset.setPreferredSize(new Dimension(200, 50));
 
btnReset.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
 
.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "btnReset");
 btnAddProduct = new JButton("Add Product");
 btnAddProduct.setBounds(1100, 70, 200, 50);
 btnAddProduct.setBackground(Color.LIGHT_GRAY);
 
btnAddProduct.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
 .put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 
0), "btnAddProduct");
 btnCheckSell = new JButton("Today's Sell");
 btnCheckSell.setBounds(1100, 130, 200, 50);
 btnCheckSell.setBackground(Color.LIGHT_GRAY);
 
btnCheckSell.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
 .put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 
0), "btnCheckSell");
 btnTotalSell = new JButton("Total Sells");
 btnTotalSell.setBounds(1100, 190, 200, 50);
 btnTotalSell.setBackground(Color.LIGHT_GRAY);
 
btnTotalSell.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
 .put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 
0), "btnTotalSell");
 // Adding Buttons to Container
 container.setBackground(Color.GRAY);
 // container.add(inputBox);
 container.add(btn1);
 container.add(btn2);
 container.add(btn3);
 container.add(btn4);
 container.add(btn5);
 container.add(btn6);
 container.add(btn7);
 container.add(btn8);
 container.add(btn9);
 container.add(btnAdd);
 container.add(btn0);
 container.add(btnDelete);
 container.add(btnPrint);
 container.add(btnReset);
 // Add Conatiner To Frame
 frame.add(container);
 frame.add(inputBox);
 frame.add(msgBox);
 frame.add(btnAddProduct);
 frame.add(btnCheckSell);
 frame.add(btnTotalSell);
 // frame Settings
 frame.setSize(1650, 1080);
 frame.setLayout(null);
 frame.setVisible(true);
 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 // Actions on Button Click
 Action actionbtn1 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 1L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn1 = (JButton) e.getSource();
 inputBox.setText("1");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtn2 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 2L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn2 = (JButton) e.getSource();
 inputBox.setText("2");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtn3 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 3L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn3 = (JButton) e.getSource();
 inputBox.setText("3");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtn4 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 4L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn4 = (JButton) e.getSource();
 inputBox.setText("4");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtn5 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 5L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn5 = (JButton) e.getSource();
 inputBox.setText("5");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't Exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtn6 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 6L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn6 = (JButton) e.getSource();
 inputBox.setText("6");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtn7 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 7L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn7 = (JButton) e.getSource();
 inputBox.setText("7");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtn8 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 8L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn8 = (JButton) e.getSource();
 inputBox.setText("8");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtn9 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 9L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn9 = (JButton) e.getSource();
 inputBox.setText("9");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtn0 = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 0L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btn0 = (JButton) e.getSource();
 inputBox.setText("0");
 int temp = Integer.parseInt(inputBox.getText());
 productName = connect.getProductName(temp);
 if (productName.isEmpty())
 msgBox.setText("Product doesn't exist");
 msgBox.setText(productName);
 }
 };
 Action actionbtnAdd = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 10L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btnAdd = (JButton) e.getSource();
 int temp = Integer.parseInt(inputBox.getText());
 productCode.add(temp);
 // System.out.println(productCode);
 }
 };
 Action actionbtnDelete = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 11L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btnDelete = (JButton) e.getSource();
 inputBox.setText("Del");
 msgBox.setText("");
 }
 };
 Action actionbtnPrint = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 12L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btnPrint = (JButton) e.getSource();
 inputBox.setText("Print");
 printBtnFunction();
 }
 };
 Action actionbtnReset = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 13L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btnReset = (JButton) e.getSource();
 inputBox.setText("Reset");
 msgBox.setText("");
 productCode.clear();
 }
 };
 Action actionbtnAddProduct = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 14L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btnAddProduct = (JButton) e.getSource();
 addNewProduct();
 }
 };
 Action actionbtnCheckSell = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 15L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btnCheckSell = (JButton) e.getSource();
 inputBox.setText("CheckSell");
 checkDaySell();
 }
 };
 Action actionbtnTotalSell = new AbstractAction() {
 /**
 *
 */
 private static final long serialVersionUID = 16L;
 @Override
 public void actionPerformed(ActionEvent e) {
 btnTotalSell = (JButton) e.getSource();
 inputBox.setText("Total");
 connect.getTotalSell();
 }
 };
 btn1.getActionMap().put("1", actionbtn1);
 btn1.addActionListener(actionbtn1);
 btn2.getActionMap().put("2", actionbtn2);
 btn2.addActionListener(actionbtn2);
 btn3.getActionMap().put("3", actionbtn3);
 btn3.addActionListener(actionbtn3);
 btn4.getActionMap().put("4", actionbtn4);
 btn4.addActionListener(actionbtn4);
 btn5.getActionMap().put("5", actionbtn5);
 btn5.addActionListener(actionbtn5);
 btn6.getActionMap().put("6", actionbtn6);
 btn6.addActionListener(actionbtn6);
 btn7.getActionMap().put("7", actionbtn7);
 btn7.addActionListener(actionbtn7);
 btn8.getActionMap().put("8", actionbtn8);
 btn8.addActionListener(actionbtn8);
 btn9.getActionMap().put("9", actionbtn9);
 btn9.addActionListener(actionbtn9);
 btn0.getActionMap().put("0", actionbtn0);
 btn0.addActionListener(actionbtn0);
 btnAdd.getActionMap().put("addBtn", actionbtnAdd);
 btnAdd.addActionListener(actionbtnAdd);
 btnDelete.getActionMap().put("btnDelete", actionbtnDelete);
 btnDelete.addActionListener(actionbtnDelete);
 btnPrint.getActionMap().put("btnPrint", actionbtnPrint);
 btnPrint.addActionListener(actionbtnPrint);
 btnReset.getActionMap().put("btnReset", actionbtnReset);
 btnReset.addActionListener(actionbtnReset);
 btnAddProduct.getActionMap().put("btnAddProduct", 
actionbtnAddProduct);
 btnAddProduct.addActionListener(actionbtnAddProduct);
 btnCheckSell.getActionMap().put("btnCheckSell", 
actionbtnCheckSell);
 btnCheckSell.addActionListener(actionbtnCheckSell);
 btnTotalSell.getActionMap().put("btnTotalSell", 
actionbtnTotalSell);
 btnTotalSell.addActionListener(actionbtnTotalSell);
 }

    public void addNewProduct() {
        JFrame f = new JFrame();
        String productName = JOptionPane.showInputDialog(f,
                "Enter Product Name:");
        String productPrice = JOptionPane.showInputDialog(f,
                "Enter Product Price:");
        int price = Integer.parseInt(productPrice);
        connection connect = new connection();
        connect.connectSaveData(productName, price);
    }

 public void printBtnFunction() {
 int total = 0;
 String ttl = "";
 JTextArea invoiceArea;
 JPanel panel;
 panel = new JPanel();
 
panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
 "Your Generated Bill"));
 invoiceArea = new JTextArea();
 invoiceArea.setEditable(false);
 invoiceArea.setBounds(300, 200, 100, 100);
 if (productCode.isEmpty()) {
 JOptionPane.showMessageDialog(null, "Enter Product Code", "Error", JOptionPane.WARNING_MESSAGE);
 return;
 }
 JFrame f = new JFrame("Invoice");
 f.setBounds(600, 90, 400, 400);
 f.setResizable(false);
 f.setVisible(true);
 Object[] ids = productCode.toArray();
 int tsid = connect.getTransctionId();
 for (Object id : ids) {
 int temp = (int) id;
 String tempName = connect.getProductName(temp);
 int tempprice = connect.getProductPrice(temp);
 total += tempprice;
 String price = Integer.toString(tempprice);
 ttl = Integer.toString(total);
 invoiceArea.setText(invoiceArea.getText() + "\n" + 
tempName + " = " + price + "\n");
 connect.savesells(temp, tsid);
 }
 invoiceArea.setText(invoiceArea.getText() + "\n \n" + "Total = " + ttl);
 panel.add(invoiceArea);
 f.add(panel);
 connect.savetotalSell(tsid, total);
 // System.out.println(total);
 }

    public void checkDaySell() {

        int getsell = connect.gettodaysSell();
        String sell = Integer.toString(getsell);
        String showDialog = "Total Sell of Today Till Now is " + sell
                + "Rs.";
        JOptionPane.showMessageDialog(null, showDialog, "Alert",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        billingSystem bill = new billingSystem();
        bill.mainpage();
    }
}
