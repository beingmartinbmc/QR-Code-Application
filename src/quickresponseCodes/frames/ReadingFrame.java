package quickresponseCodes.frames;


import quickresponseCodes.Author;
import quickresponseCodes.Browse;
import quickresponseCodes.implementation.Reader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Author(name="Ankit Sharma",date="28 June 2018")
public class ReadingFrame {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel back,q,w;
    private ImageIcon background;
    private Image img,temp;
    private static JTextField f;
    private static BufferedImage a,s;

    public ReadingFrame(){
        frame=new JFrame();
        frame.setSize(500,550);
        frame.setDefaultCloseOperation(2);
        frame.setLocationRelativeTo(null);

        panel=new JPanel();
        panel.setLayout(null);
        try {
            a = ImageIO.read(new File("./newfile.png"));
            s = ImageIO.read(new File("images/ereader.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        q=new JLabel(new ImageIcon(a));
        q.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame,"I am just a QR-Code haha!\nThough you can try to decode me");
            }
        });
        w=new JLabel(new ImageIcon(s));
        f=new JTextField(10);
        f.setFont(new Font("Dubai",0,15));
        f.setEditable(false);

        background = new ImageIcon("images/managementbackground.jpg");
        img = background.getImage();
        temp = img.getScaledInstance(500, 550, 4);
        background = new ImageIcon(temp);
        back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 500, 550);

        q.setBounds(90,50,300,300);
        w.setBounds(50,420,64,64);
        f.setBounds(160,430,250,30);

        w.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Reader.decode("./newfile.png");}
                catch (Exception h){h.printStackTrace();}
                f.setText(Reader.decodedText);
                Browse.surf(f.getText());
            }
        });

        panel.add(q);panel.add(w);panel.add(f);
        panel.add(back);
        frame.add(panel);
        frame.setVisible(true);
    }
}
