package br.com.joaopedro.front_gestao_vagas.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatErrorMessage {
// Método estático que formata a mensagem de erro
    public static String formatErrorMessage(String message){
        // Cria uma instância do ObjectMapper, que é uma ferramenta para trabalhar com JSON no Java
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            // Converte a mensagem recebida (que deve ser uma string JSON) em um nó JSON
            JsonNode rootNode = objectMapper.readTree(message);
            
            // Se o JSON for um array, chama um método específico para formatar a mensagem de erro no formato de array
            if(rootNode.isArray()){
                return formatArrayErrorMessage(rootNode);
            }
            // Caso contrário, retorna a mensagem do nó como texto simples
            return rootNode.asText();
        } catch (Exception e){
            // Caso haja um erro na conversão ou qualquer outra falha, retorna a mensagem original sem alteração
            return message;
        }
    }

    // Método auxiliar para formatar a mensagem de erro quando o JSON é um array
    public static String formatArrayErrorMessage(JsonNode arrayNode){
        // Usa um StringBuilder para construir a mensagem formatada de forma eficiente
        StringBuilder formattedMessager = new StringBuilder();

        // Itera sobre todos os elementos do array
        for(JsonNode node : arrayNode){
            // Para cada nó no array, pega o campo "message" e o adiciona à mensagem final com o prefixo "-"
            formattedMessager.append("- ").append(node.get("message").asText()).append("\n");
        }
        // Retorna a mensagem formatada
        return formattedMessager.toString();
    }
}
