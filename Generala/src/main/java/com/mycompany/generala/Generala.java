/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

/**
 *
 * @author Marcelo
 */
public class Generala {

    protected int[] dice;

    public Generala(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }


    public static int chance(int ... dice) {
        int total = 0;
        for (int valorObtenido : dice) {
            total += valorObtenido;
        }
        return total;
    }


    // '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
    //es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
    public static int generala(int... dice){
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }


    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return suma(1,d1,d2,d3,d4,d5);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return suma(2,d1,d2,d3,d4,d5);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return suma(3,d1,d2,d3,d4,d5);
    }

    public static int suma(int mod,int... dice){
        int suma=0;
        for (int valorDado : dice){
            if (valorDado == mod){suma+=mod;}
        }
        return suma;
    }

    public int fours(){
        int sum= 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives(){
        int sum = 0;
        for (int die : dice)
            if (die == 5)
                sum = sum + 5;
        return sum;
    }

    public int sixes(){
        int sum = 0;
        for (int die : dice)
            if (die == 6)
                sum = sum + 6;
        return sum;
    }

    public static int score_pair(int...dice){
        int[] counts = new int[6];
        for (int cara : dice) {
            counts[cara - 1]++;
        }
        for (int at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public static int two_pair(int...dice){
        int[] counts = new int[6];
        for (int cara : dice) {
            counts[cara - 1]++;
        }
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int...dice){
        int[] tallies= new int[6];
        for (int cara : dice){
            tallies[cara-1]++;
        }
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int ... dice){
        int[] t = new int[6];
        for (int cara : dice){
            t[cara-1]++;
        }
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int ... dice){
        int[] tallies = new int[6];
        for (int cara : dice){
            tallies[cara-1] += 1;
        }
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int...dice){
        int[] tallies = new int[6];
        for (int cara : dice){
            tallies[cara-1] += 1;
        }
        if (tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1 && tallies[5] == 1) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(int...dice){
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        for (int cara : dice){
            tallies[cara-1] += 1;
        }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}

