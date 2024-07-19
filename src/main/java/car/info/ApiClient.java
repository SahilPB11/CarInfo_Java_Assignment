package car.info;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ApiClient {
    private final String apiUrl;
    private final String apiKey;

    /**
     * Constructor to initialize ApiClient with API URL and API key.
     *
     * @param apiUrl The URL of the API endpoint.
     * @param apiKey The API key required for authentication.
     */
    public ApiClient(String apiUrl, String apiKey) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    /**
     * Fetches data from the specified API endpoint using a GET request.
     *
     * @return The response body as a String if the request is successful, otherwise null.
     */
    public String fetchData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiUrl)
                .addHeader("apiKey", apiKey)
                .get() // Perform a GET request
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string(); // Return the response body as a String
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace in case of an IOException
        }
        return null; // Return null if there's an error or the response is unsuccessful
    }
}
