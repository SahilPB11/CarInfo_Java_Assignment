package car.info;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CricketMatches {

    /**
     * Main method to initiate fetching and processing of cricket match data.
     * Initializes the API client with URL and API key, fetches JSON data, and processes it.
     * Prints results of highest scores and number of matches with scores over 300.
     *
     * @param args Command line arguments (not used in this context).
     */
    public static void main(String[] args) {
        String apiUrl = "https://api.cuvora.com/car/partner/cricket-data";
        String apiKey = "test-creds@2320";

        // Initialize API client
        ApiClient apiClient = new ApiClient(apiUrl, apiKey);

        // Fetch JSON data from API
        String jsonData = apiClient.fetchData();

        // Process fetched data if not null; otherwise, print error message
        if (jsonData != null) {
            processMatchesData(jsonData);
        } else {
            System.out.println("Failed to fetch data from API");
        }
    }

    /**
     * Processes JSON data containing cricket match details.
     * Calculates the highest score, corresponding team, and number of matches with scores over 300.
     *
     * @param jsonData JSON data retrieved from the API.
     */
    public static void processMatchesData(String jsonData) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);

        // Check if the JSON object contains the "data" array for matches
        if (jsonObject.has("data")) {
            JsonArray matches = jsonObject.getAsJsonArray("data");

            // Initialize variables to track highest score, team, and total matches with score over 300
            int highestScore = 0;
            String highestScoreTeam = "";
            int total300PlusMatches = 0;

            // Iterate through each match in the JSON array
            for (JsonElement matchElement : matches) {
                JsonObject match = matchElement.getAsJsonObject();
                String t1 = match.get("t1").getAsString();
                String t2 = match.get("t2").getAsString();
                int t1s = parseScore(match.get("t1s").getAsString());
                int t2s = parseScore(match.get("t2s").getAsString());

                // Determine highest score and corresponding team
                if (t1s > highestScore) {
                    highestScore = t1s;
                    highestScoreTeam = t1;
                }

                if (t2s > highestScore) {
                    highestScore = t2s;
                    highestScoreTeam = t2;
                }

                // Count matches where total score is over 300
                if (t1s + t2s > 300) {
                    total300PlusMatches++;
                }
            }

            // Print results
            System.out.println("Highest Score: " + highestScore);
            System.out.println("Team with Highest Score: " + highestScoreTeam);
            System.out.println("Number of Matches with total 300 Plus Score: " + total300PlusMatches);
        } else {
            System.out.println("No matches data found in JSON");
        }
    }

    /**
     * Parses the score string to extract the numeric score before the '/' character.
     * Returns 0 if the score string is null, empty, or does not contain '/'.
     *
     * @param score Score string in the format "score/overs".
     * @return Extracted numeric score or 0 if parsing fails.
     */
    public static int parseScore(String score) {
        if (score == null || score.isEmpty()) {
            return 0;
        }
        String[] parts = score.split("/");
        return Integer.parseInt(parts[0]);
    }
}
