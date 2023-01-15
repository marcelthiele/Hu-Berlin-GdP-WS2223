public class Gray {
    public static void main(String[] args) {
        System.out.println(toGray(Integer.parseInt(args[0])));

        for(int i = 0; i < Integer.MAX_VALUE; i++){
            boolean test = toGray(fromGray(i)) == i;
            if(!test) System.out.println(test + " bei " + i);
        }
    }

    public static int toGray(int n){
        char[] binary = Integer.toBinaryString(n).toCharArray();

        int[] gray = new int[binary.length];

        gray[0] = binary[0] - 48;

        for(int i = 0; i < binary.length-1; i++){
            int a = binary[i] - 48;
            int b = binary[i+1] - 48;
            gray[i+1] = a == b ? 0 : 1;
        }

        // printArray(gray);

        return binaryToDecimal(gray);
    }

    public static int fromGray(int g){
        char[] gray = Integer.toBinaryString(g).toCharArray();

        int[] binary = new int[gray.length];
        
        binary[0] = gray[0] - 48;

        for(int i = 0; i < gray.length-1; i++){
            int a = gray[i] - 48;
            int b = gray[i+1] - 48;

            if(b == 0)
                binary[i+1] = binary[i];
            else
                binary[i+1] = binary[i] == 0 ? 1 : 0;
        }

        // printArray(binary);

        return binaryToDecimal(binary);
    }

    public static int binaryToDecimal(int[] binaryArray){
        int returnInteger = 0;

        for(int i = 0; i < binaryArray.length; i++){
            if(binaryArray[i] == 1)
                returnInteger += Math.pow(2, binaryArray.length-i-1);
        }

        return returnInteger;
    }

    public static void printArray(int[] array){
        String printString = "";
        for(int i = 0; i < array.length; i++){
            printString += array[i];
        }
        System.out.println(printString);
    }
}
