package main;
import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args) 
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setResizable(false);
        window.setTitle("Operation Mystery");
        
        GamePanel Panel = new GamePanel();
        window.add(Panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        Panel.SetUpGame();
        Panel.startGameThread();
    }
}