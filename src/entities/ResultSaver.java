package entities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ResultSaver {
    public static void save(List<Result> listResult, String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<Result> existingResults = new ArrayList<>();

            if (Files.exists(path)) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                    while (true) {
                        Result result = (Result) ois.readObject();
                        existingResults.add(result);
                    }
                } catch (EOFException e) {
                }
            }

            existingResults.addAll(listResult);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                for (Result result : existingResults) {
                    oos.writeObject(result);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
