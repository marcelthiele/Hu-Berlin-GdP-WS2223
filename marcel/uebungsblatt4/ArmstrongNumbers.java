package marcel.uebungsblatt4;

public class ArmstrongNumbers {
    public static void main(String[] args) {
        System.out.println(isArmstrongNumber(370));
    }

    public static boolean isArmstrongNumber(int toCheck){
        int countOfNumbers = (int)Math.log10((double)toCheck)+1;
        int[] individualNumbers = new int[countOfNumbers]; 
        System.out.println("countOfNumber: " + countOfNumbers);

        int tempForIndividualNumberConversion = toCheck;
        for(int i = 0; i < countOfNumbers; i++){
            int currentNumber = tempForIndividualNumberConversion % 10;
            tempForIndividualNumberConversion /= 10;

            individualNumbers[i] = currentNumber;
            System.out.println(currentNumber);
        }

        int checkSum = 0;
        for(int i = 0; i < individualNumbers.length; i++){
            checkSum += Math.pow(individualNumbers[i], countOfNumbers);
        }

        return checkSum == toCheck;
    }

    public static int[] giveArmstrongNumbers(int numbersToReturn){
        return new int[6];
    }
}
