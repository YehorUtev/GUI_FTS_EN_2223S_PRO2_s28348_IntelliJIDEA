package entities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ResultSaver {
    public static void save(List<Result> listResult, String url){
        try {
            FileOutputStream fs = new FileOutputStream(url);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            for(Result result : listResult) {
                os.writeObject(result);
            }
            fs.close();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
