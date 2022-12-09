package marcel.uebungsblatt4;
/**
 * @author @marcelthiele
 * @version 0.1
 */
public class ArmstrongNumbers {
    public static void main(String[] args) {
        try {
            int inputNumber = Integer.parseInt(args[0]);
            int[] numbers = giveArmstrongNumbers(inputNumber);
            printArray(numbers);
        } catch (Exception e) {
            System.out.println("Bitte eine akzeptierte Zahl eingeben");
            System.exit(1);
        }
    }

    public static boolean isArmstrongNumber(int toCheck){
        int countOfNumbers = (int)Math.log10((double)toCheck)+1;
        int[] individualNumbers = new int[countOfNumbers]; 

        int tempForIndividualNumberConversion = toCheck;
        for(int i = 0; i < countOfNumbers; i++){
            int currentNumber = tempForIndividualNumberConversion % 10;
            tempForIndividualNumberConversion /= 10;

            individualNumbers[i] = currentNumber;
        }

        int checkSum = 0;
        for(int i = 0; i < individualNumbers.length; i++){
            checkSum += Math.pow(individualNumbers[i], countOfNumbers);
        }

        return checkSum == toCheck;
    }

    public static int[] giveArmstrongNumbers(int numbersToReturn){
        if(numbersToReturn == 0) return new int[0];

        int countOfFoundNumbers = 1;
        int[] returnArray = new int[numbersToReturn];
        returnArray[0] = 0;

        int currentNumber = 1;
        while(countOfFoundNumbers < numbersToReturn){
            if(isArmstrongNumber(currentNumber)){
                returnArray[countOfFoundNumbers] = currentNumber;
                countOfFoundNumbers++;
            }
            currentNumber++;
        }

        return returnArray;
    }

    public static void printArray(int[] arrayToPrint){
        String printString = "";
        for(int i = 0; i < arrayToPrint.length; i++){
            printString += arrayToPrint[i];
            if(i < arrayToPrint.length-1)
                printString += ",";
        }

        System.out.println(printString);
    }
}
