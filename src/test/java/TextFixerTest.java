import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextFixerTest {

    public static Map<String, String> tests1 = Stream.of(new String[][]{
            {"a", "aa"},
            {"b", "bb"},
            {"bbb", ""},
            {"bb", ""},
            {"lorem", "looorem"},
            {"ooor", "looorem"},
            {"oorem", "looorem"},
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    private static String getSample(String fn) {
        return new Scanner(Objects.requireNonNull(TextFixerTest.class.getResourceAsStream(fn)), StandardCharsets.UTF_8).useDelimiter("\\A").next();
    }

    private static String getSampleUrl(String fn) {
        var r = TextFixerTest.class.getResource(fn);
        try {
            assert r != null;
            return Paths.get(r.toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            throw new RuntimeException("В проекте неверно настроена папка с ресурсами.", e);
        }
    }

    @Test
    void basicIO() throws IOException {
        String f = getSample("sample.txt");

        TextFixer tf = new TextFixer(getSampleUrl("sample.txt"));
        assertEquals(tf.getText(), f);

        String outputPath = getSampleUrl("sample.txt") + "_ans";
        tf.save(outputPath);

        TextFixer tf2 = new TextFixer(outputPath);
        assertEquals(tf2.getText(), f);
    }

    @Test
    void ioMagic() throws IOException {
        String f = getSample("sample.txt");

        assertThrows(IOException.class, () -> {
            TextFixer tf = new TextFixer(getSampleUrl("sample.txt") + "ananas");
        });

        final TextFixer tf = new TextFixer(getSampleUrl("sample.txt"));
        assertEquals(tf.getText(), f);

        assertThrows(IOException.class, () -> {
            tf.save("https://www.KRAKEN.com");
        });

        String outputFile = getSampleUrl("sample.txt") + "1234";

        tf.save(outputFile);
        tf.save(outputFile);
        tf.save(outputFile);
    }

    @Test
    void replacements() throws IOException {
        String f = getSample("sample.txt");
        final TextFixer tf = new TextFixer(getSampleUrl("sample.txt"));
        assertEquals(tf.getText(), f);
        for (var findStr : tests1.keySet()) {
            var replaceStr = tests1.get(findStr);
            tf.replace(findStr, replaceStr);
            f = f.replace(findStr, replaceStr);
            assertEquals(tf.getText(), f);
        }
    }


}
