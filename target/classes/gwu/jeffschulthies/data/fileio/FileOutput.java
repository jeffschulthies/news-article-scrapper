package gwu.jeffschulthies.data.fileio;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jeff Schulthies
 * .
 */
public class FileOutput {
    public void fileWriter(String fileName, String url, String title, String body, String links) throws Exception {
        try {
            File directory = new File("/tmp/articles/");
            if(!directory.exists()) {
                if (directory.mkdir()) {
                    System.out.println("Directory is created!");
                } else {
                    System.out.println("Failed to create directory!");
                }
            } else {
                System.out.println("Directory already created");
            }

            File f = new File("/tmp/articles/" + fileName);
            FileOutputStream fileStream = new FileOutputStream(f);
            Writer out = new OutputStreamWriter(fileStream, "UTF8");
            //Write my Strings
            out.write(url);
            out.write("\n");

            out.write(title);
            out.write("\n");

            out.write(body);
            out.write("\n");

            out.write(links);
            out.close();

            System.out.println("File is created");

        } catch(IOException e) {

            e.printStackTrace();
            System.out.println("An Error has occurred when writing");

        }
    }

    public String getDate() {
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
        Date now = new Date();
        return date.format(now);
    }
}
