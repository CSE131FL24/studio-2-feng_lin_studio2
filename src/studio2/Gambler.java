package studio2;
import java.util.Scanner;

public class Gambler {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int losses = 0;


		System.out.print("Enter the starting amount of money: ");
		int startAmount = in.nextInt();

		System.out.print("Enter the win limit (the amount of money at which you stop): ");
		int winLimit = in.nextInt();

		System.out.print("Enter the win chance (probability of winning a single game, between 0 and 1): ");
		double winChance = in.nextDouble();

		System.out.print("Enter the number of simulations to run: ");
		int totalSimulations = in.nextInt();


		for (int sim = 1; sim <= totalSimulations; sim++) {
			int currentAmount = startAmount;
			int plays = 0;

			while (currentAmount > 0 && currentAmount < winLimit) {
				plays++;
				double outcome = Math.random();

				if (outcome < winChance) {
					currentAmount++;
				} else {
					currentAmount--;
				}
			}
			if(currentAmount >= winLimit){
				System.out.println("Simulation " + sim + ": " + plays + " WIN");}
			else {
				System.out.println("Simulation " + sim + ": " + plays + " Lose");
				losses ++;
			}
		}

		double ruinRate = (double) losses / totalSimulations;


		double expectedRuinRate;
		double alpha = (1 - winChance) / winChance;
		if (winChance == 0.5) {
			expectedRuinRate = 1.0 - (double) startAmount / winLimit;
		} else {
			expectedRuinRate = (Math.pow(alpha, startAmount)-Math.pow(alpha, winLimit))/1-Math.pow(alpha, winLimit);
			System.out.println("Ruin rate from simulation is"+ ruinRate);
			System.out.println("your expectedRuinRate is"+ expectedRuinRate);






		}}}


