

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileStorage {

    static void savePeopleToFile(ArrayList<Person> list, File file) throws IOException {
        // FIXME: use try-with-resources here
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)));
        for (Person p : list) {
            out.println(p.getName());
            out.println(p.getAge());
        }
        out.close();
    }

    static ArrayList<Person> loadPeopleFromFile(File file) throws IOException {
        ArrayList<Person> list = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return list;
            }
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                String name = in.nextLine();
                int age = in.nextInt();
                in.nextLine(); // consume the left-over newline character
                Person p = new Person(name, age);
                list.add(p);
            }
        } catch (InputMismatchException e) {
            throw new IOException("Error while parsing data file", e);
        } catch (IllegalArgumentException e) {
            throw new IOException("Error while parsing data file", e);
        }        
        return list;
    }

}
