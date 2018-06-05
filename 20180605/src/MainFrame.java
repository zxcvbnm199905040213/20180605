import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame{


    private Container cp ;
    private JLabel jlb = new JLabel();
    private JLabel jlb2 = new JLabel();
    private Timer t1 ;
    private ImageIcon imag = new ImageIcon("02.png");
    private ImageIcon imag2 = new ImageIcon("03.png");
    private ImageIcon imag3 = new ImageIcon("01.png");


    public MainFrame(){
        init();
    }


    private void init(){
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setBounds(50,50,800,700);
        cp = this.getContentPane();
        cp.setLayout(null);


        Image img = imag.getImage();
        Image img2 = img.getScaledInstance(120,80,Image.SCALE_SMOOTH);
        imag.setImage(img2);
        jlb.setBounds(350,580,120,80);
        jlb.setIcon(imag);
        cp.add(jlb);


        img = imag3.getImage();
        img2 = img.getScaledInstance(120,80,Image.SCALE_SMOOTH);
        imag3.setImage(img2);
        jlb2.setIcon(imag2);

        ///////////////////////////////////////////////////////////////////////////////


        t1 = new Timer(200, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlb2.setLocation(jlb2.getX(),jlb2.getY()-5);
                if (jlb2.getY()<0){
                    t1.stop();
                }

            }
        });


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){


                    case KeyEvent.VK_LEFT:
                        jlb.setIcon(imag);
                        jlb.setLocation(jlb.getX()-5,jlb.getY());
                        break;



                    case KeyEvent.VK_RIGHT:
                        jlb.setIcon(imag3);
                        jlb.setLocation(jlb.getX()+5,jlb.getY());
                        break;



                    case KeyEvent.VK_SPACE:
                        cp.add(jlb2);
                        jlb2.setIcon(imag2);
                        jlb2.setBounds(jlb.getX()+30,jlb.getY(),30,60);
                        t1.start();
                        break;
                }
            }
        });
    }
}