/*
 * Title: RecursiveMethods.java
 * Abstract: HW10
 * Author: Justin Andreoli
 * Email: jandreoli@csumb.edu
 * Estimate: 2 hours
 * Date: 11/7/2024
 */

import java.util.ArrayList;
import java.util.Scanner;
public class RecursiveMethods {
    public static void main(String[] args) {
        int [] data = {1, 4, 9, 12, -13, 46, 12, 17, -3, -9, -12};
        System.out.println("Count of odds (should be 6): " + countOdds(data,
                data.length));
        System.out.println("Sum of odds (should be 2): " + sumOdds(data,
                data.length));
        System.out.print("Printing odds forward (should be 1 9 -13 17 -3 -9): ");
        printOddsForward(data, 0);
        System.out.println();
        System.out.print("Printing odds backward (should be -9 -3 17 -13 9 1): ");
        printOddsBackward(data, data.length);
        System.out.println();
        ArrayList<Integer> dataList = fromArray(data);
        System.out.println("Sum of ArrayList (should be 64): " +
                sumArrayList(dataList));
        Scanner in = new Scanner(System.in);
        promptPrimes(in, 2);
    }
    public static void promptPrimes(Scanner in, int value) {
        if(value == 0) {
            return;
        } else {
            System.out.printf("Is %d prime? %b\n", value, isPrime(value));
            ArrayList<Integer> factors = factorNumber(value);
            printFactors(factors);

            System.out.print("Enter a number (0 to quit): ");
            int input = in.nextInt();
            promptPrimes(in, input);
        }
    }
    public static ArrayList<Integer> fromArray(int [] source) {
        ArrayList<Integer> dest = new ArrayList<>();
        fromArray(dest, source, 0);
        return dest;
    }
    public static void fromArray(ArrayList<Integer> dest, int [] source, int start) {
        if(start == source.length) {
            return;
        }else{
            dest.add(source[start]);
            fromArray(dest, source, start + 1);
        }
    }
    public static int sumArrayList(ArrayList<Integer> list) {
        if(list.size() == 0) {
            return 0;
        }else{
            return sumArrayList(list, list.size()-1);
        }
    }
    public static int sumArrayList(ArrayList<Integer> list, int position) {
        if(position == 0) {
            return list.get(0);
        }else{
            return list.get(position) + sumArrayList(list, position - 1);
        }
    }
    public static boolean isPrime(int base) {
        if(base < 2) {
            return false;
        } else {
            return isPrime(base, 2);
        }
    }
    public static boolean isPrime(int base, int comparison) {
        if(comparison == base) {
            return true;
        }else{
            if(base % comparison == 0){
                return false;
            }
            return isPrime(base, comparison + 1);
        }

    }
    public static void printFactors(ArrayList<Integer> factors) {
        System.out.println(printFactors(factors, 0));
    }
    public static int printFactors(ArrayList<Integer> factors, int start) {
        if(start == factors.size()) {
            System.out.print(" = ");
            return printBase(factors, 0);
        }else{
            System.out.print(factors.get(start));
            if(start+1 != factors.size()) {
                System.out.print(" * ");
            }
            return printFactors(factors, start + 1);
        }
    }
    public static int printBase(ArrayList<Integer> factors, int start){
        if(start == factors.size()) {
            return 1;
        }else{
            return factors.get(start) * printBase(factors, start+1);
        }
    }
    public static ArrayList<Integer> factorNumber(int base) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        factorNumber(al, base, 2);
        //al.add(base);
        return al;
    }
    public static void factorNumber(ArrayList<Integer> factors, int base, int comparison) {
        if(comparison > base) {
            return;
        }else{
            if(base % comparison == 0){
                factors.add(comparison);
                base = base/comparison;
                factorNumber(factors, base, comparison);
            }else {
                factorNumber(factors, base, comparison + 1);
            }
        }
    }
    public static int countOdds(int [] a, int size) {
        if(size == 0){
            return 0;
        }else{
            if(a[size-1] % 2 != 0){
                return 1 + countOdds(a, size - 1);
            }else{
                return countOdds(a, size - 1);
            }
        }
    }
    public static int sumOdds(int [] a, int size) {
        if(size == 0){
            return 0;
        }else{
            if(a[size-1] % 2 != 0){
                return a[size-1] + sumOdds(a, size - 1);
            }else{
                return sumOdds(a, size - 1);
            }
        }
    }
    public static void printOddsForward(int [] a, int start) {
        if(start >= a.length || start < 0){
            return;
        }else{
            if(a[start] % 2 != 0) {
                System.out.print(a[start] +" ");
            }
            printOddsForward(a, start + 1);
        }
    }
    public static void printOddsBackward(int [] a, int size) {
        if(size == 0){
            return;
        }else{
            if(a[size-1] % 2 != 0) {
                System.out.print(a[size - 1] +" ");
            }
            printOddsBackward(a, size - 1);
        }
    }
}