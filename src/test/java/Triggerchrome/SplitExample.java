package Triggerchrome;

public class SplitExample {
	public static void main(String[] args) {
		String values = "1. Did you, or do you expect to have a change or loss of insurance? Yes No Enter Date: Select a date after Feb 20, 2024 Select a date for :";
		String gg = "1. Did you, or do you expect to have a change or loss of insurance? Yes No";
		// Split the values by newline followed by a digit and a period
		System.out.println(values.contains(gg));
	}
}
