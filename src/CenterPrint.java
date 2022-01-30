public class CenterPrint {
    public void centerPrint(String aString){
        // Start with length of 28 line for printing
        // Then finding line middle
        // Then split it to 2 different string
        String line = "\n----------------------------";
        int middle = line.length()/2;
        String lineSub = line.substring(0,middle);
        String lineRemainder = line.substring(middle);

        // same thing as before but now for parameter aString
        int half = aString.length()/2;
        String sub = aString.substring(0, half);
        String remainder = aString.substring(half);

        // Split both lines and strings into own char arrays
        char[] lineSubChars = lineSub.toCharArray();
        char[] lineRemainderChars = lineRemainder.toCharArray();
        char[] aStringSubChars = sub.toCharArray();
        char[] aStringRemainderChars = remainder.toCharArray();

        // Replace first line last chars with half of the subString
        for (int i = 0;i < aStringSubChars.length; i++){
            lineSubChars[lineSubChars.length - aStringSubChars.length+ i] = aStringSubChars[i];
        }
        // Replace second line first chars with remainder chars of aString
        for (int i = 0;i < aStringRemainderChars.length; i++){
            lineRemainderChars[i] = aStringRemainderChars[i];
        }
        // Combine both into one string
        String fullString = String.valueOf(lineSubChars) + String.valueOf(lineRemainderChars);
        System.out.println(fullString);
    }
    //Basic line printer for bottom of each section
    public void printLine(){
        System.out.println("----------------------------");
    }
}
