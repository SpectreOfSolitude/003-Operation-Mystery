package object;

import javax.imageio.ImageIO;

import main.GamePanel;

public class PISAU extends SuperObject
{
    GamePanel gp;

    public PISAU(GamePanel gp)
    {
        this.gp = gp;
        name = "Pisau";
        try 
        {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/sword_normal.png"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        setMonologue();
    }

    public void setMonologue()
    {
        monologues[0] = "Pisau???";
	    monologues[1] = "Kenapa ada pisau disini?";
	    monologues[2] = "Apakah ada pembunuh\nberkeliaran di sini?";
	    monologues[3] = "Ahahahahaha... mana\nmungkin. ";
	    monologues[4] = "Setiap malam aku dengan\norang tersebut\njalan-jalan disini.";
        monologues[5] = "Kalau memang ada pembunuh\nberkeliaran, bukannya aku udah\n mati karenanya kemarin?";
        monologues[6] = "hahaha paling ini hanya\npisau tertinggal\n milik tamu kemarin...";
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
