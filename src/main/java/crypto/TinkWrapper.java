package crypto;

import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

public class TinkWrapper {

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        OutputStream outputStream = args != null && args.length == 1 ? new FileOutputStream(args[0]) : System.out;
        AeadConfig.register();
        KeyTemplate keyTemplate = AesCtrHmacAeadKeyManager.aes256CtrHmacSha256Template();
        KeysetHandle keysetHandle = KeysetHandle.generateNew(keyTemplate);
        CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withOutputStream(outputStream));
    }

}
