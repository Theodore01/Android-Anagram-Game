package com.example.teo.anagramgame;

import java.util.Random;

/**
 * Created by Teo on 13/2/2018.
 */

public class AnagramGame {
    public static final Random rand = new Random();
    public static final String [] Words = {"JAZZ","BUZZ","QUIZ","JUMP","JOKE","HELP","PULP","JAVA","MAZE","JEEP",
    "ECHO","OOZE","THUG","JOLT","BARD","LAMB","LAMP","CHEF","KNOB","YAWN","FLAT","PUSS","OGRE","NERD","TOFU","PING","PINK"
    ,"BLUE","PUMA","LION","RUBY","SOFA","DOOR","BEAR","CARD","COOK","COLD","DRAW","DROP","DAYS","EASY","HARD","EVIL","GOOD",
            "WALK","FAST","SLOW","FILM","FORM","HERO","HUGE","RICE","FOOD","MALE"};
    public static final String [] WordsMedium = {"BATTLE","BOTTLE","BREATH","ACTION","ANNUAL","CANCER","CIRCLE","CENTER","CHANGE"
    ,"CLIENT","DANGER","DEFEND","DOCTOR","DOLLAR","ELEVEN","ENERGY","ESCAPE","ENDING","EXPERT","FAMOUS","FATHER","FEMALE","FORMAT",
    "FLIGHT","FORMAL","FOREST","FOURTH","FRENCH","GENDER","GOLDEN","GROUND","GROWTH","HEIGHT","HEALTH","HIDDEN","ISLAND","JUNIOR",
    "LAWYER","LIQUID","MEMORY","MOTHER","REMOVE","REPLAY"};
    public static final String [] WordsExpert = {"BIRTHDAY","BASEBALL","BATHROOM","BACTERIA","CHEMICAL","CONTINUE","CREATION","CRIMINAL",
    "DATABASE","DIABETES","DISASTER","DELIVERY","EDUCATED","ENORMOUS","ELECTION","EQUALITY","EVERYONE","EXERCISE","FACILITY","FINISHED",
    "EXTERNAL","FAMILIAR","FIREWALL","FOOTBALL","FRIENDLY","FLOATING","GENEROUS","GRADUATE","GRAPHICS","GUARDIAN","HARDWARE","INNOCENT",
    "INSPIRED","HOSPITAL","KEYBOARD","LAUGHTER","LIFETIME"};
    public static String getRandomWord(){

        return Words[rand.nextInt(Words.length)];
    }
    public static String getRandomWordMedium(){
        return WordsMedium[rand.nextInt(WordsMedium.length)];
    }
    public static String getRandomWordExpert(){
        return WordsExpert[rand.nextInt(WordsExpert.length)];
    }
    public static String ShuffleWord(String word) {
        if (word != null && !"".equals(word)) {
            char a[] = word.toCharArray();
            for (int i = 0; i < a.length; i++) {
                int j = rand.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
            return new String(a);
        }
        return word;
    }

}
