package nik.ch5;

import nik.ch5.OrderedArrayRecursion;

public class OrderedArrayRecursionApp {
    public static void main(String[] args) {
        OrderedArrayRecursion arr = new OrderedArrayRecursion(10);
        arr.insert(10);
        arr.insert(6);
        arr.insert(15);
        arr.insert(3);
        arr.display();
        System.out.println(arr.find(10));
        if(arr.find(27) == arr.size())
            System.out.println("Can't find value 27");
        else
            System.out.println(arr.find(27));
    }
}
