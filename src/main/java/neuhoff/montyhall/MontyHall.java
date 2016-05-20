package neuhoff.montyhall;

import java.util.Random;

public class MontyHall {
	public static void main(String[] args) {
		// List<Boolean> doors = new ArrayList<Boolean>(){true, false, false};
		boolean door1 = false, door2 = false, door3 = false;
		Random rand = new Random();
		int car = rand.nextInt(3) + 1;
		int userChoice, switchWins = 0, noSwitchWins = 0;

		for (int i = 0; i < 100; i++) {

			switch (car) {
			case 1:
				door1 = true;
				door2 = door3 = false;
				break;
			case 2:
				door2 = true;
				door1 = door3 = false;
				break;
			case 3:
				door3 = true;
				door1 = door2 = false;
				break;
			}

			userChoice = rand.nextInt(3) + 1;
			if (userChoice != car) {
				switchWins++;
			}

		}
		
		for (int i = 0; i < 100; i++) {

			switch (car) {
			case 1:
				door1 = true;
				door2 = door3 = false;
				break;
			case 2:
				door2 = true;
				door1 = door3 = false;
				break;
			case 3:
				door3 = true;
				door1 = door2 = false;
				break;
			}

			userChoice = rand.nextInt(3) + 1;
			if (userChoice == car) {
				noSwitchWins++;
			}

		}
		
		System.out.println("Switch wins " + switchWins + " No switch wins " + noSwitchWins);

	}
}
