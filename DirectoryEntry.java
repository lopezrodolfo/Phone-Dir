/*1)Summary: The directory entry class has two data attributes one for a
person's name and another for a person's number. We have provided a
default and a non-default constructor as well as getter, setter, and
tostring methods for these attributes.
2)Author Names: Russell Gokemeijer and Rodolfo Lopez
3)Last Modified: 4/12/21*/

public class DirectoryEntry {
    //attributes
    public String name;
    public String number;

    public DirectoryEntry() {
    //def constructor
        name = "";
        number = "";
    }

    public DirectoryEntry(String nam, String num) {
    //overloaded constructor
        name = nam;
        number = num;
    }

    public String getName() {
    //getter for name
        return name;
    }

    public String getNumber() {
    //getter for number
        return number;
    }

    public void setName(String nam) {
    //setter for name
        name = nam;
    }

    public void setNumber(String num) {
    //setter for number
        number = num;
    }

    public String toString() {
    //displays object
        return "Name: " + name + "\nNumber: " + number;
    }
}