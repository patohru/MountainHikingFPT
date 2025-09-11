package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    public static boolean writeListObjectToFile(String path, List<Object> list) throws IOException {
        boolean result = false;
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(file);
        try {
            for(Object sm : list) {
                oos.writeObject(sm);
            }
            result = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            oos.close();
            file.close();
        }

        return result;
    }

    public static List<Object> readFromFile(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Object> list = new ArrayList<>();

        try {
            Object obj;
            while(fis.available() > 0) {
                obj = (Object) ois.readObject();
                list.add(obj);
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            ois.close();
            fis.close();
        }

        return list;
    }
}
