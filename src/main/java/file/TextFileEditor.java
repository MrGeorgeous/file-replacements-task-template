package file;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextFileEditor {

    /**
     * Размер буфера для чтения файла в байтах
     * TODO: найти оптимальный размер для BYTE_BUFFER_SIZE
     */
    private static final int BYTE_BUFFER_SIZE = 1;

    /**
     * Считывает текст из файла.
     *
     * <br><b>Указание.</b> Использовать только {@link FileInputStream} и {@link StringCreator}
     * @param file файловый дескриптор необходимого для прочтения файла
     * @return текст, который содержится в этом файле
     * @throws IOException если возникли ошибки чтения
     */
    public static String readText(File file) throws IOException {
        StringCreator creator = new StringCreator();
        byte[] buffer = new byte[BYTE_BUFFER_SIZE];
        throw new UnsupportedOperationException("Not implemented");
        // TODO: реализовать
    }

    /**
     * Записывает текст в файл.
     *
     * <br><b>Указание.</b> Использовать только {@link FileOutputStream} и/или {@link PrintWriter}
     *
     * @param file файловый дескриптор, по которому нужно записать файл
     * @param text непосредственно текст, который нужно записать
     * @throws IOException при возникновении ошибок
     */
    public static void writeText(File file, String text) throws IOException {
        throw new UnsupportedOperationException("Not implemented");
        // TODO: реализовать
    }

    private static class StringCreator {

        /**
         * Необходимо предложить любое решение.
         * Рекомендую пользоваться {@link ByteArrayOutputStream}
         */
        private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        /**
         * Добавить считанные байты к строке.
         *
         * <p>Если количество байт в data равно length, то необходимо прибавить строку целиком.</p>
         * <p>Если количество байт в data меньше length, то необходимо прибавить строку, созданную из первых length байт массива data.</p>
         *
         * @param data   очередной массив байт строки
         * @param length количество байт этого массива, которые надо учитывать
         */
        public void add(byte[] data, int length) {
            throw new UnsupportedOperationException("Not implemented");
            // TODO: реализовать
        }

        /**
         * Получить готовую собранную строку
         */
        public String get() {
            throw new UnsupportedOperationException("Not implemented");
            // TODO: реализовать
        }
    }

}
