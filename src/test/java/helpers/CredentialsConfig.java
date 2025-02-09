package helpers;

import org.aeonbits.owner.Config;

@Config.Sources({"${propertiesFile}","classpath:src/test/resources/config/credentials.properties"})
public interface CredentialsConfig extends Config {
    String login();
    String password();


}


