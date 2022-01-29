public class CenterPrint {
    public void centerPrint(String aString){
        // Line and its middle
        String line = "\n----------------------------";
        int middle = line.length()/2;
        String lineSub = line.substring(0,middle);
        String lineRemainder = line.substring(middle);
        // aString and its middle
        int half = aString.length()/2;
        String sub = aString.substring(0, half);
        String remainder = aString.substring(half);
        // Split line into 2 different char array at middle
        char[] lineSubChars = lineSub.toCharArray();
        char[] lineRemainderChars = lineRemainder.toCharArray();
        // Split aString into 2 different char array at middle
        char[] aStringSubChars = sub.toCharArray();
        char[] aStringRemainderChars = remainder.toCharArray();

        // Replace subLine last chars subString
        for (int i = 0;i < aStringSubChars.length; i++){
            lineSubChars[lineSubChars.length - aStringSubChars.length+ i] = aStringSubChars[i];
        }
        // Replace remainderLine fisrt chars with aString remainder
        for (int i = 0;i < aStringRemainderChars.length; i++){
            lineRemainderChars[i] = aStringRemainderChars[i];
        }
        // Combine both into one string
        String fullString = String.valueOf(lineSubChars) + String.valueOf(lineRemainderChars);
        System.out.println(fullString);
    }
    public void printLine(){
        System.out.println("----------------------------");
    }
}
