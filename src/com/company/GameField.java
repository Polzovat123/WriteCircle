package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class GameField extends JPanel implements ActionListener{
    private final int R = 4;
    private final int D = R*2;
    private final int max_len_line = 40;
    private static int Size = 200;
    private final int speed = 20;
    private int weight;
    private int height;
    public static Circle[] cir = new Circle[Size];
    public Timer t;


    public GameField(int size, int weight_window, int height_window){
        this.Size = size;
        this.weight = weight_window - 200;
        this.height = height_window - 200;
        setBackground(Color.black);
        initGame();
    }

    public void initGame(){
        createCircle();
        t = new Timer(100,this);
        t.start();
    }

    public boolean check_x_y_init(int x, int y, int len){
        for(int i=0;i<len; i++){
            double len_between_circle = Math.sqrt( (x - cir[i].get_x())*(x - cir[i].get_x())
                    + (y - cir[i].get_y())*(y - cir[i].get_y()) );
            if(len_between_circle < R + R){
                return false;
            }
        }
        return true;
    }

    public void createCircle(){
        final Random rd = new Random();
        rd.setSeed(123456789);
        for(int i=0; i<Size; i++){
            int x = rd.nextInt(weight);
            int y = rd.nextInt(height);
            if (check_x_y_init(x, y, i)){
                cir[i] = new Circle(x, y);
            }else{
                i--;
            }
        }

    }

    public int l=1;

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.yellow);
        for(int i=0; i<Size; i++){
            g.drawOval(cir[i].get_x(), cir[i].get_y(), D, D);
        }
    }

    public void move(){
        for(int i=0; i<Size; i++){
            Random rf = new Random(56734326);
            cir[i].move(speed, weight , height, i * rf.nextInt(4000), cir, Size, i, R);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        //System.out.println("I live");
        repaint();
    }
}
