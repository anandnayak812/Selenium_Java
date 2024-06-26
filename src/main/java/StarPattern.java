import java.util.Scanner;

public class StarPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a star pattern to print:");
        System.out.println("1. Right Triangle");
        System.out.println("2. Inverted Right Triangle");
        System.out.println("3. Pyramid");
        System.out.println("4. Inverted Pyramid");
        System.out.println("5. Diamond");
        System.out.print("Enter the pattern number (1-5): ");
        int choice = scanner.nextInt();
        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();

        switch (choice) {
            case 1:
                printRightTriangle(numRows);
                break;
            case 2:
                printInvertedRightTriangle(numRows);
                break;
            case 3:
                printPyramid(numRows);
                break;
            case 4:
                printInvertedPyramid(numRows);
                break;
            case 5:
                printDiamond(numRows);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
        
        scanner.close();
    }

    static void printRightTriangle(int numRows) {
        for (int i = 1; i <= numRows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printInvertedRightTriangle(int numRows) {
        for (int i = numRows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printPyramid(int numRows) {
        for (int i = 1; i <= numRows; i++) {
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printInvertedPyramid(int numRows) {
        for (int i = numRows; i >= 1; i--) {
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printDiamond(int numRows) {
        for (int i = 1; i <= numRows; i++) {
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print("-");

            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = numRows - 1; i >= 1; i--) {
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
