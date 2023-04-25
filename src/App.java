import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;


public class App {
    public static int[] check;
    public static int[] hoanVi;
    public static void main(String[] args) throws Exception {
       int[] a = readData();
       int n = a.length;
       check = new int[n];
       hoanVi = new int[n];
       hoanVi(a, 0);
    }
    private static void hoanVi(int[] a,int i) {
       for (int j = 0; j < a.length; j++) {
        if(check[j] == 0) {
            check[j] = 1;
            if(i < a.length) {
                hoanVi[i] = a[j];
            }
            
            if(i == a.length-1) {
                inRa();
            }else {
                hoanVi(a,i+1);
            }
            check[j] = 0;  
        }
       }
    }
    public static void  inRa() {
        for (int i = 0; i < hoanVi.length; i++) {
            System.out.print(hoanVi[i]+" ");
        }
        System.out.println();
    }
    

   
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static int[] readData() {
        String filename = "F:/HocTap/UDThuatToan/ontap/hoanViCuaN/src/mydata.txt";
        int[] array = new int[1];
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                if(row == 0) {
                    int n = Integer.parseInt(values[0]);
                    array = new int[n];
                    row++;
                }else {
                    for (int i = 0; i < values.length; i++) {
                        array[i] = Integer.parseInt(values[i]);
                    }
                }
            }
            return array;
        } catch(IOException e) {
            return array;
        }
    }
}
