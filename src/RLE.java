import java.util.Scanner;

public class RLE {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int userOption = 1;
        String userInput;
        String encodedMessage;
        String decodedMessage;

        while (userOption > 0 && userOption < 5) {

            System.out.println("What would you like to do?");
            System.out.println("1.Input string to be encoded");
            System.out.println("2.View encoded string");
            System.out.println("3.View decoded string");
            System.out.println("4.Exit program");
            System.out.print("Option: ");
            userOption = scanner.nextInt();
            System.out.println("");


            if (userOption == 1) {
                System.out.print("Enter message: ");
                userInput = scanner.next();

            } else if (userOption == 2) {
                encodedMessage = encodeRLE(userInput);
                System.out.print("The encoded data is: " + encodedMessage);
                System.out.println("");

            } else if (userOption == 3) {
                decodedMessage = decodeRLE(userInput);
                System.out.print("The decoded data is: " + decodedMessage);
                System.out.println("");

            } if (userOption == 4) {
                System.out.println("Program terminated");
                break;
            }
        }
    }

    public static int numOfDigits(int num){
        num = Math.abs(num);
        int numDigits = String.valueOf(num).length();
        return numDigits;
    }

    public static char[] toCharArray (int charCount, char strchar){
        int i;

        String charCountArray = String.valueOf(charCount);
        String strcharArray = Character.toString(strchar);
        String array = charCountArray.concat(strcharArray);

        char[] charArray = new char[array.length()];

        for (i = 0; i < array.length(); i++){
            charArray[i] = array.charAt(i);
        }

        while(charCount == 1){
            return;
            //FIXME
        }
        while(charCount < 1){
            return null;
        }

        return charArray;
    }

    public static int findEncodeLength(String inputString) {
        int i;
        int ascii;
        int uniqueChar = 1;
        if(inputString == null || inputString.equals("")){
            uniqueChar = 0;
        }
        for (i = 0; i < inputString.length() - 1; i++) {
            ascii = (int) inputString.charAt(i);

            if(inputString.length() == 1){
                uniqueChar--;
            }
            else if ((ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 122)) {
                uniqueChar++;
            }
            if(inputString.charAt(i) == inputString.charAt(i + 1)){
                uniqueChar--;
            }
        }
        return uniqueChar;
    }

    public static int findDecodeLength(String rleString) {
        int i;
        int sum = 0;
        String stringSum = "";
        int integer = 0;
        for (i = 0; i < rleString.length(); i++) {
            while ((int)rleString.charAt(i) > 64 && (int)rleString.charAt(i) < 91){
                sum++;
                i++;
            }
            while((int)rleString.charAt(i) > 97 && (int)rleString.charAt(i) < 122){
                sum++;
                i++;
            }//FIXME
            while ((int)rleString.charAt(i) > 48 && (int)rleString.charAt(i) < 58) {
                stringSum += rleString.charAt(i);
                i++;
            }
            integer = Integer.parseInt(stringSum);
            sum += integer;
            stringSum = "0";
            integer = 0;
        }
        return sum;
    }

    public static char[] decodeRLE(String rleString) {

    }

    public static char[][] encodeRLE(String inputString){

    }

}