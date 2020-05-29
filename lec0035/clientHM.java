import java.util.*;

public class clientHM {
    public static void main(String[] args) {
        hashMap<String, Integer> map = new hashMap<>();
        map.put("India",54748);
        map.put("United Kingdom",5479);
        map.put("Brazil",878);
        map.put("Indonesia",4354);
        map.put("Bangladesh",67892);
        map.put("ziBrla",67892);

        System.out.println(map.size());
        map.remove("Bangladesh");
        System.out.println(map.size());
        for(String s : map.keySet()){
            System.out.println(s+" --> "+map.get(s));
        }
        if(map.containsKey("India")){
            System.out.println(map.get("India"));
        }
        System.out.println("ziBrla".hashCode());
        System.out.println("Brazil".hashCode());
    }
}