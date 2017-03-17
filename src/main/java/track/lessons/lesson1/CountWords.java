package track.lessons.lesson1;

import java.io.*;

/**
 * Задание 1: Реализовать два метода
 *
 * Формат файла: текстовый, на каждой его строке есть (или/или)
 * - целое число (int)
 * - текстовая строка
 * - пустая строка (пробелы)
 *
 *
 * Пример файла - words.txt в корне проекта
 *
 * ******************************************************************************************
 *  Пожалуйста, не меняйте сигнатуры методов! (название, аргументы, возвращаемое значение)
 *
 *  Можно дописывать новый код - вспомогательные методы, конструкторы, поля
 *
 * ******************************************************************************************
 *
 */
public class CountWords {

    /**
     * Метод на вход принимает объект File, изначально сумма = 0
     * Нужно пройти по всем строкам файла, и если в строке стоит целое число,
     * то надо добавить это число к сумме
     * @param file - файл с данными
     * @return - целое число - сумма всех чисел из файла
     */
    public long countNumbers(File file) throws Exception {
        Long accumulator = 0L;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String inputString;
            Integer buffer;
            while ((inputString = bufferedReader.readLine()) != null) {
                try {
                    buffer = Integer.parseInt(inputString);
                    accumulator += buffer;
                } catch ( NumberFormatException n) { }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accumulator;
    }


    /**
     * Метод на вход принимает объект File, изначально результат= ""
     * Нужно пройти по всем строкам файла, и если в строка не пустая и не число
     * то надо присоединить ее к результату через пробел
     * @param file - файл с данными
     * @return - результирующая строка
     */
    public String concatWords(File file) throws Exception {
        StringBuilder accumulator = new StringBuilder("");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                try {
                    Integer.parseInt(inputString);
                } catch ( NumberFormatException n) {
                    if (!inputString.isEmpty()) {
                        accumulator.append(inputString);
                        accumulator.append(' ');
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accumulator.toString();
    }

}
