package lk.ac.kln.fct.data.processor;

import java.util.ArrayList;

import lk.ac.kln.fct.data.pojo.Record;

public class Main {
	private static final String FILE_PATH = "/Users/shani/IdeaProjects/Covid2/src/covid/covid-19-data.json";
	private static final String DATE = "18/05/2020";
	
	public static void main(String[] args) {
		DataProcessor processor = new DataProcessor();
		//TODO
        //Here invoke the the DataProcessor.getDataByDate method and get the returning array list.
		//Then invoke the sortAndPrint method.
        ArrayList<Record> record = processor.getDataByDate(FILE_PATH, DATE);
        sortAndPrint(record);
	}
		
	public static void sortAndPrint(ArrayList<Record> records) {
		records.sort((record1, record2)-> Integer.compare(record2.getCases(), record1.getCases()));
        //System.out.println("Hello");
		//TODO
	    //Iterate through all the elements in records array list and print the records according to the requirement.
        for(Record currentRecord:records){
            int totalCases = currentRecord.getCases();
            if (totalCases>=1000){
                String country = currentRecord.getCountriesAndTerritories();
                int deaths = currentRecord.getDeaths();
                System.out.println(" " +country+ " " +totalCases+ " " +deaths);
            }
        }
	}
}
