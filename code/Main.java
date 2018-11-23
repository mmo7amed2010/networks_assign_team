package com.Crc_generator;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        while(true) {
            System.out.println("\rEnter the number of operation");
            System.out.println("1-generator(input file)-> verifier");
            System.out.println("2-generator(input file)-> alter -> verifier");
            System.out.println("3-close");

            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            if(i==3)
                break;
            if(i==2 || i==1) {
                Generator generator = new Generator("generator_input.txt");
                String codeword = generator.Generate();

                System.out.println("m :" + generator.message);
                System.out.println("g :" + generator.polynomial);
                System.out.println("m|r :" + codeword);

                Verifier verify = new Verifier();
                if (i==1)
                    System.out.println(verify.verify());
                if (i==2)
                    System.out.println(verify.alteredVerify());


            }
        }
    }
}

