package utils.helpers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.CustomerInfo;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONHelper {
    public JSONHelper() {

    }

    /**
     * create customer inforation class based on the json file
     * @param filePath
     * @return CustomerInfo object
     */
    public CustomerInfo loadCustomerFromJSON(String filePath) {
        try {
            // create Gson instance
            GsonBuilder gsBuilder= new GsonBuilder().
                                       serializeNulls();
            Gson gson=gsBuilder.create();
           // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            // convert JSON string to User object
            CustomerInfo customer;
            customer=gson.fromJson(reader,CustomerInfo.class);
        // print user object
          //  System.out.println("Customer information is:"+customer.toString());
            // close reader
            reader.close();
            return customer;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
