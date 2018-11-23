package com.Crc_generator;

import java.io.*;

public class Verifier {

    public String message;
    public String polynomial;
    Verifier() throws IOException {
        fileInput("generator_output_verifier_input.txt");

    }
    public String verify() throws IOException {




        String codeword = solve();
        output("verifier_output.txt",codeword);
        return isCorrect(codeword);
    }
    public String alteredVerify() throws IOException {



        String x;
        if(message.substring(message.length()-2,message.length()-1).equals("1")){

            x="0";
        }else{
            x="1";
        }

        message = message.substring(0,message.length()-2)+x+message.substring(message.length()-1);
        System.out.println("altered m|r :" + message);

        String codeword=verify();
        return codeword;

    }
    public void fileInput(String pathName) throws IOException {

        File file = new File(pathName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        this.message = null;
        this.polynomial = null;
        int count= 0;
        while ((st = br.readLine()) != null) {
            if (count == 0) {
                this.message = st;
                count++;
            } else if (count == 1) {

                this.polynomial = st;
                count++;
            }
        }
    }
    public String solve()  {
        int pol_length=polynomial.length();

        int count= 0;
        count = 0;

        String result =polynomial;
        String message2 =message;
        String temp;

        for (int j =0; j <=message.length()-pol_length ; j++) {

            temp="";

            for (int i =1; i < pol_length; i++) {


                if(result.substring(i, i+1).equals(message2.substring(i, i+1))){
                    temp=temp+"0";
                }else{
                    temp=temp+"1";
                }

            }



            if(pol_length+count == message.length()){

                message2=temp;
                break;
            }
            message2=temp+message.substring(pol_length+count, pol_length+count+1);
            result="";
            if(message2.substring(0,1).equals("0")) {
                for(int i=0 ; i<pol_length; i++){

                    result+="0";
                }

            }else{

                result = polynomial;

            }

            count++;

        }

        return message2;
    }
    public String isCorrect(String output){
        for (int i=0;i<output.length();i++){

            if(output.substring(i,i+1).equals("1")){
                return "not correct";
            }
        }
        return "correct";
    }
    public void output(String fileName,String message) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(message);
        writer.newLine();
        writer.close();
    }
}

