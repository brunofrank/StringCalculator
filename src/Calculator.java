import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int Add(String numbers){
        String delimiter = ",|n";
        String numbersWithoutDelimiter = numbers;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
        }
        return Add(numbersWithoutDelimiter, delimiter);
    }

    public int Add(String numbers, final String delimiter){
        int returnValue = 0;
        String[] numbersArray = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<Integer>();
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                }
                returnValue += numberInt;
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return returnValue;
    }
}
