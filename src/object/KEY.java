package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class KEY extends SuperObject
{
    GamePanel gp;

    public KEY(GamePanel gp)
    {
        this.gp = gp;
        name = "Key";
        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        setMonologue();
    }

    public void setMonologue()
    {
        monologues[0] = " Gelang?......";
	    monologues[1] = "kenapa gelang ini membuatku merasa gelisah ….";
	    monologues[2] = "Apa aku kehilangan sesuatu yang sangat berarti ? tapi apa ? hmmm… ";
        monologues[3] = "Ah biar lah, kalau aku tidak ingat berarti tidak penting. Dilihat lihat bagus juga nih gelangnya aku pakai saja ah";

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
