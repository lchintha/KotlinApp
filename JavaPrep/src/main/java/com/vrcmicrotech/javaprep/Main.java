package com.vrcmicrotech.javaprep;

class Main {

    public static void main(String[] args){
        int[] a = {1, 2, 3, 5};
        reverseArray(a);
    }

    public static void reverseArray(int[] list){
        for(int i = list.length-1; i >= 0; i-- ){
            System.out.println(list[i]);
        }
    }


}