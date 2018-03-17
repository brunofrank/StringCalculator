public class Calculator {
    public int Add(String numbers){
        int returnValue = 0;
        String[] numbersArray = numbers.split(",");

        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) { // After refactoring
                returnValue += Integer.parseInt(number);
            }
        }
        return returnValue;
    }
}
