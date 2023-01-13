package nik.list.iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IteratorForListApp {
    public static void main(String[] args) throws IOException {
        LinkList list = new LinkList();
        ListIterator iter = list.getIterator();
        int val;

        iter.insertAfter(20);
        iter.insertAfter(40);
        iter.insertAfter(80);
        iter.insertBefore(60);

        loop: while (true){
            System.out.print("Enter first letter of show, reset,");
            System.out.print("next, get, before, after, delete: ");
            System.out.flush();
            int choice = getChar();
            switch (choice){
                case 's':
                    if(!list.isEmpty())
                        list.displayList();
                    else
                        System.out.println("List is empty");
                    break;
                case 'r':
                    iter.reset();
                    break;
                case 'n':
                    if(!list.isEmpty() && !iter.atEnd())
                        iter.nextNode();
                    else
                        System.out.println("There are NO NEXT");
                    break;
                case 'g':
                    if(!list.isEmpty()){
                        val = iter.getCurrent().data;
                        System.out.println("Returned " + val);
                    }
                    else System.out.println("List is EMPTY");
                    break;
                case 'b':
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    val = getInt();
                    iter.insertBefore(val);
                    break;
                case 'a':
                    System.out.print("Enter val to insert: ");
                    System.out.flush();
                    val = getInt();
                    iter.insertAfter(val);
                    break;
                case 'd': // delete current element
                    if(!list.isEmpty()){
                        val = iter.deleteCurrent();
                        System.out.println("Deleted " + val);
                    }
                    else System.out.println("Can't delete");
                    break;
                case 'e':
                    break loop;
                default:
                    System.out.println("Invalid entry");

            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    private static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    private static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
}
