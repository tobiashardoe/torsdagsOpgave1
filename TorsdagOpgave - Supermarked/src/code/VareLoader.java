package code;

import util.FileIO;
import java.util.ArrayList;
import java.util.List;

public class VareLoader {

    private FileIO io = new FileIO();

    public List<Vare> loadVarer(String path) {

        List<Vare> varer = new ArrayList<>();

        ArrayList<String> lines = io.readData(path);

        for (String line : lines) {
            String[] cols = line.split(";");

            varer.add(new Vare(cols));
        }

        return varer;
    }
}
