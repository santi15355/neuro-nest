package NeuroNest.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Utils {

    public String getContent(StringBuilder response) {
        try {
            JSONObject jsonObject = new JSONObject(response.toString());
            String content = jsonObject.getJSONArray("choices").getJSONObject(0)
                    .getJSONObject("message").getString("content");
                        return content;
        } catch (JSONException e) {
            // Обработка ошибки парсинга JSON
            e.printStackTrace();
        }
        return ""; // Возвращаем пустую строку, если нет данных или произошла ошибка
    }
}
