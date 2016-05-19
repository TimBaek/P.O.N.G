// The "Paddle" class.
import java.awt.*;
import hsa.Console;

public class ItemBox
{
    protected Console c;
    protected int x, y, w, h;
    protected Color clr, background;

    public ItemBox ()
    {
	x = (int) ((Math.random () * 300) + 100);
	y = (int) ((Math.random () * 300) + 100);
	w = 50;
	h = 50;
	clr = Color.black;
	background = Color.white;

    }


    public void SetX (int x1)
    {
	x = x1;
    }


    public int GetX ()
    {
	return x;
    }



    public void SetY (int y1)
    {
	y = y1;
    }


    public int GetY ()
    {
	return y;
    }


    public int GetHeight ()
    {
	return h;
    }


    public int GetWidth ()
    {
	return w;
    }


    public void SetColour (Color clr1)
    {
	clr = clr1;
    }


    public Color GetColour ()
    {
	return clr;
    }


    public void SetBackground (Color background1)
    {
	background = background1;
    }


    public Color GetBackground ()
    {
	return background;
    }


    public void Draw (Console c1)  // Example of an action
    {
	c = c1;
	c.setColor (clr);
	c.fillRect (GetX (), GetY (), GetWidth (), GetHeight ());
    }


    public void Erase (Console c1)
    {
	c = c1;
	c.setColor (background);
	c.fillRect (GetX (), GetY (), GetWidth (), GetHeight ());
    }


    public boolean isTouching (int x1, int y1, Console c1)
    {
	if (x1 >= GetX () && x1 <= GetX () + GetWidth () && y1 >= GetY () && y1 <= GetY () + GetHeight ())
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }
} // Paddle class
