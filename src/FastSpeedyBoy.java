import java.util.Scanner;
public class FastSpeedyBoy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Finish Line!");
        String userInput = "";
        int[] b = new int[10];
        int[] r = new int[10];
        b[0] = 1;
        r[0] = 1;
        int userTurn = 5;
        while (userTurn != 1 && userTurn != 0) {
            System.out.print("Start with red or blue? (Enter 0 or 1): ");
            userTurn = scan.nextInt();
        }
        int diceResult1 = 0;
        int diceResult2 = 0;
        int bluePos = 0;
        int redPos = 0;
        System.out.println();
        while (b[9] != 1 && r[9] != 1) {
            if (userTurn == 1) {
                System.out.print("Blue execute a turn: (Enter anything): ");
                userInput = scan.nextLine();
                System.out.println("Rolling dice...");
                diceResult1 = (int) ((Math.random() * 6) + 1);
                diceResult2 = (int) ((Math.random() * 6) + 1);
                System.out.println("Rolled: " + diceResult1 + " and " + diceResult2);
                if ((diceResult1 == bluePos + 2 || diceResult2 == bluePos + 2) || diceResult1 + diceResult2 == bluePos + 2) {
                    b[bluePos] = 0;
                    bluePos++;
                    b[bluePos] = 1;
                }
                System.out.println();
                userTurn--;
            } else if (userTurn == 0) {
                System.out.print("Red execute a turn: (Enter anything): ");
                userInput = scan.nextLine();
                System.out.println("Rolling dice...");
                diceResult1 = (int) ((Math.random() * 6) + 1);
                diceResult2 = (int) ((Math.random() * 6) + 1);
                System.out.println("Rolled: " + diceResult1 + " and " + diceResult2);
                if (diceResult1 == redPos + 2 || diceResult2 == redPos + 2 || diceResult1 + diceResult2 == redPos + 2) {
                    r[redPos] = 0;
                    redPos++;
                    r[redPos] = 1;
                }
                System.out.println();
                userTurn++;
            }
            System.out.print("Blue: ");
            printList(b);
            System.out.print("Red: ");
            printList(r);
            System.out.println();
        }
        System.out.println();
        if (b[9] == 1) {
            System.out.println("Blue won!");
            printList(b);
        } else if (r[9] == 1) {
            System.out.print("Red won!");
            printList(r);
        }
    }

    public static void printList(int[] a) {
        int count = 1;
        for (int b : a) {
            if (count != 10) {
                System.out.print(b + ", ");
            } else {
                System.out.print(b);
            }
            count++;
        }
        System.out.println();

    }
}