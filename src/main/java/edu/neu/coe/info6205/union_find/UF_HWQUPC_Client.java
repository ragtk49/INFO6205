package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UF_HWQUPC_Client {
    public static int count(int n) {
        UF_HWQUPC clientObj = new UF_HWQUPC(n,true);
        Random rd = new Random();
        int randomPairs = 0;
        while(clientObj.components() != 1) {
            int randomPair1 = rd.nextInt(n);
            int randomPair2 = rd.nextInt(n);
            if(!clientObj.connected(randomPair1,randomPair2)) {
                clientObj .union(randomPair1, randomPair2);
            }
            randomPairs++;
        }
        return randomPairs;
    }

    public static void main(String[] args) {
        System.out.print("Enter the number (N): ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int experiments = 5000;
        int randomPair = 0;
        for (int i = 0; i < experiments; i++) {
            randomPair += count(input);
        }
        System.out.println("Random Pairs/ Connections(M): " + randomPair/experiments);
    }
}
