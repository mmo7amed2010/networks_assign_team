 ///////////////////////////////////////////////// verifier solve /////////////////////////////////////  
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
 ///////////////////////////////////////////////// generator solve /////////////////////////////////////  
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
