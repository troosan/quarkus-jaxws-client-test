# Reproduce JAXWS call failing in Quarkus native mode

## The application works fine in "jar" mode

You can try it out by running:
```
./mvnw quarkus:dev
```
You can test the app with `http://localhost:8080/vat/NL/001028418B01`, it will return
```json
{
"countryCode": "NL",
"name": "ING BANK N.V.",
"valid": true,
"vat": "001028418B01"
}
```

## Error when running in native mode

When building the app in native mode:
```
mvn clean package -Pnative
./target/code-with-quarkus-1.0.0-SNAPSHOT-runner
```

The call to the Webservice is failing with
```
Caused by: java.lang.ClassNotFoundException: com.sun.xml.internal.ws.spi.ProviderImpl
	at com.oracle.svm.core.hub.ClassForNameSupport.forName(ClassForNameSupport.java:60)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:281)
	at javax.xml.ws.spi.ServiceLoaderUtil.nullSafeLoadClass(ServiceLoaderUtil.java:90)
	at javax.xml.ws.spi.ServiceLoaderUtil.safeLoadClass(ServiceLoaderUtil.java:123)
	at javax.xml.ws.spi.ServiceLoaderUtil.newInstance(ServiceLoaderUtil.java:101)
```