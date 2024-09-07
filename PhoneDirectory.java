/*1)Summary: The phone directory class has one data attribute which is an array list of directory entry objects. The phone directory methods either
read from or modify this data attribute (eg add, remove, display, search, load, save) 
2)Author Names: Russell Gokemeijer and Rodolfo Lopez
3)Last Modified: 4/12/21*/

import java.util.*;
import java.io.*;

public class PhoneDirectory {
    private ArrayList<DirectoryEntry> theDirectory; //array list of directory entry objects 

    public PhoneDirectory() { //constructor
        theDirectory = new ArrayList<DirectoryEntry>();
    }

    public DirectoryEntry searchEntry(String name) {
        // search the entry referenced by name; return the entry searched or null
        // if there is no entry for name    
        for(int i=0; i < this.theDirectory.size(); i++) {
            if (name.equalsIgnoreCase(this.theDirectory.get(i).name)) {
                return this.theDirectory.get(i);
            }
        }
        return null;
    }

    public DirectoryEntry removeEntry(String name) {
        // remove the entry referenced by name; return the entry removed or null
        // if there is no entry for name    
        for (int i=0; i < this.theDirectory.size(); i++) {
            if (name.equalsIgnoreCase(this.theDirectory.get(i).name)) {
                return this.theDirectory.remove(i);
            }
        }
        return null;
    }

    public void addOrChangeEntry(String name, String number) {
        // add an entry to directory or change an existing entry; return the old
        // number or null if it is a new entry
        DirectoryEntry entry = searchEntry(name);
        if (entry == null){
            theDirectory.add(new DirectoryEntry(name, number));
        }
        else {
            entry.setNumber(number);
        }
    }

    public void displayAllEntries() {
        // display all entries in a nice and readable format
        for (DirectoryEntry entry: theDirectory) {
            System.out.println();
            System.out.println("Name: " + entry.getName());
            System.out.println("Number: " + entry.getNumber());
        }
    }

    public void loadDirectory(BufferedReader reader) {
        //takes in filename with the format (name,phone#) on each line and adds
        //the file contents to the phone directory 
        String line;
        String[] words;
        int successes = 0;

        try {
            while ((line = reader.readLine()) != null) {
                words = line.split(",");
                try {
                    addOrChangeEntry(words[0], words[1]);
                    successes += 1;
                }
                catch (IndexOutOfBoundsException e) {
                }
            }
            System.out.println("Successfully added " + String.valueOf(successes) + " entries.");
        }
        catch (IOException e) { //handles invalid files
            System.out.println("Error reading file");
        }
    }

    public void saveDirectory(String fileName) {
        //goes through the current phone directory and writes each entry to the
        //passed in file formatted (name,phone#) on each line 
        PrintWriter output;
        try {
            output = new PrintWriter(new FileOutputStream(fileName));
            for (DirectoryEntry entry : theDirectory) {
                output.println(entry.getName() + "," + entry.getNumber());
            }
            System.out.println();
            System.out.println("Directory saved successfully");
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error Saving File");
        }
    }
}