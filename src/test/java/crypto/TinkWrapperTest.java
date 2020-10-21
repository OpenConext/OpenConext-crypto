package crypto;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class TinkWrapperTest {

    @Test
    public void test() throws IOException, GeneralSecurityException {
        File tempFile = File.createTempFile("temp", "json");
        String absolutePath = tempFile.getAbsolutePath();
        TinkWrapper.main(new String[]{absolutePath});
        List<String> lines = Files.lines(Paths.get(absolutePath)).collect(Collectors.toList());
        assertTrue(lines.stream().anyMatch(s -> s.contains("outputPrefixType\": \"TINK\"")));
    }

}