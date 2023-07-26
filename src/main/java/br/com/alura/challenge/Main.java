package br.com.alura.challenge;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite uma pergunta para o ChatGPT: ");
        var pergunta = leitura.nextLine();

        CompletionRequest requisicao  = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(pergunta)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        System.out.println(resposta.getChoices().get(0).getText());
    }
}