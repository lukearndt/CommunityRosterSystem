package views;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A class used to export all IO functionality out of the UI. All methods are
 * static.
 * 
 * @author Deborah Harrington & Luke Arndt
 * @version 22 May 2011
 */
public abstract class IO
{
	public static final boolean singleQuoteIsAllowed = true;
	public static final boolean singleQuoteIsForbidden = false;
	private static final SimpleDateFormat DATA_DATE_FORMAT = new SimpleDateFormat(
			"dd/MM/yyyy");
	private static BufferedReader myReader = new BufferedReader(
			new InputStreamReader(System.in));
	private static PrintWriter myPrintWriter;

	/**
	 * Takes a date and formats it to be consistent with the data format used
	 * for this application's file IO
	 * 
	 * @param aDate
	 * @return String - The formatted date
	 */
	public static String formatDate(Date aDate)
	{
		return DATA_DATE_FORMAT.format(aDate);
	}

	/**
	 * Used to get a date from a user via console interaction
	 * 
	 * @param msgLine
	 *            The message to display to the user when collecting the input
	 * @param errMsg
	 *            The message to display to users who mess it up
	 * @return the Date that we got from the user
	 */
	public static Date getDate(String msgLine, String errMsg)
	{
		Date dateReturn = null;
		while (true)
		{
			try
			{
				dateReturn = parseDate(getString(msgLine, IO.singleQuoteIsAllowed, true));
				break;
			} catch (ParseException ex)
			{
				say(errMsg);
			}
		}
		return dateReturn;
	}

	/**
	 * Returns an operating system specific delimiter string
	 */
	public static String getDelimiterForOS()
	{
		String delim = "\n";
		try
		{
			delim = System.getProperty("line.separator");
		} catch (Exception ex)
		{
			// Do nothing; delimiter will default to "\n"
		}
		return delim;
	}

	/**
	 * Used to somewhat reliably grab a double from the user. Talks to user via
	 * console.
	 * 
	 * @param msgLine
	 *            The message to display to the user to ask for the double
	 * @param errMsg
	 *            A message to display to the user if something goes wrong
	 * @return The double we collected from the user
	 */
	public static double getDouble(String msgLine, String errMsg)
	{
		double doubleReturn = 0;
		String msgRead;
		while (true)
		{
			try
			{
				msgRead = getString(msgLine, IO.singleQuoteIsAllowed, true);
				if (msgRead.contains("."))
				{
					if (msgRead.substring(msgRead.indexOf(".")).length() > 3)
					{
						throw new NumberFormatException();
					}
				}
				doubleReturn = Double.parseDouble(msgRead);
				break;
			} catch (NumberFormatException ex)
			{
				say(errMsg);
			}
		}
		return doubleReturn;
	}

	/**
	 * Uses msgLine to print a message to the user, then presents a command line
	 * and grabs the next line of user input using the scanner object. If the
	 * input is an integer, it returns it. If it is not a valid integer, it
	 * displays errMsg and waits for another input.
	 * 
	 * @param msgLine
	 *            The message to display to the user when collecting the input
	 * @param minValue
	 *            The minimum value of the integer to be collected
	 * @param maxValue
	 *            The maximum value of the integer to be collected
	 * 
	 * @return the integer that we got from the user
	 */
	public static int getInt(String msgLine, int minValue, int maxValue)

	{
		int iReturn = 0;
		while (true)
		{
			try
			{
				iReturn = Integer
						.parseInt(getString(msgLine, IO.singleQuoteIsAllowed, true));
				if (iReturn < minValue || iReturn > maxValue)
				{
					say("Input value must be a valid integer between "
							+ minValue + " and " + maxValue + ".");
				} else
				{
					break;
				}
			} catch (NumberFormatException ex)
			{
				say("Input value must be a valid integer between " + minValue
						+ " and " + maxValue + ".");
			}
		}
		return iReturn;
	}

	/**
	 * Uses msgLine to print a message to the user, then presents a command line
	 * and grabs the next line of user input using the scanner object. Can be
	 * any string.
	 * 
	 * @param msgLine
	 *            The message to display to the user in order to collect the
	 *            input
	 * @param isSingleQuoteAllowed
	 *            A boolean value that determines whether the method will accept
	 *            responses that contain one or more commas. It is recommended
	 *            that the programmer make use of the singleQuoteIsAllowed and
	 *            singleQuoteIsForbidden constants to ensure future compatibility and
	 *            code readability
	 * @return The line of input from the user
	 */
	public static String getString(String msgLine,
			boolean isSingleQuoteAllowed, boolean isInputManditory)
	{
		say(msgLine);
		String inputLine = null;
		while (true)
		{
			try
			{
				presentConsoleBracket();
				inputLine = myReader.readLine().trim();
				if (isInputManditory
						&& (inputLine == "" || inputLine == null || inputLine
								.length() < 1))
				{
					say("Input must not be blank. Please try again.");
				} else if (!isSingleQuoteAllowed && inputLine.contains("'"))
				{
					say("Input must not contain any ''' characters. Please try again.");
				} else
				{
					break;
				}
			} catch (IOException e)
			{
				say("Something went wrong. Please try again.");
			}
		}
		return inputLine;
	}

	/**
	 * A method which takes a string in a standard format and returns a date
	 * 
	 * @param dateString
	 *            A string in format "dd/MM/yyyy"
	 * @return The date that the string represents
	 * @throws ParseException
	 *             if the string represents an invalid date
	 */
	public static Date parseDate(String dateString) throws ParseException
	{
		if (dateString.length() != 10)
		{
			throw new ParseException("Date provided was of an invalid length",
					0);
		} else if (Integer.parseInt(dateString.substring(0, 2)) > 31
				|| Integer.parseInt(dateString.substring(0, 2)) < 1)
		{
			throw new ParseException("Date provided was invalid", 0);
		} else if (Integer.parseInt(dateString.substring(3, 5)) > 12
				|| Integer.parseInt(dateString.substring(3, 5)) < 1)
		{
			throw new ParseException("Date provided was invalid", 3);
		}
		return DATA_DATE_FORMAT.parse(dateString);
	}

	/**
	 * Presents a command line to the user. Convenience method.
	 */
	public static void presentConsoleBracket()
	{
		IO.say("> ");
	}

	/**
	 * A method to read the contents of a file into an ArrayList
	 * 
	 * @param fileName
	 *            The relative filename to try to read the data from
	 * @return the arrayList of data that was read from the file
	 * @throws FileNotFoundException
	 *             If the file is not found
	 * @throws IOException
	 *             If there is an I/O problem
	 */
	public static ArrayList<String> readFileIntoArrayList(String fileName)
			throws FileNotFoundException, IOException
	{
		ArrayList<String> data = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String response = reader.readLine();
		while (response != null)
		{
			data.add(response);
			response = reader.readLine();
		}
		reader.close();
		return data;
	}

	/**
	 * Prints a line, taking that line as a parameter. Convenience method.
	 * 
	 * @param aLine
	 *            the line to print out to the user
	 */
	public static void say(String aLine)
	{
		System.out.println(aLine);
	}

	/**
	 * A method to write the contents of an ArrayList to file
	 * 
	 * @param theArrayList
	 *            the arrayList that needs to be written to file
	 * @param fileName
	 *            The filename to write the data to. The file will be created if
	 *            it does not exist. NOTE: This will replace the contents of the
	 *            file, NOT append.
	 * @throws IOException
	 *             if there is an I/O problem
	 */
	public static void writeArrayListToFile(ArrayList<String> myArrayList,
			String fileName) throws IOException
	{
		for (int i = 0; i < 3; i++)
		{
			try
			{
				myPrintWriter = new PrintWriter(new BufferedWriter(
						new FileWriter(fileName)));
				for (String entry : myArrayList)
				{
					myPrintWriter.println(entry);
				}
				break;
			} catch (IOException e)
			{
				if (i < 2)
				{
					System.err.println("Failed to save to " + fileName
							+ ". Trying again...");
				} else
				{
					throw new IOException(
							"Data could not be saved to file after " + i
									+ " attempts");
				}
			} catch (Exception e)
			{
				System.err.println("There was an unexplained error: " + e);
			} finally
			{
				if (myPrintWriter != null)
				{
					myPrintWriter.close();
				}
			}
		}
	}

	/**
	 * Used to help format a string output.
	 * 
	 * @param stringToPad
	 *            The string to pad
	 * @param numCharactersTotal
	 *            The number of characters required in total
	 * @return The formatted string
	 */
	public static String padRight(String stringToPad, int numCharactersTotal)
	{
		return String.format("%1$-" + numCharactersTotal + "s", stringToPad);
	}

	/**
	 * Used to help format an integer output in a string
	 * 
	 * @param intToPad
	 *            The int to pad
	 * @param numCharactersTotal
	 *            The number of characters required in total
	 * @return The formatted string
	 */
	public static String padRight(int intToPad, int numCharactersTotal)
	{
		return String.format("%1$-" + numCharactersTotal + "s", intToPad);
	}

	/**
	 * Used to help format a double output in a string
	 * 
	 * @param doubleToPad
	 *            The double to pad
	 * @param numCharactersTotal
	 *            The number of characters required in total
	 * @return The formatted string
	 */
	public static String padRight(double doubleToPad, int numCharactersTotal)
	{
		return String.format("%1$-" + numCharactersTotal + "s", doubleToPad);
	}
}