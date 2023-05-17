package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ResultLoader {
    public static List<Result> load(String filePath) {
        List<Result> resultList = new ArrayList<>();

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                Result result = (Result) is.readObject();
                resultList.add(result);
            }
        } catch (EOFException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
        }

        return resultList;
    }
}