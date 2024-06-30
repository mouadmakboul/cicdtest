package com.example.B2Bproject.modeliA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ChatCompletionResponse {
    private List<Choice> choices;



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice{

        private int index;
        private ChatMessage message;
    }

}
