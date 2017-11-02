import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author christopherdonoso
 */

public class Hw01 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) 
    {
        //Acquires the table size and text file name from the command prompt.
        for(int i = 0; i < args.length; i++)
        {
            String s = args[i];
        }

        File text = new File (args[1]);
        int tableSize = Integer.parseInt(args[0]);


        ArrayList<String> instructionList = new ArrayList<String>();
        HashTable table = new HashTable(tableSize);        
                
        //Opens and stores the content of the text file into an array.
        try
        {
            //Reads in text file.
            Scanner scanner = new Scanner(text);
            
            //Goes through text file and stores strings in linked list.
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                instructionList.add(line);
            }
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        //Prints out the content of the text file.
        System.out.println(args[1] + " contains:");
        for(int i = 0; i < instructionList.size(); i++)
        {
            System.out.println(instructionList.get(i));
        }
         
        //Goes through the instruction from text file.
        for(int i = 0; i < instructionList.size(); i++)
        {
            String insert = "i", delete = "d", search = "s",
                    print = "p", quit= "q";
     
            
            if(instructionList.get(i).substring(0,1).equals(insert))
            {
                table.insert(instructionList.get(i).substring(2), table.hashFunction(instructionList.get(i).substring(2), tableSize));   
            }
            
            if(instructionList.get(i).substring(0,1).equals(delete))
            {
                table.delete(instructionList.get(i).substring(2), table.hashFunction(instructionList.get(i).substring(2), tableSize));   
            }
            
            if(instructionList.get(i).substring(0,1).equals(search))
            {
                table.search(instructionList.get(i).substring(2), table.hashFunction(instructionList.get(i).substring(2), tableSize));   
            }
            
            if(instructionList.get(i).substring(0,1).equals(print))
            {
                table.print(tableSize);
            }

            if(instructionList.get(i).substring(0,1).equals(quit))
            {
                table.quit();
            }            
        }

        complexityIndicator();        
    }

    static void complexityIndicator()
    {
        System.err.println("ch724936;3.0;25.0");
    }
}

//Node will have string name and key.
class Node
{
    String data;
    int key;

    public Node(String x,  int y)
    {
        data = x;
        key = y;
    }

    public Node next;
}

class HashTable
{
    private Node[] table;

    //Constructor and initializes linked list to null.
    public HashTable(int tableSize)
    {
        table = new Node[tableSize];
        
        for(int i = 0; i < tableSize; i++)
        {
            table[i] = null;
        }
    }

    //Creates the hash key.
    public int hashFunction(String name, int tableSize)
    {
        int h = 0, C = 27;
        
        for(int i = 0; i < name.length(); i++)
        {
            h = (h * C + (name.charAt(i) - 'a' + 1)) % (tableSize);
        }
                
       return h;
    }
    
    //Inserts the string and key to the hash table and linked list
    //if required.
    void insert(String name, int keyIndex)
    {
        Node head = new Node(name, keyIndex);
        
        //The hashtable is empty so it will insert a head node.
        if(table[keyIndex] == null)
        {
            table[keyIndex] = head;
        }
        
        //There is already a node in the hash table so it will create a linked list.
        else
        {
            head.next = table[keyIndex];
            table[keyIndex] = head;
        }
    }
    
    //Deletes the string and key from the hash table and linked list
    //if required.
    void delete(String name, int keyIndex)
    {
        
        Node list = table[keyIndex];
        Node previous = null;
        
        //Goes through list to find the node with the proper data.
        while(list != null && !(list.data.equals(name)))
        {
            previous = list;
            list = list.next;
        }
        
        //String was not found.
        if(list == null)
        {
            System.out.println(name + " not found - not deleted.");
            return;
        }
                    
        //If node with correct data is found, it is deleted.
        if(list.data.equals(name))
        {           
            //There is only one node in the list.
            if(previous == null)
            {
                table[keyIndex] = list.next;
            }
            
            //There is more than one node.
            else
            {
                previous.next = list.next;
            }

            System.out.println(name + " found and deleted.");
        }
    }
    
    //Searches and prints the string and key from the hash table and linked list
    //if required.
    void search(String name, int keyIndex)
    {
        Node list = table[keyIndex];
        Node previous = null;
        
        //Goes through list to find the node with the proper data.
        while(list != null && !(list.data.equals(name)))
        {
            previous = list;
            list = list.next;
        }
        
        //String was not found.
        if(list == null)
        {
            System.out.println("Search for " + name + " failed.");
            return;
        }
                    
        //If node with correct data is found, it is deleted.
        if(list.data.equals(name))
        {  
            Node newList = table[keyIndex];

            System.out.print("Search for " + name + ": Found at -> ");

            printReverse(newList);
            System.out.println("");
        }
    }
    
    //Insertion adds node to the head of the linked list
    //Therefore, it is necessary to print it in reverse order.
    void printReverse(Node head)
    {
        if(head == null)
        {
            return;
        }
        
        printReverse(head.next);
        System.out.print(head.key + "/" + head.data + ";");
    }
    
    //Prints out the hash table and linked list.
    void print(int tableSize)
    {
        System.out.println("The Hash Table contains:");    
        
        //Goes through each index in the hashtable.    
        for(int i = 0; i < tableSize; i++)
        {
            System.out.print(i + ". List (first->last): ");
            Node list = table[i];
            
            printReverse(list);

            System.out.println("");
        }
    }

    void quit()
    {
        System.exit(0);
    }
}