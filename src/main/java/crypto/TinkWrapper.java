package crypto;

import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadKeyTemplates;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

public class TinkWrapper {

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        OutputStream outputStream = args != null && args.length == 1 ? new FileOutputStream(args[0]) : System.out;
        AeadConfig.register();
        KeysetHandle keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_CTR_HMAC_SHA256);
        CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withOutputStream(outputStream));
    }

}
