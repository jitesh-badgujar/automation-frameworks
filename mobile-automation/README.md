# Mobile Automation using Appium, Java and Cucumber 

1. This project is based on top of AppiumTestDistribution framework which takes care of driver creation and parallel execution.
2. This project supports both Android and iOS, please check/update capabilities under /caps/capabilities.json.
3. Currently only Android is supported and .apk is kept under build folder. iOS can be supported if .app/.ipa file is provided in build folder. 
3. This project uses page object model, however currently only Android locators are provided. iOS locators can be added using ternary operator, something like. 
    
     By LoginButton = isAndroid ? By.id("login") : MobileBy.AccessibilityId("Login"); 
 4. Currently we are using NATIVE_APP context only, If require context can be switched to WEBVIEW_.
 5. Some utilities are provided under AppUtils class which takes are of platform specific locators like getByResourceId, getByText.
 6. Each page has screenElement field which uniquely identifies current page and can be validated using waitForIsShown method. This helps to make sure performing click action navigates users to correct screen. (e.g from searchResultPage to productDetailsPage). 
 
 


### Prerequisites
* Java (At-least 8) 
* Maven
* Node
* Appium 1.22 / 2.0 (More details: https://github.com/AppiumTestDistribution/appium-installer)
* Android Studio (For Android emulator)
* Xcode (For iOS)



### How to Run

To Run the test on android: 
Note- Create Android emulator and keep it open or use avd command to use it programmatically.
    
     Platform=android mvn clean -Dtest=RunCukes test
 

### Reports & logs
* Goto target folder to see cucumber html report. (results.html)
* Appium logs can be found inside appiumlogs folder
* Device logs can be found inside reports/scenario/deviceLogs folder