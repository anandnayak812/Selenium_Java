
public class MyCode {

	public static void main(String[] args) {
		String text = "Ami Seligman (NE CEM)";
		String[] split = text.split("\\("); // Escape parentheses
		System.out.println(split[0].trim());
	}

}
