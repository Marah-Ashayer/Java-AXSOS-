import java.util.ArrayList;
import java.util.Random;
import java.util.*; 
public class Test {
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();


		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
		char randomLetter = generator.getRandomLetter();
		System.out.println(randomLetter);

		String randomString = generator.generatePassword();
		System.out.println(randomString);


		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String> randomArrOfString = generator.getNewPasswordSet(n);
		System.out.println(randomArrOfString);
	}
}
