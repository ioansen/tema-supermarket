package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Department;
import model.Item;
import model.Store;
import model.impl.*;

public class StoreReader implements Reader{

    @Override
    public void read(String path) {

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            Store store = Store.getInstance(br.readLine());

            String line;
            String[] lineComp;
            int itemsNr;

            while((line = br.readLine()) != null){

                lineComp = line.split(";");
                Department department = figureOutDepartmentFromName(lineComp[0],
                        Integer.valueOf(lineComp[1]));
                itemsNr = Integer.valueOf(br.readLine());

                for ( int i = 0; i < itemsNr; i++){
                    line = br.readLine();
                    lineComp = line.split(";");

                    Item item = new ItemImpl(lineComp[0],
                            Integer.valueOf(lineComp[1]),
                            Double.valueOf(lineComp[2]),
                            department);

                    department.addItem(item);
                }
                store.addDepartment(department);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private Department figureOutDepartmentFromName(String name, int id){
        switch (name){
            case "BookDepartment":
                return new BookDepartment(id);
            case "MusicDepartment":
                return new MusicDepartment(id);
            case "VideoDepartment":
                return new VideoDepartment(id);
            case "SoftwareDepartment":
                return new SoftwareDepartment(id);
        }

        throw new AssertionError("not a recognizable department");
    }
}
