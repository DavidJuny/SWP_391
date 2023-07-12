package Controller;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class WordGenerateAPI {
    public static ArrayList<String> GenerateWord(String word)
    {
        int resultLimit = 10; // Number of results to retrieve
        ArrayList<String> words = null;
        ArrayList<String> phrases = null;
        try {
            URL url = new URL("https://api.datamuse.com/words?ml=" + word + "&max=" + resultLimit);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

           words = parseResponseToList(response.toString());
           phrases = addPhraseToWords(words, "How do you say ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    return phrases;
    }
    private static ArrayList<String> parseResponseToList(String response) {
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(response).getAsJsonArray();

        ArrayList<String> words = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            String word = jsonObject.get("word").getAsString();
            words.add(word);
        }
        return words;
    }
    private static ArrayList<String> addPhraseToWords(ArrayList<String> words, String phrase) {
        ArrayList<String> phrases = new ArrayList<>();

        for (String word : words) {
            String phraseWithWord = phrase + word;
            phrases.add(phraseWithWord);
        }

        return phrases;
    }
}
