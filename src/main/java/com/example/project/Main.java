package com.example.project;
public class Main {
    public static void main(String[] args) {
        String temp = "Mississippi";
        String part = "si";

        int position = 0;
        int count = 0;

        while(temp.indexOf(part) >= 0) {
           position = temp.indexOf(part);
              count++;
                 temp = temp.substring(position + 1);
                 }

                 System.out.println(count);

    }
}
