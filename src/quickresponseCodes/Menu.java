package quickresponseCodes;

import quickresponseCodes.frames.CreationFrame;
import quickresponseCodes.frames.ReadingFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Author(name="Ankit Sharma",date="28 June 2018")
public class Menu {
    static JFrame frame;
    static JPanel panel;
    static BufferedImage a,s,d;
    static JLabel back,w,e,r;
    private ImageIcon background;
    private Image img,temp;

    private Menu(){
        frame=new JFrame("QR CODES");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int a=JOptionPane.showConfirmDialog(frame,"Are you sure?");
                if(a==0)
                    frame.dispose();
            }
        });
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        panel=new JPanel();
        panel.setLayout(null);

        try{
            a=ImageIO.read(new File("images/pen.png"));
            s=ImageIO.read(new File("images/eye.png"));
            d=ImageIO.read(new File("images/exit.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        w=new JLabel(new ImageIcon(a));
        e=new JLabel(new ImageIcon(s));
        r=new JLabel(new ImageIcon(d));

        background = new ImageIcon("images/homeworkbackground.jpg");
        img = background.getImage();
        temp = img.getScaledInstance(500, 500, 4);
        background = new ImageIcon(temp);
        back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 500, 500);

        w.setBounds(50,120,128,128);
        w.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CreationFrame();
            }
        });
        e.setBounds(300,120,128,128);
        e.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ReadingFrame();
            }
        });
        r.setBounds(200,300,128,128);
        r.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame,"Have a good day!");
                frame.dispose();
            }
        });
        panel.add(w);panel.add(e);panel.add(r);
        panel.add(back);
        frame.add(panel);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame,"This is a QR code applet created by Ankit Sharma.\nYou can create your own your QR-Code, and can also read them\nAll Images are clickable!");
    }
    public static void main(String ...s){
        new Menu();
    }
}
