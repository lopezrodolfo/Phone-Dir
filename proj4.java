/*1)Summary: Our program initially displays to the user seven options that the user can select that either read from or modify an empty phone directory (except option 7 is used to quit the program) that stores people's names with their associated phone numbers. Option 1 allows the user to specify a filename containing directory entries that will be added to the current state of the phone directory. Option 2 allows the user to add a new directory entry if the inputted name is not already in the phone directory. If the inputted name is already in the phone directory, then the directory entry with that name's phone number is updated. Option 3 allows the user to remove  a directory entry specified by name     from the current state of phone directory. Option 4 allows the user to search for a directory entry specified by name and displays the directory entry if found. Option 5 displays the current state of phone directory with all of its names and phone numbers. Option 6 allows the user to specify a filename that will save the current state of the phone directory. Lastly, if the user selects option 7, then they are asked if they would like to run the program again.
2)Author Names: Russell Gokemeijer and Rodolfo Lopez
3)Last Modified: 4/12/21*/

import java.util.*;
import java.io.*;

public class proj4 {
    public static void main(String [] args) {
        //allows user to run program multiple times
        Scanner sc = new Scanner(System.in);
        while (true) {
            program(sc);
            System.out.println();
            System.out.println("Do you want to run the program again [y/n]?:");
            if (!sc.nextLine().equalsIgnoreCase("y")) {
                break;
            }
        }
        sc.close();
    }

    public static void program(Scanner sc) {
        //displays options to user and calls specific options method based on
        //user input    
        PhoneDirectory directory = new PhoneDirectory(); //instantiate phone directory object
        int whichOption;

        while (true) {
            System.out.println();
            System.out.println("What action would you like to take.[1/2/3/4/5/6/7]\n1. Load a previously saved phone directory from file."
                    + "\n2. Add or change an entry.\n3. Remove an entry.\n4. Search for an entry.\n5. Display all entries."+
                    "\n6. Save the current phone directory to a file.\n7. Quit the program");
            try {
                whichOption = Integer.parseInt(sc.nextLine());
                if (whichOption == 1) {
                    System.out.println();
                    System.out.println("Load a previously saved phone directory from file.");
                    option1(sc, directory);
                }
                else if (whichOption == 2) {
                    System.out.println();
                    System.out.println("Add or change an entry.");
                    option2(sc, directory);
                }
                else if (whichOption == 3) {
                    System.out.println();
                    System.out.println("Remove an entry.");
                    option3(sc, directory);
                }
                else if (whichOption == 4) {
                    System.out.println();
                    System.out.println("Search for an entry.");
                    option4(sc, directory);
                }
                else if (whichOption == 5) {
                    System.out.println();
                    System.out.println("Display all entries.");
                    option5(sc, directory);
                }
                else if (whichOption == 6) {
                    System.out.println();
                    System.out.println("Save the current phone directory to a file.");
                    option6(sc, directory);
                }
                else if (whichOption == 7) {
                    break;
                }
                else {
                    System.out.println();
                    System.out.println("Invalid input, try again.");
                }
            }
            catch (NumberFormatException e) { //handles invalid input
                System.out.println();
                System.out.println("Invalid input, try again.");
            }
        }
    }

    public static void option1(Scanner sc, PhoneDirectory directory) {
        //allows the user to specify a filename that will passed to the
        //load directory method 
        String whichFile;
        BufferedReader reader;

        System.out.println();
        System.out.println("Enter the name of the file you would like to load formatted as \"name, phone number\" on each line, or type cancel.");
        whichFile = sc.nextLine();
        if (!whichFile.equalsIgnoreCase("cancel")) { //user can go back
            try {
                reader = new BufferedReader(new FileReader(whichFile));
                directory.loadDirectory(reader);
                reader.close();
            }
            catch (IOException e1) {
                System.out.println("Invalid input, try again"); //handles invalid file name
                option1(sc, directory);
            }
        }
    }

    public static void option2(Scanner sc, PhoneDirectory directory) {
        //allows the user to specify a name that will either be added or changed
        //to the phone directory by calling the associated method. 
        String name;

        System.out.println();
        System.out.println("Enter the name of the person you would like to add or change an entry for.");
        name = sc.nextLine();
        if (directory.searchEntry(name) != null) { //change
            System.out.println();
            System.out.println("Enter the new number for the person you would like to change the entry of.");
            directory.addOrChangeEntry(name, sc.nextLine());
            System.out.println();
            System.out.println("Entry changed successfully.");
        }
        else { //add
            System.out.println();
            System.out.println("Enter the number for the person you would like to add an entry of.");
            directory.addOrChangeEntry(name, sc.nextLine());
            System.out.println();
            System.out.println("Entry added successfully.");
        }
    }

    public static void option3(Scanner sc, PhoneDirectory directory) {
        //allows the user to specify a name to that will be passed to the
        //remove method
        System.out.println();
        System.out.println("Which entry would you like to remove.");
        if (directory.removeEntry(sc.nextLine()) == null){
            System.out.println("Entry not found.");
        }
        else {
            System.out.println("Entry removed successfully.");
        }
    }

    public static void option4(Scanner sc, PhoneDirectory directory) {
        //allows the user to specify a name that will be passed to the search
        //method
        DirectoryEntry entry;

        System.out.println();
        System.out.println("Which entry would you like to search for.");
        entry = directory.searchEntry(sc.nextLine());
        if (entry == null) {
            System.out.println("Entry not found.");
        }
        else {
            System.out.println("Entry found.");
            System.out.println(entry.toString());
        }
    }

    public static void option5(Scanner sc, PhoneDirectory directory) {
        //calls method to display all entries
        directory.displayAllEntries();
    }

    public static void option6(Scanner sc, PhoneDirectory directory) {
        //allows user to specify name of file that will be passed to the save
        //directory method  
        System.out.println();
        System.out.println("What is the name of the file you would like to save this directory to.");
        directory.saveDirectory(sc.nextLine());
    }
}