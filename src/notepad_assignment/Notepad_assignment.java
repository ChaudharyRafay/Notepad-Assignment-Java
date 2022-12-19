package notepad_assignment;

import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;
import java.io.IOException;

class About extends JFrame {

    About() {
        setBounds(100, 100, 400, 500);
        setTitle("About Notepad");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        JLabel text = new JLabel("<html>Wellcome to Notepad <br>Notepad is a simple text editor for Microsoft Windows and a basic text-editing program which enables computer users to create documents <br>All rights reserved@2021</html>");
        text.setBounds(10, 10, 450, 300);
        add(text);
    }
}

public class Notepad_assignment extends JFrame implements ActionListener {

    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu format = new JMenu("Format");
    JMenu view = new JMenu("View");
    JMenu help = new JMenu("Help");

    //for adding menu items in file menubar
    JMenuItem new_file = new JMenuItem("New");
    JMenuItem new_window = new JMenuItem("New Window");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem save_as = new JMenuItem("SaveAs");
    JMenuItem page_setup = new JMenuItem("Page Setup...");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit_app = new JMenuItem("Exit");

    //for adding menu items in edit menubar
    JMenuItem undo = new JMenuItem("Undo");
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");

    //for adding menu items in Format menubar
    JMenuItem word_wrap = new JMenuItem("Word_Wrap");
    JMenuItem font = new JMenuItem("Font");

    //for adding menu items in View menubar
    JMenuItem zoom = new JMenuItem("Zoom");
    JMenuItem status_bar = new JMenuItem("Status Bar");
    //for adding menu items in Help menubar
    JMenuItem about = new JMenuItem("About Notepad");

    JTextArea text_area = new JTextArea();
//    JTextField text_field=new JTextField();
    String texts;
    String Title = "New Text Document";
    String last_title = " - Notepad";

    Notepad_assignment() {

        setTitle(Title + last_title);
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close button click close application 
        setJMenuBar(mb);
        mb.add(file);
        mb.add(edit);
        mb.add(format);
        mb.add(view);
        mb.add(help);
//        add(mb);

        file.add(new_file);
        file.add(new_window);
        file.add(open);
        file.add(save);
        file.add(save_as);
        file.add(page_setup);
        file.add(print);
        file.add(exit_app);

        edit.add(undo);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        format.add(word_wrap);
        format.add(font);

        view.add(zoom);
        view.add(status_bar);

        help.add(about);

        JScrollPane scroll = new JScrollPane(text_area);
        add(scroll);
//        add(text_field);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//by default text does not goes to next line and horizantall scroll appear thats awhy we finish horizantal scroll bar
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //enable vertical scroll bar
        text_area.setLineWrap(true);
//         texts=text_area.getText();
//        System.out.println(texts);

        new_file.addActionListener(this);
//        text_area.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        save_as.addActionListener(this);
        print.addActionListener(this);
        exit_app.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        undo.addActionListener(this);
        about.addActionListener(this);
    }

    public static void main(String[] args) {
        Notepad_assignment na = new Notepad_assignment();
        na.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = text_area.getText();
        String currentFile = "";
//        System.out.println("text");
        if (e.getActionCommand().equalsIgnoreCase("New")) {
            text_area.setText(null);
        } else if (e.getActionCommand().equalsIgnoreCase("Open")) {
            JFileChooser filechooser = new JFileChooser();
            int action = filechooser.showOpenDialog(null);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(filechooser.getSelectedFile()));
                    text_area.read(reader, null);
                    Title = filechooser.getSelectedFile().getName();
                    setTitle(Title + last_title);
                    currentFile = filechooser.getSelectedFile().getAbsolutePath().toString();
                    System.out.println(currentFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } //        else if (e.getActionCommand().equalsIgnoreCase("Save")) {
        // 
        //           try {
        //               File file=new File(currentFile);
        //               if(file.createNewFile()){
        //                   System.out.println("created");
        //                   FileWriter fw=new FileWriter(currentFile);
        //                   fw.write(text_area);
        //                   fw.close();
        //               }else{
        //                   System.out.println("already exists");
        //                   FileWriter fw=new FileWriter(file.getCanonicalPath());
        //                   fw.write(text);
        //                   fw.close();
        //               }
        //           } catch (IOException ex) {
        //               Logger.getLogger(Notepad_assignment.class.getName()).log(Level.SEVERE, null, ex);
        //           }
        //
        //        } 
        else if (e.getActionCommand().equalsIgnoreCase("SaveAs")) {
            JFileChooser filechooser = new JFileChooser();
            int action = filechooser.showSaveDialog(null);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                String filename = filechooser.getSelectedFile().getAbsolutePath().toString();
                try {
                    BufferedWriter writter = new BufferedWriter(new FileWriter(filename));
                    text_area.write(writter);
                    Title = filechooser.getSelectedFile().getName();
                    setTitle(Title + last_title);
                    System.out.println(Title);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } else if (e.getActionCommand().equalsIgnoreCase("print")) {
            try {
                text_area.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equalsIgnoreCase("exit")) {
            System.exit(0);
        } else if (e.getActionCommand().equalsIgnoreCase("cut")) {
            text_area.cut();
        } else if (e.getActionCommand().equalsIgnoreCase("copy")) {
            text_area.copy();
        } else if (e.getActionCommand().equalsIgnoreCase("paste")) {
            text_area.paste();
        } else if (e.getActionCommand().equalsIgnoreCase("About Notepad")) {
            new About().setVisible(true);
        }
    }

}
