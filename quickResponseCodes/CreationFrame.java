package quickresponseCodes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Author(name="Ankit Sharma",date="28 June 2018")
public class CreationFrame{
    static JFrame frame;
    static JPanel panel;
    static JLabel w,e,back;
    static BufferedImage s,d;
    static JTextField z;
    private ImageIcon background;
    private Image img,temp;

    CreationFrame(){
        frame=new JFrame("Generator");
        frame.setSize(450,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(2);
        panel=new JPanel();
        panel.setLayout(null);
        try{
            s=ImageIO.read(new File("D:\\qrCodes\\images\\message.png"));
            d=ImageIO.read(new File("D:\\qrCodes\\images\\ok.png"));
        }
        catch (IOException h){
            h.printStackTrace();
        }
        w=new JLabel(new ImageIcon(s));
        e=new JLabel(new ImageIcon(d));
        z=new JTextField(10);
        z.setFont(new Font("Dubai",0,18));

        background = new ImageIcon("D:\\GLA Simulation\\src\\images\\securitybackground.jpg");
        img = background.getImage();
        temp = img.getScaledInstance(500, 600, 4);
        background = new ImageIcon(temp);
        back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 500, 600);

        w.setBounds(40,50,64,64);
        z.setBounds(140,70,250,30);
        e.setBounds(200,150,64,64);

        e.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{Generation.generateQRCode(z.getText(),300,300,"./newfile.png");}
                catch (Exception h){h.printStackTrace();}
                JOptionPane.showMessageDialog(frame,"Generated!");
            }
        });
        panel.add(w);panel.add(z);panel.add(e);
        panel.add(back);
        frame.add(panel);
        frame.setVisible(true);
    }
}
