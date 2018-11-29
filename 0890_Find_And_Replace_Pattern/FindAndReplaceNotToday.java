import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplaceNotToday {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        int length = words.length;
        List<String> list = new ArrayList<>(length);
        for(int i = 0; i < length;i++){
            if(isStringEquals(words[i],pattern))
                list.add(words[i]);
        }
        return list;

    }
    public static boolean isStringEquals(String source ,String target){
        int length = target.length();
        HashMap<Character,Character> map = new HashMap<>(length);
        map.put(target.charAt(0),source.charAt(0));
        for(int i = 1;i < length;i++){
            Character tmp_target = target.charAt(i);
            Character tmp_source = source.charAt(i);
            if(map.containsKey(tmp_target) ){
                if(!map.get(tmp_target).equals(tmp_source))
                    return false;
            }
            else if(map.containsValue(tmp_source)){
                for(Map.Entry entry:map.entrySet()){
                    if(tmp_source.equals(entry.getValue()) && !tmp_target.equals(entry.getKey()))
                        return false;
                }
            }
            else{
                map.put(tmp_target,tmp_source);
            }

        }

        return true;


    }


}
