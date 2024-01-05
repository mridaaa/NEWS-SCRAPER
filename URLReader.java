// Anushka Dole & Mrida Yawale
// December 28, 2023
// Code to read URL
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.*;

public class URLReader {
    private String url;

    public URLReader(String url) {
        this.url = url;
    }

    public String readURL() {

        StringBuffer content = new StringBuffer();
        try {
            URL site = new URI(url).toURL();
            URLConnection connection = site.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line + "\n");
                // System.out.println(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("An exception occurred");
            e.printStackTrace();
        }
        return content.toString();
    }
}
