// Задание: создать два текстовых документа с помощью IDEA. Наполнить их произвольным текстом.
// Из первого текстового файла во второй надо переписать все строки, вставив в конец каждой строки ее длину.
import java.io.*;
class TwoFiles {
    public static void main(String[] args) {
// создаём первый текстовый документ и наполняем текстом
        String text = "Ох, лето красное! любил бы я тебя,\n" +
                "Когда б не зной, да пыль, да комары, да мухи.\n" +
                "Ты, все душевные способности губя,\n" +
                "Нас мучишь; как поля, мы страждем от засухи;\n" +
                "Лишь как бы напоить, да освежить себя —\n" +
                "Иной в нас мысли нет, и жаль зимы старухи,\n" +
                "И, проводив ее блинами и вином,\n" +
                "Поминки ей творим мороженым и льдом.\n" +
                "_____________\n" +
                "Отрывок из стихотворения \"Осень\", А. С. Пушкин.";
        // Cоздаём новый файл и помещаем (добавляем) в него текст.
        File f = new File("myFile.txt");
        File nf = new File("myNewFile.txt");
        // Здесь - для простоты файл находится в папке проекта.
        // Иначе указывать new FileReader("c:\\<путь к файлу>\\firstFile.txt")
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("firstFile.txt", true)))
        {
            writer.write(text);
            writer.newLine();
        }
        catch ( IOException e ) // обрабатываем ошибки при работе с файлами
        {
            System.out.println(e.getMessage());
        }

        //========================================
        // создаём 2-й текстовый документ и наполняем текстом из первого, считая длины строк


        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader("firstFile.txt")))
        {
            line = reader.readLine();
            //System.out.println(line + line.length());
            while (line != null)
            {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("secondFile.txt", true)))
                {
                    writer.write(line + " (" + line.length() + ")");
                    writer.newLine();
                }
                catch ( IOException e )
                {
                    System.out.println(e.getMessage());
                }

                System.out.println(line + line.length());
                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}