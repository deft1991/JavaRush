package MyPack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Golitsyn.SN on 13.05.2016.
 *
 *
 * site.com
 * javaRush.ru
 */
public class RegularTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([A-Za-z0-9])+(\\.\\+[A-Za-z0-9])*\\.([a-z]){2,}$");
        Matcher m = pattern.matcher("javaRush.ru");
        boolean b = m.matches();
        System.out.println(b);
        File fileSeach = new File("C:\\temp2");
        boolean q = fileSeach.exists();
        System.out.println(q);

        File t = new File("C:\\temp");
      /*  try {
            t.createNewFile();
            Files.copy(t.toPath(), fileSeach.toPath());
            File[]files = t.listFiles();
            for (File f : files) {
                Files.copy(f.toPath(),fileSeach.getAbsoluteFile().toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        System.out.println(fileSeach.getAbsoluteFile());
        System.out.println(fileSeach.getAbsolutePath());
    }
}
