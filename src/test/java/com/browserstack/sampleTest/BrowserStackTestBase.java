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
    String [] venderInfo;
    String venderName;
    String technology;


    /**
     * Thsi is to read the capabilities
     * @param config_file - Name of the config file
     * @param platform -> venderName.technology (e.g BrowserStack.web)
     * @param environment
     * @param username
     * @param accessKey
     * @throws Exception
     */
    public void capabilitySetUp(String config_file, String platform, String environment,String username,String accessKey) throws Exception {
        venderInfo = platform.split("\\.");
        venderName = venderInfo[0];
        technology = venderInfo[1];
        readCred(username,accessKey, venderName);
        capabilities = new DesiredCapabilities();

        readConfigFile(venderName, technology,config_file);


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


        if(technology.contains("web")){
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

    public void readConfigFile(String venderName, String technology , String config_file) throws IOException, ParseException {
        String configFileName = venderName + "." + technology + "." + config_file;
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader("src/SeleniumGridTest/resources/conf/" + configFileName));
        commonCapabilities = (JSONObject) config.get("capabilities");
        envs = (JSONObject) config.get("environments");

    }
    public void readCred(String user , String password,String vender) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/"+vender+".BrowserStack.cred.conf.json"));
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
        else {
            username = user;
            accessKey = password;
        }
        server = (String)config.get("server");
    }


}
