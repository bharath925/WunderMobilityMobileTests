# WunderMobilityMobileTests
Appium and TestNg

This project exhibits MobileTests for FasTip android application

# Pre Requisites 

1.	Download Java and set Java_Home in environmental variables
2.	Download Android STUDIO from below link
3.	Check Android installation path in Machine
4.	Set Android_Home Environmental variables path to SDK location and include bin folder paths in PATH variable
5.	Open Android Studio and configure Virtual device/Emulator
6.	Download Node.js                                                                                                                        
7.	Set Node_Home Environmental variables path
8.	Set npm Environmental variables path
9.	Download Appium Server from Node command line
10.	Download Appium and Selenium Java client library
11.	Maven (For managing dependencies)
12.	Install Eclipse – Pull the code from the repository



# Environment on which the tests were run 
1. Device On which Tests Have Run : Pixel 2XL (Emulator)
2. API Version Used : Level 25 (As the application used was not supoorting on latest version of Android)
3. Appium Version   :1.15
4. Java :1.8


# Configuration changes required
1. MobileAutomation/resources/global.properties  -->  update the deviceName (Emulator)
2. MobileAutomation/resources/startEmulator.bat --> Update the SDK(emulator) location and (emulator -avd (DeviceName))

# Running the tests
Once all the configuration and setup is done Run the testng.xml as TestNG Suite and after the run the testNg 
report is generated in test-output open the emailable-report.html to view the results


( **Note**: Due to lack of time , the project has not been simplied too much)


