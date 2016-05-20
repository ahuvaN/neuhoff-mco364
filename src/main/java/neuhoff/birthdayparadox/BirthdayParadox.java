package neuhoff.birthdayparadox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;

public class BirthdayParadox {

	public static void main(String[] args) {

		Random random = new Random();
		HashSet<Integer> birthdays = new HashSet<Integer>();
		HashMap<Integer, Integer> percentages = new HashMap<Integer, Integer>();

		for (int ppl = 2; ppl <= 100; ppl++) {
			percentages.put(ppl, 0);

			for (int numTimes = 1; numTimes <= 100; numTimes++) {

				for (int x = 0; x < ppl; x++) {

					int rand = random.nextInt(365) + 1;
					if (birthdays.contains(rand)) {
						int val = percentages.get(ppl);
						percentages.put(ppl, ++val);
						break;
					} else {
						birthdays.add(rand);
					}
				}
				birthdays.clear();
			}

		}
		
		for (Entry<Integer, Integer> entry : percentages.entrySet()) { 
			String key = entry.getKey().toString(); 
			Integer value = entry.getValue(); 
			System.out.println("Number of people " + key + " percentage of match " + value); }


	}
}
