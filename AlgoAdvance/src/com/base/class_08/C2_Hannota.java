package com.base.class_08;

public class C2_Hannota {
    
    public static void process(int dish, String from, String middle, String to) {
        if(dish == 1) {
            System.out.println(dish + " from " + from + " move to " + to);
            return;
        }
        process(dish - 1, from, to, middle);
        System.out.println(dish + " from " + from + " move to " + to);
        process(dish - 1, middle, from, to);
    }
    
    public static void main(String[] args) {
        process(3, "A", "B", "C");
    }

}
