
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaGetRequest {
    private static HttpURLConnection conn;

    public static void main(String[] args) throws IOException {

        var url = "https://github.com/vnn7298";
        try {
            var url = new URL(url);
            String line;
            StringBuilder content;
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()))) {
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println("Content:" +content.toString());
        } finally {
            conn.disconnect();
        }
    }
}
