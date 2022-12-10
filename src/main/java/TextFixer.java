import file.FileValidator;
import file.TextFileEditor;

import java.io.File;
import java.io.IOException;

public final class TextFixer {

    private String data;

    /**
     * Конструктор по имени исходного текстового файла
     * Проверяет файл на корректность и считывает его
     * @param filename путь к файлу
     * @throws IOException если файл не корректный
     */
    public TextFixer(String filename) throws IOException {
        File file = new File(filename);
        FileValidator.validateForRead(file);
        this.data = TextFileEditor.readText(file);
    }

    /**
     * Заменить все вхождения первой строки на вторую
     *
     * <p><pre>
     *     Abba babs bobs!
     *     findStr = "b"
     *     replaceStr = "bb"
     *
     *     Abba babs bobs!
     *      ^^  ^ ^  ^ ^ - нашли вхождения исходной строки
     *     Для каждого такого включения заменили на replaceStr
     *
     *     Abbbba bbabbs bbobbs!
     * </pre></p>
     * @param findStr строка, вхождения которой необходимо найти
     * @param replaceStr строка, на которую нужно заменить вхождения findStr
     */
    public void replace(String findStr, String replaceStr) {
        // throw new UnsupportedOperationException("Not implemented");
        // TODO: реализовать
        data = data.replace(findStr, replaceStr);
    }

    /**
     * Получить текст после изменений
     * @return текущий текст
     */
    public String getText() {
        return data;
    }

    /**
     * Сохранить файл после произведенным над ним операций replace
     * @param outputFilename путь к месту сохранения текстового файла
     * @throws IOException если путь некорректный или возникла другая ошибка
     */
    public void save(String outputFilename) throws IOException {
        File file = new File(outputFilename);
        FileValidator.validateForWrite(file);
        TextFileEditor.writeText(file, data);
    }

}
