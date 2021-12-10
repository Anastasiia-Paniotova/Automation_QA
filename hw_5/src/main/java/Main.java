import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomMapImpl<String,String> customerMap = new CustomMapImpl<>();

        System.out.println("Select the option for map (1 - put; 2 - get by key; 3 - show all keys; 4 - show all values; 0 - exist): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String option;

        while ((option = reader.readLine()) != null) {
            switch (option) {
                case "1": {
                    System.out.println("You selected - PUT option");
                    System.out.println("Type your KEY:");
                    String key = reader.readLine();
                    System.out.println("Type your VALUE:");
                    String value = reader.readLine();
                    customerMap.put(key,value);
                    System.out.println();
                    System.out.println("Select the option for map (1 - put; 2 - get by key; 3 - show all keys; 4 - show all values; 0 - exist): ");
                }
                break;
                case "2": {
                    System.out.println("You selected - GET by key option");
                    System.out.println("Type the key of value: ");
                    String key = reader.readLine();
                    System.out.println(customerMap.get(key));
                    System.out.println();
                    System.out.println("Select the option for map (1 - put; 2 - get by key; 3 - show all keys; 4 - show all values; 0 - exist): ");
                }
                break;
                case "3": {
                    System.out.println("You selected - SHOW ALL VALUES");
                    System.out.println(customerMap.listValues());

                    System.out.println("Select the option for map (1 - put; 2 - get by key; 3 - show all keys; 4 - show all values; 0 - exist): ");
                }
                break;
                case "4": {
                    System.out.println("You selected - SHOW ALL keys");
                    System.out.println(customerMap.setKeys());
                    System.out.println("Select the option for map (1 - put; 2 - get by key; 3 - show all keys; 4 - show all values; 0 - exist): ");
                }
                break;

                case "0": {
                    System.exit(0);
                }

            }

        }
    }
}