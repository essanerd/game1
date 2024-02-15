import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;


    // test comment

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();// basicallly returns a number of the key  that was pressed

        if (code == KeyEvent.VK_W) {// if code = w
            upPressed = true; // w pressed is true

        }

        if (code == KeyEvent.VK_S) {// if code = s
            downPressed = true; // s pressed is true

        }

        if (code == KeyEvent.VK_A) {// if code = a
            leftPressed = true; // a pressed is true
        }

        if (code == KeyEvent.VK_D) {// if code = d
            rightPressed = true; // d pressed is true

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {// if code = w
            upPressed = false; // w pressed is False

        }

        if (code == KeyEvent.VK_S) {// if code = s
            downPressed = false; // s pressed is false

        }

        if (code == KeyEvent.VK_A) {// if code = a
            leftPressed = false;  // a pressed is false
        }

        if (code == KeyEvent.VK_D) {// if code = d
            rightPressed = false; // d pressed is  false

        }


    }
}
