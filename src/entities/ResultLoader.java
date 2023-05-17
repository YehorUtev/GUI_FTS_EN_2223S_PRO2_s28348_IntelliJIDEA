package entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ResultLoader {

    public static List<Result> load(String url){
        List<Result> list = new ArrayList<>();
        try {
            FileInputStream fs = new FileInputStream(url);
            ObjectInputStream os = new ObjectInputStream(fs);
            Object object = new Object();
            while((object =  os.readObject()) != null){
                list.add((Result) object);
            }
            fs.close();
            os.close();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return list;
    }
}
