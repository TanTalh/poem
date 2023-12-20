package com.example.pushkin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        String s = "У Лукоморья дуб зеленый";
        int charCount = s.length();
        int wordCount = countWords(s);
        int lCount = countSpecificChar(s,'л');
        List<String> WordsStartingWithA = findWordsStartingWith(s, "а");
        List<String> fiveLettersWords = findWordsWithLenght(s, 5);

        String resultString = String.format(
                "Колличество символов: "+charCount+
                        "\nКолличество букв 'л': "+lCount+
                        "\nКолличество слов: "+wordCount+
                        "\nСлова из 5 букв: "+listToString(fiveLettersWords)+
                        "\nСлова начинающиеся на 'а': "+listToString(WordsStartingWithA));

        resultTextView.setText(resultString);

    }

    private int countSpecificChar (String text, char targetChar){  // счетовод нужных чаров
        int count = 0;
        for(char c : text.toCharArray()){
            if (c == targetChar){
                count++;
            }
        }
        return count;
    }

    private int countWords(String text){ // счетчик слов по пробелам
        String[] words = text.split("\\s+");
        return words.length; //
    }

    private List<String> findWordsWithLenght(String text, int lenght){
        List<String> words = new ArrayList<>();
        String[] allWords = text.split("\\s+");
        for(String word : allWords){
            if(word.length() == lenght){
                words.add(word);
            }
        }
        return words;
    }

    private   List<String> findWordsStartingWith(String text, String prefix){
        List<String> words = new ArrayList<>();
        String[] allWords = text.split("\\s+");
        int  w = 0;
        for(String word : allWords){
            if (word.toLowerCase().startsWith(prefix.toLowerCase())){
                words.add(word);
                w++;
            }
        }
        return words;
    }

    private String listToString (List<String> list){
        StringBuilder builder = new StringBuilder();
        for(String item : list){
            builder.append(item).append(",");
        }
        if(builder.length() > 2){
            builder.setLength(builder.length() - 2);
        }
        return builder.toString();
    }














}