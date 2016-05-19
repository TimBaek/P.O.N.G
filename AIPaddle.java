// The "Paddle" class.
import java.awt.*;
import hsa.Console;

public class AIPaddle
{
    protected int x, y, height, width, speed;
    protected Color clr, background;
    static Console c;           // The output console
    public AIPaddle ()
    {
	x = 0;
	y = 0;
	clr = Color.black;
	background = Color.white;
	height = 100;
	width = 100;
	speed = 10;
    }


    public AIPaddle (int x1, int y1, Color clr1, int s1, int h1, int w1)
    {
	this.x = x1;
	this.y = y1;
	this.clr = clr1;
	this.speed = s1;
	this.height = h1;
	this.width = w1;
	background = Color.white;
    }


    public int Getspeed ()
    {
	return speed;
    }



    public void Setspeed (int s1)
    {
	speed = s1;
    }


    public int GetHeight ()
    {
	return height;
    }



    public void SetHeight (int h1)
    {
	height = h1;
    }


    public int GetWidth ()
    {
	return width;
    }


    public void SetWidth (int w1)
    {
	width = w1;
    }


    public void SetX (int x1)  //Communicators - setting a value
    {
	x = x1;
    }


    public int GetX ()  // returns the characteristic
    {
	return x;
    } // Returns a characteristic value of x - It is a function method that returns a value


    public void SetY (int y1)  //Communicators - setting a value
    {
	y = y1;
    }


    public int GetY ()
    {
	return y;
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


    public boolean isTouching (int x1, int y1, Console c1)
    {
	if (x1 >= x && x1 <= (x + width) && y1 >= y && y1 <= (y + height))
	{
	    return true;
	}
	return false;
    }


    public void Draw (Console c1)
    {
	c = c1;
	c.setColor (clr);
	c.fillRect (GetX (), GetY (), GetWidth (), GetHeight ());
    }


    public void Erase (Console c1)
    {
	c = c1;
	c.setColour (background);
	c.fillRect (GetX (), GetY (), GetWidth (), GetHeight ());
    }


    public void Move (Console c1, int x1, int y1)
    {
	c = c1;
	Erase (c1);
	SetX (x1);
	SetY (y1);
	Draw (c1);
    }
} // Paddle class
