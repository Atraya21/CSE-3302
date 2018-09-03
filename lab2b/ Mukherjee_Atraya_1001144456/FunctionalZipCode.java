package lab2bclassdec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalZipCode {
	private static File infile = new File("/Users/atrando/Documents/CSE 3302/lab2b/L02b zip_code_database.csv");
	private static File outfile = new File("/Users/atrando/Documents/CSE 3302/lab2b/Problem_2b_output.txt");
	
private static void initTheArray (ArrayList<zipCodeClass> zccArray, ArrayList<String> countyList) { // ArrayList of Texas cities class as txc Array , name , county , population
		try {
			ArrayList<String> copy = new ArrayList<String>(); // starts an ArrayList copy
			ArrayList<String> ctyList = new ArrayList<String>(); //starts an ArrayList ctyList which stores counties
			String [] values; //string array values
			String line = "";
			BufferedReader br = new BufferedReader (new FileReader(infile));
			
			while ((line = br.readLine()) != null) {
				values = line.split(","); // every csv value is stored as values
				zccArray.add(new zipCodeClass(Integer.parseInt(values[0]),values[1],values[2],values[3],Integer.parseInt(values[4]))); // see where to parse int
				copy.add(new String(values[3])); // values 3 is county , copy is adding all the county s as an Array List
			}
			ctyList= (ArrayList<String>) copy.stream().distinct().sorted().collect(Collectors.toList()); //county list and sorted , distinct and collected in ctylist , find collectors tolist
			countyList.addAll(ctyList); // county list has been passed to this function find add all
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

private static IntStream getPopStream(ArrayList<zipCodeClass> zccArray, String countyName) {
//	method returns a stream of integer populations for the given county
//	the returned stream is then further reduced in the main function where called to produce
//	the desired answer
	return zccArray.stream()
			.filter(zcc -> zcc.getcountyName().equals(countyName))
			.mapToInt(zcc -> zcc.getestPop());
}

private static ArrayList StreamCity(ArrayList<zipCodeClass> zccArray, String countyName) {
//	method returns a stream of integer populations for the given county

	ArrayList <String> cities=(ArrayList<String>)zccArray.stream()
							.filter(zcc -> zcc.getcountyName().equals(countyName))
							.map(zcc->zcc.getcityName())
							.sorted((zcc1,zcc2)->zcc1.compareTo(zcc2))
							.distinct()
							.collect(Collectors.toList());
	return cities;	
}

private static IntStream getPopCity(ArrayList<zipCodeClass> zccArray, String countyName, String cityName) { // see if you need to mention county name in this 
//	method returns a stream of integer populations for the given county
//	the returned stream is then further reduced in the main function where called to produce
//	the desired answer
	return zccArray.stream()
			.filter(zcc -> zcc.getcountyName().equals(countyName))
			.filter(zcc -> zcc.getcityName().equals(cityName))
			.mapToInt(zcc -> zcc.getestPop());
}

private static IntStream getuniqzip(ArrayList<zipCodeClass> zccArray,String countyName, String cityName) { //check with intstream and int 
	return zccArray.stream()
			.filter(zcc -> zcc.getcountyName().equals(countyName))
			.filter(zcc -> zcc.getcityName().equals(cityName))
			.mapToInt(zcc -> zcc.getzipCode())
			.distinct();
}
private static void writeCountyData2 (ArrayList<zipCodeClass> zccArray, ArrayList<String> countyList) {
	try {
		FileWriter writer = new FileWriter(outfile);
		writer.write("County Name"+"\t"+"County Pop"+"\t"+"City Name"+"\t"+"City Pop"+"\t"+"No.ZipCodes\n");
		DecimalFormat IntWithComma=new DecimalFormat("###,###,###"); // know decimal format , may have to change it 
		countyList.stream().forEach(p -> { // here is where the stream starts 
										ArrayList<String> cities= StreamCity(zccArray,p.toString()); // gets the city stream
										cities.stream().forEach(q->{
			try {
				writer.write(p.toString()+"\t"+IntWithComma.format(getPopStream(zccArray,p.toString()).sum())+"\t"+q.toString()+
							"\t"+IntWithComma.format(getPopCity(zccArray,p.toString(),q.toString()).sum())+"\t"+IntWithComma.format(getuniqzip(zccArray,p.toString(),q.toString()).count())+
							"\n");
			} catch (IOException e) { // get county firts then no of ctities in the county then , for every county summing the population , then getitng max city and finally printitng max
				e.printStackTrace();}
			});
			});
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}


public static void main(String[] args) {
	ArrayList<zipCodeClass> zccArray = new ArrayList<zipCodeClass>();
	ArrayList<String> countyList = new ArrayList<String>(); // county list started
	initTheArray(zccArray,countyList);
	writeCountyData2(zccArray,countyList);
	} 
}
