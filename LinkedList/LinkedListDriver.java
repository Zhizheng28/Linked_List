import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {

    public static void main(String[] args) {
        
        try {
            File file = new File("input.txt");  //"args[1]"
            Scanner readFile = new Scanner(file);
            Scanner input = new Scanner(System.in);
            int num;
            String userInput;
            boolean quit = false;
            SortedLinkedList list1 = new SortedLinkedList();

            while (readFile.hasNextInt()) {
                num = readFile.nextInt(); 
                ItemType item  = new ItemType(num);
                list1.insertItem(item);
            } // while
            
            // Print all Commands 
            System.out.println("Commands:");
            System.out.println("(i) - Insert Value");
            System.out.println("(s) - Search Value");
            System.out.println("(d) - Delete Value");
            System.out.println("(a) - Delete alternate nodes");
            System.out.println("(m) - Merge lists");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Print length");
            System.out.println("(q) - Quit program");
            
            while (quit != true) { // while user not quit run
                System.out.print("Enter a command: ");
                userInput = input.nextLine();
                //Take user Command and perform actions
                if (userInput.equals("i")) { // insert value
                    System.out.print("Enter a number to insert: ");
                    num = input.nextInt();
                    input.nextLine();
                    System.out.print("Original list : ");
                    list1.printList();
                    ItemType value  = new ItemType(num);
                    list1.insertItem(value);
                    System.out.print("New list : ");
                    list1.printList();
                } else if(userInput.equals("s")) { // search value
                    System.out.print("Enter a number to search: ");
                    num = input.nextInt();
                    input.nextLine();
                    if (list1.getHead() != null) {
                        System.out.println("Original list: ");
                        list1.printList();
                        ItemType value  = new ItemType(num);
                        if (list1.searchItem(value) != -1) {
                            System.out.println("The item is present at index " + list1.searchItem(value));
                        } else {
                            System.out.println("Item is not present in the list");
                        }
                    } else {
                        System.out.println("The list is empty");
                    }
                } else if(userInput.equals("d")) { // delete value
                    System.out.print("Enter a number to delete: ");
                    num = input.nextInt();
                    input.nextLine();
                    System.out.println("Original list: ");
                    list1.printList();
                    ItemType value  = new ItemType(num);
                    list1.deleteItem(value);
                    System.out.print("New list: ");
                    list1.printList();                
                } else if(userInput.equals("a")) { // delete alternate lists
                    System.out.println("Original list: ");
                    list1.printList();
                    list1.deleteAlternateNodes(list1);
                    System.out.print("New list: ");
                    list1.printList();
                } else if(userInput.equals("m")) { // merge lists
                    int len;
                    System.out.print("Enter the length of the new list: ");
                    SortedLinkedList list2 = new SortedLinkedList();
                    len = input.nextInt();
                    System.out.print("Enter the numbers: ");
                    for (int i = 0; i < len; i++) {
                        int val = input.nextInt();
                        ItemType item = new ItemType(val);
                        list2.insertItem(item);
                    } // for
                    input.nextLine();
                    System.out.print("The list 1: ");
                    list1.printList();
                    System.out.print("The list 2: ");
                    list2.printList();
                    System.out.print("Merged List: ");
                    list1.mergeList(list1, list2);
                    list1.printList();
                } else if(userInput.equals("p")) { // print list
                    System.out.println("The list is: ");
                    list1.printList();
                } else if(userInput.equals("l")) { // print length
                    System.out.print("The length of the list is ");
                    System.out.println(list1.getLength());
                } else if(userInput.equals("q")) { // quit/exit
                    System.out.println("Exiting the program...");
                    quit = true;
                } else { // Invalid command
                    System.out.println("Invalid command, try again!");
                } // if else 
            } // while
            readFile.close(); // close scanner
            input.close(); // close scanner
            System.exit(0);
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.toString());
        } // try/catch fnfe 
    } // main

} // LinkedListDriver