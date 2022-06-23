package Strings;

public class Stringswitchcase {

	public static void main(String[] args) {

		printColorUsingSwitch("red");
		printColorUsingIf("red");
		// switch case string is case sensitive
		printColorUsingSwitch("RED");
		try
		{
			printColorUsingSwitch(null);
		}
		catch(NullPointerException e)
		{
			System.out.println("Caught");
		}
	}

	private static void printColorUsingIf(String color) {
		if (color.equals("blue")) {
			System.out.println("BLUE");
		} else if (color.equals("red")) {
			System.out.println("RED");
		} else {
			System.out.println("INVALID COLOR CODE");
		}
	}

	private static void printColorUsingSwitch(String color) {
		switch (color) {
		case "blue":
			System.out.println("BLUE");
			break;
		case "red":
			System.out.println("RED");
			break;
		default:
			System.out.println("INVALID COLOR CODE");
		}
	}



}
