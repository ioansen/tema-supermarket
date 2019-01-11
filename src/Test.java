import events.Event;
import readers.CustomersReader;
import readers.EventReader;
import readers.StoreReader;

import java.io.File;
import java.nio.file.Files;

public class Test {

    public static void main(String[] args) {

        File testingDir = new File("C:\\temp\\Teste");
        File[] tests = testingDir.listFiles();
        StoreReader storeReader = new StoreReader();
        CustomersReader customersReader = new CustomersReader();
        EventReader eventReader = new EventReader();
       /* for ( File file : tests ){
            String path = file.getAbsolutePath();
            storeReader.read(path + "\\store.txt");
            customersReader.read(path + "\\customers.txt");
            eventReader.read(path  + "\\events.txt");
        }*/
       for (int i = 0; i < 1; i ++){
           System.out.println("Running test " + tests[i].getName());
           File file = tests[i];
           String path = file.getAbsolutePath();
           storeReader.read(path + "\\store.txt");
           customersReader.read(path + "\\customers.txt");
           eventReader.read(path  + "\\events.txt");
       }

    }
}
