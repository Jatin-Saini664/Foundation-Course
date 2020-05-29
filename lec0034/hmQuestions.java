import java.util.HashMap;

import java.util.*;

public class hmQuestions {
    public static void maxFreqChar(String str) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map1.get(ch)==null)
                map1.put(ch,1);
            else
                map1.put(ch,map1.get(ch)+1);
        }
        int max=0;
        char a='a';
        for(char key:map1.keySet()){
            if(map1.get(key)>max){
                max=map1.get(key);
                a=key;
            }
        }
        System.out.println(a+" --> "+max);
    }
    public static void common(int[] arr,int[] arr1) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],true);
        }
        for(int i=0;i<arr1.length;i++){
            if(map.get(arr1[i])!=null){
                System.out.print(arr1[i]+" ");
            }
        }
    }
    public static void common2(int[] arr,int[] arr1) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])==false)
                map.put(arr[i],1);
            else
            map.put(arr[i],map.get(arr[i])+1);
        }
        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])&&map.get(arr1[i])>1){
                System.out.print(arr1[i]+" ");
                map.put(arr1[i],map.get(arr1[i])-1);
            }else if(map.containsKey(arr1[i])&&map.get(arr1[i])==1){
                System.out.println(arr1[i]+" ");
                map.remove(arr1[i]);
            }
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        String str = "abchehjwekjwdvhjegdbwbjhgwbxvjygxbqjgab";
        // maxFreqChar(str);
        // map.put("india",345902);
        // map.put("brazil",67478);
        // map.put("us",28976);
        // map.put("tanzania",4567);
        // map.put("mexico",98675);
        // map.put("japan",2456);
        // map.put("china",23465789);
        // map.remove("tanzania");
        // Syst<em.out.println(map.get("india"));<
        // int[] arr = {5,10,1,2,7,9,15,8,6,20,27};
        // int[] arr1 = {3,30,29,37,1,7,8,20,2};
        // common(arr,arr1);
        int[] arr = {1,5,10,27,9,8,7,5,6,20,27,3,7};
        int[] arr1 = {3,3,27,37,27,5,30,27};
        common2(arr, arr1);
    }
}