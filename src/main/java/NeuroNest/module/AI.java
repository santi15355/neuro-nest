package NeuroNest.module;

import NeuroNest.config.Config;
import NeuroNest.service.Utils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.thymeleaf.templateparser.markup.HTMLTemplateParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class AI {

    private final Config config;

    private final Utils utils;

    private static final String MODEL_35 = "gpt-3.5-turbo";
    private static final String MODEL_40 = "gpt-4-1106-preview";

    private static final String PROXY_API_URL = "https://api.proxyapi.ru/openai/v1/chat/completions";

    @SneakyThrows
    public String getAnswerFromAI(String userMessage) {

        URL url = new URL(PROXY_API_URL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + config.getTokenProxyApi());
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        String jsonBody = "{\"model\": \"" + MODEL_35 + "\", \"messages\": [{\"role\": \"user\", \"content\": \""
                + userMessage + "\"}]}";

        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8);
        writer.write(jsonBody);
        writer.flush();
        writer.close();

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        } catch (IOException e) {
            // Обработка исключения IOException
            e.printStackTrace();
        }
        return utils.getContent(response);
    }
}
