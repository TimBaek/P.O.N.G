// The "PongV1" class.
import java.awt.*;
import hsa.Console;
import java.io.*;

public class PongV2
{
    static Console c;           // The output console
    static Paddle paddle1 = new Paddle ();
    static Paddle paddle2 = new Paddle ();
    static AIPaddle paddleR = new AIPaddle ();
    static ItemBox item1 = new ItemBox ();
    static ItemBox item2 = new ItemBox ();
    static Ball Ball1 = new Ball ();
    static Ball Ball2 = new Ball ();
    static int moveX, moveY, touch;
    static int speed = 10, score1 = 0, score2 = 0, highscore = 0;
    static char k, cKey, ans;
    static Font level;
    static boolean win = false, pt = false;
    static Color Green = new Color (102, 255, 102);
    static Color Brown = new Color (153, 76, 0);
    static Color Sky = new Color (127, 255, 212);
    public static void main (String[] args) throws Exception
    {
	c = new Console ();
	menu (); //Invoking the main method
    } // main method


    public static void menu () throws Exception
    {
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	Font title;
	c.setColor (Color.white);
	c.setFont (title = new Font ("Comic Sans MS", Font.BOLD, 50));
	c.drawString ("S.P.O.R.T.S", 150, 90);
	c.drawString ("P.O.N.G", 200, 140);

	//Selections
	Font button;
	c.setFont (button = new Font ("Times New Roman", Font.BOLD, 20));
	c.setColor (Color.white);

	c.drawRect (240, 180, 160, 30);
	c.drawString ("Single Player (s)", 250, 200);

	c.drawRect (240, 240, 160, 30);
	c.drawString ("Multi Player (m)", 250, 260);

	c.drawRect (240, 300, 160, 30);
	c.drawString ("Instruction (i)", 265, 320);

	c.drawRect (240, 360, 160, 30);
	c.drawString ("Quit (q)", 285, 380);

	do
	{
	    cKey = c.getChar ();
	    if (cKey == 'm' || cKey == 'M')
	    {
		IntroM ();
	    }
	    else if (cKey == 's' || cKey == 'S')
	    {
		LevelSelction ();
	    }
	    else if (cKey == 'i' || cKey == 'I')
	    {
		Instruction ();
	    }
	    else if (cKey == 'q' || cKey == 'Q')
	    {
		c.close ();
	    }
	}
	while (cKey != 'm' && cKey != 'M' && cKey != 'i' && cKey != 'I' && cKey != 'q' && cKey != 'Q' && cKey != 's' && cKey != 'S' && cKey != 'h' && cKey != 'H');
    }


    public static void LevelSelction () throws Exception
    {
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.white);
	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 40));
	c.drawString ("Level Selction", 200, 120);

	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 20));
	c.drawRect (60, 230, 150, 30);
	c.drawString ("Beginner (b)", 80, 250);

	c.drawRect (230, 230, 150, 30);
	c.drawString ("Novice (n)", 260, 250);

	c.drawRect (400, 230, 150, 30);
	c.drawString ("Expert (e)", 430, 250);

	cKey = c.getChar (); //Invoking the intros before the actual game
	if (cKey == 'B' || cKey == 'b')
	{
	    IntroB ();
	}
	else if (cKey == 'n' || cKey == 'N')
	{
	    IntroN ();
	}
	else if (cKey == 'e' || cKey == 'E')
	{
	    IntroE ();
	}
    }


    public static void IntroB () throws Exception
    {
	Font h;
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.white);
	c.setFont (h = new Font ("Comic Sans MS", Font.BOLD, 50));
	c.drawString ("Beginner Level", 140, 100);
	c.drawString ("Introduction", 170, 150);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 15));
	c.drawString ("It is 2016 Brazil World Cup.", 220, 200);
	c.drawString ("You are in the Canadian Soccer team, and it is the final round of the qualifier.", 80, 220);
	c.drawString ("If you lose this game, Canada will fail to advance to 16th round.", 120, 240);
	c.drawString ("However, if you win, Canada will advance to 16th round.", 160, 260);
	c.drawString ("G.O.O.D L.U.C.K", 250, 280);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 20));
	c.drawString ("Objective: Reach the score of 5", 180, 400);
	c.drawString ("Press any key to continue", 220, 450);

	while (true)
	{
	    if (c.isCharAvail ())
	    {
		k = c.getChar ();
		BeginnerSinglePlay ();
	    }
	}
    }


    public static void IntroN () throws Exception
    {
	Font h;
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.white);
	c.setFont (h = new Font ("Comic Sans MS", Font.BOLD, 50));
	c.drawString ("Novice Level", 170, 100);
	c.drawString ("Introduction", 170, 150);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 15));
	c.drawString ("It is 2014-2015 sesaon Stanley Cup Final.", 180, 200);
	c.drawString ("You are part of Toronto Maple Leaf, and it has been 50 years", 120, 220);
	c.drawString ("since Toronto Maple Leafs has won the Stanely Cup.", 160, 240);
	c.drawString ("If you lose this game, Toronto fails once again and will never make to the finals again.", 40, 260);
	c.drawString ("However, if you win, Toronto Maple Leafs make a history and you become the winning player.", 10, 280);
	c.drawString ("G.O.O.D L.U.C.K", 250, 300);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 20));
	c.drawString ("Objective: Reach the score of 5", 180, 400);
	c.drawString ("Press any key to continue", 220, 450);

	while (true)
	{
	    if (c.isCharAvail ())
	    {
		k = c.getChar ();
		NoviceSinglePlay ();
	    }
	}
    }


    public static void IntroE () throws Exception
    {
	Font h;
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.white);
	c.setFont (h = new Font ("Comic Sans MS", Font.BOLD, 50));
	c.drawString ("Expert Level", 165, 100);
	c.drawString ("Introduction", 170, 150);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 15));
	c.drawString ("It is 2018 Wimbledon Championships finals at the Wembley Stadium.", 80, 200);
	c.drawString ("If you are a man, you are facing Rafael Nadal.", 170, 220);
	c.drawString ("If you are a woman, you are facing Maria Sharapova.", 140, 240);
	c.drawString ("You have practiced all these days for this final .", 170, 260);
	c.drawString ("If you lose this game, you will be unable to return to the Championship.", 90, 280);
	c.drawString ("However, if you win, your name will remain forever in the history of tennis.", 80, 300);
	c.drawString ("G.O.O.D L.U.C.K", 250, 320);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 20));
	c.drawString ("Objective: Reach the score of 5", 180, 400);
	c.drawString ("Press any key to continue", 220, 450);

	while (true)
	{
	    if (c.isCharAvail ())
	    {
		k = c.getChar ();
		ExpertSinglePlay ();
	    }
	}
    }


    public static void IntroM () throws Exception
    {
	Font h;
	char ans;
	c.clear ();
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.white);
	c.setFont (h = new Font ("Comic Sans MS", Font.BOLD, 30));
	c.drawString ("Multi Player", 220, 150);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 15));
	c.drawString ("Welcome to Multi Player", 230, 200);
	c.drawString ("Unfortunately, there is no story in this section.", 160, 240);
	c.drawString ("However, you will be facing another HUMAN PLAYER!!", 140, 260);
	c.drawString ("Also, would you like to play with extra features? (y/n) ", 150, 280);

	ans = c.getChar ();
	if (ans == 'n' || ans == 'N')
	{
	    MultiPlay ();
	}
	else if (ans == 'y' || ans == 'Y')
	{
	    MultiPlay2 ();
	}
    }


    public static void Instruction () throws Exception
    {
	Font h;
	char ha;
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.white);
	c.setFont (h = new Font ("Comic Sans MS", Font.BOLD, 30));
	c.drawString ("Instruction", 220, 40);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 15));
	c.drawString ("The goal of the game is to keep the ball out of your boundary", 100, 80);
	c.drawString ("as well as being the first person to reach the score of 5.", 120, 100);
	c.drawString ("The game is divided into 2 components: Single Player and Multi Player.", 80, 120);
	c.drawString ("In Single Player, you are facing an AI, and it is divided into 3 levels: Beginner, Novice, Expert", 20, 140);
	c.drawString ("Higher the level, more difficult it is and extra features are added", 90, 160);
	c.drawString ("In Multi Player, it is Player vs Player without any additions", 120, 180);

	c.setFont (h = new Font ("Comic Sans MS", Font.BOLD, 30));
	c.drawString ("Controls", 240, 250);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 15));
	c.drawString ("Player 1", 140, 280);
	c.drawString ("W - Up", 140, 320);
	c.drawString ("S - Down", 140, 360);
	c.drawString ("Player 2", 400, 280);
	c.drawString ("O - Up", 400, 320);
	c.drawString ("L - Down", 400, 360);

	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 20));
	c.drawString ("Press m to return to menu", 200, 450);

	while (true)
	{
	    if (c.isCharAvail ())
	    {
		k = c.getChar ();
		if (k == 'm' || k == 'M')
		{
		    menu ();
		}
	    }
	}
    }


    public static void BeginnerSinglePlay () throws Exception
    {
	c.clear ();
	c.setColor (Green);
	c.fillRect (0, 0, 640, 500);

	paddle1.SetColor (Color.red);
	paddle1.SetWidth (20);
	paddle1.SetHeight (100);
	paddle1.SetSpeed (30);
	paddle1.SetBackground (Green);
	paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
	paddle1.Draw (c);

	paddleR.SetColour (Color.cyan);
	paddleR.SetWidth (20);
	paddleR.SetHeight (100);
	paddleR.Setspeed (5);
	paddleR.SetBackground (Green);
	paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
	paddleR.SetX (640 - paddleR.GetWidth ());
	paddleR.Draw (c);

	Ball1.SetRadius (10);
	Ball1.SetColour (Color.yellow);
	Ball1.SetX (paddleR.GetWidth () + Ball1.GetRadius ());
	Ball1.SetY (500 / 2);
	Ball1.Draw (c);
	Ball1.SetBackground (Green);

	c.setColor (Color.white);
	int a = 0;
	for (int i = 0 ; i < 10 ; i++)
	{
	    c.fillRect (310, a, 10, 40);
	    a += 50;
	}
	int move = 1;
	do
	{
	    do
	    {
		Ball1.SetVertical ((int) (Math.random () * 7) - 3); //Setting the ball's beginning direction
	    }
	    while (Ball1.GetVertical () == 0);

	    k = c.getChar ();
	    while (true)
	    {
		Ball1.Move (c);
		paddle1.Draw (c);
		paddleR.Draw (c);
		Thread.sleep (speed); //Ball speed

		c.setColor (Color.white);
		int q = 0;
		for (int i = 0 ; i < 10 ; i++)
		{
		    c.fillRect (310, q, 10, 40);
		    q += 50;
		}

		c.setColor (Color.blue);
		c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		c.drawString (score1 + "      " + score2, 250, 80);

		paddleR.Draw (c);

		if (c.isCharAvail ())
		{
		    k = c.getChar ();

		    if (k == 's')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }

		    else if (k == 'w')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }
		}
		paddleR.Erase (c);
		paddleR.Move (c, paddleR.GetX (), paddleR.GetY () + (move * paddleR.Getspeed ())); //Moving the AIpaddle down first
		if (paddleR.isTouching (paddleR.GetX (), 500, c))
		{
		    move = -1; //move up
		}
		if (paddleR.isTouching (paddleR.GetX (), 0, c))
		{
		    move = 1; // move down
		}

		if (Ball1.GetY () > 500 - Ball1.GetRadius ()) //Condition when the ball reaches Bottom screen
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball1.GetY () < 0 + Ball1.GetRadius ()) //Condition when the ball reaches Top screen
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball1.GetX () > 700) //Out of the screen
		{
		    if (score1 == 4)
		    {
			win = true;
			HighScore (); //Calculate high scroe
			P1WinMsg (); //Output message
		    }
		    score1++; //Add Player 1's Score
		    speed = 10; //Reset the ball speed

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
		    paddleR.SetX (640 - paddleR.GetWidth ());

		    c.clear ();
		    c.setColor (Green);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int j = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, j, 10, 40);
			j += 50;
		    }
		    c.setColor (Color.blue);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetY (500 / 2);
		    Ball1.SetX (640 - paddleR.GetWidth () - Ball1.GetRadius ());
		    Ball1.Draw (c);
		    Thread.sleep (300);
		    Ball1.Move (c);
		}

		else if (Ball1.GetX () < -60) //Out of the screen
		{
		    if (score2 == 4)
		    {
			win = false;
			HighScore (); //Calculate high score
			P2WinMsg (); //Output message
		    }
		    score2++; //Add Player 2's score
		    speed = 10; //Reset speed

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
		    paddleR.SetX (640 - paddleR.GetWidth ());

		    c.clear ();
		    c.setColor (Green);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int h = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, h, 10, 40);
			h += 50;
		    }
		    c.setColor (Color.blue);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetY (500 / 2);
		    Ball1.SetX (paddleR.GetWidth () + Ball1.GetRadius ());
		    Ball1.Draw (c);
		    k = c.getChar ();
		    Ball1.Move (c);
		}

		else if (paddle1.isTouching (Ball1.GetX () - Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () < 0)
		{
		    touch++;
		    paddle1.GetX ();
		    paddle1.GetY ();
		    paddle1.Draw (c);

		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);

		}
		else if (paddleR.isTouching (Ball1.GetX () + Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () > 0)
		{
		    touch++;
		    paddleR.GetX ();
		    paddleR.GetY ();
		    paddleR.Draw (c);

		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (touch == 5)
		{
		    touch = 0;
		    do
		    {
			speed--;
		    }
		    while (speed < 1);
		}
	    }
	}
	while (score1 > 5 || score2 > 5);
    }


    public static void NoviceSinglePlay () throws Exception
    {
	c.clear ();
	c.setColor (Sky);
	c.fillRect (0, 0, 640, 500);

	paddle1.SetColor (Color.green);
	paddle1.SetWidth (20);
	paddle1.SetHeight (100);
	paddle1.SetSpeed (30);
	paddle1.SetBackground (Sky);
	paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
	paddle1.Draw (c);

	paddleR.SetColour (Color.red);
	paddleR.SetWidth (20);
	paddleR.SetHeight (100);
	paddleR.Setspeed (2);
	paddleR.SetBackground (Sky);
	paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
	paddleR.SetX (640 - paddleR.GetWidth ());
	paddleR.Draw (c);

	Ball1.SetRadius (10);
	Ball1.SetColour (Color.yellow);
	Ball1.SetX (paddleR.GetWidth () + Ball1.GetRadius ());
	Ball1.SetY (500 / 2);
	Ball1.Draw (c);
	Ball1.SetBackground (Sky);

	Ball2.SetRadius (10);
	Ball2.SetColour (Color.red);
	Ball2.SetX (640 - paddleR.GetWidth () - Ball1.GetRadius ());
	Ball2.SetY (500 / 2);
	Ball2.Draw (c);
	Ball2.SetBackground (Sky);

	c.setColor (Color.white);
	int a = 0;
	for (int i = 0 ; i < 10 ; i++)
	{
	    c.fillRect (310, a, 10, 40);
	    a += 50;
	}

	do
	{
	    do
	    {
		Ball1.SetVertical ((int) (Math.random () * 7) - 3);
	    }
	    while (Ball1.GetVertical () == 0);

	    Ball2.SetHorizontal (-2);
	    do
	    {
		Ball2.SetVertical ((int) (Math.random () * 7) - 3);
	    }
	    while (Ball2.GetVertical () == 0);

	    k = c.getChar ();
	    while (true)
	    {
		Ball1.Move (c);
		Ball2.Move (c);
		paddle1.Draw (c);
		paddleR.Draw (c);
		Thread.sleep (speed);

		c.setColor (Color.white);
		int q = 0;
		for (int i = 0 ; i < 10 ; i++)
		{
		    c.fillRect (310, q, 10, 40);
		    q += 50;
		}

		c.setColor (Color.black);
		c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		c.drawString (score1 + "      " + score2, 250, 80);

		if (c.isCharAvail ())
		{
		    k = c.getChar ();

		    if (k == 's')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }

		    else if (k == 'w')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }
		}

		if (Ball1.GetY () < (paddleR.GetY () + (paddleR.GetHeight () / 3 * 2))) //AI paddle movement
		{
		    if (paddleR.GetY () - paddleR.Getspeed () >= 0)
		    {
			paddleR.Move (c, paddleR.GetX (), paddleR.GetY () - paddleR.Getspeed ());

		    }
		    else
		    {
			paddleR.Move (c, paddleR.GetX (), 0);
		    }
		}
		else if (Ball1.GetY () > (paddleR.GetY () + (paddleR.GetHeight () / 3 * 2))) //AI paddle movement
		{
		    if (paddleR.GetY () + paddleR.Getspeed () <= (500 - paddleR.GetHeight ()))
		    {
			paddleR.Move (c, paddleR.GetX (), paddleR.GetY () + paddleR.Getspeed ());
		    }
		    else
		    {
			paddleR.Move (c, paddleR.GetX (), 500 - paddleR.GetHeight ());
		    }
		}
		else if (Ball2.GetY () < (paddleR.GetY () + (paddleR.GetHeight () / 3 * 2))) //AI paddle movement
		{
		    if (paddleR.GetY () - paddleR.Getspeed () >= 0)
		    {
			paddleR.Move (c, paddleR.GetX (), paddleR.GetY () - paddleR.Getspeed ());
		    }
		    else
		    {
			paddleR.Move (c, paddleR.GetX (), 0);
		    }
		}
		else if (Ball2.GetY () > (paddleR.GetY () + (paddleR.GetHeight () / 3 * 2))) //AI paddle movement
		{
		    if (paddleR.GetY () + paddleR.Getspeed () <= (500 - paddleR.GetHeight ()))
		    {
			paddleR.Move (c, paddleR.GetX (), paddleR.GetY () + paddleR.Getspeed ());
		    }
		    else
		    {
			paddleR.Move (c, paddleR.GetX (), 500 - paddleR.GetHeight ());
		    }
		}

		if (Ball1.GetY () > 500 - Ball1.GetRadius ())
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball1.GetY () < 0 + Ball1.GetRadius ())
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball2.GetY () > 500 - Ball2.GetRadius ())
		{
		    Ball2.SetVertical (-1 * Ball2.GetVertical ());
		    Ball2.SetHorizontal (Ball2.GetHorizontal ());
		    Ball2.Move (c);
		}
		else if (Ball2.GetY () < 0 + Ball2.GetRadius ())
		{
		    Ball2.SetVertical (-1 * Ball2.GetVertical ());
		    Ball2.SetHorizontal (Ball2.GetHorizontal ());
		    Ball2.Move (c);
		}

		else if (Ball1.GetX () > 700 || Ball2.GetX () > 700)
		{
		    if (score1 == 4)
		    {
			win = true;
			HighScore ();
			P1WinMsg ();
		    }
		    score1++;
		    speed = 10;

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
		    paddleR.SetX (640 - paddleR.GetWidth ());

		    c.clear ();
		    c.setColor (Sky);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int j = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, j, 10, 40);
			j += 50;
		    }
		    c.setColor (Color.black);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetX (paddleR.GetWidth () + Ball1.GetRadius ());
		    Ball1.SetY (500 / 2);
		    Ball1.Draw (c);

		    Ball2.SetX (640 - paddleR.GetWidth () - Ball1.GetRadius ());
		    Ball2.SetY (500 / 2);
		    Ball2.Draw (c);
		    k = c.getChar ();
		    Ball1.Move (c);
		    Ball2.Move (c);
		}

		else if (Ball1.GetX () < -60 || Ball2.GetX () < -60)
		{
		    if (score2 == 4)
		    {
			win = false;
			HighScore ();
			P2WinMsg ();
		    }
		    score2++;
		    speed = 10;

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
		    paddleR.SetX (640 - paddleR.GetWidth ());

		    c.clear ();
		    c.setColor (Sky);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int h = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, h, 10, 40);
			h += 50;
		    }
		    c.setColor (Color.black);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetX (paddleR.GetWidth () + Ball1.GetRadius ());
		    Ball1.SetY (500 / 2);
		    Ball1.Draw (c);

		    Ball2.SetX (640 - paddleR.GetWidth () - Ball1.GetRadius ());
		    Ball2.SetY (500 / 2);
		    Ball2.Draw (c);
		    k = c.getChar ();
		    Ball1.Move (c);
		    Ball2.Move (c);
		}
		else if (Ball1.GetX () > 700 && Ball2.GetX () < -60)
		{
		    speed = 10;

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
		    paddleR.SetX (640 - paddleR.GetWidth ());

		    c.clear ();
		    c.setColor (Sky);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int j = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, j, 10, 40);
			j += 50;
		    }
		    c.setColor (Color.black);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetX (paddleR.GetWidth () + Ball1.GetRadius ());
		    Ball1.SetY (500 / 2);
		    Ball1.Draw (c);

		    Ball2.SetX (640 - paddleR.GetWidth () - Ball1.GetRadius ());
		    Ball2.SetY (500 / 2);
		    Ball2.Draw (c);
		    k = c.getChar ();
		    Ball1.Move (c);
		    Ball2.Move (c);
		}
		else if (Ball1.GetX () < -60 && Ball2.GetX () > 700)
		{
		    speed = 10;

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
		    paddleR.SetX (640 - paddleR.GetWidth ());

		    c.clear ();
		    c.setColor (Sky);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int j = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, j, 10, 40);
			j += 50;
		    }
		    c.setColor (Color.black);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetX (paddleR.GetWidth () + Ball1.GetRadius ());
		    Ball1.SetY (500 / 2);
		    Ball1.Draw (c);

		    Ball2.SetX (640 - paddleR.GetWidth () - Ball1.GetRadius ());
		    Ball2.SetY (500 / 2);
		    Ball2.Draw (c);
		    k = c.getChar ();
		    Ball1.Move (c);
		    Ball2.Move (c);
		}

		else if (paddle1.isTouching (Ball1.GetX () - Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () < 0)
		{
		    touch++;
		    paddle1.GetX ();
		    paddle1.GetY ();
		    paddle1.Draw (c);

		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);

		}
		else if (paddleR.isTouching (Ball1.GetX () + Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () > 0)
		{
		    touch++;
		    paddleR.GetX ();
		    paddleR.GetY ();
		    paddleR.Draw (c);

		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);

		}
		else if (paddle1.isTouching (Ball2.GetX () - Ball2.GetRadius (), Ball2.GetY (), c) && Ball2.GetHorizontal () < 0)
		{
		    touch++;
		    ranclr ();
		    Ball2.SetVertical (Ball2.GetVertical ());
		    Ball2.SetHorizontal (-1 * Ball2.GetHorizontal ());
		    Ball2.Move (c);

		}
		else if (paddleR.isTouching (Ball2.GetX () + Ball2.GetRadius (), Ball2.GetY (), c) && Ball2.GetHorizontal () > 0)
		{
		    touch++;
		    ranclr ();
		    Ball2.SetVertical (Ball2.GetVertical ());
		    Ball2.SetHorizontal (-1 * Ball2.GetHorizontal ());
		    Ball2.Move (c);

		}

		else if (touch == 10)
		{
		    touch = 0;
		    do
		    {
			speed--;
		    }
		    while (speed < 1);
		}
	    }
	}
	while (score1 > 5 || score2 > 5);
    }


    public static void ExpertSinglePlay () throws Exception
    {
	c.clear ();
	c.setColor (Green);
	c.fillRect (0, 0, 640, 500);

	paddle1.SetColor (Brown);
	paddle1.SetWidth (20);
	paddle1.SetHeight (100);
	paddle1.SetSpeed (30);
	paddle1.SetBackground (Green);
	paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
	paddle1.Draw (c);

	paddleR.SetColour (Color.cyan);
	paddleR.SetWidth (20);
	paddleR.SetHeight (150);
	paddleR.Setspeed (2);
	paddleR.SetBackground (Green);
	paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
	paddleR.SetX (640 - paddleR.GetWidth ());
	paddleR.Draw (c);

	Ball1.SetRadius (10);
	Ball1.SetColour (Color.yellow);
	Ball1.SetX (paddleR.GetWidth () + Ball1.GetRadius ());
	Ball1.SetY (500 / 2);
	Ball1.Draw (c);
	Ball1.SetBackground (Green);

	item1.SetColour (Color.red);

	c.setColor (Color.white);
	int a = 0;
	for (int i = 0 ; i < 10 ; i++)
	{
	    c.fillRect (310, a, 10, 40);
	    a += 50;
	}

	do
	{
	    do
	    {
		Ball1.SetVertical ((int) (Math.random () * 7) - 3);
	    }
	    while (Ball1.GetVertical () == 0);

	    k = c.getChar ();
	    while (true)
	    {
		Ball1.Move (c);
		paddle1.Draw (c);
		paddleR.Draw (c);
		Thread.sleep (speed);

		c.setColor (Color.white);
		int q = 0;
		for (int i = 0 ; i < 10 ; i++)
		{
		    c.fillRect (310, q, 10, 40);
		    q += 50;
		}

		c.setColor (Color.blue);
		c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		c.drawString (score1 + "      " + score2, 250, 80);

		paddleR.Draw (c);

		if (c.isCharAvail ())
		{
		    k = c.getChar ();

		    if (k == 's')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }

		    else if (k == 'w')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }
		}
		paddleR.Erase (c);
		if (Ball1.GetY () < (paddleR.GetY () + ((paddleR.GetHeight () / 3 * 2)))) //AI paddle movement
		{
		    if (paddleR.GetY () - paddleR.Getspeed () >= 0)
		    {
			paddleR.Move (c, paddleR.GetX (), paddleR.GetY () - paddleR.Getspeed ());

		    }
		    else
		    {
			paddleR.Move (c, paddleR.GetX (), 0);
		    }
		}
		else if (Ball1.GetY () > (paddleR.GetY () + (paddleR.GetHeight () / 3 * 2))) //AI paddle movement
		{
		    if (paddleR.GetY () + paddleR.Getspeed () <= (500 - paddleR.GetHeight ()))
		    {
			paddleR.Move (c, paddleR.GetX (), paddleR.GetY () + paddleR.Getspeed ());
		    }
		    else
		    {
			paddleR.Move (c, paddleR.GetX (), 500 - paddleR.GetHeight ());
		    }
		}

		if (Ball1.GetY () > 500 - Ball1.GetRadius ())
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball1.GetY () < 0 + Ball1.GetRadius ())
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball1.GetX () > 700)
		{
		    if (score1 == 4)
		    {
			win = true;
			HighScore ();
			P1WinMsg ();
		    }
		    score1++;
		    speed = 10;

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
		    paddleR.SetX (640 - paddleR.GetWidth ());

		    c.clear ();
		    c.setColor (Green);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int j = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, j, 10, 40);
			j += 50;
		    }
		    c.setColor (Color.blue);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetY (500 / 2);
		    Ball1.SetX (640 - paddleR.GetWidth () - Ball1.GetRadius ());
		    Ball1.Draw (c);
		    Thread.sleep (300);
		    Ball1.Move (c);
		}

		else if (Ball1.GetX () < -60)
		{

		    if (score2 == 4)
		    {
			win = false;
			HighScore ();
			P2WinMsg ();
		    }
		    score2++;
		    speed = 10;

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
		    paddleR.SetX (640 - paddleR.GetWidth ());

		    c.clear ();
		    c.setColor (Green);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int h = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, h, 10, 40);
			h += 50;
		    }
		    c.setColor (Color.blue);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetY (500 / 2);
		    Ball1.SetX (paddleR.GetWidth () + Ball1.GetRadius ());
		    Ball1.Draw (c);
		    k = c.getChar ();
		    Ball1.Move (c);
		}

		else if (paddle1.isTouching (Ball1.GetX () - Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () < 0)
		{
		    touch++;
		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (paddleR.isTouching (Ball1.GetX () + Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () > 0)
		{
		    touch++;
		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (touch == 5)
		{
		    touch = 0;
		    do
		    {
			speed--;
		    }
		    while (speed < 1);
		}
	    }
	}
	while (score1 > 5 || score2 > 5);
    }


    public static void MultiPlay () throws Exception
    {
	c.clear ();
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	paddle1.SetColor (Color.green);
	paddle1.SetWidth (20);
	paddle1.SetHeight (100);
	paddle1.SetSpeed (30);
	paddle1.SetBackground (Color.black);
	paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
	paddle1.Draw (c);

	paddle2.SetColor (Color.cyan);
	paddle2.SetWidth (20);
	paddle2.SetHeight (100);
	paddle2.SetSpeed (30);
	paddle2.SetBackground (Color.black);
	paddle2.SetY ((500 - paddle2.GetHeight ()) / 2);
	paddle2.SetX (640 - paddle2.GetWidth ());
	paddle2.Draw (c);

	Ball1.SetRadius (10);
	Ball1.SetColour (Color.yellow);
	Ball1.SetX (paddle2.GetWidth () + Ball1.GetRadius ());
	Ball1.SetY (500 / 2);
	Ball1.Draw (c);
	Ball1.SetBackground (Color.black);

	c.setColor (Color.white);
	int a = 0;
	for (int i = 0 ; i < 10 ; i++)
	{
	    c.fillRect (310, a, 10, 40);
	    a += 50;
	}

	do
	{
	    do
	    {
		Ball1.SetVertical ((int) (Math.random () * 7) - 3);
	    }
	    while (Ball1.GetVertical () == 0);

	    k = c.getChar ();
	    while (true)
	    {
		Ball1.Move (c);
		paddle1.Draw (c);
		paddle2.Draw (c);
		Thread.sleep (speed); //Ball Speed

		c.setColor (Color.white);
		int q = 0;
		for (int i = 0 ; i < 10 ; i++)
		{
		    c.fillRect (310, q, 10, 40);
		    q += 50;
		}

		c.setColor (Color.yellow);
		c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		c.drawString (score1 + "      " + score2, 250, 80);

		if (c.isCharAvail ())
		{
		    k = c.getChar ();

		    if (k == 's')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }

		    else if (k == 'w')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }

		    else if (k == 'l')
		    {
			k = 's';
			Thread.sleep (3);
			paddle2.Move (c, k);
		    }
		    else if (k == 'o')
		    {
			c.setColor (Color.white);
			k = 'w';
			Thread.sleep (3);
			paddle2.Move (c, k);
		    }
		}

		if (Ball1.GetY () > 500 - Ball1.GetRadius ())
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball1.GetY () < 0 + Ball1.GetRadius ())
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball1.GetX () > 700)
		{
		    if (score1 == 4)
		    {
			P1MultiWinMsg ();
		    }
		    score1++;
		    speed = 10;

		    c.clear ();
		    c.setColor (Color.black);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int j = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, j, 10, 40);
			j += 50;
		    }
		    c.setColor (Color.yellow);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddle2.SetY ((500 - paddle2.GetHeight ()) / 2);
		    paddle2.SetX (640 - paddle2.GetWidth ());

		    paddle1.Draw (c);
		    paddle2.Draw (c);

		    Ball1.SetY (500 / 2);
		    Ball1.SetX (640 - paddle2.GetWidth () - Ball1.GetRadius ());
		    Ball1.Draw (c);

		    k = c.getChar ();
		    Ball1.Move (c);
		}

		else if (Ball1.GetX () < -60)
		{
		    if (score2 == 4)
		    {
			P2MultiWinMsg ();
		    }
		    score2++;
		    speed = 10;

		    c.clear ();
		    c.setColor (Color.black);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int h = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, h, 10, 40);
			h += 50;
		    }
		    c.setColor (Color.yellow);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddle2.SetY ((500 - paddle2.GetHeight ()) / 2);
		    paddle2.SetX (640 - paddle2.GetWidth ());

		    paddle1.Draw (c);
		    paddle2.Draw (c);

		    Ball1.SetY (500 / 2);
		    Ball1.SetX (paddle2.GetWidth () + Ball1.GetRadius ());
		    Ball1.Draw (c);

		    k = c.getChar ();
		    Ball1.Move (c);
		}

		else if (paddle1.isTouching (Ball1.GetX () - Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () < 0)
		{
		    touch++;
		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (paddle2.isTouching (Ball1.GetX () + Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () > 0)
		{
		    touch++;
		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (touch == 5)
		{
		    touch = 0;
		    do
		    {
			speed--;
		    }
		    while (speed < 1);
		}
	    }
	}
	while (score1 > 5 || score2 > 5);
    }


    public static void MultiPlay2 () throws Exception
    {
	int move = 1;
	c.clear ();
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	paddle1.SetColor (Color.green);
	paddle1.SetWidth (20);
	paddle1.SetHeight (100);
	paddle1.SetSpeed (30);
	paddle1.SetBackground (Color.black);
	paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
	paddle1.Draw (c);

	paddle2.SetColor (Color.cyan);
	paddle2.SetWidth (20);
	paddle2.SetHeight (100);
	paddle2.SetSpeed (30);
	paddle2.SetBackground (Color.black);
	paddle2.SetY ((500 - paddle2.GetHeight ()) / 2);
	paddle2.SetX (640 - paddle2.GetWidth ());
	paddle2.Draw (c);

	paddleR.SetColour (Color.red);
	paddleR.SetWidth (10);
	paddleR.SetHeight (150);
	paddleR.Setspeed (2);
	paddleR.SetBackground (Color.black);
	paddleR.SetY ((500 - paddleR.GetHeight ()) / 2);
	paddleR.SetX (310);
	paddleR.Draw (c);

	Ball1.SetRadius (10);
	Ball1.SetColour (Color.yellow);
	Ball1.SetX (paddle2.GetWidth () + Ball1.GetRadius ());
	Ball1.SetY (500 / 2);
	Ball1.Draw (c);
	Ball1.SetBackground (Color.black);

	c.setColor (Color.white);
	int a = 0;
	for (int i = 0 ; i < 10 ; i++)
	{
	    c.fillRect (310, a, 10, 40);
	    a += 50;
	}


	do
	{
	    do
	    {
		Ball1.SetVertical ((int) (Math.random () * 7) - 3);
	    }
	    while (Ball1.GetVertical () == 0);

	    k = c.getChar ();
	    while (true)
	    {
		Ball1.Move (c);
		paddle1.Draw (c);
		paddle2.Draw (c);
		paddleR.Draw (c);
		Thread.sleep (speed); //Ball Speed

		c.setColor (Color.white);
		int q = 0;
		for (int i = 0 ; i < 10 ; i++)
		{
		    c.fillRect (310, q, 10, 40);
		    q += 50;
		}

		c.setColor (Color.yellow);
		c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		c.drawString (score1 + "      " + score2, 250, 80);

		if (c.isCharAvail ())
		{
		    k = c.getChar ();

		    if (k == 's')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }

		    else if (k == 'w')
		    {
			Thread.sleep (3);
			paddle1.Move (c, k);
		    }

		    else if (k == 'l')
		    {
			k = 's';
			Thread.sleep (3);
			paddle2.Move (c, k);
		    }
		    else if (k == 'o')
		    {
			c.setColor (Color.white);
			k = 'w';
			Thread.sleep (3);
			paddle2.Move (c, k);
		    }
		}
		paddleR.Erase (c);
		paddleR.Move (c, paddleR.GetX (), paddleR.GetY () + (move * paddleR.Getspeed ()));
		if (paddleR.isTouching (paddleR.GetX (), 500, c))
		{
		    move = -1;
		}
		if (paddleR.isTouching (paddleR.GetX (), 0, c))
		{
		    move = 1;
		}
		if (Ball1.GetY () > 500 - Ball1.GetRadius ())
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball1.GetY () < 0 + Ball1.GetRadius ())
		{
		    Ball1.SetVertical (-1 * Ball1.GetVertical ());
		    Ball1.SetHorizontal (Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (Ball1.GetX () > 700)
		{
		    if (score1 == 4)
		    {
			P1MultiWinMsg ();
		    }
		    score1++;
		    speed = 10;

		    c.clear ();
		    c.setColor (Color.black);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int j = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, j, 10, 40);
			j += 50;
		    }
		    c.setColor (Color.yellow);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddle2.SetY ((500 - paddle2.GetHeight ()) / 2);
		    paddle2.SetX (640 - paddle2.GetWidth ());

		    paddle1.Draw (c);
		    paddle2.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetY (500 / 2);
		    Ball1.SetX (640 - paddle2.GetWidth () - Ball1.GetRadius ());
		    Ball1.Draw (c);

		    k = c.getChar ();
		    Ball1.Move (c);
		}

		else if (Ball1.GetX () < -60)
		{
		    if (score2 == 4)
		    {
			P2MultiWinMsg ();
		    }
		    score2++;
		    speed = 10;

		    c.clear ();
		    c.setColor (Color.black);
		    c.fillRect (0, 0, 640, 500);

		    c.setColor (Color.white);
		    int h = 0;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			c.fillRect (310, h, 10, 40);
			h += 50;
		    }
		    c.setColor (Color.yellow);
		    c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
		    c.drawString (score1 + "      " + score2, 250, 80);

		    paddle1.SetY ((500 - paddle1.GetHeight ()) / 2);
		    paddle2.SetY ((500 - paddle2.GetHeight ()) / 2);
		    paddle2.SetX (640 - paddle2.GetWidth ());

		    paddle1.Draw (c);
		    paddle2.Draw (c);
		    paddleR.Draw (c);

		    Ball1.SetY (500 / 2);
		    Ball1.SetX (paddle2.GetWidth () + Ball1.GetRadius ());
		    Ball1.Draw (c);

		    k = c.getChar ();
		    Ball1.Move (c);
		}

		else if (paddle1.isTouching (Ball1.GetX () - Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () < 0)
		{
		    touch++;
		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (paddle2.isTouching (Ball1.GetX () + Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () > 0)
		{
		    touch++;
		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (paddleR.isTouching (Ball1.GetX () - Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () < 0)
		{
		    touch++;
		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (paddleR.isTouching (Ball1.GetX () + Ball1.GetRadius (), Ball1.GetY (), c) && Ball1.GetHorizontal () > 0)
		{
		    touch++;
		    ranclr ();
		    Ball1.SetVertical (Ball1.GetVertical ());
		    Ball1.SetHorizontal (-1 * Ball1.GetHorizontal ());
		    Ball1.Move (c);
		}
		else if (touch == 5)
		{
		    touch = 0;
		    do
		    {
			speed--;
		    }
		    while (speed < 1);
		}
	    }
	}
	while (score1 > 5 || score2 > 5);
    }



    public static void ranclr () throws Exception
    {
	int R = (int) (Math.random () * 230) + 10;
	int G = (int) (Math.random () * 230) + 10;
	int B = (int) (Math.random () * 230) + 10;
	Color ball = new Color (R, G, B);
	Ball1.SetColour (ball);
	int R1 = (int) (Math.random () * 230) + 10;
	int G1 = (int) (Math.random () * 230) + 10;
	int B1 = (int) (Math.random () * 230) + 10;
	Color ball2 = new Color (R1, G1, B1);
	Ball2.SetColour (ball2);
    }


    public static void HighScore ()
    {
	if (win = true)
	{
	    highscore = (((score1 - score2) * 100) * speed);
	}


	else if (win = false)
	{
	    highscore = (((score2 - score1) * 10) * 10);
	}
    }


    public static void P1WinMsg () throws Exception
    {
	c.clear ();
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.red);
	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
	c.drawString ("GAME OVER!", 160, 200);
	c.setColor (Color.green);
	c.drawString ("You Won!", 220, 280);
	c.drawString ("Score: " + highscore, 210, 340);
	c.setColor (Color.red);
	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 30));
	c.drawString ("Would you like to return to menu? (y/n)", 80, 400);
	ans = c.getChar ();
	score1 = 0;
	score2 = 0;
	while (ans == 'y' && ans == 'Y' && ans == 'n' && ans == 'N')
	{
	    ans = c.getChar ();
	}


	if (ans == 'y' || ans == 'Y')
	{
	    menu ();
	}


	else if (ans == 'n' || ans == 'N')
	{
	    c.close ();
	}
    }


    public static void P1MultiWinMsg () throws Exception
    {
	c.clear ();
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.red);
	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
	c.drawString ("GAME OVER!", 160, 200);
	c.setColor (Color.green);
	c.drawString ("Player 1 Wins", 180, 300);
	c.setColor (Color.red);
	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 30));
	c.drawString ("Would you like to return to menu? (y/n)", 80, 400);
	ans = c.getChar ();

	score1 = 0;
	score2 = 0;
	while (ans == 'y' && ans == 'Y' && ans == 'n' && ans == 'N')
	{
	    ans = c.getChar ();
	}


	if (ans == 'y' || ans == 'Y')
	{
	    menu ();
	}


	else if (ans == 'n' || ans == 'N')
	{
	    c.close ();
	}
    }


    public static void P2WinMsg () throws Exception
    {
	c.clear ();
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.red);
	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
	c.drawString ("GAME OVER!", 160, 200);
	c.setColor (Color.cyan);
	c.drawString ("You Lost!", 220, 280);
	c.drawString ("Score: " + highscore, 210, 340);
	c.setColor (Color.red);
	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 30));
	c.drawString ("Would you like to return to menu? (y/n)", 100, 400);

	ans = c.getChar ();
	score1 = 0;
	score2 = 0;
	while (ans == 'y' && ans == 'Y' && ans == 'n' && ans == 'N')
	{
	    ans = c.getChar ();
	}


	if (ans == 'y' || ans == 'Y')
	{
	    menu ();
	}


	else if (ans == 'n' || ans == 'N')
	{
	    c.close ();
	}
    }


    public static void P2MultiWinMsg () throws Exception
    {
	c.clear ();
	c.setColor (Color.black);
	c.fillRect (0, 0, 640, 500);

	score1 = 0;
	score2 = 0;
	c.setColor (Color.red);
	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 50));
	c.drawString ("GAME OVER!", 160, 200);
	c.setColor (Color.cyan);
	c.drawString ("Player 2 Wins", 180, 300);
	c.setColor (Color.red);
	c.setFont (level = new Font ("Times New Roman", Font.BOLD, 30));
	c.drawString ("Would you like to return to menu? (y/n)", 100, 400);
	ans = c.getChar ();
	score1 = 0;
	score2 = 0;
	while (ans == 'y' && ans == 'Y' && ans == 'n' && ans == 'N')
	{
	    ans = c.getChar ();
	}


	if (ans == 'y' || ans == 'Y')
	{
	    menu ();
	}


	else if (ans == 'n' || ans == 'N')
	{
	    c.close ();
	}
    }
} // PongV1 class


