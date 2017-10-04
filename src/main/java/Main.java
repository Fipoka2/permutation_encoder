import java.util.Scanner;

public class Main{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String DEFAULT_MESSAGE = "Internet security is a branch of computer security" +
            " specifically related to the Internet, often involving browser security but also " +
            "network security on a more general level as it applies to other applications or operating" +
            " systems on a whole. Its objective is to establish rules and measures to use against attacks " +
            " the Internet.";

    public static void main(String[] args) {
        Validator v = new ArrayValidator();
        String message;
        PermutationEncoder encoder;

        System.out.println("1:enter message\n2:default message  ");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1: {
                sc.nextLine();
                message = sc.nextLine();
                System.out.println("capacity:");
                int capacity  = sc.nextInt();
                System.out.println("transposition array:");
                int arr[] = new int[capacity];
                for (int i = 0;i<capacity;i++)
                    arr[i] = sc.nextInt();
                try {
                    if (!v.isValid(arr)) {
                        System.out.println("array exception...");
                        System.exit(0);
                    }
                }
                catch (ArrayIndexOutOfBoundsException ex)
                {
                    System.out.println("array exception...");
                    System.exit(0);
                }
                encoder = new PermutationEncoder(arr,capacity);
                break;
            }
            case 2:{
                message = DEFAULT_MESSAGE;
                encoder = new PermutationEncoder();
                break;
            }
            default: {
                message = DEFAULT_MESSAGE;
                encoder = new PermutationEncoder();
                break;
            }
        }

        encoder.encode(message);
        System.out.println();
        message = encoder.encode(message);
        System.out.println();
        System.out.println(ANSI_RED + "Encoded message: " + ANSI_RESET + message);

        System.out.println("1:enter  decoded message\n2: use default decoded message  ");
        String msg;
        switch (sc.nextInt()){
            case 1: {
                sc.nextLine();
                msg = sc.nextLine();
                System.out.println("capacity:");
                int capacity  = sc.nextInt();
                encoder.setUnitCapacity(capacity);
                System.out.println("transposition array:");
                int arr[] = new int[capacity];
                for (int i = 0;i<capacity;i++)
                    arr[i] = sc.nextInt();
                try {
                    if (!v.isValid(arr)) {
                        System.out.println("array exception...");
                        System.exit(0);
                    }
                }
                //fsdsfs
                catch (ArrayIndexOutOfBoundsException ex)
                {
                    System.out.println("array exception..");
                    System.exit(0);
                }
                encoder.setPermutationArray(arr);
                break;
            }
            case 2:{
                msg = message; break;
            }
            default: { msg = message; break;
            }
        }

        if (msg.length()%encoder.getUnitCapacity()==0)
            System.out.println(ANSI_RED + "Decoded message: " + ANSI_RESET + encoder.decode(msg));
        else System.out.println( ANSI_RED + "An error occurred while encoding a message." + ANSI_RESET);


    }
}
