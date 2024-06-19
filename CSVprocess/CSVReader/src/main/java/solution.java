/*
6. Coding exercise: Availity receives enrollment files from various benefits management and enrollment solutions
(I.e. HR platforms, payroll platforms). Most of these files are typically in EDI format. However, there are some
files in CSV format. For the files in CSV format, write a program that will read the content of the file and
separate enrollees by insurance company in its own file. Additionally, sort the contents of each file by last and
first name (ascending), Lastly. If there are duplicate User lds for the same Insurance Company, then only
the record with the highest version should be included. The following data points are included in the file:
user id (string)
First Name (string)
last Name (string)
Version (integer)
Insurance Company (string)
 */


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/data.csv"; // replace with your file path

        // A map to store lists of users by company name
        Map<String, List<User>> companyUsersMap = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath))) {
            String[] nextLine;
            String[] header = null;

            while ((nextLine = reader.readNext()) != null) {

                String userId = nextLine[0];
                String firstName = nextLine[1];
                String lastName = nextLine[2];
                String companyName = nextLine[4];
                int version = Integer.parseInt(nextLine[3]);

                User u = new User(userId, firstName, lastName, companyName, version);
                if(companyUsersMap.containsKey(companyName)) {
                    List<User> users = companyUsersMap.get(companyName);
                    boolean found = false;
                    for (User user : users) {
                        if(user.equals(u)){
                            if(user.getVersion() < version){
                                users.remove(user);
                                users.add(u);
                            }
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        users.add(u);
                    }
                }else{
                    List<User> users = new ArrayList<>();
                    users.add(u);
                    companyUsersMap.put(companyName, users);
                }

            }


            // Write each company's users to a separate file
            for (Map.Entry<String, List<User>> entry : companyUsersMap.entrySet()) {
                String companyName = entry.getKey();
                List<User> users = entry.getValue();
                String outputFilePath = "src/main/resources/" + companyName + ".csv"; // adjust path and filename

                Collections.sort(users);

                try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

                    // Write all user records for this company
                    for (User user : users) {
                        writer.writeNext(user.toCSVString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}