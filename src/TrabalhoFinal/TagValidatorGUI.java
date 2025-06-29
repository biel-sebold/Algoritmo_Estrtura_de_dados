package TrabalhoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class TagValidatorGUI extends JFrame {
    private JTextField filePathField;
    private JTextArea resultArea;
    private JButton processButton;

    private static final String[] SINGLETON_TAGS = {
        "meta", "base", "br", "col", "command", "embed", 
        "hr", "img", "input", "link", "param", "source", "!DOCTYPE"
    };

    public TagValidatorGUI() {
        setTitle("Validador de Arquivo HTML");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel();
        filePathField = new JTextField(20);
        processButton = new JButton("Processar Arquivo");
        inputPanel.add(new JLabel("Caminho do arquivo:"));
        inputPanel.add(filePathField);
        inputPanel.add(processButton);

        // Área de resultados
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Ação do botão
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = filePathField.getText();
                validateHTML(filePath);
            }
        });
    }

    public void validateHTML(String filePath) {
        Stack<String> tagStack = new Stack<>(); // Pilha para armazenar tags de início
        HashMap<String, Integer> tagCount = new HashMap<>(); // Mapa para contar a frequência das tags
        boolean isValid = true; // Flag para verificar se o HTML é válido
        resultArea.setText(""); // Limpa a área de resultados

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
                            resultArea.append("Tag final inesperada: </" + tag + ">\n"); // Mensagem de erro
                            isValid = false; // Marca como inválido
                        }
                    }
                }
            }

            // Verificar se ainda há tags de início sem correspondência
            if (!tagStack.isEmpty()) {
                resultArea.append("Faltam tags finais para: " + tagStack + "\n"); // Mensagem de erro
                isValid = false; // Marca como inválido
            }

            if (isValid) {
                resultArea.append("O arquivo está bem formatado.\n"); // Mensagem de sucesso
                reportTags(tagCount); // Relatório de tags
            } else {
                resultArea.append("O arquivo não está bem formatado.\n"); // Mensagem de erro
            }

        } catch (IOException e) {
            resultArea.append("Erro ao ler o arquivo: " + e.getMessage() + "\n"); // Tratamento de exceção
        }
    }

    private void reportTags(HashMap<String, Integer> tagCount) {
        resultArea.append("Tags encontradas e suas frequências:\n");
        tagCount.forEach((tag, count) -> resultArea.append(tag + ": " + count + "\n")); // Exibe a frequência das tags
    }

    private boolean isSingletonTag(String tag) {
        for (String singleton : SINGLETON_TAGS) {
            if (singleton.equals(tag)) {
                return true; // Retorna verdadeiro se for uma singleton tag
            }
        }
        return false; // Retorna falso se não for
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TagValidatorGUI gui = new TagValidatorGUI();
            gui.setVisible(true);
        });
    }
}

