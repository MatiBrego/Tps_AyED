import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public void start_menu(PathBuilder new_path_builder) {
        String input = "";
        while(!Objects.equals(input, "3")) {
            System.out.println("1 - Next Jump");
            System.out.println("2 - See Stacks In Current Jump");
            System.out.println("3 - Exit");
            Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter an option: ");
            input = myScanner.nextLine();

            if(Objects.equals(input, "1"))
                new_path_builder.nextJump();
            else if(Objects.equals(input, "2"))
                new_path_builder.print_stacks();
        }
        new_path_builder.recursive_peek(new Position(1, 1), new_path_builder.getCurrent_jump(), "");
    }

}
