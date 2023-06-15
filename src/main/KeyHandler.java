package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class KeyHandler implements KeyListener
{
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

    public KeyHandler(GamePanel gp)
    {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
       
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int code = e.getKeyCode();

        if(gp.gameState == gp.playState)
        {
            
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
            {
                upPressed = true;
            }
            if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT )
            {
                leftPressed = true;
            }
            if(code == KeyEvent.VK_S|| code == KeyEvent.VK_DOWN )
            {
                downPressed = true;
            }
            if(code == KeyEvent.VK_D ||code == KeyEvent.VK_RIGHT)
            {
                rightPressed = true;
            }
            
            if(code == KeyEvent.VK_P)
            {   
                gp.gameState= gp.pauseState;    
            }

            if (code == KeyEvent.VK_C || code == KeyEvent.VK_SPACE || code == KeyEvent.VK_ENTER)
            {
                enterPressed = true;
            }
        }

        // Pause
        else if(gp.gameState == gp.pauseState)
        {
            if(code == KeyEvent.VK_P)
            {
                gp.gameState= gp.playState;
            }    
        }        
        else if(gp.gameState == gp.dialogueState)
        {
            if (code == KeyEvent.VK_ENTER|| code == KeyEvent.VK_SPACE || code == KeyEvent.VK_C )
            {
                gp.gameState = gp.playState;
            }
        }
    }    
    

    @Override
    public void keyReleased(KeyEvent e) 
    {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W)
        {
            upPressed = false;
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S)
        {
            downPressed = false;
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }
        if(code == KeyEvent.VK_UP)
        {
            upPressed = false;
        }
        if(code == KeyEvent.VK_DOWN)
        {
            downPressed = false;
        }
        if(code == KeyEvent.VK_RIGHT)
        {
            rightPressed = false;
        }
        if(code == KeyEvent.VK_LEFT)
        {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_C)
        {
            enterPressed = false;
        }
        if (code == KeyEvent.VK_SPACE)
        {
            enterPressed = false;
        }
        if (code == KeyEvent.VK_ENTER)
        {
            enterPressed = false;
        }

    }
    
}
