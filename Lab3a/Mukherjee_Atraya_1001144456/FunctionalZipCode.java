
package lab_03a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalZipCode {
    
    private static String [] values;
    
    private static void initZipArray (ArrayList<zipCodeClass> zipArray) throws FileNotFoundException,IOException {
        File infile1 = new File("/Users/atrando/Documents/CSE 3302/Lab3a/Data files/L03a zip_code_database.csv");
        String line = "";
        BufferedReader br = new BufferedReader (new FileReader(infile1));
        
        while ((line = br.readLine()) != null) {
            values = line.split(",");
            zipArray.add(new zipCodeClass(Integer.parseInt(values[0]),values[1],values[2],values[3],Integer.parseInt(values[4])));
        }
        br.close();
    }
    
    private static void writeZipData (ArrayList<zipCodeClass> zipArray) throws IOException {
        DecimalFormat IntWithComma=new DecimalFormat("###,###,###");
        File outfile = new File("/Users/atrando/Documents/CSE 3302/Lab3a/Data files/Problem_3a_output.txt");
        FileWriter writer = new FileWriter(outfile);
        writer.write("County\tCity\tZip Type\tCity Pop\tFirst Zip\tNo. Zip\tCounty Pop\n");
        // This gets the unique and sorted list of county names from the zipArray stream
        zipArray.stream().map(p -> p.getCountyName()).distinct().sorted()  // This gets the unique and sorted list of county names from the zipArray stream
        
        .forEach (cnty -> { // what does cnty  also see citcou in .filter
            ArrayList<String> cityNames = new ArrayList<String>(); //city names started
            cityNames = (ArrayList<String>) zipArray.stream()
            .filter(citcou -> citcou.getCountyName().equals(cnty.toString()))
            .map(zipCodeClass::getCityName).distinct().sorted()
            .collect(Collectors.toList());
            //county and city uniquely collected
            cityNames.stream()
            .forEach(city -> {
                
                
                ArrayList <String> ziptype = (ArrayList<String>) zipArray.stream() // what is stream object ?? are there multiple ?
                .filter(c -> c.getCountyName().equals(cnty))
                .filter(c -> c.getCityName().equals(city))
                .map(c -> c.getTypeZip())
                .sorted((c1,c2)->c1.compareTo(c2))
                .distinct()
                .collect (Collectors.toList());
                
                if(ziptype.size()==1) {
                    ziptype.stream()
                    .forEach(zip->{
                        int cityPop = zipArray.stream()
                        .filter(c -> c.getCountyName().equals(cnty))
                        .filter(c -> c.getCityName().equals(city))
                        .filter(c -> c.getTypeZip().equals(zip))
                        .mapToInt(c -> c.getEstPop())
                        .reduce(0, (x,y) -> x+y);
                        
                        
                        
                        ArrayList<Integer> firstzip = (ArrayList<Integer>)zipArray.stream()
                        .filter(c -> c.getCountyName().equals(cnty))
                        .filter(c -> c.getCityName().equals(city))
                        .filter(c -> c.getTypeZip().equals(zip))
                        .map(c -> c.getZipCode())
                        .collect (Collectors.toList());
                        //always print the first one
                        
                        long zipCount = zipArray.stream()
                        .filter(c -> c.getCountyName().equals(cnty))
                        .filter(c -> c.getCityName().equals(city))
                        .filter(c -> c.getTypeZip().equals(zip))
                        .mapToInt(c -> c.getEstPop())
                        .count();
                        
                        long countyPop = zipArray.stream()
                        .filter(c -> c.getCountyName().equals(cnty))
                        .filter(c -> c.getCityName().equals(city))
                        .mapToInt(c -> c.getEstPop())
                        .reduce(0, (x,y) -> x+y);
                        
                        
                        try {writer.write(cnty.toString()+"\t"+city.toString()+"\t"+zip.toString()+"\t"+IntWithComma.format(cityPop)+"\t"+firstzip.get(0)+"\t"+zipCount+"\t"+IntWithComma.format(countyPop)+"\n");
                        } catch (IOException e) {
                            e.printStackTrace(); }
                    });
                }
                
                
                
                
                
                else
                    
                {
                    
                    try {
                        writer.write(cnty.toString()+"\t"+city.toString());
                        
                        ziptype.stream()
                        .forEach(zip2->{
                            
                            
                            
                            int cityPop2 = zipArray.stream()
                            .filter(c -> c.getCountyName().equals(cnty))
                            .filter(c -> c.getCityName().equals(city))
                            .filter(c -> c.getTypeZip().equals(zip2))
                            .mapToInt(c -> c.getEstPop())
                            .reduce(0, (x,y) -> x+y);
                            
                            
                            
                            ArrayList<Integer> firstzip2 = (ArrayList<Integer>)zipArray.stream()
                            .filter(c -> c.getCountyName().equals(cnty))
                            .filter(c -> c.getCityName().equals(city))
                            .filter(c -> c.getTypeZip().equals(zip2))
                            .map(c -> c.getZipCode())
                            .collect (Collectors.toList());
                            //always print the first one
                            
                            long zipCount2 = zipArray.stream()
                            .filter(c -> c.getCountyName().equals(cnty))
                            .filter(c -> c.getCityName().equals(city))
                            .filter(c -> c.getTypeZip().equals(zip2))
                            .mapToInt(c -> c.getEstPop())
                            .count();
                            
                            long countyPop2 = zipArray.stream()
                            .filter(c -> c.getCountyName().equals(cnty))
                            .filter(c -> c.getCityName().equals(city))
                            .mapToInt(c -> c.getEstPop())
                            .reduce(0, (x,y) -> x+y);
                            
                            
                            if(ziptype.get(0)==zip2) {    try {writer.write("\t"+zip2.toString()+"\t"+IntWithComma.format(cityPop2)+"\t"+firstzip2.get(0)+"\t"+zipCount2+"\t"+IntWithComma.format(countyPop2)+"\n");
                            }catch (IOException e) {
                                e.printStackTrace(); }}
                            else {try {writer.write("\t\t"+zip2.toString()+"\t"+IntWithComma.format(cityPop2)+"\t"+firstzip2.get(0)+"\t"+zipCount2+"\n");
                            }catch (IOException e) {
                                e.printStackTrace(); }
                            }
                            
                        });}
                    catch (IOException e) {
                        e.printStackTrace(); }
                }
                
                
                
            });
        });
        
        writer.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException,IOException {
        ArrayList<zipCodeClass> zipArray = new ArrayList<zipCodeClass>();
        initZipArray(zipArray);
        writeZipData(zipArray);
    }
}


