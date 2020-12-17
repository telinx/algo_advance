package com.base.class_03;

import java.util.LinkedList;
import java.util.Queue;

interface Animal{
    void eat();
    int getIndex();
}

class Cat implements Animal{
    
    private int index;
    
    

    public void eat() {
        System.out.println("Cat eat");
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

class Dog implements Animal{
    
    private int index;
    
   
    
    public void eat() {
        System.out.println("Dog eat");
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

public class C5_CatDogQueue {
    
    private Queue<Animal> catQueue;
    private Queue<Animal> dogQueue;
    private int index;
    public C5_CatDogQueue() {
        super();
        this.catQueue = new LinkedList<Animal>();
        this.dogQueue = new LinkedList<Animal>();
        this.index = 0;
    }
    
    public void add(Dog dog) {
        this.index++;
        dog.setIndex(index);
        this.dogQueue.add(dog);
    }
    
    public void add(Cat cat) {
        this.index++;
        cat.setIndex(index);
        this.dogQueue.add(cat);
    }
    
    public Animal poll() {
        if(this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
            throw new RuntimeException("empty");
        }
        Animal animal = null;
        if(!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
            if(this.dogQueue.peek().getIndex() < this.catQueue.peek().getIndex()) {
                animal = this.dogQueue.poll();
            }else {
                animal = this.catQueue.poll();
            }
        }else if(!this.dogQueue.isEmpty()) {
            animal = this.dogQueue.poll();
        }else {
            animal = this.catQueue.poll();
        }
        return animal;
    }
    
    public Animal pollDog() {
        if(this.dogQueue.isEmpty()) {
            throw new RuntimeException("empty");
        }
        return this.dogQueue.poll();
    }
    
    public Animal pollCat() {
        if(this.catQueue.isEmpty()) {
            throw new RuntimeException("empty");
        }
        return this.catQueue.poll();
    }
    
    

}
