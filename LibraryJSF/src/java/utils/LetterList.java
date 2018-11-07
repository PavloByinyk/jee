/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author pbyin
 */
@ApplicationScoped
@ManagedBean
public class LetterList {
//    public ArrayList<String> getRussianLetters(){
//        ArrayList<String> letters = new char[21];
//        letters[0] = 'A';
//        letters[1] = 'Б';
//        letters[2] = 'В';
//        letters[3] = 'Г';
//        letters[4] = 'Д';
//        letters[5] = 'Е';
//        letters[6] = 'Э';
//        letters[7] = 'И';
//        letters[8] = 'Ы';
//        letters[9] = 'Н';
//        letters[10] = 'С';
//        letters[11] = 'Р';
//        letters[12] = 'Т';
//        letters[13] = 'М';
//        letters[14] = 'О';
//        letters[15] = 'К';
//        letters[16] = 'У';
//        letters[17] = 'Х';
//        letters[18] = 'Ш';
//        letters[19] = 'Щ';
//        letters[20] = 'Я';
//    return letters; 
//    }
     public ArrayList<String> getRussianLetters(){
        ArrayList<String> letters = new ArrayList<String>();
        letters.add("A");
        letters.add("Б");
        letters.add("В");
        letters.add("Г");
        letters.add("Д");
        letters.add("Е");
        letters.add("Э");
        letters.add("И");
        letters.add("Ы");
        letters.add("Н");
        letters.add("С");
        letters.add("Р");
        letters.add("Т");
        letters.add("М");
        letters.add("О");
        letters.add("К");
        letters.add("У");
        letters.add("Х");
        letters.add("Ш");
        letters.add("Щ");
        letters.add("Я");
    return letters; 
    }
}
