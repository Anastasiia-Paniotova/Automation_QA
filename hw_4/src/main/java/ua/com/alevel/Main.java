package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomerList<String> customerList = new CustomerList<>();

        System.out.println("Select the option for list (1 - add; 2 - get by index; 3 - update by index; 4 - delete by index; 5 - show all; 0 - exist) :");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String option;

        while ((option = reader.readLine()) != null) {
            switch (option) {
                case "1": {
                    System.out.println("You selected - ADD option");
                    System.out.println("Type your element");
                    String element = reader.readLine();
                    customerList.add(element);
                    System.out.println("Select the option for list (1 - add; 2 - get by index; 3 - update by index; 4 - delete by index;5 - show all) :");
                }
                break;
                case "2": {
                    System.out.println("You selected - GET by index option");
                    System.out.println("Type the index of element: ");
                    int index = Integer.parseInt(reader.readLine());

                    if (index > customerList.size()) {
                        System.out.println("You should ADD the elements before using GET");
                    } else {
                        System.out.println(customerList.get(index));
                    }
                    System.out.println("Select the option for list (1 - add; 2 - get by index; 3 - update by index; 4 - delete by index;5 - show all) :");
                }
                break;
                case "3": {
                    System.out.println("You selected - UPDATE by index option");
                    System.out.println("Type the index of element: ");
                    int index = Integer.parseInt(reader.readLine());
                    System.out.println("Type the element: ");
                    String element = reader.readLine();
                    customerList.set(index, element);
                    System.out.println("Select the option for list (1 - add; 2 - get by index; 3 - update by index; 4 - delete by index; 5 - show all) :");
                }
                case "4": {
                    System.out.println("You selected - DELETE by index option");
                    System.out.println("Type the index of element: ");
                    int index = Integer.parseInt(reader.readLine());
                    customerList.delete(index);
                    System.out.println("Select the option for list (1 - add; 2 - get by index; 3 - update by index; 4 - delete by index; 5 - show all):");
                }
                case "5": {
                    System.out.println("You selected - SHOW ALL option");
                    for (int i = 0; i < customerList.size(); i++) {
                        System.out.println(customerList.get(i));
                    }
                    System.out.println("Select the option for list (1 - add; 2 - get by index; 3 - update by index; 4 - delete by index);  5 - show all):");
                }
                case "0": {
                    System.exit(0);
                }

            }

        }
    }
}

