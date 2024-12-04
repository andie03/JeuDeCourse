import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Mypanel extends JPanel implements KeyListener {
    // attributs des largeurs
    final static int ROADWIDTH = 500;
    final static int POSITIONROADX = ((MyFrame.FRAMEWIDTH) / 2) - ((Mypanel.ROADWIDTH) / 2);
    // variable pour contenir l'image
    BufferedImage voiture;
    private double angle = 0; // Angle de rotation de la voiture
    // place initiale de la voiture
    private int positionX = 325;
    private int positionY = 545;

    // Constructeur
    Mypanel() {
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this); // Ajout du listener pour les touches du clavier
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        // ceci est le dessin de la route
        g.setColor(Color.GRAY);
        g.fillRect(Mypanel.POSITIONROADX, 0, ROADWIDTH, MyFrame.FRAMEHEIGHT);

        // dessin des bords gauche
        g.setColor(Color.black);
        g.fillRect(Mypanel.POSITIONROADX, 0, 10, MyFrame.FRAMEHEIGHT);

        // dessin des bords droite
        g.setColor(Color.BLACK);
        g.fillRect((Mypanel.POSITIONROADX + Mypanel.ROADWIDTH), 0, 10, MyFrame.FRAMEHEIGHT);

        // dessin des lignes sur la route
        for (int i = 0; i <= MyFrame.FRAMEHEIGHT; i += 40) {
            g.setColor(Color.WHITE);
            g.fillRect(MyFrame.FRAMEWIDTH / 2, i, 10, 20);
        }

        // import de l'image
        try {
            voiture = ImageIO.read(new File("/Users/rosine/IdeaProjects/Course/assets/car.png"));
            if (voiture == null) {
                System.out.println("Erreur de chargement de l'image");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rotation de l'image de la voiture
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(Math.toRadians(angle), positionX + voiture.getWidth() / 2, positionY + voiture.getHeight() / 2);
        g2d.drawImage(voiture, positionX, positionY, getFocusCycleRootAncestor());
    }

    public void deplacerDroite() {
        if (positionX + 100 < Mypanel.POSITIONROADX + Mypanel.ROADWIDTH - 10 ) {
            this.positionX += 40;
            this.angle = 90;
            repaint();
        }
    }

    public void deplacerGauche() {
        if (positionX > Mypanel.POSITIONROADX + 10) {
            this.positionX -= 40;
            this.angle = -90;
            repaint();
        }
    }

    public void deplacerHaut() {
        if (positionY > 30 ) {
            this.positionY -= 40;
            this.angle = 0;
            repaint();
        }
        if (positionY == 200) {
            this.repaint();
        }
    }

    public void deplacerBas() {
        if (positionY + 30 < MyFrame.FRAMEHEIGHT - 150) {
            this.positionY += 40 ;
            this.angle = 180;
            repaint();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // Méthodes pour gérer les évènements clavier (implémentation de KeyListener)
    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP:
                deplacerHaut();
                break;

            case KeyEvent.VK_DOWN:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}