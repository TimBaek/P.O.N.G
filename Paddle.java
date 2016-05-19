// The "Paddle" class.
import java.awt.*;
import hsa.Console;

public class Paddle
{
    protected int x, y, height, width, speed;     // The output console
    protected Color clr, background;
    protected char k;
    protected Console c;


    public Paddle ()
    {
	x = 0;
	y = 0;
	height = 20;
	width = 120;
	clr = Color.black;
	background = Color.white;
	speed = 10;

    }


    public Paddle (int x1, int y1, int height1, int width1, Color clr1, int speed1)
    {
	this.x = x1;
	this.y = y1;
	this.height = height1;
	this.width = width1;
	this.clr = clr1;
	this.speed = speed1;
	background = Color.white;
    } // Another Constructor method - Method overloading


    //Communicators
    public void SetX (int x1)  // Sets the characteristics - Methods
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


    public void SetColor (Color clr1)
    {
	clr = clr1;
    }


    public Color GetColor ()
    {
	return clr;
    }


    public void SetHeight (int height1)
    {
	height = height1;
    }


    public int GetHeight ()
    {
	return height;
    }


    public void SetWidth (int width1)
    {
	width = width1;
    }


    public int GetWidth ()
    {
	return width;
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


    public void SetSpeed (int speed1)
    {
	speed = speed1;
    }


    public int GetSpeed ()
    {
	return speed;
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


    //Action
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


    //public void Move (Console c1, int x1, int y1, char k)
    public void Move (Console c1, char k)
    {
	/*c = c1;
	Erase (c1);
	SetY (y1);
	SetX (x1);
	Draw (c1);*/


	Erase (c1);
	if (k == 'w' && y > 0)
	{
	    SetY (y - speed);
	}
	else if (k == 's' && y < 500 - height - 15)
	{
	    SetY (y + speed);
	}
	Draw (c1);
    }
} // Paddle class
