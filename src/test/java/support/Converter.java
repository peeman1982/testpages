package support;

import java.util.Arrays;
import java.util.List;

public class Converter {
    boolean isValidInput = true;
    long result = 0;
    long finalResult = 0;
    List<String> allowedStrings = Arrays.asList
            (
                    "zero","one","two","three","four","five","six","seven",
                    "eight","nine"
            );

    String input = "One, two, three";

    if(input != null && input.length()> 0)
    {
        input = input.replaceAll(",", " ");
       // input = input.toLowerCase().replaceAll(" and", " ");
        String[] splittedParts = input.trim().split("\\s+");

        for(String str : splittedParts)
        {
            if(!allowedStrings.contains(str))
            {
                isValidInput = false;
                System.out.println("Invalid word found : "+str);
                break;
            }
        }
        if(isValidInput)
        {
            for(String str : splittedParts)
            {
                if(str.equalsIgnoreCase("zero")) {
                    result += 0;
                }
                else if(str.equalsIgnoreCase("one")) {
                    result += 1;
                }
                else if(str.equalsIgnoreCase("two")) {
                    result += 2;
                }
                else if(str.equalsIgnoreCase("three")) {
                    result += 3;
                }
                else if(str.equalsIgnoreCase("four")) {
                    result += 4;
                }
                else if(str.equalsIgnoreCase("five")) {
                    result += 5;
                }
                else if(str.equalsIgnoreCase("six")) {
                    result += 6;
                }
                else if(str.equalsIgnoreCase("seven")) {
                    result += 7;
                }
                else if(str.equalsIgnoreCase("eight")) {
                    result += 8;
                }
                else if(str.equalsIgnoreCase("nine")) {
                    result += 9;
                }
            }

            finalResult += result;
            result=0;
            System.out.println(finalResult);
        }
    }
}
