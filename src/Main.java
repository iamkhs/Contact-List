import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final MobilePhone mobilePhone = new MobilePhone();
    static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        printActions();
        boolean quit = true;
        System.out.println("Starting Phone.......");
        while(quit){
            System.out.println("Choose your action : ");
            int action = 0;
            try {
                action = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("please enter number only!!");
                input.nextLine();
            }
            switch (action){
                case 0 -> printActions();
                case 1 -> mobilePhone.printContactList();
                case 2 -> addContact();
                case 3 -> updateContact();
                case 4 -> removeContact();
                case 5 -> searchContact();
                case 6 -> {
                    quit = false;
                    System.out.println("Shutting down.....");
                }
            }
        }
    }

    private static void addContact(){
        System.out.print("Enter contact name : ");
        String name = input.nextLine();

        System.out.print("Enter contact number : ");
        String number = input.nextLine();

        mobilePhone.addNewContact(name, number);
    }

    private static void removeContact(){
        System.out.print("Enter contact name : ");
        String name = input.nextLine();

        mobilePhone.removeContact(name);
    }

    private static void updateContact(){
        System.out.print("Enter contact name : ");
        String name = input.nextLine();

        System.out.print("Enter contact number : ");
        String oldNumber = input.nextLine();

        System.out.print("Enter new contact number : ");
        String newNumber = input.nextLine();

        mobilePhone.updateContact(name, oldNumber, newNumber);

    }

    private static void searchContact(){
        System.out.print("Enter contact name : ");
        String name = input.nextLine();
        mobilePhone.queryContact(name);
    }
    private static void printActions(){
        System.out.println("\nAvailable action: \npress");
        System.out.println("""
            0 - to print a list of available actions
            1 - to print contacts
            2 - to add a new contact
            3 - to update existing an contact
            4 - to remove an existing contact
            5 - query if an existing contact
            6 - to shutdown
            """);
    }
}