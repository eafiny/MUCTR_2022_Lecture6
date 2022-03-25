package ru.muctr.Exceptions;

class GenException{
    static void genException(){
        int nums[] = new int[4];
        nums[7] = 10;
        System.out.println("Эта строка не будет отображена");
    }
}

public class ExceptionDemo1 {
    public static void main(String[] args){
        try{
            GenException.genException();
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println("Выход за пределы массива");
        }
            System.out.println("Эта строка будет отображена");
    }
}
