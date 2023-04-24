import com.sun.jdi.IntegerValue;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {



        try {
            Integer[] arr = {1, 2, 3};
            System.out.println(elementsOfArray(arr));
            String[] finalarr = fileReader("/IdeaProjects/kacitasdavaleba1/file.txt");
            System.out.println(finalarr);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }catch (InvalidNumberException e){
            System.out.println("Number is Negative!!");
        }


    }


    static String[] fileReader(String filePath) throws InvalidNumberException {
        System.out.print("fileReader method is called: ");

        String fileContent = null;
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] arr = fileContent.split(" ");
        String[] arr1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] parseIntarr = new String[10];

        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr[i].contains(arr1[j])) {
                    if (Integer.parseInt(arr[i]) < 0){
                        throw new InvalidNumberException("Invalid number");
                    }
                    parseIntarr[counter] = arr[i];

                    counter++;
                    break;

                }

            }
            if (counter == 10) {
                break;
            }

        }
//        for (String i : parseIntarr) {
//            System.out.println("arr");
//            System.out.println(i);
//        }
        return parseIntarr;


    }



    static int elementsOfArray(Integer[] arr) {
        System.out.print("elementsOfArray method is called: ");
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            counter += arr[i];
        }

        return counter;


    }
}