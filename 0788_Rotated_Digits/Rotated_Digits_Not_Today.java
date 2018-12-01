public class Rotated_Digits_Not_Today {
    public int rotatedDigits(int N) {
        HashMap<Integer,Integer> map = new HashMap<>(7);
        map.put(2,5);
        map.put(5,2);
        map.put(6,9);
        map.put(9,6);
        Set<Integer> limitSet = new HashSet<>(8);

        limitSet.add(0);
        limitSet.add(1);
        limitSet.add(2);
        limitSet.add(5);
        limitSet.add(6);
        limitSet.add(8);
        limitSet.add(9);
        int remainder;
        int count = 0;
        boolean flag;
        int divisor;
        for(int i = 1;i <= N ;i++){
            flag = true;
            divisor = i;
            do{
                remainder = divisor % 10;
                if(!limitSet.contains(remainder)){
                    flag = false;
                }
                divisor /= 10;
            }while(divisor != 0 && flag);
            if(flag && isGoodNum(i,map)){
                System.out.println(i);
                count++;
            }
        }

        return count;
    }
    public boolean isGoodNum(int num,HashMap map)

    {

        int remainder = num % 10;
        int divisor = num / 10;
        int result = (map.containsKey(remainder)) ? (int)map.get(remainder) : remainder;
        int count = 1;
        while(divisor > 0){
            remainder = divisor % 10;
            result += ((map.containsKey(remainder)) ? (int)map.get(remainder) : remainder) * Math.pow(10,count);
            divisor /= 10;
            count++;
        }
        return !(result == num);


    }
}
