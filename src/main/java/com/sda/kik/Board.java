package com.sda.kik;

import java.util.Arrays;

/**
 * Created by RENT on 2017-06-20.
 */
public class Board {

//    private String[] array = new String[9];
//
//    public Board(String[] array) {
//        this.array = array;
//    }

    private  String[] array;

    public Board() {
        array = new String[9];

    }

    /**
     * opis lalala
     * @param position values (1-9)
     * @param sign values (O or X)
     * @return
     */

    public boolean addMove(int position, String sign) {
        boolean valueToReturn = false;
        if (isRangeValid(position) && isPositionEmpty(position)) {
            array[position - 1] = sign;
            valueToReturn = true;
        }
        return valueToReturn;
    }

    public boolean isGameFinished(String[] array) {
//        boolean valueToReturn = false;
//        if () {
//
//            valueToReturn = true;
//        }
//        return valueToReturn;
        return true;
    }

    private boolean isFulfilled() {

        return  true;
    }

    private boolean areValuesEquals(int i, int j, int k) {
        return array[i] != null && array[i].equals(array[j]) && array[i].equals(array[k]);
    }

    private boolean checkRows() {
        boolean flag = false;
        int i = 0;
        do {
            flag = areValuesEquals(i, i + 1, i + 2);
            i += 3;
        } while (i < 9 &&!flag);
        return  flag;
    }

    private boolean checkColumns() {

        return  true;
    }

    private boolean checkDiagonals() {

        return  true;
    }

    private boolean isRangeValid(int position) {
        return (position > 0 && position < 10);
    }

    private boolean isPositionEmpty(int position) {
        return array[position - 1] == null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i] == null ? (i + 1) : array[i]);
            stringBuilder.append((i + 1) % 3 == 0 ? "\n" : "|");
        }

        return stringBuilder.toString();
    }
}

