package com.example.ledger;

import com.example.ledger.query.QueryParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String filename = args[0];
        File fh = new File(filename);
        try {
            Scanner sc = new Scanner(fh);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                QueryParser.executeQuery(line);
            }
            sc.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
