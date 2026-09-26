package practice;

import java.util.Random;

public class OtpGenrator {

	public static void main(String[] args) {

		Runnable otp = () -> {
			Random ran = new Random();
			String vowels = "AEIOU";
			// vowels.charAt(0) --A
			char vowel = vowels.charAt(ran.nextInt(vowels.length()));

			String result = "" + vowel;

			for (int i = 0; i < 4; i++) {
				result += ran.nextInt(10);
			}
			System.out.println("OPT: " + result);
		};
		otp.run();
	}
}

/*
 * Exercise 2 Create a Lamda for generating a random OTP which will be formed of
 * 5 chars, the 1st Char should be a vowel followed by 4 random numbers
 * generated from 0-9. eg A8391, U8665 and so on
 * 
 */