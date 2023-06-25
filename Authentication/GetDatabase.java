package Authentication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GetDatabase {

    protected ArrayList<String> username = new ArrayList<>();
    protected ArrayList<String> password = new ArrayList<>();
    
    protected String location = "F:\\ProgrammingS2\\MyProject\\JavaProjectGit\\TictactoeJFrame\\Authentication\\UserDb.txt";

    /**
     * Taking user data inside database  
     * then adding it into the ArrayList.
     */
    public GetDatabase() {

        try {

            FileReader reader = new FileReader(location);

            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = bufferedReader.readLine();

            while (data != null) {

                StringTokenizer subData = new StringTokenizer(data, ",");

                username.add(subData.nextToken());
                password.add(subData.nextToken());

                data = bufferedReader.readLine();

            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Can't read data");
        }

    }

}
