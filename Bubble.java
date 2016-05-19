// The "BubbleClass" class.
import java.awt.*;
import hsa.Console;

public class Bubble extends Ball
{
    protected int iHorizontal, iVertical; //add other fields (characteristics)

    protected Console c;

    public Bubble (int ix, int iy, int iradius, Color clr1, int iH, int iV)
    {
	new Ball (ix, iy, iradius, clr);  //call the constructor method first
	iHorizontal = iH;
	iVertical = iV;

    }


    public Bubble (int x, int y, int radius, Color clr)
    {
	new Ball (x, y, radius, clr);
	iHorizontal = 2;
	do
	{
	    iVertical = (int) (Math.random () * 11) - 5;
	}
	while (iVertical == 0);

    }


    public void SetHorizontal (int iH)  // Sets the characteristics
    {
	iHorizontal = iH;
    }


    public int GetHorizontal ()  // Returns the characteristic
    {
	return iHorizontal;
    }


    public void SetVertical (int iV)  // Sets the characteristics
    {
	iVertical = iV;
    }


    public int GetVertical ()  // Returns the characteristic
    {
	return iVertical;
    }


    /*public void SetSpeed (int speed1)
    {
	speed = speed1;
    }


    public int GetSpeed ()
    {
	return speed;
    }*/


    public void Move (Console c1)
    {
	Erase (c1);
	SetX (GetX () + GetHorizontal ());
	SetY (GetY () + GetVertical ());
	Draw (c1);

    }
} // BubbleClass class
