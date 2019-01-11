package readers;

import events.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EventReader implements Reader {

    @Override
    public void read(String path) {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            int itemsNr = Integer.valueOf(br.readLine());
            for ( int i = 0; i < itemsNr; i++){
               figureOutEventFromLine(br.readLine()).fire();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private Event figureOutEventFromLine(String line){
        String[] lineComp = line.split(";");
        String name = lineComp[0];
        switch (name){
            case "addItem":
                return new AddItemEvent(Integer.valueOf(lineComp[1]), lineComp[2], lineComp[3]);
            case "delItem":
                return new DelItemEvent(Integer.valueOf(lineComp[1]), lineComp[2], lineComp[3]);
            case "addProduct":
                return new AddProductEvent(Integer.valueOf(lineComp[1]),
                        Integer.valueOf(lineComp[2]),
                        Double.valueOf(lineComp[3]),
                        lineComp[4]);
            case "delProduct":
                return new DelProductEvent(Integer.valueOf(lineComp[1]));
            case "getItem":
                return new GetItemEvent(lineComp[1]);
            case "getItems":
                return new GetItemsEvent(lineComp[1], lineComp[2]);
            case "getTotal":
                return new GetTotalEvent(lineComp[1], lineComp[2]);
            case "accept":
                return new AcceptEvent(Integer.valueOf(lineComp[1]), lineComp[2]);
            case "getObservers":
                return new GetObserversEvent(Integer.valueOf(lineComp[1]));
            case "getNotification":
                return new GetNotificationsEvent(lineComp[1]);
            case "modifyProduct":
                return new ModifyProductEvent(Integer.valueOf(lineComp[1]),
                        Integer.valueOf(lineComp[2]),
                        Double.valueOf(lineComp[3]));
        }

        throw new AssertionError("not a recognizable event: " + name);
    }
}
