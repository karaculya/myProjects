package string;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //1
    public static String[] readArray() throws Exception {
        BufferedReader reader1 = new BufferedReader(new FileReader("text.txt"));
        int line = Integer.parseInt(reader1.readLine());
        String[] array = new String[line];
                for(int i = 0; i < array.length; i++){
                    array[i] = reader1.readLine();
                }
        return array;
    }
    //2
    public static int binarySearch(String[] array, String s){
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, s);
        return index;
    }
    //3
    public static int countElements(String[] array, String s){
        int count = 1;
                if (Arrays.binarySearch(array, s) >=0)
                    count++;
                else
                    count = -1;
        return count;
    }
    //4
    public static String[] removeElement(String[] array, int index){
        int n = array.length;
        if (index < 0 || index >= n)
            return array;
        String[] temp = new String[n-1];
        for (int i = 0, k = 0; i<n; i++) {
            if(i == index)
                continue;
            temp[k++] = array[i];
        }
        return temp;
    }
    //4'
    public static void deleteElement(String[] array, int index){
        int n = array.length;
        String[] temp = new String[n-1];
        for (int i = 0, k = 0; i<n; i++) {
            if (i == index)
                continue;
            temp[k++] = array[i];
            array[index] = "deleted";
        }
    }
    //5
    public static String[] addElement(String[] array, String s){
        int n = array.length;
        String[] newArray = new String[n+1];
        for(int i = 0; i<n; i++)
            newArray[i] = array[i];
        newArray[n] = s;
        return newArray;
    }
    //5'
    public static void appendElement(String[] array, String s){
        int n = array.length;
        String[] temp = new String[n];
        for (int i = 0; i<n-1; i++)
            temp[i] = array[i];
        array[n-1] = s;
    }
    //6
    public static void getArray(String[] array){
        System.out.println(Arrays.toString(array));
    }
    //7
    public static void saveFile(String[] array) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("vegetables.txt"));
        writer.write(array.length + "\r\n");
        for(int i = 0; i <array.length; i++)
            writer.write(array[i] + "\r\n");
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String [] a = null;
        System.out.println("1 - прочитать массив строк\r\n" +
                "2 - найти строку в массиве\r\n" +
                "3 - посчитать количество элементов эквивалентных строке\r\n" +
                "4 - удалить строку в массиве\r\n" +
                "5 - добавить строку в массив\r\n" +
                "6 - вывести массив\r\n" +
                "7 - сохранить массив\r\n" +
                "8 - выход");
        int k = 0;
        while(k!=8) {
            k = scanner.nextInt();
            if(a == null)
                a = readArray();
            switch (k){
                case 1:
                    a = readArray();
                    System.out.println("Массив из файла:");
                    for (int i = 0; i < a.length; i++)
                        System.out.println(a[i]);
                    break;
                case 2:
                    System.out.println("Введите слово, которое ищете в массиве:");
                    String b = scanner.next();
                    System.out.println(binarySearch(a, b));
                    break;
                case 3:
                    System.out.println("Введите слово для подсчёта его повторов в массиве:");
                    String c = scanner.next();
                    System.out.println(countElements(a, c));
                    break;
                case 4:
                    System.out.println("Введите 1 - если хотите сделать это с помощью функции\r\n" +
                            "2 - если хотите сделать это с помощью процедуры");
                    int w = scanner.nextInt();
                    if(w == 1) {
                        System.out.println("Введите индекс строки, чтобы удалить её из массива:");
                        int i = scanner.nextInt();
                        a = removeElement(a, i);
                        System.out.println(Arrays.toString(a));
                    }
                    else if(w == 2){
                        System.out.println("Введите индекс строки, чтобы удалить её из массива:");
                        int i = scanner.nextInt();
                        deleteElement(a, i);
                        System.out.println(Arrays.toString(a));
                    }
                    else
                        System.out.println("Ошибка!");
                    break;
                case 5:
                    System.out.println("Введите 1 - если хотите сделать это с помощью функции\r\n" +
                            "2 - если хотите сделать это с помощью процедуры");
                    int q = scanner.nextInt();
                    if (q == 1){
                    System.out.println("Введите строку, чтобы добавить её в массив:");
                    String d = scanner.next();
                    a =   addElement(a, d);
                    System.out.println(Arrays.toString(a));
                    }
                    else if(q == 2){
                        System.out.println("Введите строку, чтобы добавить её в массив:");
                        String d = scanner.next();
                        appendElement(a, d);
                        System.out.println(Arrays.toString(a));
                    }
                    else
                        System.out.println("Ошибка!");
                    break;
                case 6:
                    System.out.println("Текущий массив:");
                    getArray(a);
                    break;
                case 7:
                    System.out.println("Сохранить новый массив?\r\n"+"Введите 1 если хотите, 2 если не хотите");
                    int v = scanner.nextInt();
                    if (v == 1) {
                        System.out.println("Массив сохранен в файл vegetables.txt");
                        saveFile(a);
                    }
                    else
                        System.out.println("Массив не сохранен");
                    break;

            }
        }
    }
}
