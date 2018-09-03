package lab03_b;

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


	
public class RealEstateMainFunctional {
	private static String [] values;
	private static String [] values2;
	
	private static File outfile = new File("/Users/mukherjeea/Desktop/HouseOrderByRatingTest");
	
	 private static void initZipArray (ArrayList<RealEstateClass> zipArray) throws FileNotFoundException,IOException {
		 //change the in file destination 
	        File infile1 = new File("/Users/mukherjeea/Desktop/CSE3302_0b/House Data EXAMPLE.csv");
	        String line = "";
	        BufferedReader br = new BufferedReader (new FileReader(infile1));
	        
	        while ((line = br.readLine()) != null) {
	            values = line.split(",");
	            zipArray.add(new RealEstateClass (values[0],values[1],values[2],Integer.parseInt(values[3]),Integer.parseInt(values[4]),Double.parseDouble(values[5]),Double.parseDouble(values[6]),values[7],Integer.parseInt(values[8]),Integer.parseInt(values[9]),Integer.parseInt(values[10]),Integer.parseInt(values[11]),Integer.parseInt(values[12]),Integer.parseInt(values[13])));
	        }
	        br.close();
	    }
	 
	 //address zipArray2 in main
	 
	 private static void initZipArray2 (ArrayList<ZipRateTable> zipArray2) throws FileNotFoundException,IOException {
		 //change the in file destination 
	        File infile1 = new File("/Users/mukherjeea/Desktop/CSE3302_0b/ZipRateTable.csv");
	        String line = "";
	        BufferedReader br = new BufferedReader (new FileReader(infile1));
	        
	        while ((line = br.readLine()) != null) {
	            values2 = line.split(",");
	            zipArray2.add(new ZipRateTable (Integer.parseInt(values2[0]),Integer.parseInt(values2[1])));
	        }
	        br.close();
	    }
	 
	 private static void writeZipData (ArrayList<RealEstateClass> zipArray,ArrayList<ZipRateTable> zipArray2) throws IOException {
		 // decimal format changes
	        DecimalFormat IntWithComma=new DecimalFormat("###,###,###");
	        File outfile = new File("/Users/mukherjeea/Desktop/outputtest1");
	        FileWriter writer = new FileWriter(outfile);
	        writer.write("Type\tAddress\tCity\tZip\tPrice\tBeds\tBaths\tLocation\tSqft\tlot size\tYr Blt\tDOM\t$/SqFt\tHOA/mth\tRank grp\tPercnt Sqft\n");
	        //change all of this 
	       
	        zipArray.stream()
	        .forEach(a->{
	        		if(a.getProperty_Type().equals("Single Family Residential") && a.getPrice()< 200000 && a.getDollar_Per_Sq_Ft()<110 && a.getSquare_Feet()>=1750 && a.getSquare_Feet() <=2500 && a.getYear_Built()>=2007 && a.getHOA_Per_Month() <=25 ) 
	        			{a.setRating(1);}
	        		
	        		if(a.getProperty_Type().equals("Single Family Residential") && a.getPrice()< 200000 && a.getDollar_Per_Sq_Ft()<110 && a.getSquare_Feet()>=1750 && a.getSquare_Feet() <=2500 && a.getYear_Built()>=2007 && a.getHOA_Per_Month() >25 && a.getHOA_Per_Month() <=30 ) 
        			{a.setRating(2);}
	        		
	        		if(a.getProperty_Type().equals("Single Family Residential") && a.getPrice()< 200000 && a.getDollar_Per_Sq_Ft()<110 && a.getSquare_Feet()>=1750 && a.getSquare_Feet() <=2500 && a.getYear_Built()>=2000 && a.getYear_Built()<2007 && a.getHOA_Per_Month() <=25 ) 
        			{a.setRating(3);}
	        		
	        		if(a.getProperty_Type().equals("Single Family Residential") && a.getPrice()< 200000 && a.getDollar_Per_Sq_Ft()<110 && a.getSquare_Feet()>=1750 && a.getSquare_Feet() <=2500 && a.getYear_Built()>=2000 && a.getYear_Built()<2007 && a.getHOA_Per_Month() >25 && a.getHOA_Per_Month() <=30  ) 
        			{a.setRating(4);}
	        		
	        		else {a.setRating(0);}
	        });// for each ends here 
	        
	       
	        								
	        
	    	ArrayList<RealEstateClass> result= (ArrayList<RealEstateClass>) zipArray.stream()
	    									.filter(prop->prop.getRating()>0 && prop.getRating()<5)
	    									.sorted((x,y)->Integer.compare(x.getPrice(), y.getPrice()))
	    									.sorted((m,n)->Integer.compare(m.getDollar_Per_Sq_Ft(), n.getDollar_Per_Sq_Ft()))
	    									.collect (Collectors.toList()); 
	    	
	    	ArrayList<Integer> zipcodes= (ArrayList<Integer>) zipArray2.stream()
					.filter(b->b.getRating()>6)
					.map(b->b.getZipCode())
					//.distinct()
					.collect(Collectors.toList());
	        										
	    										
	       result.stream().forEach(res->{zipcodes.stream().forEach(zip->{
	    	   
	    	  double totdfsf= (double)zipArray.stream().filter(z->z.getZip()==zip)
	    			  .map(z->z.getDollar_Per_Sq_Ft())
	    			  .reduce(0,Integer::sum);
	    	  
	    	  double countdfsf= (double)zipArray.stream().filter(z->z.getZip()==zip).count();
	    	  
	    	  double avgdfsf= totdfsf/countdfsf;
	    	   
	    	   if(res.getZip()==zip) 
	    	   	{ try {
					writer.write(res.getProperty_Type().toString()+"\t"+res.getAddress().toString()+"\t"+res.getCity().toString()+"\t"+res.getZip()+"\t"+res.getPrice()+"\t"+res.getBeds()+"\t"+res.getBaths()+"\t"+res.getLocation().toString()+"\t"+res.getSquare_Feet()+"\t"+res.getLot_Size()+"\t"+res.getYear_Built()+"\t"+res.getDays_On_Market()+"\t"+res.getDollar_Per_Sq_Ft() +"\t"+res.getHOA_Per_Month()+"\t"+res.getRating()+"\t"+(res.getDollar_Per_Sq_Ft()*100)/avgdfsf+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	   		
	    	   	}
	    	   
	       																});});
	       writer.close();
	       
        
    }
	 
	 public static void main(String[] args) throws FileNotFoundException,IOException {
		 // make sure you match the names
	        ArrayList<RealEstateClass> zipArray = new ArrayList<RealEstateClass>();
	        initZipArray(zipArray);
	        
	        ArrayList<ZipRateTable> zipArray2 = new ArrayList<ZipRateTable>();
	        initZipArray2(zipArray2);
	        writeZipData(zipArray,zipArray2);
	        
	        
	    }

}
