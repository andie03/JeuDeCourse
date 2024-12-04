import javax.swing.*;

public class MyFrame extends JFrame {

    final static int FRAMEWIDTH = 1000;
    final static int FRAMEHEIGHT = 700;

    //constructeur de la fenetre
    MyFrame(){

        Mypanel panel = new Mypanel();
        Deplacement dep = new Deplacement(panel);

        this.setTitle("Jeu de course");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(MyFrame.FRAMEWIDTH, MyFrame.FRAMEHEIGHT);
        this.setContentPane(panel);
        this.addKeyListener(dep);
        this.setFocusable(true);
        this.requestFocusInWindow();



        this.setVisible(true);
    }
}
