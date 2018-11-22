    public String verify() throws IOException {




        String codeword = solve();
        output("verifier_output.txt",codeword);
        return isCorrect(codeword);
    }
/////////////////////////////////////////////////////////////////
        public String Generate() throws IOException {

        fileInput();
        concat();
        String codeword =  solve();
        output("generator_output_verifier_input.txt",codeword);
        return codeword;
    };
//////////////////////////////////////////////////////////////////////
    public void concat(){


        int pol_length=polynomial.length();
        this.concatmessage=this.message;
        for(int i=1 ; i<pol_length; i++){

            this.concatmessage=this.concatmessage+"0";
        }
    }