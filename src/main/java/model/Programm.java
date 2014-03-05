package model;

import model.engine.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programm {
    static BufferedReader br;
    public static void main(String... args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        Board gf = new Board();
        gf.beginTurn();
        gf.endTurn();
        gf.beginTurn();
        gf.endTurn();

        int action = 0;
        do{
            System.out.println(gf.getStatus());
            System.out.println("Введи номер разыгрваемой карты ");
            int cardNum = Integer.valueOf(br.readLine());
            gf.playCard(cardNum);
            System.out.println(gf.toString());
        }while(action!=0);
    }

    public static void requestHex(int[] coords) {

        System.out.println("В какую ячейку сыграть (2 числа через запятую)?");
        String[] str = new String[0];
        try {
            str = br.readLine().split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        coords[0] = Integer.valueOf(str[0]);
        coords[1]= Integer.valueOf(str[1]);

    }
}
