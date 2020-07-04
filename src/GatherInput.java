import java.util.Scanner;

    public class GatherInput {
        public static boolean gatherBooleanInput(String message) {
            int result = GatherInput.gatherIntInput(message + "(Enter 1 for yes and 2 for no)", 2, 1);
            return result == 1;
        }

        public static int gatherIntInput(String message, Integer max, Integer min) {
            Scanner kb = new Scanner(System.in);
            System.out.println(message);

            int result;
            try {
                result = kb.nextInt();
            } catch (Exception ex) {
                GatherInput.showErrorMessage("Enter valid value");
                result = GatherInput.gatherIntInput(message, max, min);
            }

            if (max != null && result > max) {
                GatherInput.showErrorMessage("Enter a value less than or equal to " + max);
                result = GatherInput.gatherIntInput(message, max, min);
            }

            if (min != null && result < min) {
                GatherInput.showErrorMessage("Enter a value more than " + min);
                result = GatherInput.gatherIntInput(message, max, min);
            }

            return result;
        }

        public static String gatherStringInput(String message) {
            return GatherInput.gatherStringInput(message, false);
        }

        public static String gatherStringInput(String message, boolean isRequired) {
            Scanner kb = new Scanner(System.in);
            if (!isRequired) {
                message = message + " (Optional)";
            }
            System.out.println(message);
            String result = kb.nextLine();
            if (result.isEmpty()) {
                GatherInput.showErrorMessage("This value is required");
                GatherInput.gatherStringInput(message, isRequired);
            }
            return result;
        }

        private static void showErrorMessage(String message) {
            System.out.println("Error: " + message);
        }
    }
