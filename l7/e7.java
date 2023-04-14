package l7;



public class e7 {

    /**
     * Вариант 4. Задача 5.
     * Заменить все одинаковые рядом стоящие символы в тексте одним символом.
     */
    public static void main(String[] args) {


    }

    public static String readFile(String filename) {
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                text += line+'\n';
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return text;
    }
}
