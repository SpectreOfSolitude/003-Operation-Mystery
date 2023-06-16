package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class GELANG extends SuperObject
{
    GamePanel gp;

    public GELANG(GamePanel gp)
    {
        this.gp = gp;
        name = "Gelang";
        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/shield_blue.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        setMonologue();
    }

    public void setMonologue()
    {
        monologues[0] = " Cincin..?";
	    monologues[1] = "kenapa cincin ini \nmembuatku merasa gelisah…";
	    monologues[2] = "Apa aku telah kehilangan \nsesuatu yang sangat berarti? \ntapi apa? hmmm… ";
        monologues[3] = "Ah sudahlah. kalau aku tidak \ningat, berarti tidak penting.";
        monologues[3] = "Dilihat-lihat, bagus juga nih \ncincinnya. aku pakai saja.";

    }

    public void setAction()
    {
        actionLockCounter ++;
    }

    public void monologue()
    {
        if(monologues[monologueIndex] == null)
        {
            monologueIndex = 0;
        }

        gp.ui.currentDialogue = monologues[monologueIndex];
        monologueIndex++;
    }

}
