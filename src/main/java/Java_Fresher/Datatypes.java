package Java_Fresher;

import java.util.Scanner;

import org.bouncycastle.asn1.isismtt.x509.AdditionalInformationSyntax;

import net.bytebuddy.implementation.bytecode.Addition;

public class Datatypes {

	public static String addition(String i, String h) {
		String k = i + h;
		return k;

	}

	public static int subtract(int i, int h) {
		int k = i - h;
		return k;

	}

	public static void hello() {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		StringBuffer sr = new StringBuffer("Anand");
		String s = new String("Anand");
		System.out.println(s.equals(sr));
		System.out.println(sr.equals(s));
		System.out.println(sr.toString()==s);
		System.out.println(sr.toString().contains(s));
		System.out.println(s.contains(sr.toString()));
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Value: ");
		String choice = scanner.nextLine();
		String input = choice;
		String[] words = input.split(" ");
		StringBuilder reversed = new StringBuilder();

		for (String word : words) {
			StringBuilder wordBuilder = new StringBuilder(word);
			String reversedWord = wordBuilder.reverse().toString();
			reversed.append(reversedWord).append(" ");
		}

		String reversedString = reversed.toString().trim();
		System.out.println(reversedString);

	}
}
