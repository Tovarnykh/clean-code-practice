package ua.foxminded.javaspring.tovarnykh.cleancode.task2;

/**
 *
 * @author Victor Tovarnykh
 * @version 0.0.1
 * @since 0.0.1
 */
public class IntegerDivision {

	/**
	 * Method name: IntegerDivision
	 *
	 * Private Constructor that does anything.
	 */
	private IntegerDivision() {

	}

	/**
	 * Method name: makeDivision
	 * 
	 * @param dividend The number to be divided.
	 * @param divisor  The number by which to divide.
	 * @return (String) Step by step result of division into a column.
	 * @throws IllegalArgumentException
	 * 
	 *                                  Inside the function: 1. Checking the
	 *                                  numbers, to fit all conditions of dividing.
	 *                                  2. Find the module of both numbers and split
	 *                                  the dividend on atomic numbers. 3. Place
	 *                                  digit to memory and look is it possible to
	 *                                  subtract it on divisor, if it not take one
	 *                                  more digit in memory until we can subtract.
	 *                                  4. When find a digit to subtract start
	 *                                  calculation and add writing them to
	 *                                  calculation String. 5. Repeat this steps
	 *                                  until we get one digit in memory that can`t
	 *                                  be subtracted or we receive 0.
	 */
	public static String makeDivision(int dividend, int divisor) {

		if (divisor == 0) {
			throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
		}

		StringBuilder calculations = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		StringBuilder reminder = new StringBuilder();

		if ((dividend < 0) ^ (divisor < 0)) {
			answer.append("-");
		}

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		if (dividend < divisor) {
			return "" + dividend + "/" + divisor + "=0";
		}

		String[] digits = String.valueOf(dividend).split("");
		Integer reminderNumber;
		Integer multiplyResult;
		Integer subtractionResult;

		for (int i = 0; i < digits.length; i++) {
			reminder.append(digits[i]);
			reminderNumber = Integer.parseInt(reminder.toString());

			if (reminderNumber >= divisor) {
				subtractionResult = reminderNumber % divisor;
				multiplyResult = reminderNumber / divisor * divisor;
				String lastReminder = String.format("%" + (i + 2) + "s", "_" + reminderNumber.toString());
				String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
				Integer amountOfTabulations = lastReminder.length() - calculateDigit(multiplyResult);

				calculations.append(lastReminder).append("\n");
				calculations.append(multiply).append("\n");
				calculations.append(makeDivider(reminderNumber, amountOfTabulations)).append("\n");

				answer.append(reminderNumber / divisor);

				reminder.replace(0, reminder.length(), subtractionResult.toString());
				reminderNumber = Integer.parseInt(reminder.toString());
			} else {
				if (i >= calculateDigit(divisor)) {
					answer.append(0);
				}
			}

			if (i == (digits.length - 1)) {
				calculations.append(String.format("%" + (i + 2) + "s", reminderNumber.toString())).append("\n");
			}
		}

		return viewCalculations(dividend, divisor, calculations, answer);
	}

	/**
	 * Method name: viewCalculations
	 * 
	 * @param dividend           The number to be divided.
	 * @param divisor            The number by which to divide.
	 * @param devideCalculations Step by step calculations that we did.
	 * @param devideAnswer       Answer we receive after calculations.
	 * @return (String) Whole column division.
	 * 
	 *         Inside the function: 1. Divide String on three sections. 2. If we
	 *         have a new like making tabulation to create a ladder like view. 3.
	 *         Insert all the numbers on their places. 3. Claim section borders. 4.
	 */
	private static String viewCalculations(Integer dividend, Integer divisor, StringBuilder devideCalculations,
			StringBuilder devideAnswer) {
		int[] sectionBorders = new int[3];
		int massiveCell = 0;

		for (int loopIndex = 0; loopIndex < devideCalculations.length(); loopIndex++) {
			if (devideCalculations.charAt(loopIndex) == '\n') {
				sectionBorders[massiveCell] = loopIndex;
				massiveCell++;
			}

			if (massiveCell == 3) {
				break;
			}
		}

		int numberOfSymbols = calculateDigit(dividend) + 1 - sectionBorders[0];

		devideCalculations.insert(sectionBorders[2],
				assemblyString(numberOfSymbols, ' ') + "|" + devideAnswer.toString());
		devideCalculations.insert(sectionBorders[1],
				assemblyString(numberOfSymbols, ' ') + "|" + assemblyString(devideAnswer.length(), '-'));
		devideCalculations.insert(sectionBorders[0], "|" + divisor);
		devideCalculations.replace(1, sectionBorders[0], dividend.toString());

		return devideCalculations.toString();
	}
	
	/**
	 * Method name: assemblyString
	 * 
	 * @param numberOfSymbols  Numbers we receive during calculations.
	 * @param delimiter  Delimiter between numbers.
	 * @return (String) Line with numbers we write after subtraction.
	 * 
	 *         Inside the function: 1. Creating new line. 2. Fill it with numbers.
	 */
	private static String assemblyString(int numberOfSymbols, char delimiter) {
		StringBuilder newString = new StringBuilder();

		for (int i = 0; i < numberOfSymbols; i++) {
			newString.append(delimiter);
		}
		return newString.toString();
	}
	
	
	/**
	 * Method name: makeDivider
	 * 
	 * @param reminderNumber  Number we keep in memory to subtract.
	 * @param amountOfTabulations  How many tabs we need to fill in.
	 * @return (String) Line to fit ladder like view.
	 */
	private static String makeDivider(Integer reminderNumber, Integer amountOfTabulations) {
		return assemblyString(amountOfTabulations, ' ') + assemblyString(calculateDigit(reminderNumber), '-');
	}
	
	/**
	 * Method name: calculateDigit
	 * 
	 * @param dividend  Number we keep in memory to subtract.
	 * @return (int) Number after subtraction.
	 */
	private static int calculateDigit(int dividend) {
		return (int) Math.log10(dividend) + 1;
	}

}