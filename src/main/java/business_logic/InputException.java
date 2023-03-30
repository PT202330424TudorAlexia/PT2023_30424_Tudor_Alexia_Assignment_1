package business_logic;

public class InputException extends Exception{
    public InputException(String text){
        System.out.println(text);
    }
}
