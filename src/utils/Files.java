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
        FileInputStream fis = null;
        try {
            File file = new File(path);
            if(!file.exists() || file.length() == 0) return new ArrayList<>();

            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Object> list = new ArrayList<>();
            while(fis.available() > 0) {
                Object obj = ois.readObject();
                list.add(obj);
            }

            return list;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
