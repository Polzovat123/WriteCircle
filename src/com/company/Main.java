package com.company;

import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class Main extends JFrame {

    public static int Size = 200;
    public static int height_window = 1300;
    public static int weight_window = 2400;
    
    public Main(){
        setTitle("Background");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(weight_window,height_window);
        add(new GameField(Size, weight_window,height_window));
        setVisible(true);
    }

    public static void read_data(){
        System.out.println("Write size array: ");
        Scanner in = new Scanner(System.in);
        Size = in.nextInt();
    }
    
    public static void Show(){
	
    }

    public static void main(String[] args) {
        //read_data();
        //create_circle();
	    Main window = new Main();
    }
}
