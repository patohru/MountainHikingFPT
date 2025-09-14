package controllers;

import models.Mountain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MountainController extends ArrayList<Mountain> {
    public void readMountain() {
        this.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("MountainList.csv"))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String mountainCode = data[0].trim();
                String mountainName = data[1].trim();
                String province = data[2].trim();
//                String description = data[3] == null ? "" : data[3].trim();

                Mountain mountain = new Mountain(mountainCode, mountainName, province, "");
                this.add(mountain);
            }
        } catch (IOException e) {
            System.out.println("Failed to read file");
        }
    }

    public boolean getMountainCode(String mountainCode) {
        for(Mountain mountain : this) {
            if(mountain.getMountainCode().equals(mountainCode)) {
                return true;
            }
        }

        return false;
    }
}
