import java.util.*;
public class ClassExercise8_20 {

	static String[][] connect = new String[6][7];
	static boolean playerR = true;
	static Scanner input = new Scanner(System.in);
	final static int height = connect.length;
	final static int width = connect[0].length;
	public static void buildArray()
	{
		for (int r = 0; r < height; r++)
		{
			for (int c = 0; c < width; c++)
			{
				connect[r][c] = " ";
			}
				
		}
	}
	
	public static void printGame()
	{
		System.out.println("");
		for (int c = 0; c < width; c++)
		{
			System.out.print(" " + c);
		}
		System.out.println("");
		for (int r = 0; r < height; r++)
		{
			for (int c = 0; c < width; c++)
			{
				System.out.print("|" + connect[r][c]);
			}
			System.out.print("| \n");
		}
		for(int c = 0; c < width; c++)
		{
			System.out.print("--");
		}
		System.out.println("-");
	}
	public static boolean inputDisk(int col, boolean player)
	{
		String p = "";
		if (player == true)
			p = "R";
		else
			p = "Y";
		for(int r = 5; r >= 0; r--)
		{
			if (connect[r][col].equals(" "))
			{
				connect[r][col] = p;
				return true;
			}
		}
		
		return false;
	}
	
	public static void PlayGame()
	{
		int num = 0;
		boolean works = true;
		while(works)
		{
			if (playerR)
			{
				System.out.print("Drop a red disk at column (0-6): ");
				
			} else
			{
				System.out.print("Drop a yellow disk at column (0-6): ");
			}
			try
			{
			num = input.nextInt();
			
			inputDisk(num, playerR);
			playerR =!playerR;
			works = false;
			}
			catch(InputMismatchException e)
			{
				works = true;
				input.nextLine();
				System.out.println("Please enter an Integer");
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				works = true;
				input.nextLine();
				System.out.println("Please enter a number between 0 and 6");
			}
		}
		printGame();
		if (!GameOver())
		{
			PlayGame();
		} else
		{
			if (playerR)
			{
				System.out.println("Yellow Player has won!");
			}else
			{
				System.out.println("Red Player has won!");
			}
		}
	}
	
	public static boolean GameOver()
	{
		final String Empty = " ";
		
		for(int r = 0; r <height; r++)
		{
			for(int c = 0; c < width; c++)
			{
				String player = connect[r][c];
				if (player.equals(Empty))
				{
					continue;
				}
				
				if (c + 3 < width &&
					player.equals(connect[r][c+1]) &&
					player.equals(connect[r][c+2]) &&
					player.equals(connect[r][c+3]))
					return true;
				if (r + 3 < height) {
	                if (player.equals(connect[r+1][c]) && // look up
	                    player.equals(connect[r+2][c]) &&
	                    player.equals(connect[r+3][c]))
	                    return true;
	                if (c + 3 < width &&
	                    player.equals(connect[r+1][c+1]) && // look up & right
	                    player.equals(connect[r+2][c+2]) &&
	                    player.equals(connect[r+3][c+3]))
	                    return true;
	                if (c - 3 >= 0 &&
	                    player.equals(connect[r+1][c-1]) && // look up & left
	                    player.equals(connect[r+2][c-2]) &&
	                    player.equals(connect[r+3][c-3]))
	                    return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		buildArray();
		printGame();
		PlayGame();

	}
	
	

}
