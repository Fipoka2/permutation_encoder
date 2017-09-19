import java.util.Arrays;

public class ValidTest {

    public static void main(String[] args) {

        Validator v = new ArrayValidator();
        try {
            System.out.println(v.isValid(new int[]{1,5,3,4,2}));
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }

    }

}
