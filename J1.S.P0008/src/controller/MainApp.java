package controller;

import common.InOutUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MainApp {
    private Map<String,Integer> counterWord = new HashMap<String, Integer>();
    private Map<Character,Integer> counterChar = new HashMap<Character, Integer>();

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        System.out.println("Enter your content:");
        String content = InOutUtils.inputString();
        mainApp.analyze(content);
        mainApp.displayCounter();
    }
    public void displayCounter(){
        System.out.println(counterWord);
        System.out.println(counterChar);
    }
    public void analyze(String content){
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) continue;
            if(!counterChar.containsKey(ch)){
                counterChar.put(ch,1);
            }else{
                counterChar.put(ch,((int)counterChar.get(ch)) + 1);
            }
        }
        StringTokenizer tokenizer = new StringTokenizer(content);
        while(tokenizer.hasMoreElements()){
            String token = tokenizer.nextToken();
            if(!counterWord.containsKey(token)){
                counterWord.put(token,1);
            }else{
                counterWord.put(token, ((int)counterWord.get(token)) + 1);
            }
        }
    }
}
