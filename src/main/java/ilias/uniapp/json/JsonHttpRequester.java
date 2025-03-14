package ilias.uniapp.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ilias.uniapp.db.University;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class JsonHttpRequester {

    private static final String SEARCH_UNIVERSITY_URL = "http://universities.hipolabs.com/search?name=";
    private static final String SEARCH_BY_COUNTRY_URL = "http://universities.hipolabs.com/search?country=";


    // Μέθοδος για την αποστολή HTTP GET αιτήματος και λήψη της απάντησης σε μορφή String
    private static String getJsonString(String serverUrl, String param) {
        String urlParam = "";
        if (param.length() > 0) {
            // πρέπει να κωδικοποιήσουμε τη λέξη-παράμετρο στη μορφή URI
            try {
                urlParam = java.net.URLEncoder.encode(param, "utf-8");
            } catch (UnsupportedEncodingException uee) {
                throw new RuntimeException(uee);
            }
        }

        String url = serverUrl + urlParam;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Μέθοδος για την επιστροφή ενός συγκεκριμένου πανεπιστημίου
    public static University getUniversity(String universitySearchName) {
        if (universitySearchName == null || universitySearchName.isEmpty()) {
            return null;
        }

        String returnedJsonData = getJsonString(SEARCH_UNIVERSITY_URL, universitySearchName);
        JsonArray jsonArray = JsonParser.parseString(returnedJsonData).getAsJsonArray();

        if (jsonArray.size() > 0) {
            JsonObject universityJson = jsonArray.get(0).getAsJsonObject(); // Παίρνουμε το πρώτο αποτέλεσμα

            String name = universityJson.get("name").getAsString();
            // Παίρνουμε το πρώτο domain και την πρώτη ιστοσελίδα
            String domain = universityJson.getAsJsonArray("domains").get(0).getAsString();
            String webPage = universityJson.getAsJsonArray("web_pages").get(0).getAsString();
            String alphaTwoCode = universityJson.get("alpha_two_code").getAsString();
            String country = universityJson.get("country").getAsString();
            String stateProvince = universityJson.has("state-province") && !universityJson.get("state-province").isJsonNull()
                    ? universityJson.get("state-province").getAsString() : "";

            return new University(name, domain, webPage, alphaTwoCode, country, stateProvince);
        }

        return null;
    }

    // Μέθοδος για την επιστροφή μιας λίστας πανεπιστημίων (ονόματα)
    public static List<String> getUniversities(String universitySearchName) {
        List<String> universities = new ArrayList<>();
        if (universitySearchName == null || universitySearchName.isEmpty()) {
            return universities;
        }

        String returnedJsonData = getJsonString(SEARCH_UNIVERSITY_URL, universitySearchName);
        JsonArray jsonArray = JsonParser.parseString(returnedJsonData).getAsJsonArray();

        // Ελέγχουμε κάθε αποτέλεσμα από τον πίνακα
        for (JsonElement jsonObject : jsonArray) {
            if (jsonObject.isJsonObject()) {
                JsonObject jsonObjectJson = jsonObject.getAsJsonObject();
                JsonElement universityName = jsonObjectJson.get("name");
                if (universityName != null) {
                    universities.add(universityName.getAsString());
                }
            }
        }
        return universities;
    }


    // Μέθοδος για την επιστροφή μιας λίστας πανεπιστημίων (ονόματα) βάση χώρας
    public static List<String> getUniversitiesByCountry(String countrySearchName) {
        List<String> universities = new ArrayList<>();
        if (countrySearchName == null || countrySearchName.isEmpty()) {
            return universities;
        }

        String returnedJsonData = getJsonString(SEARCH_BY_COUNTRY_URL, countrySearchName);
        JsonArray jsonArray = JsonParser.parseString(returnedJsonData).getAsJsonArray();

        // Ελέγχουμε κάθε αποτέλεσμα από τον πίνακα
        for (JsonElement jsonObject : jsonArray) {
            if (jsonObject.isJsonObject()) {
                JsonObject jsonObjectJson = jsonObject.getAsJsonObject();
                JsonElement universityName = jsonObjectJson.get("name");

                if (universityName != null) {
                    universities.add(universityName.getAsString());
                }
            }
        }
        return universities;
    }
}