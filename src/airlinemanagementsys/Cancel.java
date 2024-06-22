package airlinemanagementsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, cancellationno, lblfcode, lbldate;
    JButton fetchButton, flight;
    
    
    public Cancel() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELATION");
        heading.setBounds(260, 20, 500, 35);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 32));
        heading.setForeground(Color.red);
        add(heading);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsys/icons/cancel.png"));
        Image i2 = image.getImage().getScaledInstance(500/2, 500/2, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lblimage = new JLabel(i3);
        lblimage.setBounds(550,70,500/2,500/2);
        add(lblimage);
        
        JLabel lblaadhar = new JLabel("PNR Number :");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name: ");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Cancellation num : ");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        cancellationno = new JLabel(""+random.nextInt(1000000));
        cancellationno.setBounds(220, 180, 150, 25);
        cancellationno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cancellationno);
        
        JLabel lbladdress = new JLabel("Flight code : ");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25);
        add(lblfcode);
        
        JLabel lblgender = new JLabel("Date: ");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        lbldate = new JLabel();
        lbldate.setBounds(220, 280, 150, 25);
        add(lbldate);
        
        
        
        flight = new JButton("Cancel");
        flight.setBackground(Color.red);
        flight.setForeground(Color.WHITE);
        flight.setBounds(335, 330, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        
        setSize(800, 450);
        setLocation(350, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '"+pnr+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    lblfcode.setText(rs.getString("flightcode"));
                    lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    lbldate.setText(rs.getString("ddate"));
                    lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR number!");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = lbldate.getText();
            
            try {
                Conn conn = new Conn();

                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled Successfully!");     
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Cancel();
    }
}