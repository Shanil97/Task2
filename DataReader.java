package covid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

    public class DataReader {
        private static final String JSON_ARRAY = "records";
        private static final String COUNTRY = "countriesAndTerritories";
        private static final String DATE = "dateRep";
        private static final String CASES = "cases";
        private static final String DEATHS = "deaths";

        /**
         * This method reads the contents form a JSON file and prints the required data.
         *
         * @param filePath the path to JSON file.
         */
        public void readData(String filePath) {
            try {
                String fileContent = Files.readString(Paths.get(filePath));
                JSONObject obj  = new JSONObject(fileContent);
                JSONArray arr = obj.getJSONArray(JSON_ARRAY);

                System.out.println("\tDate\t|\tCases\t|\tDeaths ");

                for(int i = 0; i < arr.length(); i ++) {
                    if(arr.getJSONObject(i).getString(COUNTRY).equals("Sri_Lanka")){
                        System.out.println(" " +arr.getJSONObject(i).getString(DATE)+ " \t" +arr.getJSONObject(i).getString(CASES)+ " \t\t\t" +arr.getJSONObject(i).getString(DEATHS)+ "" );
                    }
                }

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

