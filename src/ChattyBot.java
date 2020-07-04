import java.util.ArrayList;

public class ChattyBot {
    private String remainders;

    private void introduction() {
        System.out.println("Hello! My name is Aid.");
        System.out.println("I was created in 2018.");
        String userName = GatherInput.gatherStringInput("Please, remind me your name.", true);
        System.out.println("What a great name you have, " + userName + "!");
    }

    private void waitOneSecond() {
        try {
            Thread.sleep(750);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void userAge() {
        System.out.println("Let me guess your age.");
        remainders = GatherInput.gatherStringInput("Say me remainders of dividing your age by 3, 5 and 7.(Separate numbers with a space)", true);
        int age = guessUserAge();
        boolean isValidAge = age != -1;
        if (isValidAge) {
            System.out.println("Your age is " + age + " that's a good time to start programming!");
        } else {
            System.out.println("Those numbers don't match. Try again!");
            userAge();
        }
    }

    private int guessUserAge() {
        ArrayList<Integer> listOfRemainders = new ArrayList<>();
        String[] arrOfRemainders = remainders.split(" ", 3);
        for (String s : arrOfRemainders) {
            listOfRemainders.add(Integer.valueOf(s));
        }
        int remainder1 = listOfRemainders.get(0);
        int remainder2 = listOfRemainders.get(1);
        int remainder3 = listOfRemainders.get(2);

        for (int i = 0; i < 150; i++) {
            int guess1 = i % 3;
            int guess2 = i % 5;
            int guess3 = i % 7;

            if (guess1 == remainder1) {
                if (guess2 == remainder2) {
                    if (guess3 == remainder3) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private void countNumbers() {
        int numberToCountTo = GatherInput.gatherIntInput("Now I will prove to you that I can count to any number you want.", 1000000000, 0);
        for (int i = 0; i < numberToCountTo + 1; i++) {
            System.out.println(i + "!");
            waitOneSecond();
        }
    }

    private void askMethodQuestion() {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        int answer = GatherInput.gatherIntInput("4. To interrupt the execution of a program.", 4, 1);

        if (answer == 2) {
            System.out.println("Congratulations, have a nice day!");
            System.exit(0);
        } else {
            System.out.println("Please, try again.");
            System.out.println();
            askMethodQuestion();
        }
    }

    public void runChattyBot() {
        introduction();
        userAge();
        countNumbers();
        askMethodQuestion();
    }
}
