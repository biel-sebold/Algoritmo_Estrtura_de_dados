package TrabalhoFinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class TagValidator {
    private static final String[] SINGLETON_TAGS = {
        "meta", "base", "br", "col", "command", "embed", 
        "hr", "img", "input", "link", "param", "source", "!DOCTYPE"
    };

    public static void main(String[] args) {
        String filePath = "caminho/do/seu/arquivo.html"; // Substitua pelo caminho do seu arquivo
        validateHTML(filePath);
    }

    public static void validateHTML(String filePath) {
        Stack<String> tagStack = new Stack<>(); // Pilha para armazenar tags de início
        HashMap<String, Integer> tagCount = new HashMap<>(); // Mapa para contar a frequência das tags
        boolean isValid = true; // Flag para verificar se o HTML é válido

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); // Remove espaços em branco no início e no fim
                if (line.isEmpty()) continue; // Ignorar linhas em branco

                // Regex para encontrar tags
                String regex = "<\\/?([a-zA-Z][a-zA-Z0-9]*)"; // Expressão regular para capturar tags
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                java.util.regex.Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String tag = matcher.group(1).toLowerCase(); // Tag em minúsculas
                    if (line.charAt(matcher.start()) == '<' && line.charAt(matcher.start() + 1) != '/') {
                        // Tag de início
                        if (!isSingletonTag(tag)) { // Verifica se não é uma singleton tag
                            tagStack.push(tag); // Adiciona a tag à pilha
                        }
                        tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1); // Conta a frequência da tag
                    } else {
                        // Tag de fim
                        if (tagStack.isEmpty() || !tagStack.pop().equals(tag)) {
                            System.out.println("Tag final inesperada: </" + tag + ">"); // Mensagem de erro
                            isValid = false; // Marca como inválido
                        }
                    }
                }
            }

            // Verificar se ainda há tags de início sem correspondência
            if (!tagStack.isEmpty()) {
                System.out.println("Faltam tags finais para: " + tagStack); // Mensagem de erro
                isValid = false; // Marca como inválido
            }

            if (isValid) {
                System.out.println("O arquivo está bem formatado."); // Mensagem de sucesso
                reportTags(tagCount); // Relatório de tags
            } else {
                System.out.println("O arquivo não está bem formatado."); // Mensagem de erro
            }

        } catch (IOException e) {
            e.printStackTrace(); // Tratamento de exceção
        }
    }

    private static void reportTags(HashMap<String, Integer> tagCount) {
        System.out.println("Tags encontradas e suas frequências:");
        tagCount.forEach((tag, count) -> System.out.println(tag + ": " + count)); // Exibe a frequência das tags
    }

    private static boolean isSingletonTag(String tag) {
        for (String singleton : SINGLETON_TAGS) {
            if (singleton.equals(tag)) {
                return true; // Retorna verdadeiro se for uma singleton tag
            }
        }
        return false; // Retorna falso se não for
    }
}
