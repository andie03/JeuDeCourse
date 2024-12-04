import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Deplacement implements KeyListener {

    private Mypanel panel;

    public Deplacement (Mypanel panel){
        this.panel = panel;
    }

    //--------Ceci sera les methodes venant de l'interface--------------
    @Override
        public void keyPressed (KeyEvent key){
        switch (key.getKeyCode()){

            case KeyEvent.VK_UP :
                panel.deplacerHaut();
                break;

            case KeyEvent.VK_DOWN :
                panel.deplacerBas();
                break;

            case KeyEvent.VK_RIGHT :
                panel.deplacerDroite();
                break;

            case KeyEvent.VK_LEFT :
                panel.deplacerGauche();
                break;


            default:
                break;

        }
    }

    //_____________Je mets justes ces methodes car on doit l'implementer sur l'interface_______________

    @Override
    public void keyTyped (KeyEvent e){

    }
    @Override
    public void keyReleased(KeyEvent e){

    }
    //_____________Je mets justes ces methodes car on doit l'implementer sur l'interface_______________
}
