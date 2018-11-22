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
///////////////////////////////////////////////////////////////////////////  
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
////////////////////////////////////////////////////////////////////
    public String isCorrect(String output){
        for (int i=0;i<output.length();i++){

            if(output.substring(i,i+1).equals("1")){
                return "not correct";
            }
        }
        return "correct";
    }