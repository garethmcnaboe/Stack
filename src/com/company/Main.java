package com.company;

import java.util.Scanner;

public class Main {

    private static int maxSize;
    private static int[] stackArray;
    private static int top;
    private static int numberOfInstructions;
    private static int tempInt;

    public static void Stack(int s){
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public static void push(int j){
        top++;
        stackArray[top] = j;
    }

    public static int pop(){
        return stackArray[top--];
    }

    //public long peek(){
    //    return stackArray[top];
    //}

    public static boolean isEmpty(){

        return(top == -1);
    }

    //public boolean isFull(){
    //    return(top == maxSize-1);
    //}

    //public void makeEmpty(){
    //    top=-1;
    //}

    public static int separateOut(String tempStr){

        for (int j = 0; j < tempStr.length(); j++) {
            if (tempStr.charAt(j) == ' ') {
                String tempStr1 = tempStr.substring(j+1);
                tempInt = Integer.parseInt(tempStr1);
            }
        }
        return tempInt;
    }


    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
         numberOfInstructions = sc.nextInt();

         Stack(numberOfInstructions);

         sc.nextLine();
         for(int i = 0; i<numberOfInstructions; i++) {
             String tempStr = sc.nextLine();

             if (tempStr.charAt(1) == 'O') {
                 if (!isEmpty()) {
                     pop();
                 }
             }

             if (tempStr.charAt(1) == 'U') {
                 tempInt = separateOut(tempStr);
                 push(tempInt);
             }
         }

         int largestItem = 0;

         for(int h = top; h > -1; h--){
             if(stackArray[h] > largestItem){
                 largestItem = stackArray[h];
             }
         }


         if (largestItem>0) {
             System.out.println(largestItem);
         }
         else
             System.out.println("empty");

         //for(int m = top; m>-1; m--){
           //  System.out.println(stackArray[m] + " ");
         //}
    }
}
