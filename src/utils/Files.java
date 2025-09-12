package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Files {
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

    public static List<Object> readFromFile(String path) {
        File file = new File(path);
        if(!file.exists() || file.length() == 0) return new ArrayList<>();

        ArrayList<Object> list = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if(obj instanceof List) {
                list.add(obj);
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
