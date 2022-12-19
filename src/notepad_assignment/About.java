
package notepad_assignment;
import javax.swing.*;
public class About extends JFrame {
    About(){
        setBounds(100,100,400,500);
        setTitle("About Notepad");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        JLabel text=new JLabel("<html>Wellcome to Notepad <br>Notepad is a simple text editor for Microsoft Windows and a basic text-editing program which enables computer users to create documents <br>All rights reserved@2021</html>");
        text.setBounds(550,50,550,300);
        add(text);
    }
    public static void main(String [] args){
        new About().setVisible(true);
    }
}
