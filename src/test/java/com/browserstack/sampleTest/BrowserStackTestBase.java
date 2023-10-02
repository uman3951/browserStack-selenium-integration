package com.browserstack.sampleTest;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStackTestBase {
    public RemoteWebDriver webDriver;
    public RemoteWebDriver androidDriver;
    private static JSONObject config;
    private static JSONObject envs;
    private static Map<String, Object> commonCapabilities;
    private static String username;
    private static String accessKey;
    private static String server;
    private static String app;
    DesiredCapabilities capabilities;
    String [] venderAndDetails;
    //public AndroidDriver<AndroidElement> androidDriver;

    public void readConfigFile(String config_file ,String platform) throws Exception {
        if (platform.equals("BrowserStack.web")) {
            readWebConfigFile(config_file);
        } else {
            readMobileConfigFile(config_file);
            }
        }


    /**
     * This is to set up capabilities of both web and mobile
     * @param config_file
     * @param platform
     * @param environment
     * @param username
     * @param accessKey
     * @throws Exception
     */
    public void capabilitySetUp(String config_file, String platform, String environment,String username,String accessKey) throws Exception {
        venderAndDetails = platform.split(".");

        if((username == null || accessKey==null)&&venderAndDetails[0].contains("BrowserStack")){
            readCred(username,accessKey);
        }
        else {
            this.username = username;
            this.accessKey = accessKey;
        }

        readConfigFile(config_file,platform);
        capabilities = new DesiredCapabilities();

        Map<String, Object> envCapabilities = (Map<String, Object>) envs.get(environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue());
        }

        commonCapabilities = (Map<String, Object>) config.get("capabilities");
        Iterator itBs = commonCapabilities.entrySet().iterator();

        while (itBs.hasNext()) {
            Map.Entry pair = (Map.Entry) itBs.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue());
            }

        readCred(username,accessKey);

        if(venderAndDetails[1].contains("web")){
            connectWithBrowserStackWeb();
        }
        else {
            app = System.getenv("BROWSERSTACK_APP_ID");
            if(app != null && !app.isEmpty()) {
                capabilities.setCapability("app", app);
            }
            connectBrowserStackAndroid();
        }

    }


    /**
     * connect to browserstack web using username, access key and server
     * @throws MalformedURLException
     */
    public void connectWithBrowserStackWeb() throws MalformedURLException {
        webDriver = new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@"+server+"/wd/hub"), capabilities);
    }

    /**
     * connect to browserstack mobile using username, access key and server
     * @throws MalformedURLException
     */
    public void connectBrowserStackAndroid() throws MalformedURLException {
        androidDriver = new AndroidDriver(new URL("https://"+username+":"+accessKey+"@"+server+"/wd/hub"),capabilities);
    }

    public void readWebConfigFile(String config_file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        commonCapabilities = (JSONObject) config.get("capabilities");
        envs = (JSONObject) config.get("environments");

    }
    public void readMobileConfigFile(String configFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/"+configFile));
        envs = (JSONObject) config.get("environments");
    }

    public void readCred(String user , String password) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/browserStack.cred.conf.json"));
        if(user == null|| password == null ) {
            username = System.getenv("BROWSERSTACK_USERNAME");
            if (username == null) {
                username = (String) config.get("username");
            }

            accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
            if (accessKey == null) {
                accessKey = (String) config.get("access_key");
            }
            else {
                username = user;
                accessKey = password;
            }
        }
        server = (String)config.get("server");
    }


}
