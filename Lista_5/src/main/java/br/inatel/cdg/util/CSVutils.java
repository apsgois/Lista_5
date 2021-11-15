package br.inatel.cdg.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVutils {

    static Map<String, String> map = new HashMap<String, String>();

    public static void main(String[] args) {

        String csvFile = "funcionarios.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] funcionarios = line.split(cvsSplitBy);
                for (int i = 0; i < funcionarios.length; i++) {
                    map.put(funcionarios[1], funcionarios[4]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String id = entry.getKey();
            String filhos = entry.getValue();
            System.out.println("Id " + id + " , Filhos=" + filhos + "]");
        }
    }
}
