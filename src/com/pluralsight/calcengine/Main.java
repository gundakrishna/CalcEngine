    package com.pluralsight.calcengine;

    import java.time.Instant;
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.util.Scanner;

    public class Main {

    static void learnString(){
        int iVal = 100;
        String name = String.valueOf(iVal);
        System.out.println(name);
        int i = 2, j = 3;
        int result = i * j;
        String output = i  + " * " + j + " = " + result;
        System.out.println(output);
    }

    static void learnStringBuilder(){
        String location = "Florida";
        int flightNumber = 175;
        location = "Floridaa";
        StringBuilder sb = new StringBuilder(40);
        sb.append("I flew to ");
        sb.append(location);
        sb.append(" on Flight #");
        sb.append(flightNumber);
        String message = sb.toString();
        String time = "9:00";
        int pos = sb.indexOf(" on");
        sb.insert(pos, " at ");
        sb.insert(pos+4, time);
        System.out.println(sb);
        message = sb.toString();
        System.out.println(message);
    }

    static void stringFormatting(){
        int david = 17, dawson = 15, dillon = 8, gordon = 6;
        double avgDiff = ((david-dawson) + (dawson-dillon) + (dillon - gordon))/3.0d;

        // My nephews are 17, 15, 8, and 6 years old
        String s1 = "My nephews are " + david + ", " + dawson + ", " + dillon + ", and " + gordon + " years old";
        String s2 = String.format("My nephews are %d, %d, %d, and %d years old", david, dawson, dillon, gordon);

        String s3 = "The average age between each is " + avgDiff + " years";
        String s4 = String.format("The average age between each is %.1f years", avgDiff);
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);

//        %[argument index][flags][width][precision]conversion
//        ------------------------------------------------------------
//          Meaning       Type        Example Value       Result
//        ------------------------------------------------------------
//  d       Decimal       Integral        32              32
//  x X     Hex           Integral         32             20
//  f       Decimal       Floating Point    123.0         123.000000
//  e       Scientific Notation     Floating Point      123.0       1.230000e+02
//  s       String          General         "Hello"         Hello

/*
*   Format Flags:
*   Flag                        Meaning
*   -----------------------------------------------
*   #                           Include Radix
*   0                           Zero-padding
*   -                           Left Justified
*   ,                           Include grouping separator
*   space                       Leading space when positive number
*   +                           Always show sign
*   (                           Enclose negative values in parenthesis
* */

        int iVal = 32;
//        String s5 = String.format("%d", iVal);
        String hexExample = String.format("Int to Hexadecimal conversion = %#x", iVal);
        System.out.println(hexExample);
        int w = 5, x = 235, y = 481, z = 12;
        String s6 = String.format("W:%d X:%d", w, x);
        String s7 = String.format("W:%4d X:%4d", w, x);
        String s8 = String.format("Y:%2d Z:%2d", y, z);
        String s9 = String.format("W:%04d X:%04d", w, x);
        String s10 = String.format("W:%-4d X:%-4d", w, x);
        iVal = 1234567;
        double dVal = 1234567.0d;
        String s11 = String.format("%,d", iVal);
        String s12 = String.format("%,.2f", dVal);
//        System.out.println(s6);
//        System.out.println(s7);
//        System.out.println(s8);
//        System.out.println(s9);
//        System.out.println(s10);
//        System.out.println(s11);
//        System.out.println(s12);

        int iPosVal = 123, iNegVal = -456;
        String s13 = String.format("%d", iPosVal);
        String s14 = String.format("%d", iNegVal);
//        System.out.println(s13);
//        System.out.println(s14);
        String s15 = String.format("% d", iPosVal);
        String s16 = String.format("% d", iNegVal);
//        System.out.println(s15);
//        System.out.println(s16);
        String s17 = String.format("%+d", iPosVal);
        String s18 = String.format("%+d", iNegVal);
//        System.out.println(s17);
//        System.out.println(s18);
        String s19 = String.format("%(d", iPosVal);
        String s20 = String.format("%(d", iNegVal);
//        System.out.println(s19);
//        System.out.println(s20);

        /*
        *   %[argument index][flags][width][precision]conversion
        * Argument Index:
        * Index                             Meaning
        * -----------------------------------------------
        * Not specified                     Corresponds sequentially to arguments
        *   index$                          Index of argument to use (1-based)
        *   <                               Corresponds to same arguments as previous format specifier
        *
        * */

        int valA = 100, valB = 200, valC = 300;
        String s21 = String.format("%d %d %d",valA, valB, valC);
//        System.out.println(s21);
        String s22 = String.format("%3$d %1$d %2$d",valA, valB, valC);
//        System.out.println(s22);
        String s23 = String.format("%2$d %<d %1$d",valA, valB, valC);
        System.out.println(s23);
    }

    static void learnMoreDataTypes(){
        /*######################## Time of Events - Instant class ########################*/
        /*
            Instant class is used for tracking time of events
            - Optimized for time-stamp events
            - Works well for relative time comparisions
        * */
//        Instant myTimeInstant = Instant.now();
//        System.out.println(myTimeInstant);
//        checkRelationship(myTimeInstant);
        /*######################## Local human-friendly time ########################*/
        /*
        * LocalTime class - tracks just the time of day. It doesn't keep track of date portion at all.
        * 09.15.10.000000 international standard for how we represent time
        *
        * LocalDate class - Tracks just the date portion.
        * 2022-12-25
        *
        * LocalDateTime class - It has both the date and time value but it still doesn't have a time zone.
        * 2022-12-25T09.15.10.000000
        * None of these times track time zone
        * */

        /*######################## Global human-friendly time ########################*/
        /*
        * ZonedDateTime class - Provide the date and time values as you expect just like
        * LocalDateTime class and also understands time zones.
        * It doesn't just track the basics of timezone it give the strong time zone support.
        * Which would be a timezone relationship to Universal Time (UTC) but it also knows all the key aspects of that time zone.
        * It knows when daylight saving time starts
        * Allows us to work with values across time zones
        * Allows us to convert to different time zones as well.
        *
        *
        * */
    }

    public static void formattingDateTypes(){
        /*
        * Converting date/time values to/from String:
        * - By default each type is limited to a single string format
        *
        * DateTimeFormatter class -
        * - allows us to describe date/time formatting
        * - includes several date/time formats
        * - can be used when converting to string
        * - can be used when parsing from string
        *
        * */
        LocalDate today = LocalDate.now(); //yyyy-MM-dd
        System.out.println(today);
        DateTimeFormatter useDateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(today.format(useDateFormatter));
        String useDateString = "07-04-2022"; //"MM-dd-yyyy"
        //ERROR as format of LocalDate is not matching
//        LocalDate failedDate = LocalDate.parse(useDateString);
//        System.out.println(failedDate);

        DateTimeFormatter useDateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate theDate = LocalDate.parse(useDateString, useDateFormat);
        System.out.println(theDate);
    }

    static void wrapperClasses(){
        double a = 100.0d;
        double b = 20.0d;
        /*
        * Wrapper class Method handle common operations:
        * - converting to from other types
        * - Extracting values from strings
        * - Finding min/max values
        * - Many others
        * */
    }

    static void learnClassesInterfaces(){
        /*
        * Classes -
        * - Contain state
        * - Contain code to manipulate that state
        * - Allows us to create custom data types
        *
        * Interfaces -
        * - Model data type behavior
        * - create contracts between data types
        *
        *
        * Working with classes and interfaces in Java Course
        *
        * Practice makes a Man perfect!
        * */
    }

    static void checkRelationship(Instant otherInstant){
        Instant nowInstant = Instant.now();
        if(otherInstant.compareTo(nowInstant) > 0){
            System.out.println("Instant is in the future");
        } else if(otherInstant.compareTo(nowInstant) < 0) {
            System.out.println("Instant is in the past");
        } else {
            System.out.println("Instant is now");
        }
    }

    public static void main(String[] args) {
//        learnString();
//        learnStringBuilder();
//        stringFormatting();
//        learnMoreDataTypes();
//        formattingDateTypes();
//        wrapperClasses();
//        learnClassesInterfaces();
//        System.out.println("------------------------");
//        if(1 == 1) return;
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];
        if(args.length == 0){
            for(int i = 0; i < opCodes.length; i++){
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }
            for(double ele: results) {
                System.out.println(ele);
            }
        } else if (args.length == 1 && args[0].equals("interactive")) {
            executeInteractively();
        } else if(args.length == 3) {
            handleCommandLine(args);
        } else {
            System.out.println("Please provide an operation code and 2 numeric values");
        }
    }

    static void executeInteractively(){
        System.out.println("Please provide an operation code and 2 numeric values:");
        Scanner scannerObj = new Scanner(System.in);
        String userInput = scannerObj.nextLine(); // "multiply five six"
        String[] parts = userInput.split(" ");// {"multiply", "five", "six"}
        performOperation(parts);
    }

        private static void performOperation(String[] parts) {
            char opCode = opCodeFromString(parts[0]);
            if(opCode == 'w'){
             handleWhen(parts);
            }else{
                double leftVal = valueFromWord(parts[1]);
                double rightVal = valueFromWord(parts[2]);
                double result = execute(opCode, leftVal, rightVal);
                displayResult(opCode, leftVal, rightVal, result);
            }
        }

        private static void handleWhen(String[] parts) {
            // when yyyy-mm-dd days For example: when 2022-01-12 10
            LocalDate startDate = LocalDate.parse(parts[1]);
            long daysToAdd = (long) valueFromWord(parts[2]);
            LocalDate newDate = startDate.plusDays(daysToAdd);
//            String output = newDate.toString();
            String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
            System.out.println(output);
        }

        private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
            char symbol = symbolFromOpcode(opCode);
//            StringBuilder builder = new StringBuilder(20);
//            builder.append(leftVal); // 2 + 3 = 5
//            builder.append(" ");
//            builder.append(symbol);
//            builder.append(" ");
//            builder.append(rightVal);
//            builder.append(" = ");
//            builder.append(result);
//            String message = builder.toString();

            String message = String.format("%.1f %c %.1f = %.1f", leftVal, symbol, rightVal, result);
            System.out.println(message);
        }


        private static char symbolFromOpcode(char opCode){
            char[] opCodes = { 'a', 's', 'm', 'd' };
            char[] symbols = { '+', '-', '*', '/' };
            char symbol = ' ';
            for(int index = 0; index < opCodes.length; index++){
                if(opCode == opCodes[index]){
                    symbol = symbols[index];
                    break;
                }
            }
            return symbol;
        }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode){
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = (rightVal != 0) ? leftVal / rightVal : 0.0d;
                break;
            default:
                result = 0.0d;
                System.out.println("Invalid opCode:" + opCode);
                break;
        }
        return result;
    }

    public static char opCodeFromString(String operationName){
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
          "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        double value = -1d; //0d;
        for(int index = 0; index < numberWords.length; index++){
            if(word.equals(numberWords[index])){
                value = index;
                break;
            }
        }
        if(value == -1d){
            value = Double.parseDouble(word);
        }
        return value;
    }

}
