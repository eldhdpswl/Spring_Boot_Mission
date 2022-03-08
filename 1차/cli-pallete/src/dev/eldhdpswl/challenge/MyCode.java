package dev.eldhdpswl.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class MyCode {

    public static void main(String[] atgs) throws Exception{

        Scanner in = new Scanner(System.in);

        System.out.print("숫자를 입력하세요 : ");
        int n = in.nextInt();

        // ArrayList 출력 
        ArrayList<String> al = new ArrayList<>();        

        for(int i=0; i<=n; i++){
            al.add(i+"   Item"+(i+1));
        }
        
        System.out.println();
        System.out.println("ArrayList 출력");
        System.out.println("idx Item");
        if(al.size() != 0){
            for(String value: al){
                System.out.println(value);
            }
        }else{
            System.out.println("No Elements");
        }
        
        
        // LinkedList 출력 
        LinkedList<String> ll = new LinkedList<String>();

        for(int j=0; j<=n; j++){
            ll.add("Item"+(j+1));
        }

        System.out.println();
        System.out.println("LinkedList 출력");
        System.out.println("idx Item");
        if(ll.size() != 0){
            for(int k=0; k<ll.size(); k++){
                System.out.println(k+ "   " + ll.get(k));
            }
        }else{
            System.out.println("No Elements"); 
        }
        

        // Vector 출력 
        Vector<String> v = new Vector<String>();
        for(int i=0; i<=n; i++){
            v.add(i+"   Item"+(i+1));
        }
        Iterator iter = v.iterator();

        System.out.println();
        System.out.println("Vector 출력");
        System.out.println("idx Item");
        if(v.size() != 0){
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        }else{
           System.out.println("No Elements"); 
        }

        

        // HashSet 출력(순서 미출력)
        HashSet<String> set = new HashSet<>();        
        for(int i=0; i<=n; i++){
            set.add(i+"   Item"+(i+1));
        }
        Iterator iter2 = set.iterator();

        System.out.println();
        System.out.println("HashSet 출력");
        System.out.println("idx Item");
        if(set.isEmpty()){
            System.out.println("No Elements");
        }else{
            while(iter2.hasNext()){
                System.out.println(iter2.next());
            }
        }

        // HashSet 출력(순서 출력)
        HashSet<String> set2 = new HashSet<>(); 
        for(int i=0; i<=n; i++){
            set2.add(i+"   Item"+(i+1));
        }
        TreeSet<String> ts = new TreeSet<String>();
        ts.addAll(set2);

        Iterator iter3 = ts.iterator();

        System.out.println();
        System.out.println("HashSet 순서출력");
        System.out.println("idx Item");
        if(set2.isEmpty()){
            System.out.println("No Elements");
        }else{
            while(iter3.hasNext()){
                System.out.println(iter3.next());
            }
        }

    }

}


