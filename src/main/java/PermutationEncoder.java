import java.util.Arrays;

public class PermutationEncoder implements Encoder{

    private final String regex;

    private int[] permutationArray;

    private int unitCapacity;

    public PermutationEncoder() {
        unitCapacity =15;
        int temp[] = {5,10,2,3,0,4,11,14,7,13,8,1,12,6,9};
        permutationArray = temp;
        regex = "(?<=\\G.{"+ unitCapacity + "})";
    }

    public PermutationEncoder(int[] permutationArray, int unitCapacity) {
        this.permutationArray = permutationArray;
        this.unitCapacity = unitCapacity;
        regex = "(?<=\\G.{"+ unitCapacity + "})";
    }

    @Override
    public String encode(String message) {

        String[] substr = message.split(regex);
        String last = substr[substr.length-1];
        if (last.length()!=unitCapacity){
            substr[substr.length-1] = addSpace(last,unitCapacity-last.length());
        }
        for (int i=0;i<substr.length;i++){
            substr[i] = permute(substr[i]);
        }
        StringBuilder sb = new StringBuilder();

        for (String s : Arrays.asList(substr))
        {
            sb.append(s);
        }
        return sb.toString();
    }

    @Override
    public String decode(String encodedString) {
        String[] substr = encodedString.split(regex);
        for (int i=0;i<substr.length;i++){
            substr[i] = reverse(substr[i]);
        }
        StringBuilder sb = new StringBuilder();

        for (String s : Arrays.asList(substr))
        {
            sb.append(s);
        }
        return sb.toString();
    }

    private String addSpace(String str, int number){
        for (int i=0 ; i<number; i++){
            str  = str.concat(" ");
        }
        return str;
    }

    private String permute(String str){
        char[] chars = str.toCharArray();
        char[] chars1 = new char[chars.length];
        for (int i=0;i<chars.length;i++){
            chars1[i] = chars[permutationArray[i]];
        }
        return new String(chars1);

    }

    private String reverse(String str){
        char[] chars = str.toCharArray();
        char[] chars1 = new char[chars.length];
        for (int i=0;i<chars.length;i++){
            chars1[permutationArray[i]] = chars[i];
        }
        return new String(chars1);
    }


    public int getUnitCapacity() {
        return unitCapacity;
    }

    public int[] getPermutationArray() {
        return permutationArray;
    }

    public void setPermutationArray(int[] permutationArray) {
        this.permutationArray = permutationArray;
    }

    public void setUnitCapacity(int unitCapacity) {
        this.unitCapacity = unitCapacity;
    }
}
