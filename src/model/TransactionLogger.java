package model;

import java.io.*;

public class TransactionLogger {
    private static final String FILE_NAME="transactions.txt";

    public static void logTransaction(String msg){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_NAME,true))){
            bw.write(msg);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getTransactions(){
        try(BufferedReader br=new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
