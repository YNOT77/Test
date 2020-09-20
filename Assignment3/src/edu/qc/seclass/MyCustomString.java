package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface{
    private String string;
    @Override

    public String getString() {
        if(string ==null)
            return null;
        return string;
    }

    @Override
    public void setString(String string) {
        this.string= string;
    }

    @Override
    public int countNumbers() {
        if(string ==null) throw new NullPointerException();
        int count =0;

        boolean Pre = false;
        for(int i = 0; i< string.length();i++){
            if(Character.isDigit(string.charAt(i))){
                if (!Pre) {
                    count ++;
                    Pre = true;
                }
            } else {
                Pre= false;
            }
        }
        return count;
    }


    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd){
        if(n <= 0) throw new IllegalArgumentException();
        if(string ==null) throw new NullPointerException();

        String test= "";
        if(startFromEnd ==false){
            for (int i = n-1; i < string.length(); i += n){
                test += string.charAt(i);
            }
        }else{
            for (int i = string.length()-n; i >=0; i -= n){
                test += string.charAt(i);
            }
        };
        if(!startFromEnd){
            return test;
        }else{
            return new StringBuilder(test).reverse().toString();
        }

    };




    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if(startPosition >endPosition) throw new IllegalArgumentException();
        if(startPosition <=0 || endPosition >string.length()) throw new MyIndexOutOfBoundsException();
        if(string == null) throw new NullPointerException();

        String arrayOfInt[]={"Zero","One","Two","Three","Four","Five","Six","Seven", "Eight","Nine"};
        String test = string;
        for(int i =startPosition-1; i < endPosition; i++){
            if(Character.isDigit(string.charAt(i))){
                String numString = String.valueOf(string.charAt(i));
                int indexOfWord= Integer.parseInt(numString);
                test = test.replaceFirst(numString, arrayOfInt[indexOfWord]);
            }
        }
        string=test;
    }
}
