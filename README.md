[![](https://jitpack.io/v/mwangox/stoja.svg)](https://jitpack.io/#mwangox/stoja)


A spring boot starter implementation for [stoja](https://github.com/mwangox/stoja) java library. A developer is required to just include this dependency
and inject `StooClient` into a spring component that wants to interact with `StooKV`.

## Installation

Minimal supported java version is 17.

`gradle jitpack`
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

```groovy
dependencies {
    implementation 'com.github.mwangox:stoja-spring-boot-starter:1.0.6'
}
```

### Example using default configurations

```java
import com.mwangox.stoja.StooClient;

@Service
public class MyService {
    
    @Autowired
    private StooClient stooClient;
    
    public void stooKvOperations(){
        //Set normal key
        stooClient.set("my-app", "prod", "database.username", "lauryn.hill");

        //Get stored value from a key
        String value = stooClient.get("my-app", "prod", "database.username");
        System.out.println(value);

        //Set secret key
        stooClient.setSecret("my-app", "prod", "database.password", "theScrore@1996");

        //Get all keys
        Map<String, String> kv = stooClient.getAllByNamespaceAndProfile("my-app", "prod");
        System.out.println(kv);

         //Delete a key
        stooClient.delete("my-app", "prod", "database.hostname");
    }
}
```

The auto configurations can be customized in properties/yml files as:
```properties
    stoja.config.default-namespace=my-app
    stoja.config.default-profile=prod
    stoja.config.endpoint=localhost:50002
    stoja.config.timeout-after-ms=4000
    stoja.config.tls.ca-cert-path=/stookv/kv_ca.pem
    stoja.config.tls.server-name-override=stookv.hostname.com
    stoja.config.tls.skip-tls-verification=false
    stoja.config.use-tls=false
```

## License

The project is licensed under [MIT license](./MIT-LICENSE).

### Contribution

Unless you explicitly state otherwise, any contribution intentionally submitted
for inclusion in `stoja` by you, shall be licensed as MIT, without any additional
terms or conditions.



