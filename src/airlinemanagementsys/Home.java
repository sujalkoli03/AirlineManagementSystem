
package airlinemanagementsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Home extends JFrame implements ActionListener{
        
        public Home(){
            
            
            setLayout(null);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsys/icons/front.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(0,0,2000,1000);
            add(image);
            
            JLabel heading = new JLabel("WELCOME TO INDIAN AIRLINES!");
            heading .setBounds( 700, 80, 1000, 40);
            heading.setForeground(Color.red);
            heading.setFont(new Font("Times New Roman", Font.PLAIN, 36));
            image.add(heading);
            
            JMenuBar menubar = new JMenuBar();
            setJMenuBar(menubar);
            
            JMenu details = new JMenu("Details");
            details.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            menubar.add(details);
            
            
            JMenuItem flightDetails = new JMenuItem("Flight Details");
            flightDetails.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            flightDetails.addActionListener(this);
            details.add(flightDetails);
            
            JMenuItem reservationDetails = new JMenuItem("Reservation Details");
            reservationDetails.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            reservationDetails.addActionListener(this);
            details.add(reservationDetails);
            
            JMenuItem bookFlight = new JMenuItem("Book Flight ");
            bookFlight.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            bookFlight.addActionListener(this);
            details.add(bookFlight);
            
            JMenuItem journeyDetails = new JMenuItem("Journey Details");
            journeyDetails.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            journeyDetails.addActionListener(this);
            details.add(journeyDetails);
            
            JMenuItem ticketCancelation = new JMenuItem("Ticket Cancelation");
            ticketCancelation.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            ticketCancelation.setForeground(Color.red);
            ticketCancelation.addActionListener(this);
            details.add(ticketCancelation);
            
            JMenu ticket = new JMenu("Ticket");
            ticket.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            menubar.add(ticket);
            
            JMenuItem boardingPass = new JMenuItem("Boarding Pass");
            boardingPass.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            boardingPass.addActionListener(this);
            ticket.add(boardingPass);
            
            setExtendedState(JFrame.MAXIMIZED_BOTH);
       
            setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae){
            String text = ae.getActionCommand();
        
        if (text.equals("Reservation Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        }else if (text.equals("Book Flight ")) {
            new BookFlight();
        }else if (text.equals("Journey Details")) {
            new JourneyDetails();
        }else if (text.equals("Ticket Cancelation")) {
            new Cancel();
        }else if (text.equals("Boarding Pass")) {
            new BoardingPass();
        }

            
    }
    
    public static void main(String[] args){
        new Home();
    }
}
