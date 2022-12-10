package file;

import java.io.File;
import java.io.IOException;

public class FileValidator {

    /**
     * Проверяет, что путь указывает на корректный файл
     *
     * @param file экземпляр класса File
     * @throws IOException если файл не существует, не является обычным (регулярным файлом) или является директорией
     */
    private static void validate(File file) throws IOException {
        throw new UnsupportedOperationException("Not implemented");
        // TODO: бросить исключение, если файл не существует, не является обычным (регулярным файлом) или является директорией
    }

    /**
     * Проверяет, что путь указывает на корректный для записи файл
     *
     * Если файл не существует, хорошо
     * Есль файл уже существует, то он должен быть доступен для записи
     *
     * @param file экземпляр класса File
     * @throws IOException если файл некорректный или недоступен для записи
     */
    public static void validateForWrite(File file) throws IOException {
        throw new UnsupportedOperationException("Not implemented");
        // TODO: бросить исключение, если нет возможности записи
    }

    /**
     * Проверяет, что путь указывает на корректный для чтения файл
     *
     * <br><b>Указание.</b> Переиспользовать {@link #validate(File file)}
     * @param file экземпляр класса File
     * @throws IOException если файл некорректный или недоступен для чтения
     */
    public static void validateForRead(File file) throws IOException {
        throw new UnsupportedOperationException("Not implemented");
        // TODO: бросить исключение, если нет возможности чтения
    }
}
