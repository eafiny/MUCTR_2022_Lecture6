package ru.muctr.Exceptions;

public class ExceptionDemo2 {
    public static void main(String[] args){
        int numer[] = {4,8,16,32,64,128, 256};
        int denom[] = {2,0,4,4,8,8};

        for (int i = 0; i < numer.length; i++) {
            try{
                System.out.println(numer[i] + "/" + denom[i] + " равно "
                + numer[i]/denom[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Выход за границу массива");
            }catch (ArithmeticException e){
                System.out.println("Деление на ноль");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
