/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.trillit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author IRFAN
 */
public class CsvReader {

    public List<String> readHeader(String file_path, String SEPARATOR) {
        try {
            Path path = Paths.get(file_path);
            Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            BufferedReader breader = new BufferedReader(reader);
            return breader.lines()
                    .findFirst()
                    .map(line -> Arrays.asList(line.split(SEPARATOR)))
                    .get();
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    public List<List<String>> readRecords(int skip, String file_path, String SEPARATOR) {
         BufferedReader breader=null;
        try {
            String SEPString = SEPARATOR;
            Path path = Paths.get(file_path);
            Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            breader = new BufferedReader(reader);
            return breader.lines()
                    .skip(skip)
                    .map(line -> Arrays.asList(line.split(SEPString)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } finally {
            try {
                if (breader != null) {
                    breader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<List> readFile(String file_path, String SEPARATOR) {
        BufferedReader br = null;
        ArrayList<List> al=new ArrayList();
        try {
            br = new BufferedReader(new FileReader(file_path));
            String line = null;
            while ((line = br.readLine()) != null) {                
                String[] values = line.split(SEPARATOR);   
                if(values.length == 2){
                    ArrayList<String> t=new ArrayList();
                    t.add(values[0]);
                    t.add(values[1]);
                    al.add(t);
                }else if(values.length == 92){
                    ArrayList<String> t=new ArrayList();
                    t.add(values[5]);
                    t.add(values[18]);
                    al.add(t);
                }
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return al;
    }
}
