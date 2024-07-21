package sunnykumarlearning.Test.Parabank;

public class PrimeNumber {

	public static void main(String[] args) {

		for (int i = 2; i <= 100; i++) {
			boolean isPrimeNumber = true;
			for (int j = 2; j <=i-1; j++) {
				if (i % j == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				System.out.println(i + " is a prime number ");
			} 
			else {
				System.out.println(i + " is not a prime number ");
			}
		}
	}
}
