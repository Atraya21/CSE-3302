package Lab2_a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalTexasCities {
	private static void initTheArray (ArrayList<texasCitiesClass> txcArray) throws FileNotFoundException,IOException {
		String [] values;
		String line = "";
		BufferedReader br = new BufferedReader (new FileReader("C:\\Users\\atray\\Documents\\CSE 3302\\lab2\\L02a Cityname_wo_headers.csv"));
		// change the file destination
		while ((line = br.readLine()) != null) {
			values = line.split(",");
			txcArray.add(new texasCitiesClass(values[0],values[1],Integer.parseInt(values[2])));
		}
		br.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<texasCitiesClass> txcArray = new ArrayList<texasCitiesClass>();
		initTheArray(txcArray);
		File file= new File("L02a_Functional_Output.txt");
		FileWriter writer ;
		writer = new FileWriter(file);
		  
		writer.write("County Name\tNo.Cities\tTotal Pop\tAve Pop\tLargest City\tPopulation");
		writer.write("\n");
		System.out.printf("County Name\tNo.Cities\tTotal Pop\tAve Pop\tLargest City\tPopulation");
		System.out.println();
		List<texasCitiesClass> collected2 = txcArray.stream()
				//sorting counties alphabetically
											.sorted((txc1, txc2) -> txc1.getCounty().compareTo(txc2.getCounty()))
				//every county is distinct
											.distinct()
											.collect(Collectors.toList());
		
		List<texasCitiesClass> collected = collected2.stream()
											.distinct()
											.filter(txc -> txc.getCounty().equals("Bell"))
											.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())
											
											.collect(Collectors.toList());
											
		
		Long count=	collected.stream()
											.count();
											System.out.printf("\tBell\t%d",count);
											writer.write("\tBell\t");
											writer.write(String.valueOf(count));
		int pop= collected.stream()
											.map(txc->txc.getPopulation())
											.reduce(0, Integer :: sum);
											System.out.printf("\t\t%d",pop);
											System.out.printf("\t\t%d",pop/count);
											writer.write("\t");
											writer.write(String.valueOf(pop));
											writer.write("\t");
											writer.write(String.valueOf(pop/count));
											
		
		texasCitiesClass maximum=collected.stream() 
											.max(Comparator.comparing(txc->txc.getPopulation()))
											.get();
											System.out.printf("\t\t%s\t\t%d",maximum.getName(),maximum.getPopulation());
											
											writer.write("\t");
											writer.write(maximum.getName());
											writer.write("\t");
											writer.write(String.valueOf(maximum.getPopulation()));
	
											writer.write("\n");
											System.out.println();
		
			  collected = collected2.stream()
													.distinct()
													.filter(txc -> txc.getCounty().equals("Bexar"))
													.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())
													
													.collect(Collectors.toList());
													
				
				count=	collected.stream()
													.count();
													System.out.printf("\tBexar\t%d",count);
													
													writer.write("\tBexar\t");
													writer.write(String.valueOf(count));
				pop= collected.stream()
													.map(txc->txc.getPopulation())
													.reduce(0, Integer :: sum);
				System.out.printf("\t\t%d",pop);
				System.out.printf("\t\t%d",pop/count);
				writer.write("\t");
				writer.write(String.valueOf(pop));
				writer.write("\t");
				writer.write(String.valueOf(pop/count));
				
				maximum=collected.stream() 
													.max(Comparator.comparing(txc->txc.getPopulation()))
													.get();
				System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
				writer.write("\t");
				writer.write(maximum.getName());
				writer.write("\t");
				writer.write(String.valueOf(maximum.getPopulation()));

				writer.write("\n");	
				System.out.println();
				
				collected = collected2.stream()
						.distinct()
						.filter(txc -> txc.getCounty().equals("Brazoria"))
						.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())
						
						.collect(Collectors.toList());
						

count=	collected.stream()
						.count();
						System.out.printf("\tBrazoria\t%d",count);
						
						writer.write("\tBrazoria\t");
						writer.write(String.valueOf(count));
pop= collected.stream()
						.map(txc->txc.getPopulation())
						.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
						.max(Comparator.comparing(txc->txc.getPopulation()))
						.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();
				
collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Brazos"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tBrazos\t%d",count);

writer.write("\tBrazos\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Cameron"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tCameron\t%d",count);

writer.write("\tCameron\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();


collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Collin"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tCollin\t%d",count);

writer.write("\tCollin\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Comal"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tComal\t%d",count);

writer.write("\tComal\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Dallas"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tDallas\t%d",count);

writer.write("\tDallas\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Denton"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tDenton\t%d",count);

writer.write("\tDenton\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Ector"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tEctor\t%d",count);

writer.write("\tEctor\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("El Paso"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tEl Paso\t%d",count);

writer.write("\tEl Paso\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Fort Bend"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tFort Bend\t%d",count);

writer.write("\tFort Bend\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Galveston"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tGalveston\t%d",count);

writer.write("\tGalveston\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Gregg"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tGregg\t%d",count);

writer.write("\tGregg\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Harris"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tHarris\t%d",count);

writer.write("\tHarris\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Hays"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tHays\t%d",count);

writer.write("\tHays\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Hidalgo"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tHidalgo\t%d",count);

writer.write("\tHidalgo\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Jefferson"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tJefferson\t%d",count);

writer.write("\tJefferson\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Lubbock"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tLubbock\t%d",count);

writer.write("\tLubbock\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("McLennan"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tMcLennan\t%d",count);

writer.write("\tMcLennan\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Midland"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tMidland\t%d",count);

writer.write("\tMidland\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Montgomery"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tMontgomery\t%d",count);

writer.write("\tMontgomery\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Nueces"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tNueces\t%d",count);

writer.write("\tNueces\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Pasadena"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tPasadena\t%d",count);

writer.write("\tPasadena\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Potter"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tPotter\t%d",count);

writer.write("\tPotter\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Smith"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tSmith\t%d",count);

writer.write("\tSmith\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Tarrant"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tTarrant\t%d",count);

writer.write("\tTarrant\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Taylor"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tTaylor\t%d",count);

writer.write("\tTaylor\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Tom Green"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tTom Green\t%d",count);

writer.write("\tTom Green\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Travis"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tTravis\t%d",count);

writer.write("\tTravis\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Victoria"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tVictoria\t%d",count);

writer.write("\tVictoria\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Webb"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tWebb\t%d",count);

writer.write("\tWebb\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Wichita"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tWichita\t%d",count);

writer.write("\tWichita\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();

collected = collected2.stream()
.distinct()
.filter(txc -> txc.getCounty().equals("Williamson"))
.sorted((txc1, txc2) -> txc1.getPopulation()-txc2.getPopulation())

.collect(Collectors.toList());


count=	collected.stream()
.count();
System.out.printf("\tWilliamson\t%d",count);

writer.write("\tWilliamson\t");
writer.write(String.valueOf(count));
pop= collected.stream()
.map(txc->txc.getPopulation())
.reduce(0, Integer :: sum);
System.out.printf("\t\t%d",pop);
System.out.printf("\t\t%d",pop/count);
writer.write("\t");
writer.write(String.valueOf(pop));
writer.write("\t");
writer.write(String.valueOf(pop/count));

maximum=collected.stream() 
.max(Comparator.comparing(txc->txc.getPopulation()))
.get();
System.out.printf("\t\t%s\t%d",maximum.getName(),maximum.getPopulation());
writer.write("\t");
writer.write(maximum.getName());
writer.write("\t");
writer.write(String.valueOf(maximum.getPopulation()));

writer.write("\n");	
System.out.println();
  }
	
}


