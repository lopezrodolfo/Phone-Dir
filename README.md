# Phone Directory Management System

A simple Java-based phone directory management system that allows users to create, modify, and manage a list of contacts.

## Authors

- Rodolfo Lopez
- Russell Gokemeijer

## Date

April 12, 2021

## Features

- Load existing phone directory from a file
- Add or update contact entries
- Remove entries
- Search for specific entries
- Display all entries
- Save the current directory to a file

## Usage

1. Compile the Java files:

   ```
   javac proj4.java DirectoryEntry.java PhoneDirectory.java
   ```

2. Run the program:

   ```
   java proj4
   ```

3. Follow the on-screen prompts to interact with the phone directory.

## File Format

When loading or saving files, use the following format:

- One entry per line
- Each line should contain: `name,phone_number`
