# OpenConext-crypto

Generate TINK cryptographic key material.  

First fetch the crypto jar with all dependencies packaged inside the jar.
```
wget https://build.openconext.org/repository/public/releases/org/openconext/crypto/1.0.0/crypto-1.0.0-shaded.jar
```
Then generate the key material and output to the console:
```
java -jar crypto-1.0.0-shaded.jar
```
Or output to a file:
```
java -jar crypto-1.0.0-shaded.jar secret-keyset.json
```