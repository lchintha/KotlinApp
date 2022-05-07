package com.vrcmicrotech.javaprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args){

        List<List<String>> debts = Arrays.asList(
                Arrays.asList("Alex", "Blake", "2"),
                Arrays.asList("Blake", "Alex", "2"),
                Arrays.asList("Casey", "Alex", "5"),
                Arrays.asList("Blake", "Casey", "7"),
                Arrays.asList("Alex", "Blake", "4"),
                Arrays.asList("Alex", "Casey", "4")
        );

        System.out.println(maxTrailing1(Arrays.asList(5, 3, 6, 7, 4)));

        //System.out.println(arrangements(2));

    }

    public static List<String> getSmallestNegativeBalance(List<List<String>> debts){

        Map<String, Integer> map = new HashMap<>();

        for(List<String> debt : debts){
            int amount = Integer.parseInt(debt.get(2));

            String borrower = debt.get(0);
            int borrowerBalance = map.getOrDefault(borrower, 0);
            map.put(borrower, borrowerBalance - amount);

            String lender = debt.get(1);
            int lenderBalance = map.getOrDefault(lender, 0);
            map.put(lender, lenderBalance + amount);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(a) - map.get(b) );
        pq.addAll(map.keySet());

        List<String> res = new ArrayList<>();
        int min = 0;

        while(!pq.isEmpty()) {
            String person = pq.poll();
            int balance = map.get(person);
            if(balance >= 0)
                return res;
            if(min >= balance) {
                min = balance;
                res.add(person);
            }
        }

        if(res.size() > 0)
            return res;
        else
            res.add("no one is in debt");

        return res;
    }

    public static int maxTrailing(List<Integer> levels){

        int max = 0;

        for(int i=1; i < levels.size(); i++){
            for(int j=0; j < i; j++){
                int diff = levels.get(i) - levels.get(j);
                if(diff > max){
                    max = diff;
                }
            }
        }

        if(max == 0){
            return -1;
        }

        return max;
    }

    public static int maxTrailing1(List<Integer> levels){

        int min = levels.get(0);
        int result = -1;

        for(int i=1; i<levels.size(); i++){
            if (levels.get(i) > min) {
                result = Math.max(levels.get(i) - min, result);
            }
            min = Math.min(min, levels.get(i));
        }

        return result;
    }





    public static int arrangements(int n){

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        return permute(arr, n);

    }

    private static int permute(int[] arr, int i) {
        if (i == 0) {
            return 1;
        }

        int res = 0;
        for (int j = i; j >= 1; j--) {
            if (arr[j] % i == 0 || i % arr[j] == 0) {
                swap(arr, i, j);
                res += permute(arr, i - 1);
                swap(arr, i, j);
            }
        }
        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}