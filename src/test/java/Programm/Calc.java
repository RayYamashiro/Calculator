package Programm;

import static java.lang.Math.pow;

public class Calc implements Calculator, CalculatorView
{

    private double firstNum;
    private double secondNum;

    private static Calc instance;  //singleton

    private Calc(){}

    public static Calc getInstance()
    {
        if( instance == null) {
            instance = new Calc();
            return instance;
        }
        else
            return instance;
    }
    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public double getFirstNum() {
        return firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public static String valueOf(double a)
    {
        String temp = Double.toString(a);
        return temp;
    }
   /* public  void startWork()
    {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Write first number");
            setFirstNum(Double.parseDouble(reader.readLine()));
            System.out.println("Write second number");
            setSecondNum(Double.parseDouble(reader.readLine()));
            System.out.println("Write command: " + "sum,sub,mult,div ");
            String command = reader.readLine();
            double temp = 0;
            switch (command)
            {
                case "sum":
                    temp = sum(getFirstNum(), getSecondNum());
                    printResult(temp);
                    break;

                case "sub":
                    temp = subtract(getFirstNum(), getSecondNum());
                    printResult(temp);
                    break;
                case "mult":
                    temp =  multiply(getFirstNum() , getSecondNum());
                    printResult(temp);
                    break;
                case "div":
                    try {
                        temp = divide(getFirstNum(), getSecondNum());
                        printResult(temp);
                    }catch (ArithmeticException e)
                    {
                        displayError(e.getStackTrace().toString());
                    }
                    break;
                 default:
                 System.out.println("Wrong number");
                 break;

            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    */
    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws ArithmeticException{
        if(a == 0 || b == 0 || b < pow(10, -8))
            throw new ArithmeticException();
        else
            return a/b;
    }

    @Override
    public void printResult(double result) {
        System.out.println("Result " + result  + "\n");
    }

    @Override
    public void displayError(String message) {
        System.out.println("Error occurred " + message+ "\n");
    }

    @Override
    public String getFirstArgumentAsString() {
        return valueOf(getFirstNum());
    }

    @Override
    public String getSecondArgumentAsString() {
        return valueOf(getSecondNum());
    }

    public boolean isAvailable() {
        if(Calc.getInstance() instanceof Calc)
            return true;
        else
            return false;
    }


}