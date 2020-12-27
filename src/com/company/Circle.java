package com.company;

import java.util.Random;

public class Circle {

    private int x, y;
    
    public Circle(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int get_x(){
        return x;
    }

    public int get_y(){
        return y;
    }

    public boolean check_to_touch(Circle cir[], int Size, int num_now, int new_x, int new_y, int R){
        for(int i=0; i<Size; i++){
            if(i != num_now){
                double del_x = cir[i].x - new_x;
                double del_y = cir[i].y - new_y;
                double len_between_two_circle = Math.sqrt( del_x * del_x + del_y * del_y );
                if(len_between_two_circle < R * R){
                    return false;
                }
            }
        }
        return true;
    }

    public void move( int speed, int w, int h, int sp_code, Circle a[], int Size, int num_now, int R){
        final Random rd = new Random();
        rd.setSeed(sp_code);
        int sc =0;
        while(true){
            int degree = (int) (( Math.random() * (90-0) ) + 0);

            int delta_x = (int) (speed * Math.sin(degree));
            if(rd.nextInt(200)-100<0){delta_x*=-1;}
            int delta_y = (int) (speed * Math.cos(degree))* rd.nextInt(2)-1;
            if(rd.nextInt(200)-100<0){delta_y*=-1;}
            if(x+delta_x>0 && x+delta_x<w && y + delta_y>0 &&
                    y + delta_y < h && check_to_touch(a, Size, num_now, x + delta_x, y + delta_y, R)){
                x += delta_x;
                y += delta_y;
                return;
            }
            if(sc == 10)return;
            sc++;
        }
    }

}
