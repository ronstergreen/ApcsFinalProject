import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * 
 * Describes the JFrame the Adventure game should open in Also controls the game
 * // TODO
 *
 * @author
 * @version Apr 27, 2018
 * @author Period: 4
 * @author Assignment: Adventure
 *
 * @author Sources:
 */
public class AdventureFrame extends JFrame
{
    private AdventureComponent scene;

    private static final int FRAME_WIDTH = 800;

    private static final int FRAME_HEIGHT = 500;

    private PlayerMovementKeyListener keyListener;
    private boolean canMove;

    class PlayerMovementKeyListener implements KeyListener
    {
        private boolean pressed;


        public void keyPressed( KeyEvent k )
        {
            if ( !pressed && canMove )
            {
                int keyCode = k.getKeyChar();
                if ( keyCode == 97 )
                {
                    // A
                    scene.movePlayer( Move.LEFT );
                    checkMonster();
                }
                else if ( keyCode == 119 )
                {
                    // W
                    scene.movePlayer( Move.UP );
                    checkMonster();
                }
                else if ( keyCode == 100 )
                {
                    // D
                    scene.movePlayer( Move.RIGHT );
                    checkMonster();
                }
                else if ( keyCode == 115 )
                {
                    // S
                    scene.movePlayer( Move.DOWN );
                    checkMonster();
                }
                
                pressed = true;
            }

        }


        public void keyReleased( KeyEvent k )
        {
            pressed = false;
        }


        public void keyTyped( KeyEvent k )
        {

        }
    }

    // TODO: Check if you're on a monster. Start battle.
    private void checkMonster() {
        if(scene.checkMonster()) {
            System.out.println("monster");
            Battle b = new Battle(scene.getPlayer());
            BattleFrame battle = new BattleFrame(b);
            battle.addWindowListener( new WindowListener() 
            {

                @Override
                public void windowActivated( WindowEvent arg0 ) {}

                @Override
                public void windowClosed( WindowEvent arg0 )
                {
                    canMove = true;
                    if (scene.checkPlayerDeath()) 
                    {
                        System.out.println("RESET");
                        resetScene();
                    }
                    
                }

                @Override
                public void windowClosing( WindowEvent arg0 ) {}

                @Override
                public void windowDeactivated( WindowEvent arg0 ){}

                @Override
                public void windowDeiconified( WindowEvent arg0 ){}

                @Override
                public void windowIconified( WindowEvent arg0 ){}

                @Override
                public void windowOpened( WindowEvent arg0 ){}

            } );
            battle.setVisible( true );
            canMove = false;
        }
        else {
            System.out.println( "no monster" );
        }
    }
    
    private void resetScene() 
    {
//        getContentPane().remove( scene );
//        getContentPane().repaint();
        scene.removeKeyListener( keyListener );
//        scene = new AdventureComponent();
//        add( scene );
//        setSize( FRAME_WIDTH, FRAME_HEIGHT );
//        setBackground(Color.WHITE);
//        
//        canMove = true;
//        
//        keyListener = new PlayerMovementKeyListener();
//        scene.addKeyListener( keyListener );
//        getContentPane().repaint();
//        scene.setFocusable( true );
    }

    /**
     * Sets parameters of the JFrame and adds the Adventure game to it
     */
    public AdventureFrame()
    {
        scene = new AdventureComponent();
        add( scene );
        setSize( FRAME_WIDTH, FRAME_HEIGHT );
        setBackground(Color.WHITE);
        
        canMove = true;
        
        keyListener = new PlayerMovementKeyListener();
        scene.addKeyListener( keyListener );
        
        scene.setFocusable( true );
        
    }
}
