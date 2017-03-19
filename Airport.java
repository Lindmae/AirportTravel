import java.io.*;
import java.util.*;
import java.lang.*;

class Node{
    private Integer data;
    private Node next;
    private boolean visited;
    
    public int getData(){
        return data;
    }
    
    public void setData (int e)
    {
        data = e;
    }
    
    public Node getNext(){
        return next;
    }
    
    public void setNext(Node n){
        next = n;
    }
    
    //constructor
    Node(int e){
        data = e;
        next = null;
    }
    
    Node(){
        data = -999;
        next = null;
    }
    
    void setUnvisited (){
        visited = false;
    }
    
    void setVisited (){
        visited = true;
    }
    
    boolean checkVisited(){
        if (visited == false){
            return false;
        }
        else
            return true;
    }
    
    
}

class List{
    private Node head;
    
    public List(){
        head = null;
    }

    public void show(){
        Node cur = head;
        while (cur != null){
            System.out.println (cur.getData() );
            cur = cur.getNext();
        }
        
    }
    
    public void insert (int v1){
        
        Node tmp = new Node(v1);
        Node cur = head;
        
        if( head == null){        //list is empty
            head = tmp;
        }
        else {                                //list has elements
            while (cur.getNext() != null){    //get to last value
                cur = cur.getNext();
            }
            cur.setNext(tmp);                 //set next to temp
        }
    }
    
    public void remove (int v1){
        Node cur = head;
        Node prev = null;
        
        if (head.getData() == v1){              //removing first
            head = head.getNext();
        }
        else {
            while (cur != null && cur.getData() != v1){
                prev = cur;
                cur = cur.getNext();
            }
            
            if(cur == null){
                System.out.println("Value not found! :(");
            }
            else {
                prev.setNext(cur.getNext());
            }
        }
    }
    
    void setArraytoUnvisited(){
        Node temp = head;
        
        while (temp != null){
            temp.setUnvisited();
            temp = temp.getNext();
        }
    } 
    
    void depthFirstSearchHelper (int x, int y, List[] Airports) {
        //mark all airports as unvisited;
        for (int i = 0; i < Airports.length; i++){
            Airports[i].setArraytoUnvisited();
        }
        if (Airports[x-1].dfs(x,y,Airports) == true){
            System.out.println("You can get from airport " + x + " to airport " + y + " in one or more flights");
        }
        else {
            System.out.println("You can NOT get from airport " + x + " to airport " + y + " in one or more flights");
        }
    }
    
    boolean dfs (int a, int b, List[] Airports) {
        Node temp = head;
        int value;
        
        while(temp!=null){
            value = temp.getData();
            
            if(value==b)                        //if (c = = b)
                return true;
            if(temp.checkVisited() == false){ //if ( airport c is unvisited )
                temp.setVisited();          //mark airport c as visited;
                if(Airports[value-1].dfs (value, b, Airports) == true)
                    return true;
            }
            
            temp = temp.getNext();
        }
        return false;
    }
    

}
