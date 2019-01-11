package readers;

import model.Department;
import model.Store;
import model.impl.CustomerImpl;
import model.impl.ItemImpl;
import strategy.Strategy;
import strategy.StrategyA;
import strategy.StrategyB;
import strategy.StrategyC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomersReader implements Reader {

    @Override
    public void read(String path) {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            Store store = Store.getInstance();
            String line;
            String[] lineComp;
            int itemsNr = Integer.valueOf(br.readLine());
            for ( int i = 0; i < itemsNr; i++){
                lineComp = br.readLine().split(";");
                store.enter(new CustomerImpl(lineComp[0], Double.valueOf(lineComp[1]),
                        fugureOutStrategyFromLetter(lineComp[2])));
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private Strategy fugureOutStrategyFromLetter(String letter){
        switch (letter){
            case "A":
                return new StrategyA();
            case "B":
                return new StrategyB();
            case "C":
                return new StrategyC();
        }

        throw new AssertionError("non recognizable strategy: " + letter);
    }
}
