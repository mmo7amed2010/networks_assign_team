package com.Crc_generator;

import java.io.*;

public class Generator {


    public String message;
    public String concatmessage;
    public String polynomial;
    public String pathName;

    Generator(String pathName)  {

        this.pathName=pathName;

    }
    public String Generate() throws IOException {

        fileInput();
        concat();
        String codeword =  solve();
        output("generator_output_verifier_input.txt",codeword);
        return codeword;
    };
    public void fileInput() throws IOException {

        File file = new File(this.pathName);

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
    public void concat(){


        int pol_length=polynomial.length();
        this.concatmessage=this.message;
        for(int i=1 ; i<pol_length; i++){

            this.concatmessage=this.concatmessage+"0";
        }
    }
    public String solve(){


        int count = 0;
        int pol_length= polynomial.length();
        String result =polynomial;
        String message2 =concatmessage;
        String temp;

        for (int j =0; j <=concatmessage.length()-pol_length ; j++) {

            temp="";

            for (int i =1; i < pol_length; i++) {


                if(result.substring(i, i+1).equals(message2.substring(i, i+1))){
                    temp=temp+"0";
                }else{
                    temp=temp+"1";
                }

            }



            if(pol_length+count == concatmessage.length()){

                message2=temp;
                break;
            }
            message2=temp+concatmessage.substring(pol_length+count, pol_length+count+1);
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
        return message+message2;
    }

    public void output(String fileName,String message) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(message);
        writer.newLine();

        writer.write(this.polynomial);

        writer.close();
    }

}

