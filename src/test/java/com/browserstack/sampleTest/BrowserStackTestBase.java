package com.browserstack.sampleTest;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserStackTestBase {
    public WebDriver webDriver;
    private static JSONObject config;
    private static JSONObject envs;
    private static Map<String, Object> commonCapabilities;
    private static String username;
    private static String accessKey;
    private static String app;
    MutableCapabilities webCapabilities;
    DesiredCapabilities mobileCapabilities;
    public AndroidDriver<AndroidElement> androidDriver;
    public void readConfigFile(String config_file ,String platform) throws Exception {
        if (platform.equals("web")) {
            readWebConfigFile(config_file);
        } else {
            readMobileConfigFile(config_file);
            }
        }

    /**
     * This is to set up the web capabilities
     * @param config_file
     * @param platform
     * @param environment
     * @throws Exception
     */
    public void webCapabilitySetUp(String config_file,String platform,String environment) throws Exception {

        readConfigFile(config_file,platform);
        webCapabilities = new MutableCapabilities();

        Map<String, Object> envCapabilities = (Map<String, Object>) envs.get(environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            webCapabilities.setCapability(pair.getKey().toString(), pair.getValue());
        }

        commonCapabilities = (Map<String, Object>) config.get("capabilities");
        Iterator itBs = commonCapabilities.entrySet().iterator();

        while (itBs.hasNext()) {
            Map.Entry pair = (Map.Entry) itBs.next();
            webCapabilities.setCapability(pair.getKey().toString(), pair.getValue());
            }
        readCred();
        connectWithBrowserStackWeb();
    }

    /**
     * This is to set up mobile capabilities
     * @param config_file
     * @param platform
     * @throws Exception
     */
    public void mobileCapabilitySetUp(String config_file,String platform) throws Exception {
        readConfigFile(config_file,platform);
        mobileCapabilities = new DesiredCapabilities();
        JSONArray envs = (JSONArray) config.get("environments");
        Map<String, String> envCapabilities = (Map<String, String>) envs.get(0);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            mobileCapabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(mobileCapabilities.getCapability(pair.getKey().toString()) == null){
                mobileCapabilities.setCapability(pair.getKey().toString(), pair.getValue());
            }
        }
        readCred();
        app = System.getenv("BROWSERSTACK_APP_ID");
        if(app != null && !app.isEmpty()) {
            mobileCapabilities.setCapability("app", app);
        }
        connectBrowserStackAndroid();
    }

    /**
     * connect to browserstack web using username, access key and server
     * @throws MalformedURLException
     */
    public void connectWithBrowserStackWeb() throws MalformedURLException {
        webDriver = new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"),webCapabilities);
    }

    /**
     * connect to browserstack mobile using username, access key and server
     * @throws MalformedURLException
     */
    public void connectBrowserStackAndroid() throws MalformedURLException {
        androidDriver = new AndroidDriver(new URL("https://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"),mobileCapabilities);
    }

    public void readWebConfigFile(String config_file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        commonCapabilities = (JSONObject) config.get("capabilities");
        //commonCapabilities = (Map<String, Object>) config.get("capabilities");
        envs = (JSONObject) config.get("environments");

        readCred();
    }
    public void readMobileConfigFile(String configFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/"+configFile));
    }

    public void readCred(){
        username = System.getenv("BROWSERSTACK_USERNAME");
        if(username == null) {
            username = (String) config.get("username");
        }

        accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(accessKey == null) {
            accessKey = (String) config.get("access_key");
        }
    }


}
