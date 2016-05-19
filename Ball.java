// The "Ball" class.
import java.awt.*;
import hsa.Console;

public class Ball
{

    //Characteristics of the object

    protected int x, y, radius, speed, score, iHorizontal, iVertical; // Variables
    protected Color clr, background;
    protected Console c;

    public Ball ()  // Constructor method where values are being initialized
    {
	x = 320;
	y = 240;
	radius = 50;
	speed = 10;
	iHorizontal = 2;
	do
	{
	    iVertical = (int) (Math.random () * 11) - 5;
	}
	while (iVertical == 0);
	clr = Color.black;
	background = Color.white;
	score = 0;
    } // Constructor method


    public Ball (int x1, int y1, int rad1, Color clr1, int iH, int iV)
	//Method overloading - 2 methods with the same name but has either
	// Different parameters or number of parameters
    {
	this.x = x1;
	this.y = y1;
	this.radius = rad1;
	//this.speed = speed1;
	this.clr = clr1;
	this.iHorizontal = iH;
	this.iVertical = iV;
	background = Color.white;
    } // Another Constructor method - Method overloading


    //Communicators - to set the values and to get the values of characteristics

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


    public void SetRadius (int rad1)
    {
	radius = rad1;
    }


    public int GetRadius ()
    {
	return radius;
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


    //Action

    public void Draw (Console c1)  // Example of an action
    {
	c = c1;
	int x0 = x - radius;
	int y0 = y - radius;
	c.setColor (clr);
	c.fillOval (x0, y0, 2 * radius, 2 * radius);
    }


    public void Erase (Console c1)
    {
	c = c1;
	int x0 = x - radius;
	int y0 = y - radius;
	c.setColor (background);
	c.fillOval (x0, y0, 2 * radius, 2 * radius);
    }


    public void Move (Console c1)
    {
	Erase (c1);
	SetX (GetX () + GetHorizontal ());
	SetY (GetY () + GetVertical ());
	Draw (c1);


    }
} // Ball class

