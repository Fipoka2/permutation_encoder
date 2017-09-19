public class ArrayValidator implements Validator {


    @Override
    public boolean isValid(int[] arr) {

        int valid[] = new int[arr.length];
        for (int anArr : arr) {
            valid[anArr]++;
        }
        for (int i : valid){
            if (i==0)
                return false;
        }
        return true;
    }
}
