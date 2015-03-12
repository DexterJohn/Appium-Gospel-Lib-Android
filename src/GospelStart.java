import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Dictionary;
//import java.util.HashMap;
import java.util.List;
//import java.net.URL;
import java.util.Properties;
































import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.selendroid.SelendroidCapabilities;
//import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidKeys;
//import io.selendroid.exceptions.NoSuchElementException;































import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteTouchScreen;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Not used yet
//import org.openqa.selenium.WebElement;

/** GospelStart
 * Used to test Android Gospel Library
 * 
 * @author zademaxfield
 *
 */
public class GospelStart {
	//Selendroid 
	//private WebDriver driver = null;
	private Properties prop;
	//Appium
	//private AndroidDriver driver;
	AppiumSwipeableDriver driver;
	TouchActions touch;

	//Selendroid way
	/*
	@Before
	public void setup() throws Exception {
		driver = new SelendroidDriver(new SelendroidCapabilities(
				"org.lds.ldssa:3.2.3"));     
	}
	*/
	
	/** setUp() for Appium
	 * The classpathRoot will change from MAC to Windows
	 * 
	 * @throws Exception
	 */
    @Before
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        //File appDir = new File(classpathRoot, "..\\..\\..\\..\\Selenium");
        //MAC Path
        File appDir = new File(classpathRoot, "../../../Selenium");
        File app = new File(appDir, "gospel-library-release-32400-20150310-1646.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        
        // ************** Devices ***************
        
        //Samsung Galaxy Tab
        //capabilities.setCapability("deviceName","41031b0b89e93163");
        //HTC Nexus 9
        //capabilities.setCapability("deviceName","HT4ASJT02851");
        //Nexus 5
        //capabilities.setCapability("deviceName","03aadbed215c8e5f");
        // Android Emulator
        //capabilities.setCapability("deviceName","Android Emulator");
        //Samsung Galaxy Note 4 
        capabilities.setCapability("deviceName","751bc6f2");
        
        capabilities.setCapability("automationName","selendroid");
        capabilities.setCapability("newCommandTimeout","600");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "org.lds.ldssa");
        capabilities.setCapability("appActivity", "org.lds.ldssa.Main");
        //driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
        driver = new AppiumSwipeableDriver(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
        touch = new TouchActions(driver);

    }	

	
    
	@Test
	public void simpleTest() throws Exception {
		firstPages();
		//justForTesting();
		
		//ScriptuesOldTestamentTest();
		//ScriptuesNewTestamentTest();
		//ScriptuesBookOfMormon();
		//ScripturesDoctrineAndCovenants();
		//ScripturesPearlOfGreatPrice();
		//NotesSyncTest();
		//DownloadGeneralConference();
		//DownloadAllPresidents();
		//BookMarkSimpleTest();
		BookMarkUpdateTest();
		//BookMarkCustomNameTest();
		//ScreensSimpleTest();
		//HistorySimpleTest();
		//SearchSimpleTest();
		//SearchPrevNextTest();
		//RelatedContentSimpleTest();
		//FavoritesSimpleTest();
		//CustomCollectionSimpleTest();
		//CustomCollectionMultipleTest();
		//HighLightSimpleTest();
		//NotesSearchTest();
		//RemoveAllRemoveSingleTest();
		//CreateHighlightSimpleTest();
		//CreateHighlightAllColors();
		
		
		//Bug in selendroid - test should pass but it needs work
		//SearchAutoFillAndHistoryTest();
		
	}
	

	public void justForTesting() throws Exception {
		Thread.sleep(1000);
		goToChapter("OldTestament", "Genesis", "Chapter9");
		Thread.sleep(1000);

	}
		
	
	/*
	
    @Rule
    public Retry retry = new Retry(3);
	
	@Test
	public void OldTestamentTest() throws Exception {
		firstPages();
		ScriptuesOldTestamentTest();	
	}
	
	@Test
	public void NewTestamentTest() throws Exception {
		firstPages();
		ScriptuesNewTestamentTest();
	}
	
	@Test
	public void BookOfMormonTest() throws Exception {
		firstPages();
		ScriptuesBookOfMormon();
	}
	
	@Test
	public void DoctrineAndCovenantsTest() throws Exception {
		firstPages();
		ScripturesDoctrineAndCovenants();
	}

	@Test
	public void PearlOGreatTest() throws Exception {
		firstPages();
		ScripturesPearlOfGreatPrice();
	}
	
	@Test
	public void NotesTest() throws Exception {
		firstPages();
		NotesSyncTest();
	}
	
	@Test
	public void GeneralConfDownload() throws Exception {
		firstPages();
		DownloadGeneralConference();
	}
	
	@Test
	public void DownloadAllUnderPresidents() throws Exception {
		firstPages();
		DownloadAllPresidents();
	}
	
	@Test
	public void BookMarkSimple() throws Exception {
		firstPages();
		BookMarkSimpleTest();
	}
	
	@Test
	public void BookMarkUpdate() throws Exception {
		firstPages();
		BookMarkUpdateTest();
	}
	
	@Test
	public void BookMarkCustom() throws Exception {
		firstPages();
		BookMarkCustomNameTest();
	}
	
	@Test
	public void ScreensTest() throws Exception {
		firstPages();
		ScreensSimpleTest();
	}
	
	@Test
	public void HistoryTest() throws Exception {
		firstPages();
		HistorySimpleTest();
	}
	
	@Test
	public void SearchTest() throws Exception {
		firstPages();
		SearchSimpleTest();
	}
	
	@Test
	public void ReleatedContentTest() throws Exception {
		firstPages();
		RelatedContentSimpleTest();
	}
	
	@Test
	public void FavoritesTest() throws Exception {
		firstPages();
		FavoritesSimpleTest();
	}
	
	@Test
	public void CustomCollectionsTest() throws Exception {
		firstPages();
		CustomCollectionSimpleTest();
	}
	
	@Test
	public void CustomCollectionsMultipleTest() throws Exception {
		firstPages();
		CustomCollectionMultipleTest();
	}
	
	@Test
	public void HighLightTest() throws Exception {
		firstPages();
		HighLightSimpleTest();
	}
	
	@Test
	public void NotesSearch() throws Exception {
		firstPages();
		NotesSearchTest();
	}
	
	@Test
	public void RemoveAllRemoveSingle() throws Exception {
		firstPages();
		RemoveAllRemoveSingleTest();
	}
	
	@Test
	public void SearchPrevNext() throws Exception {
		firstPages();
		SearchPrevNextTest();
	}
	
	@Test
	public void CreateHighlightSimple() throws Exception {
		firstPages();
		CreateHighlightSimpleTest();
	}
	
	@Test
	public void HighlightAllColors() throws Exception {
		firstPages();
		CreateHighlightAllColors();
	}
	
	*/
	
//**************************************************************
//**************** Start of tests ******************************
//**************************************************************
	
	/** firstPages()
	 * When the app is first installed there are 3 pages 
	 * We set the app to use Any Network 
	 * 
	 * @throws Exception
	 */
	public void firstPages() throws Exception {
		int myCheck;
		Thread.sleep(7000);

		//First Page
		checkTextByXpath("StartPageMiddleTitle", "New in version 3.2.4");
		checkTextByID("StartPageText", "Fixed various bugs and stability issues");
		clickButtonByID("BottomButton");
		Thread.sleep(4000);
		
		//    ****** The second page is not displayed on tablet *****
		myCheck = checkTextByXpathReturn("StartPageMiddleTitle", "Network Preferences");
		if (myCheck == 1) {
			checkTextByXpath("StartPageMiddleTitle", "Network Preferences");
			checkTextByID("SelectionMessage", 
					"Please update your network preferences for downloading content (including updates and subscriptions).");
			//Select one of the radio buttons
			clickButtonByID("RadioAnyNetwork");
			//clickButtonByID("RadioPrompt");
			//clickButtonByID("RadioWifiOnly");
			clickButtonByID("BottomButton");
			Thread.sleep(1000);
		}

		
		//Third Page
		checkTextByXpath("StartPageMiddleTitle", "Setup Annotation Sync");
		checkTextByID("SetupMessage", 
				"Gospel Library includes the ability to backup and sync your annotations using your LDS Account."
				+ " Would you like to setup annotation sync now?");
		clickButtonByID("BottomButton");
		Thread.sleep(5000);
	}

	/** ScriptuesOldTestamentTest()
	 * This will verify some of the scriptures in the Old Testament - Genesis
	 * 
	 * @throws Exception
	 */
	public void ScriptuesOldTestamentTest() throws Exception {
		goToChapter("OldTestament", "Genesis", "Chapter1");
		checkScriptureText("1", "1 In the abeginning bGod ccreated the dheaven and the eearth", "WEBVIEW_2" );
		
		//Swipe to chapter 2
		flickRightToLeft();
		Thread.sleep(3000);
		checkScriptureText("1", "1 Thus the heavens and the aearth", "WEBVIEW_1" );
		
		//Swipe to chapter 5
		for (int x = 1 ; x < 4 ; x++ ) {
			flickRightToLeft();
			Thread.sleep(3000);
		}
		//Should be on chapter 5
		checkScriptureText("1", "1 This is the abook of the bgenerations", "WEBVIEW_1" );
		checkScriptureText("32", "32 And Noah was five hundred years old:", "WEBVIEW_1" );
	
		//Swipe back to chapter 4
		flickLeftToRight();
		Thread.sleep(3000);
		checkScriptureText("1", "1 And Adam knew Eve his wife; and she conceived, and bare aCain", "WEBVIEW_2" );
		
		//Go back to the home page
		clickButtonByID("Home");
		
	}
	
	/** ScriptuesNewTestamentTest()
 	 * Tests scriptures in the New Testament
 	 * 
	 * @throws Exception
	 */
	public void ScriptuesNewTestamentTest() throws Exception {
		goToChapter("NewTestament", "Luke", "Chapter1");
		checkScriptureText("1", "1 aForasmuch as bmany have taken in hand to set", "WEBVIEW_2" );
		
		flickRightToLeft();
		Thread.sleep(3000);
		checkScriptureText("1", "1 And it came to pass in those days, that there", "WEBVIEW_1" );
		
		for (int x = 1 ; x < 4 ; x++ ) {
			flickRightToLeft();
			Thread.sleep(3000);
		}
		//Should be on chapter 5
		checkScriptureText("1", "1 And it came to pass, that, as the people pressed upon him", "WEBVIEW_1" );
		checkScriptureText("39", "39 No man also having drunk old wine", "WEBVIEW_1" );

		//Go back to the home page
		clickButtonByID("Home");

	}
	
	/** ScriptuesBookOfMormon()
	 * Check some scriptures in the Book Of Mormon - 1 Nephi
	 * 
	 * @throws Exception
	 */
	public void ScriptuesBookOfMormon() throws Exception {
		goToChapter("BookOfMormon", "1Nephi", "Chapter3");
		checkScriptureText("7", "I awill go and do the things which the Lord hath commanded", "WEBVIEW_2" );

		//Go back to the home page
		clickButtonByID("Home");
	}
	
	/** ScripturesDoctrineAndCovenants()
	 * Check some scriptures in the D & C Chapter 4
	 * 
	 * @throws Exception
	 */
	public void ScripturesDoctrineAndCovenants() throws Exception {
		goToChapter("DoctrineAndCovenants", "none", "Chapter4");
		checkScriptureText("1", "1 Now behold, a amarvelous work is about to come forth among the children of men.", "WEBVIEW_2" );

		//Go back to the home page
		clickButtonByID("Home");
	
	}
	
	/** ScripturesPearlOfGreatPrice()
	 * Check some scriptures in the Pearl Of Great Price - Moses Chapter 1
	 * 
	 * @throws Exception
	 */
	public void ScripturesPearlOfGreatPrice() throws Exception {
		goToChapter("PearlOfGreatPrice", "Moses", "Chapter1");
		checkScriptureText("1", "1 The words of God, which he aspake unto Moses at a time when Moses was", "WEBVIEW_2" );

		//Go back to the home page
		clickButtonByID("Home");	
	}
	
	/** NotesSyncTest()
	 * Check that notes are displayed on device after login
	 * 
	 * @throws Exception
	 */
	public void NotesSyncTest() throws Exception {
		//Go to the Notes page
		clickButtonByXpath("Notes");
		Thread.sleep(2000);
		
		//Make sure there are no notes
		clickButtonByXpath("All");
		Thread.sleep(2000);
		checkNoNotesByID();
		clickSpinnerItem("NotesSpinner");
		Thread.sleep(1000);
		clickButtonByXpath("Journal");
		Thread.sleep(2000);
		checkNoNotesByID();
		clickSpinnerItem("NotesSpinner");
		Thread.sleep(1000);
		clickButtonByXpath("Tags");
		Thread.sleep(2000);
		checkNoNotesByID();
		clickSpinnerItem("NotesSpinner");
		Thread.sleep(1000);
		clickButtonByXpath("Notebooks");
		Thread.sleep(2000);
		checkNoNotesByID();

		//Sign in 
		pressMenuKey();
		clickButtonByXpath("Settings");
		Thread.sleep(1000);
		clickButtonByXpath("SignIn");
		Thread.sleep(1000);
		sendTextbyID("Username", "zautomobile1");
		sendTextbyID("Password", "ldsM0b1l3");
		clickButtonByID("SignInButton");
		Thread.sleep(4000);
		//ToDo need a check to see if the login was successful. 
		
		clickButtonByID("OKButton");
		Thread.sleep(2000);
		
		checkTextViewByXpath("zautomobile1");
		Thread.sleep(2000);
		
		//Go back to the home page
		clickButtonByID("Home");
		
		Thread.sleep(2000);
		clickButtonByXpath("Notes");
		//Need a better way to do this, the sleep is waiting for the download to complete. 
		Thread.sleep(2000);
		
		clickButtonByXpath("All");
		Thread.sleep(2000);
		checkNotesByID("MarkedSource", "Alma 1:1");
		checkNotesByID("MarkedSource", "Moses 6:6");
		checkNotesByID("MarkedTitle", "Entry 1");
		checkNotesByID("MarkedText", "Journal Entry number 1");
		checkNotesByID("MarkedTitle", "My Tag Test");
		checkNotesByID("MarkedText", "Goat Tag test");
		checkNotesByID("MarkedSource", "- Dec 18, 2014");
		
		
		clickSpinnerItem("NotesSpinner");
		Thread.sleep(1000);
		
		//Check Notes > Journal
		clickButtonByXpath("Journal");
		Thread.sleep(2000);
		checkNotesByID("MarkedTitle", "My Tag Test");
		checkNotesByID("MarkedText", "Goat Tag test");
		checkNotesByID("MarkedSource", "- Dec 18, 2014");
		checkNotesByID("MarkedTitle", "Entry 1");
		checkNotesByID("MarkedText", "Journal Entry number 1");
		
		clickSpinnerItem("NotesSpinner");
		Thread.sleep(1000);
		
		//Check Notes > Tags
		clickButtonByXpath("Tags");
		Thread.sleep(2000);
		checkNotesByID("TagTitle", "goattag");
		checkNotesByID("TagPreview", "My Tag Test Goat Tag test - Dec 18, 2014 goattag");
		
		clickSpinnerItem("NotesSpinner");
		Thread.sleep(1000);
		
		//Check Notes > Notebooks
		clickButtonByXpath("Notebooks");
		Thread.sleep(2000);
		checkNoNotesByID();
	}
	
	/** DownloadGeneralConference()
	 * Download and check some General Conference issues
	 * 
	 * @throws Exception
	 */
	public void DownloadGeneralConference() throws Exception {
		clickButtonByXpath("GeneralConference");
		Thread.sleep(6000);
		clickButtonByXpathDownload("October2013");
		Thread.sleep(1000);
		clickButtonByXpathTitleName("Welcome to Conference");
		Thread.sleep(1000);
		checkMagazineText("head1", "Welcome to Conference", "WEBVIEW_1" );
		checkMagazineText("p4", "How good it is, my beloved brothers and sisters", "WEBVIEW_1" );
		Thread.sleep(1000);
		pressBackKey();
		clickButtonByXpathTitleName("Like a Broken Vessel");
		Thread.sleep(1000);
		checkMagazineText("head1", "Like a Broken Vessel", "WEBVIEW_2" );
		checkMagazineText("p5", "The Apostle Peter wrote that disciples of Jesus Christ", "WEBVIEW_2" );
		Thread.sleep(1000);
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);
	}
	
	/** DownloadAllPresidents()
	 * Download and check all items under the Children category
	 * 
	 * @throws Exception
	 */
	public void DownloadAllPresidents() throws Exception {
		longPressByXpath("TeachingsOfPresidents");
		Thread.sleep(1000);
		checkTextByID("AlertTitle", "Teachings of Presidents");
		clickButtonByXpath("DownloadAll");
		Thread.sleep(1000);
		checkTextByID("AlertTitle", "Download All");
		clickButtonByID("DownloadAllButton");
		Thread.sleep(1000);
		clickButtonByXpath("TeachingsOfPresidents");
		Thread.sleep(20000);		
		clickButtonByXpathTitleName("Ezra Taft Benson");
		//clickButtonByXpathTitleNameNoDownload("Old Testament Stories");
		
		//Put in a download check?
		
		Thread.sleep(2000);
		clickButtonByXpathTitleNameNoDownload("Chapter 2: Pray Always");
		Thread.sleep(3000);
		checkMagazineText("head1", "CHAPTER 2", "WEBVIEW_2" );
		checkMagazineText("p2", "Pray Always", "WEBVIEW_2" );
		checkMagazineText("p5", "All through my life the counsel to depend on prayer has been", "WEBVIEW_2" );
		Thread.sleep(2000);
		pressBackKey();
		Thread.sleep(2000);
		pressBackKey();
		Thread.sleep(5000);
		clickButtonByXpathTitleName("Wilford Woodruff");
		Thread.sleep(2000);
		clickButtonByXpathTitleNameNoDownload("Chapter 9: Proclaiming the Gospel");
		Thread.sleep(2000);
		checkMagazineText("head1", "CHAPTER 9", "WEBVIEW_2" );

		Thread.sleep(2000);
		clickSpinnerItem("TeachingsOfPresidentsSpinner");
		Thread.sleep(1000);
		clickButtonByXpathTitleName("Heber J. Grant");
		Thread.sleep(2000);
		clickButtonByXpathTitleNameNoDownload("Chapter 4: Persistence");
		Thread.sleep(4000);
		checkMagazineText("head1", "CHAPTER 4", "WEBVIEW_2" );
		clickSpinnerItem("TeachingsOfPresidentsSpinner");
		Thread.sleep(1000);
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);
	}
	
	
	/** BookMarkSimpleTest()
	 * A simple bookmark test
	 * 
	 * @throws Exception
	 */
	public void BookMarkSimpleTest() throws Exception {
		//Open Scripts to Old Testament > Job Chapter 1
		goToChapter("OldTestament", "Job", "Chapter1");

		//Add a Bookmark
		clickButtonByID("menuBookmark");
		clickButtonByXpath("AddBookmarkMenu");
		checkTextByID("BookMarkName", "Job 1");
		clickButtonByID("BookMarkOK");
		
		clearAnnotationMessage();

		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);

		//Go to the Bookmark and check to see if we are in the right place
		clickButtonByID("menuBookmark");
		clickButtonByXpathTitleNameNoDownload("Job 1");
		Thread.sleep(1000);
		checkScriptureText("1", "1 There was a man in the land of aUz, whose name was bJob;", "WEBVIEW_2" );

		//Delete the Bookmark
		clickButtonByID("menuBookmark");
		clickButtonByXpathMenuInfoButton("Job 1");
		clickButtonByXpathMenuBookMarkTitleReference("Delete" , "Job 1");

		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);	
		
		//Make sure the Bookmark is deleted
		clickButtonByID("menuBookmark");
		checkNoElementXpathName("Job 1");
		pressBackKey();
		
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);	
	}
	
	/** BookMarkUpdateTest()
	 * Add a bookmark then update the bookmark
	 * 
	 * @throws Exception
	 */
	public void BookMarkUpdateTest() throws Exception {
		//Open Scripts to Book Of Mormon > Alma Chapter 2
		goToChapter("BookOfMormon", "Alma", "Chapter2");
		
		//Add a Bookmark
		clickButtonByID("menuBookmark");
		clickButtonByXpath("AddBookmarkMenu");
		checkTextByID("BookMarkName", "Alma 2");
		clickButtonByID("BookMarkOK");

		clearAnnotationMessage();

		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);
		
		//Go to the Bookmark and check to see if we are in the right place
		clickButtonByID("menuBookmark");
		clickButtonByXpathTitleNameNoDownload("Alma 2");
		Thread.sleep(1000);
		checkScriptureText("1", "1 And it came to pass in the commencement of the fifth year", "WEBVIEW_2" );

		//Swipe 2 times to go to chapter 4
		flickRightToLeft();
		Thread.sleep(3000);
		flickRightToLeft();
		Thread.sleep(3000);
		checkScriptureText("1", "1 Now it came to pass in the sixth year of the reign", "WEBVIEW_1" );
		
		//Update the Bookmark
		clickButtonByID("menuBookmark");
		clickButtonByXpathMenuInfoButton("Alma 2");
		clickButtonByXpathMenuBookMarkTitleReference("Update" , "Alma 2");

		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);
		
		//Go to the Bookmark and check to see if we are in the right place
		clickButtonByID("menuBookmark");
		clickButtonByXpathTitleNameNoDownload("Alma 4");
		Thread.sleep(1000);
		checkScriptureText("1", "1 Now it came to pass in the sixth year of the reign", "WEBVIEW_2" );
		
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);	
		
		//Delete the Bookmark
		clickButtonByID("menuBookmark");
		clickButtonByXpathMenuInfoButton("Alma 4");
		clickButtonByXpathMenuBookMarkTitleReference("Delete" , "Alma 4");
		

		//Make sure the Bookmark is deleted
		clickButtonByID("menuBookmark");
		checkNoElementXpathName("Alma 4");
		pressBackKey();
		
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);	
		
	}
	
	/** BookMarkCustomNameTest()
	 * Add a Bookmark with a custom name
	 * 
	 * @throws Exception
	 */
	public void BookMarkCustomNameTest() throws Exception {
		goToChapter("NewTestament", "Matthew", "Chapter4");
		
		//Add a Bookmark
		clickButtonByID("menuBookmark");
		clickButtonByXpath("AddBookmarkMenu");
		checkTextByID("BookMarkName", "Matthew 4");
		clearTextFieldID("BookMarkName");
		sendTextbyID("BookMarkName", "My Bookmark");
		clickButtonByID("BookMarkOK");
		
		clearAnnotationMessage();

		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);
		
		//Go to the Bookmark and check to see if we are in the right place
		clickButtonByID("menuBookmark");
		checkBookMarkSubtitle("Matthew 4");
		clickButtonByXpathTitleNameNoDownload("My Bookmark");
		Thread.sleep(1000);
		checkScriptureText("1", "1 Then was Jesus aled up of the Spirit into the wilderness", "WEBVIEW_2" );

		//Swipe 2 times to go to chapter 6
		flickRightToLeft();
		Thread.sleep(3000);
		flickRightToLeft();
		Thread.sleep(3000);
		checkScriptureText("1", "1 aTake heed that ye do not your balms before men", "WEBVIEW_1" );
		
		//Update the Bookmark
		clickButtonByID("menuBookmark");
		clickButtonByXpathMenuInfoButton("My Bookmark");
		clickButtonByXpathMenuBookMarkTitleReference("Update" , "My Bookmark");

		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);
		
		//Go to the Bookmark and check to see if we are in the right place
		clickButtonByID("menuBookmark");
		checkBookMarkSubtitle("Matthew 6");
		clickButtonByXpathTitleNameNoDownload("My Bookmark");
		Thread.sleep(1000);
		checkScriptureText("1", "1 aTake heed that ye do not your balms before men", "WEBVIEW_2" );
		
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);	
		
		//Delete the Bookmark
		clickButtonByID("menuBookmark");
		clickButtonByXpathMenuInfoButton("My Bookmark");
		clickButtonByXpathMenuBookMarkTitleReference("Delete" , "My Bookmark");
		

		//Make sure the Bookmark is deleted
		clickButtonByID("menuBookmark");
		checkNoElementXpathName("My Bookmark");
		pressBackKey();
		
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);	
	}
	
	/** HistorySimpleTest()
	 * Test the History feature
	 * 
	 * @throws Exception
	 */
	public void HistorySimpleTest() throws Exception {
		goToChapter("NewTestament", "Romans", "Chapter10");
		
		//Go back to the home page
		clickButtonByID("Home");
		
		goToChapter("BookOfMormon", "Helaman", "Chapter7");
		
		//Go back to the home page
		clickButtonByID("Home");
		
		Thread.sleep(1000);
		clickButtonByXpath("TeachingsOfPresidents"); 
		Thread.sleep(2000);
		clickButtonByXpathTitleNameNoDownload("Joseph Fielding Smith");
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Chapter 13: Baptism");
		
		Thread.sleep(1000);
		
		clickButtonByID("menuBookmark");
		clickButtonByXpath("HistoryMenu");
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		checkTextViewByXpath("Romans 10");
		checkTextViewByXpath("Helaman 7");
		checkTextViewByXpath("Chapter 13: Baptism, Joseph Fielding Smith");
		

		
		//Go to each history item and make sure we are in the correct place 
		clickButtonByXpathTitleNameNoDownload("Romans 10");
		Thread.sleep(1000);
		//checkScriptureText("1", "1 Brethren, my heart�s desire and prayer to God for Israel is", "WEBVIEW_2" );
		checkScriptureText("1", "desire and prayer to God for Israel is", "WEBVIEW_2" );
		
		clickButtonByID("menuBookmark");
		clickButtonByXpath("HistoryMenu");
		Thread.sleep(1000);

		clickButtonByXpathTitleNameNoDownload("Helaman 7");
		Thread.sleep(1000);
		checkScriptureText("1", "1 Behold, now it came to pass in the sixty and ninth year of the", "WEBVIEW_2" );
		
		clickButtonByID("menuBookmark");
		clickButtonByXpath("HistoryMenu");
		Thread.sleep(1000);
		
		clickButtonByXpathTitleNameNoDownload("Chapter 13: Baptism, Joseph Fielding Smith");
		Thread.sleep(3000);
		checkMagazineText("head1", "Baptism", "WEBVIEW_2" );
		
		Thread.sleep(1000);
		//Go back to the home page
		clickButtonByID("Home");
	}
	
	/** ScreensSimpleTest()
	 * Simple test for the Screens
	 * 
	 * @throws Exception
	 */
	public void ScreensSimpleTest() throws Exception {
		goToChapter("NewTestament", "Romans", "Chapter10");
		
		//Open Screens menu
		//Clear the alert
		clickButtonByID("menuNewScreen");
		Thread.sleep(1000);
		checkTextByID("ScreensAlertTitle", "Tip");
		clickButtonByID("ScreensOK");
		Thread.sleep(2000);
		
		//Check that the scripture was added to the screens
		checkTextViewByXpath("Romans 10:1");
		
		//Open a new screen
		clickButtonByID("ScreensNew");
		Thread.sleep(1000);
		checkTextByID("ActionBarTitle", "Library");
		Thread.sleep(1000);

		goToChapter("BookOfMormon", "Helaman", "Chapter7");
		
		//Add this scripture to the screens
		clickButtonByID("menuNewScreen");
		Thread.sleep(1000);
		checkTextViewByXpath("Romans 10:1");
		checkTextViewByXpath("Helaman 7:1");
		
		//Go to each screen and make sure we are in the correct place 
		clickButtonByXpathTitleNameNoDownload("Romans 10:1");
		Thread.sleep(1000);
		//checkScriptureText("1", "1 Brethren, my heart's desire and prayer to God for Israel is", "WEBVIEW_2" );
		checkScriptureText("1", "desire and prayer to God for Israel is", "WEBVIEW_2" );
		
		clickButtonByID("menuNewScreen");
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Helaman 7:1");
		Thread.sleep(1000);
		checkScriptureText("1", "1 Behold, now it came to pass in the sixty and ninth year of the", "WEBVIEW_2" );
		
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);
	}
	
	/** SearchSimpleTest()
	 * Simple Search Test
	 * 
	 * @throws Exception
	 */
	public void SearchSimpleTest() throws Exception {
		goToChapter("BookOfMormon", "Mosiah", "Chapter7");
		
		clickButtonByID("menuSearch");
		//"Find on page" "Search Book of Mormon" "Search Scriptures" "Search Library"
		clickButtonByXpathTitleNameNoDownload("Find on page");
		Thread.sleep(1000);
		sendTextbyID("FOPSearchText", "king");
		Thread.sleep(1000);
		checkTextByID("SearchFOPCount", "1 of 18");
		Thread.sleep(1000);
		clickButtonByID("SearchDone");
		Thread.sleep(1000);
		
		clickButtonByID("menuSearch");
		//"Find on page" "Search Book of Mormon" "Search Scriptures" "Search Library"
		clickButtonByXpathTitleNameNoDownload("Search Book of Mormon");
		Thread.sleep(1000);
		sendTextbyID("SearchText", "goat");
		clickButtonByID("SearchGoButton");
		Thread.sleep(2000);
		checkSearchText("and the ass and the horse, and the goat and the wild goat,");
		Thread.sleep(1000);
		
		pressBackKey();
		Thread.sleep(1000);
		
		clickButtonByID("menuSearch");
		//"Find on page" "Search Book of Mormon" "Search Scriptures" "Search Library"
		clickButtonByXpathTitleNameNoDownload("Search Scriptures");
		Thread.sleep(1000);
		clearTextFieldID("SearchText");
		sendTextbyID("SearchText", "it came to pass");
		clickButtonByID("SearchGoButton");
		Thread.sleep(5000);
		checkSearchText("Old Testament");
		checkSearchText2("226 results");
		checkSearchText("New Testament");
		checkSearchText2("37 results");
		checkSearchText("Book of Mormon");
		checkSearchText2("170 results");
		checkSearchText("Doctrine and Covenants");
		checkSearchText2("3 results");
		checkSearchText("Pearl of Great Price");
		checkSearchText2("9 results");
		checkSearchText("Topical Guide");
		checkSearchText2("2 results");
		checkSearchText("Joseph Smith Translation");
		checkSearchText2("5 results");
		checkSearchText("index to the triple combination");
		checkSearchText2("1 result");
		Thread.sleep(1000);
		
		pressBackKey();
		Thread.sleep(1000);
		
		clickButtonByID("menuSearch");
		//"Find on page" "Search Book of Mormon" "Search Scriptures" "Search Library"
		clickButtonByXpathTitleNameNoDownload("Search Library");
		Thread.sleep(1000);
		clearTextFieldID("SearchText");
		sendTextbyID("SearchText", "lion");
		clickButtonByID("SearchGoButton");
		Thread.sleep(1000);
		checkSearchText("Scriptures");
		checkSearchText2("153 results");
		checkSearchText("Family");
		checkSearchText2("2 results");
		Thread.sleep(1000);
		
		//Go back to the home page
		clickButtonByID("Home");
	}
	
	/** RelatedContentSimpleTest()
	 * Check that the related content is correct
	 * 
	 * @throws Exception
	 */
	public void RelatedContentSimpleTest() throws Exception {
		//Open a scripture to check the releated content
		goToChapter("NewTestament", "Galatians", "Chapter1");
		
		//Check the related content
		clickButtonByID("menuReleated");
		checkRelatedContentText("1a apostle");
		checkRelatedContentText("4a gave");
		clickRelatedContentText("1a apostle");
		Thread.sleep(2000);
		checkScriptureText("t1", "PRIESTHOOD, AUTHORITY", "WEBVIEW_2" );
		pressBackKey();
		Thread.sleep(2000);
		clickRelatedContentText("4a gave");
		Thread.sleep(2000);
		checkScriptureText("t1", "JESUS CHRIST, REDEEMER", "WEBVIEW_2" );
		Thread.sleep(2000);
		pressBackKey();
		Thread.sleep(2000);
		clickButtonByID("menuReleated");
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(1000);
	}
	
	/** FavoritesSimpleTest()
	 * Simple Favorites test
	 * 
	 * @throws Exception
	 */
	public void FavoritesSimpleTest() throws Exception {
		Thread.sleep(1000);
		clickButtonByXpath("Favorites"); 
		Thread.sleep(4000);
		checkTextByXpath("GospelArtBook", "Gospel Art Book");
		checkTextByXpath("BookOfMormon", "Book of Mormon");
		checkTextByXpath("April2014", "April 2014");
		checkTextByXpath("JosephFieldingSmith", "Joseph Fielding Smith");
		checkTextByXpath("PreachMyGospel", "Preach My Gospel: A Guide to Missionary Service");
		checkTextByXpath("MormonMessages", "Mormon Messages");
		checkTextByXpath("BibleVideosLifeofChrist", "Bible Videos: The Life of Jesus Christ");
		
		clickButtonByXpath("GospelArtBook");
		Thread.sleep(1000);
		checkTextViewByXpath("Gospel Art Book");
		checkTextViewByXpath("Old Testament");
		checkTextViewByXpath("New Testament");
		checkTextViewByXpath("Book of Mormon");
		checkTextViewByXpath("Church History");
		checkTextViewByXpath("Gospel in Action");
		checkTextViewByXpath("Latter-day Prophets");
		
		pressBackKey();
		Thread.sleep(1000);
		
		clickButtonByXpath("BookOfMormon");
		Thread.sleep(1000);
		//checkTextViewByXpath("Introduction and Witnesses");
		checkTextViewByXpath("Jacob");
		checkTextViewByXpath("Enos");
		checkTextViewByXpath("Jarom");
		checkTextViewByXpath("Omni");
		
		pressBackKey();
		Thread.sleep(1000);
		
		clickButtonByXpath("April2014");
		Thread.sleep(1000);
		checkTextViewByXpath("Welcome to Conference");
		//checkTextViewByXpath("The Cost�and Blessings�of Discipleship");
		//checkTextViewByXpath("The Joyful Burden of Discipleship");
		
		checkTextViewByXpath("The Joyful Burden of Discipleship");
		checkTextViewByXpath("Christ the Redeemer");
		checkTextViewByXpath("Spiritual Whirlwinds");
		
		pressBackKey();
		Thread.sleep(1000);
		
		clickButtonByXpath("JosephFieldingSmith");
		Thread.sleep(1000);
		checkTextViewByXpath("Title Page");
		checkTextViewByXpath("Introduction");
		checkTextViewByXpath("Historical Summary");
		checkTextViewByXpath("The Life and Ministry of Joseph Fielding Smith");
		checkTextViewByXpath("Chapter 1: Our Father in Heaven");
		
		pressBackKey();
		Thread.sleep(1000);
		
		clickButtonByXpath("PreachMyGospel");
		Thread.sleep(1000);
		checkTextViewByXpath("Title Page");
		checkTextViewByXpath("3: What Do I Study and Teach?");
		checkTextViewByXpath("Lesson 2: The Plan of Salvation");
		checkTextViewByXpath("Lesson 3: The Gospel of Jesus Christ");
		checkTextViewByXpath("Lesson 4: The Commandments");
		
		pressBackKey();
		Thread.sleep(1000);
		
		clickButtonByXpath("MormonMessages");
		Thread.sleep(1000);
		checkTextViewByXpath("You Never Know");
		checkTextViewByXpath("The Hope of God's Light");
		checkTextViewByXpath("The Savior Wants to Forgive");
		checkTextViewByXpath("True Christianity");
		checkTextViewByXpath("Abide with Me");
		
		pressBackKey();
		Thread.sleep(1000);
		
		clickButtonByXpath("BibleVideosLifeofChrist");
		Thread.sleep(1000);
		checkTextViewByXpath("The Feeding of the 5,000");
		checkTextViewByXpath("Wherefore Didst Thou Doubt?");
		checkTextViewByXpath("Christ's Authority is Questioned");
		checkTextViewByXpath("Widow Of Nain");
		checkTextViewByXpath("I Have Kept the Faith");
		
		//Go back to the home page
		clickButtonByID("Home");
	}
	
	/** CustomCollectionSimpleTest()
	 * Simple Custom Collection Test
	 * 
	 * @throws Exception
	 */
	public void CustomCollectionSimpleTest() throws Exception {
		//Add a custom collection
		pressMenuKey();
		clickButtonByXpath("CustomCollections");
		Thread.sleep(1000);
		clickButtonByID("NewCollection");
		sendTextbyID("CollectionName", "MyCollection");
		clickButtonByID("CollectionOK");
		
		//Add items to the custom collection
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Scriptures");
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Old Testament");
		clickButtonByXpathTitleNameNoDownload("New Testament");
		clickButtonByXpathTitleNameNoDownload("Pearl of Great Price");
		scrollDown("Pearl of Great Price");
		clickButtonByXpathTitleNameNoDownload("Bible Photographs");
		clickButtonByID("DoneCollection");
		Thread.sleep(1000);
		checkTextViewByXpath("Old Testament");
		checkTextViewByXpath("New Testament");
		checkTextViewByXpath("Pearl of Great Price");
		checkTextViewByXpath("Bible Photographs");
		clickButtonByID("DoneCollection");
		clickButtonByID("DoneCollection");
		Thread.sleep(1000);
		
		//Check to see if the items are in the custom collection
		clickButtonByXpathTitleNameNoDownload("MyCollection");
		checkTextViewByXpath("Old Testament");
		checkTextViewByXpath("New Testament");
		checkTextViewByXpath("Pearl of Great Price");
		checkTextViewByXpath("Bible Photographs");
		Thread.sleep(1000);
		
		//Edit the Collection
		pressMenuKey();
		Thread.sleep(1000);
		clickButtonByXpath("EditCollection");
		//Remove Item
		clickButtonByXpathTitleNameNoDownload("New Testament");
		clickButtonByID("DoneCollection");
		Thread.sleep(3000);
		checkNoElementXpathName("New Testament");
		checkTextViewByXpath("Old Testament");
		checkTextViewByXpath("Pearl of Great Price");
		checkTextViewByXpath("Bible Photographs");
		
		//Edit Add an item
		pressMenuKey();
		Thread.sleep(1000);
		clickButtonByXpath("EditCollection");
		clickButtonByID("AddCollection");
		clickButtonByXpathTitleNameNoDownload("Liahona");
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("December 2014");
		clickButtonByID("DoneCollection");
		clickButtonByID("DoneCollection");
		Thread.sleep(1000);
		checkTextViewByXpath("Old Testament");
		checkTextViewByXpath("Pearl of Great Price");
		checkTextViewByXpath("Bible Photographs");
		checkTextViewByXpath("December 2014");
		
		//Delete the Collection
		pressMenuKey();
		Thread.sleep(1000);
		clickButtonByXpath("DeleteCollection");
		Thread.sleep(1000);
		//checkContainsTextByID("CollectionAlertTitle", "Delete �MyCollection�?");
		checkContainsTextByID("CollectionAlertTitle", "MyCollection");
		clickButtonByID("CollectionNo");
		Thread.sleep(1000);
		pressMenuKey();
		clickButtonByXpath("DeleteCollection");
		Thread.sleep(1000);
		//checkContainsTextByID("CollectionAlertTitle", "Delete �MyCollection�?");
		checkContainsTextByID("CollectionAlertTitle", "MyCollection");
		clickButtonByID("CollectionYes");
		Thread.sleep(1000);
		checkNoElementXpathName("MyCollection");
	}
	
	/** CustomCollectionMultipleTest()
	 * Create multiple custom collections
	 * 
	 * @throws Exception
	 */
	public void CustomCollectionMultipleTest() throws Exception {
		//**********************
		//1st custom collection
		//**********************
		pressMenuKey();
		clickButtonByXpath("CustomCollections");
		Thread.sleep(1000);
		clickButtonByID("NewCollection");
		sendTextbyID("CollectionName", "Collection1");
		clickButtonByID("CollectionOK");
		
		//Add items to the custom collection
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Scriptures");
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Old Testament");
		clickButtonByXpathTitleNameNoDownload("New Testament");
		clickButtonByXpathTitleNameNoDownload("Pearl of Great Price");
		scrollDown("Pearl of Great Price");
		clickButtonByXpathTitleNameNoDownload("Bible Photographs");
		clickButtonByID("DoneCollection");
		Thread.sleep(1000);
		checkTextViewByXpath("Old Testament");
		checkTextViewByXpath("New Testament");
		checkTextViewByXpath("Pearl of Great Price");
		checkTextViewByXpath("Bible Photographs");
		clickButtonByID("DoneCollection");
		clickButtonByID("DoneCollection");
		Thread.sleep(1000);
		
		//Go back to the home page
		clickButtonByID("Home");
		
		//**********************
		//2nd custom collection
		//**********************
		pressMenuKey();
		clickButtonByXpath("CustomCollections");
		Thread.sleep(1000);
		clickButtonByID("NewCollection");
		sendTextbyID("CollectionName", "Collection2");
		clickButtonByID("CollectionOK");
		
		//Add items to the custom collection
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Scriptures");
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Topical Guide");
		clickButtonByXpathTitleNameNoDownload("New Testament");
		clickButtonByXpathTitleNameNoDownload("Book of Mormon");
		clickButtonByID("DoneCollection");
		Thread.sleep(1000);
		checkTextViewByXpath("Topical Guide");
		checkTextViewByXpath("New Testament");
		checkTextViewByXpath("Book of Mormon");
		clickButtonByID("DoneCollection");
		clickButtonByID("DoneCollection");
		Thread.sleep(1000);
		
		//Go back to the home page
		clickButtonByID("Home");
		
		//**********************
		//3rd custom collection
		//**********************
		pressMenuKey();
		clickButtonByXpath("CustomCollections");
		Thread.sleep(1000);
		clickButtonByID("NewCollection");
		sendTextbyID("CollectionName", "Collection3");
		clickButtonByID("CollectionOK");
		
		//Add items to the custom collection
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("General Conference");
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("April 2014");
		clickButtonByID("DoneCollection");
		Thread.sleep(1000);
		clickButtonByID("AddCollection");
		clickButtonByXpathTitleNameNoDownload("Music");
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Hymns of The Church of Jesus Christ of Latter-day Saints");
		clickButtonByID("DoneCollection");
		checkTextViewByXpath("April 2014");
		checkTextViewByXpath("Hymns of The Church of Jesus Christ of Latter-day Saints");
		clickButtonByID("DoneCollection");
		clickButtonByID("DoneCollection");
		Thread.sleep(1000);
		
		//Go back to the home page
		clickButtonByID("Home");
		
		
		//***********************
		// Check Collection1
		//***********************
		clickButtonByXpathTitleNameNoDownload("Collection1");
		checkTextViewByXpath("Old Testament");
		checkTextViewByXpath("New Testament");
		checkTextViewByXpath("Pearl of Great Price");
		checkTextViewByXpath("Bible Photographs");
		Thread.sleep(1000);
		//Go back to the home page
		clickButtonByID("Home");
		
		//***********************
		// Check Collection2
		//***********************
		
		clickButtonByXpathTitleNameNoDownload("Collection2");
		checkTextViewByXpath("Topical Guide");
		checkTextViewByXpath("New Testament");
		checkTextViewByXpath("Book of Mormon");
		Thread.sleep(1000);
		//Go back to the home page
		clickButtonByID("Home");
		
		
		//***********************
		// Check Collection3
		//***********************
		
		clickButtonByXpathTitleNameNoDownload("Collection3");
		checkTextViewByXpath("April 2014");
		checkTextViewByXpath("Hymns of The Church of Jesus Christ of Latter-day Saints");
		Thread.sleep(1000);
		//Go back to the home page
		clickButtonByID("Home");
		
		
		//***********************
		// Delete Collection 1
		//***********************
		clickButtonByXpathTitleNameNoDownload("Collection1");
		pressMenuKey();
		clickButtonByXpath("DeleteCollection");
		Thread.sleep(1000);
		//checkTextByID("CollectionAlertTitle", "Delete �Collection1�?");
		checkContainsTextByID("CollectionAlertTitle", "Collection1");
		clickButtonByID("CollectionYes");
		Thread.sleep(1000);
		checkNoElementXpathName("Collection1");
		
		//***********************
		// Delete Collection 2
		//***********************
		clickButtonByXpathTitleNameNoDownload("Collection2");
		pressMenuKey();
		clickButtonByXpath("DeleteCollection");
		Thread.sleep(1000);
		//checkTextByID("CollectionAlertTitle", "Delete �Collection2�?");
		checkContainsTextByID("CollectionAlertTitle", "Collection2");
		clickButtonByID("CollectionYes");
		Thread.sleep(1000);
		checkNoElementXpathName("Collection2");
		
		//***********************
		// Delete Collection 3
		//***********************
		clickButtonByXpathTitleNameNoDownload("Collection3");
		pressMenuKey();
		clickButtonByXpath("DeleteCollection");
		Thread.sleep(1000);
		//checkTextByID("CollectionAlertTitle", "Delete �Collection3�?");
		checkContainsTextByID("CollectionAlertTitle", "Collection3");
		clickButtonByID("CollectionYes");
		Thread.sleep(1000);
		checkNoElementXpathName("Collection3");
	}
	
	/** HighLightSimpleTest()
	 * Simple Highlight Test
	 * 
	 * @throws Exception
	 */
	public void HighLightSimpleTest() throws Exception {
		goToChapter("OldTestament", "Genesis", "Chapter1");
		
		checkScriptureText("1", "1 In the abeginning bGod ccreated the dheaven and the eearth", "WEBVIEW_2" );
		checkNoHighlight("17117417048572036419", "WEBVIEW_2" );
		checkNoHighlight("11960920563163096019", "WEBVIEW_2" );
		checkNoHighlight("50592517553572101300", "WEBVIEW_2" );
		checkNoHighlight("45246420991898482480", "WEBVIEW_2" );
		checkNoHighlight("12830602616702807751", "WEBVIEW_2" );
		checkNoHighlight("64435288995272079840", "WEBVIEW_2" );
		checkNoHighlight("18565341494452282580", "WEBVIEW_2" );
		checkNoHighlight("72365154116889295780", "WEBVIEW_2" );
		checkNoHighlight("27562686592732056340", "WEBVIEW_2" );
		checkNoHighlight("22939485847599533470", "WEBVIEW_2" );
		
		flickRightToLeft();
		Thread.sleep(3000);
		//Should be on Genesis Chapter 2 
		checkScriptureText("1", "1 Thus the heavens and the aearth", "WEBVIEW_1" );
		checkNoHighlight("12999927233167343316", "WEBVIEW_1" );
		checkNoHighlight("15693629222522373657", "WEBVIEW_1" );
		checkNoHighlight("10905843253248016592", "WEBVIEW_1" );
		checkNoHighlight("17277842224227557064", "WEBVIEW_1" );
		checkNoHighlight("14206442862602744712", "WEBVIEW_1" );
		checkNoHighlight("16078937628349928007", "WEBVIEW_1" );
		checkNoHighlight("38480510140579679320", "WEBVIEW_1" );
		checkNoHighlight("17509279195066802128", "WEBVIEW_1" );
		checkNoHighlight("12917229371964540000", "WEBVIEW_1" );
		checkNoHighlight("10260283822508721500", "WEBVIEW_1" );
	
		//Go back to the home page
		clickButtonByID("Home");
		Thread.sleep(3000);
		//Log in then check the highlight again
		syncLogIn("zautomobile2", "ldsM0b1l3");		

		goToChapter("OldTestament", "Genesis", "Chapter1");
		
		checkScriptureText("1", "1 In the abeginning bGod ccreated the dheaven and the eearth", "WEBVIEW_2" );
		checkHighlight("17117417048572036419", "WEBVIEW_2" );
		checkHighlight("11960920563163096019", "WEBVIEW_2" );
		checkHighlight("50592517553572101300", "WEBVIEW_2" );
		checkHighlight("45246420991898482480", "WEBVIEW_2" );
		checkHighlight("12830602616702807751", "WEBVIEW_2" );
		checkHighlight("64435288995272079840", "WEBVIEW_2" );
		checkHighlight("18565341494452282580", "WEBVIEW_2" );
		checkHighlight("72365154116889295780", "WEBVIEW_2" );
		checkHighlight("27562686592732056340", "WEBVIEW_2" );
		checkHighlight("22939485847599533470", "WEBVIEW_2" );
		
		flickRightToLeft();
		Thread.sleep(3000);
		//Should be on Genesis Chapter 2 
		checkScriptureText("1", "1 Thus the heavens and the aearth", "WEBVIEW_1" );
		checkHighlight("12999927233167343316", "WEBVIEW_1" );
		checkHighlight("15693629222522373657", "WEBVIEW_1" );
		checkHighlight("10905843253248016592", "WEBVIEW_1" );
		checkHighlight("17277842224227557064", "WEBVIEW_1" );
		checkHighlight("14206442862602744712", "WEBVIEW_1" );
		checkHighlight("16078937628349928007", "WEBVIEW_1" );
		checkHighlight("38480510140579679320", "WEBVIEW_1" );
		checkHighlight("17509279195066802128", "WEBVIEW_1" );
		checkHighlight("12917229371964540000", "WEBVIEW_1" );
		checkHighlight("10260283822508721500", "WEBVIEW_1" );
		
		Thread.sleep(1000);
		
		//Go back to the home page
		clickButtonByID("Home");
		
	}
	
	/** NotesSearchTest()
	 * Search in Notes
	 * 
	 * @throws Exception
	 */
	public void NotesSearchTest() throws Exception {
		int myCheck;
		//Create new notebook
		enterNewNotebook("Notes Test 1");
		

		
		//Go to the Notebook page
		Thread.sleep(1000);
		clickButtonByXpath("Notes");
		Thread.sleep(1000);
		clickButtonByXpath("Notebooks");
		Thread.sleep(1000);
		clickButtonByXpathTitleNameNoDownload("Notes Test 1");
		Thread.sleep(1000);
		
		//Create a new Journal Entry
		enterNewJournal();
		sendTextbyID("EditNoteTitle", "Journal 1");
		sendTextbyID("EditNoteContent", "Text for journal entry 1");
		clickButtonByID("JournalMenuItemDone");
		
		//Check the Journal Entry
		Thread.sleep(1000);
		checkTextViewByXpath("Journal 1");
		checkTextViewByXpath("Text for journal entry 1");
		Thread.sleep(1000);

		//Create a new Journal Entry
		enterNewJournal();
		sendTextbyID("EditNoteTitle", "Journal 2");
		sendTextbyID("EditNoteContent", "Text for journal entry 2");
		Thread.sleep(1000);
		
		
		//Smaller devices in portrait mode need this
		myCheck = checkElementIDReturn("JournalMenuItemTag");
		if (myCheck == 1) {
			clickButtonByID("JournalMenuItemTag");
		} else {
			clickButtonByXpath("Overflow");
			clickButtonByXpathTitleNameNoDownload("Tag");
		}
		
		Thread.sleep(1000);
		
		//Create a new Tag
		sendTextbyID("EditTagText", "Alma");
		Thread.sleep(1000);
		clickTagName("Alma");
		Thread.sleep(1000);
		checkTagName("Alma ");
		clickButtonByID("TagDone");
		clickButtonByID("JournalMenuItemDone");
		
		//Check the Journal entry
		Thread.sleep(1000);
		checkTextViewByXpath("Journal 2");
		checkTextViewByXpath("Text for journal entry 2");
		checkTextViewByXpath("Alma");
		Thread.sleep(2000);
		
		//Create a new Journal Entry
		enterNewJournal();
		sendTextbyID("EditNoteTitle", "John the BP");
		sendTextbyID("EditNoteContent", "This is a entry for John");
		
		
		//Smaller devices in portrait mode need this
		myCheck = checkElementIDReturn("JournalMenuItemTag");
		if (myCheck == 1) {
			clickButtonByID("JournalMenuItemTag");
		} else {
			clickButtonByXpath("Overflow");
			clickButtonByXpathTitleNameNoDownload("Tag");
		}
		
		
		Thread.sleep(2000);
		
		//Create a new Tag
		sendTextbyID("EditTagText", "John");
		Thread.sleep(1000);
		clickTagName("John the Baptist");
		Thread.sleep(1000);
		checkTagName("John the Baptist ");
		clickButtonByID("TagDone");
		clickButtonByID("JournalMenuItemDone");
		
		Thread.sleep(1000);
		checkTextViewByXpath("John the BP");
		checkTextViewByXpath("This is a entry for John");
		checkTextViewByXpath("John the Baptist");
		Thread.sleep(1000);
		
		//Search Journal Entries
		sendTextbyID("SearchAnnotations", "John");

		
		
		//Smaller devices in portrait mode need this
		if (checkElementTextViewReturn("Done")) {
			clickButtonByXpathTitleNameNoDownload("Done");
		} else {
			clickButtonByID("JournalSearchDone");
		}
		
		

		Thread.sleep(1000);
		//Make sure the search entry is displayed
		checkTextViewByXpath("John the BP");
		checkTextViewByXpath("This is a entry for John");
		checkTextViewByXpath("John the Baptist");
		//Make sure the other entries are not displayed 
		checkNoElementXpathName("Journal 2");
		checkNoElementXpathName("Text for journal entry 2");
		checkNoElementXpathName("Alma");
		checkNoElementXpathName("Journal 1");
		checkNoElementXpathName("Text for journal entry 1");
		//Clear the search
		clickButtonByID("SearchClear");
		
		//Search Journal Entries
		sendTextbyID("SearchAnnotations", "Journal");
		
		//Smaller devices in portrait mode need this
		if (checkElementTextViewReturn("Done")) {
			clickButtonByXpathTitleNameNoDownload("Done");
		} else {
			clickButtonByID("JournalSearchDone");
		}
		
		Thread.sleep(2000);
		//Make sure the search entry is not displayed
		checkNoElementXpathName("John the BP");
		checkNoElementXpathName("This is a entry for John");
		checkNoElementXpathName("John the Baptist");
		//Make sure the other entries are displayed 
		checkTextViewByXpath("Journal 2");
		checkTextViewByXpath("Text for journal entry 2");
		checkTextViewByXpath("Alma");
		checkTextViewByXpath("Journal 1");
		checkTextViewByXpath("Text for journal entry 1");
		//Clear the search
		clickButtonByID("SearchClear");
	
		Thread.sleep(1000);
			
		pressMenuKey();
		clickButtonByXpath("DeleteNotebook");
		Thread.sleep(1000);
		
		// Need method to check the message
		
		clickButtonByID("NotebookDeleteOK");
		Thread.sleep(1000);
		checkNoElementXpathName("Notes Test 1");
		Thread.sleep(1000);
		
		//Go back to the home page
		clickButtonByID("Home");
				
	}
	
	/** RemoveAllRemoveSingleTest()
	 * Remove single books in a category
	 * Remove all books in a category
	 * 
	 * @throws Exception
	 */
	public void RemoveAllRemoveSingleTest() throws Exception {
		Thread.sleep(1000);
		scrollDown("Family");
		Thread.sleep(1000);
		clickButtonByXpath("MelchizedekPriesthood"); 
		
		//Download the Family Guidebook
		Thread.sleep(3000);
		clickButtonByXpathTitleNameNoDownload("Family Guidebook");
		Thread.sleep(1000);
		
		//Hide Items that are not downloaded
		pressMenuKey();
		clickButtonByXpath("CatalogOptions");
		clickButtonByXpath("HideItemsNotDownloaded");
		Thread.sleep(4000);
		
		
		//Downloaded Items
		Assert.assertTrue(checkElementTextViewReturn("Family Guidebook"));
		//Not Downloaded
		Assert.assertFalse(checkElementTextViewReturn("Handbook 2: Administering the Church"));
		Assert.assertFalse(checkElementTextViewReturn("Ezra Taft Benson"));
		Assert.assertFalse(checkElementTextViewReturn("October 2014"));
		Assert.assertFalse(checkElementTextViewReturn("Duties and Blessings of the Priesthood: Basic Manual for Priesthood Holders, Part A"));
		Assert.assertFalse(checkElementTextViewReturn("Duties and Blessings of the Priesthood: Basic Manual for Priesthood Holders, Part B"));
		Thread.sleep(1000);
		
		//Show all the items
		pressMenuKey();
		clickButtonByXpath("CatalogOptions");
		clickButtonByXpath("ShowItemsNotDownloaded");
		
		//Download the rest of the items in that page
		clickButtonByXpathTitleNameNoDownload("Handbook 2: Administering the Church");
		clickButtonByXpathTitleNameNoDownload("Ezra Taft Benson");
		clickButtonByXpathTitleNameNoDownload("October 2014");
		clickButtonByXpathTitleNameNoDownload("Duties and Blessings of the Priesthood: Basic Manual for Priesthood Holders, Part A");
		clickButtonByXpathTitleNameNoDownload("Duties and Blessings of the Priesthood: Basic Manual for Priesthood Holders, Part B");
		Thread.sleep(5000);
		
		//Hide Items that have not been downloaded (There shouldn't be any)
		pressMenuKey();
		clickButtonByXpath("CatalogOptions");
		clickButtonByXpath("HideItemsNotDownloaded");
		Thread.sleep(1000);
		
		//Check all of the items
		Assert.assertTrue(checkElementTextViewReturn("Family Guidebook"));
		Assert.assertTrue(checkElementTextViewReturn("Handbook 2: Administering the Church"));
		Assert.assertTrue(checkElementTextViewReturn("Ezra Taft Benson"));
		Assert.assertTrue(checkElementTextViewReturn("October 2014"));
		Assert.assertTrue(checkElementTextViewReturn("Duties and Blessings of the Priesthood: Basic Manual for Priesthood Holders, Part A"));
		Assert.assertTrue(checkElementTextViewReturn("Duties and Blessings of the Priesthood: Basic Manual for Priesthood Holders, Part B"));
		
		//Remove some of the items by long pressing on an item
		longPressByTextView("Ezra Taft Benson");
		clickButtonByXpathTitleNameNoDownload("Remove");
		longPressByTextView("October 2014");
		clickButtonByXpathTitleNameNoDownload("Remove");
		
		//Check the visible items
		Assert.assertTrue(checkElementTextViewReturn("Family Guidebook"));
		Assert.assertTrue(checkElementTextViewReturn("Handbook 2: Administering the Church"));
		Assert.assertFalse(checkElementTextViewReturn("Ezra Taft Benson"));
		Assert.assertFalse(checkElementTextViewReturn("October 2014"));
		Assert.assertTrue(checkElementTextViewReturn("Duties and Blessings of the Priesthood: Basic Manual for Priesthood Holders, Part A"));
		Assert.assertTrue(checkElementTextViewReturn("Duties and Blessings of the Priesthood: Basic Manual for Priesthood Holders, Part B"));
		
		
		//Remove all items
		pressMenuKey();
		clickButtonByXpath("CatalogOptions");
		clickButtonByXpathTitleNameNoDownload("Remove All in Melchizedek Priesthood");
		checkTextByID("AlertTitle", "Remove All");
		clickButtonByID("RemoveAllGo");
		
		Thread.sleep(1000);
		
		//Check for the "Show Items Not Downloaded" button
		checkTextByID("ShowItemsNotDownloadedButton", "Show Items Not Downloaded");
		
		//Show all items
		pressMenuKey();
		clickButtonByXpath("CatalogOptions");
		clickButtonByXpath("ShowItemsNotDownloaded");
		Thread.sleep(1000);
		
		
		//Go back to the home page
		clickButtonByID("Home");
		
	}
	
	/** SearchPrevNextTest()
	 * Search then use the previous and next buttons
	 *  
	 * @throws Exception
	 */
	public void SearchPrevNextTest() throws Exception {
		goToChapter("BookOfMormon", "Alma", "Chapter10");
		Thread.sleep(5000);
		clickButtonByID("menuSearch");
		Thread.sleep(5000);
		//"Find on page" "Search Book of Mormon" "Search Scriptures" "Search Library"
		clickButtonByXpathTitleNameNoDownload("Find on page");
		Thread.sleep(5000);
		sendTextbyID("FOPSearchText", "words");
		Thread.sleep(1000);
		checkTextByID("SearchFOPCount", "1 of 8");
		Thread.sleep(1000);
		clickButtonByID("SearchNext");
		checkTextByID("SearchFOPCount","2 of 8");
		clickButtonByID("SearchNext");
		checkTextByID("SearchFOPCount","3 of 8");
		clickButtonByID("SearchNext");
		checkTextByID("SearchFOPCount","4 of 8");
		clickButtonByID("SearchNext");
		checkTextByID("SearchFOPCount","5 of 8");
		clickButtonByID("SearchNext");
		checkTextByID("SearchFOPCount","6 of 8");
		clickButtonByID("SearchNext");
		checkTextByID("SearchFOPCount","7 of 8");
		clickButtonByID("SearchNext");
		checkTextByID("SearchFOPCount","8 of 8");
		
		//Go back up
		clickButtonByID("SearchPrev");
		checkTextByID("SearchFOPCount","7 of 8");
		clickButtonByID("SearchPrev");
		checkTextByID("SearchFOPCount","6 of 8");
		clickButtonByID("SearchPrev");
		checkTextByID("SearchFOPCount","5 of 8");
		clickButtonByID("SearchPrev");
		checkTextByID("SearchFOPCount","4 of 8");
		clickButtonByID("SearchPrev");
		checkTextByID("SearchFOPCount","3 of 8");
		clickButtonByID("SearchPrev");
		checkTextByID("SearchFOPCount","2 of 8");
		clickButtonByID("SearchPrev");
		checkTextByID("SearchFOPCount","1 of 8");
		
		clickButtonByID("SearchDone");
		Thread.sleep(1000);
		
		clickButtonByID("Home");
		Thread.sleep(1000);	
		
	}
	
	
	// TODO: There is a bug in seledroid - appium it won't see the autofill items
	// The test should pass but when the bug is fixed this test will need some work
	public void SearchAutoFillAndHistoryTest() throws Exception {
		goToChapter("NewTestament", "John", "Chapter2");
		
		//Check the suggestions when you enter in a search term
		clickButtonByID("menuSearch");
		//"Find on page" "Search Book of Mormon" "Search Scriptures" "Search Library"
		clickButtonByXpathTitleNameNoDownload("Search Library");
		Thread.sleep(1000);
		clearTextFieldID("SearchText");
		sendTextbyID("SearchText", "Luke");
		Assert.assertTrue(checkSearchAutoCompleteReturn("Luke"));
		//Assert.assertTrue(checkSearchAutoCompleteReturn("Luke, Gospel of"));
		//Assert.assertTrue(checkSearchAutoCompleteReturn("Lukewarm"));
		
		clickButtonByID("SearchGoButton");
		Thread.sleep(1000);
		
		//Should take you back to the scripture
		pressBackKey();
		Thread.sleep(1000);
		
		//Open up the search again - search term should be automatically populated
		clickButtonByID("menuSearch");
		//"Find on page" "Search Book of Mormon" "Search Scriptures" "Search Library"
		clickButtonByXpathTitleNameNoDownload("Search Library");
		Thread.sleep(1000);
		Assert.assertTrue(checkSearchAutoCompleteReturn("Luke"));
		//Assert.assertTrue(checkSearchAutoCompleteReturn("Luke, Gospel of"));
		//Assert.assertTrue(checkSearchAutoCompleteReturn("Lukewarm"));
		
		//Enter in a new search 
		clearTextFieldID("SearchText");
		sendTextbyID("SearchText", "Mark");
		Assert.assertTrue(checkSearchAutoCompleteReturn("Mark"));
		//Assert.assertTrue(checkSearchAutoCompleteReturn("Mark, Gospel of"));
		//Assert.assertTrue(checkSearchAutoCompleteReturn("Marks, William"));

		clickButtonByID("SearchGoButton");
		Thread.sleep(1000);
		
		clickButtonByID("Home");
		Thread.sleep(1000);		
		
		//Go to a scripture and do another test - should have the older searches
		goToChapter("NewTestament", "Luke", "Chapter2");
		clickButtonByID("menuSearch");
		//"Find on page" "Search Book of Mormon" "Search Scriptures" "Search Library"
		clickButtonByXpathTitleNameNoDownload("Search Library");
		Thread.sleep(1000);
		//Assert.assertTrue(checkSearchAutoCompleteReturn("Luke"));
		//Assert.assertTrue(checkSearchAutoCompleteReturn("Mark"));
		
		clickButtonByID("SearchDone");
		Thread.sleep(1000);
		
		clickButtonByID("Home");
		Thread.sleep(1000);	
		
	}
	
	/** CreateHighlightSimpleTest()
	 * Create a Highlight simple test
	 * 
	 * @throws Exception
	 */
	public void CreateHighlightSimpleTest() throws Exception {
		Thread.sleep(5000);
		goToChapter("BookOfMormon", "Jacob", "Chapter1");
		Thread.sleep(1000);
		
		//You must select a link on the scripture text
		longPressScriptureByLink("small", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 400, 25, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -450, -25, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightPurple");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		
		clearAnnotationMessage();
		
		//You must select a link on the scripture text
		longPressScriptureByLink("sacred", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 450, 50, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -380, -0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightRed");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		clickButtonByID("Home");
		Thread.sleep(1000);	
		clickButtonByXpath("Notes");
		Thread.sleep(2000);
		clickButtonByXpath("All");
		Thread.sleep(1000);
		
		checkNotesByID("MarkedSource", "Jacob 1:1");
		checkNotesByID("MarkedSource", "Jacob 1, Book of Mormon");
		Thread.sleep(1000);
		
		clickButtonByID("Home");
		Thread.sleep(1000);	
		
		//Delete the marked scriptures
		goToChapter("BookOfMormon", "Jacob", "Chapter1");
		//Choose the # of highlight mark you want to press 1 for the first one 2 for the second etc...
		clickHighlightMark(1);
		clickButtonByID("MenuItemDelete");
		Thread.sleep(1000);
		clickHighlightMark(1);
		clickButtonByID("MenuItemDelete");
		Thread.sleep(1000);
		
		
		clickButtonByID("Home");
		Thread.sleep(1000);	
	}
	
	/** CreateHighlightAllColors()
	 * Create Highlights of all colors
	 * 
	 * @throws Exception
	 */
	//TODO Add login > Create the highlights > Check highlights on the web
	public void CreateHighlightAllColors() throws Exception {
		Thread.sleep(1000);
		goToChapter("OldTestament", "Genesis", "Chapter9");
		Thread.sleep(1000);
		
		//You must select a link on the scripture text
		longPressScriptureByLink("Be", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 400, 0, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -550, 0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightRed");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		
		clearAnnotationMessage();
		
		//You must select a link on the scripture text
		longPressScriptureByLink("fear", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 600, 50, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -100, 0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightOrange");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		//You must select a link on the scripture text
		longPressScriptureByLink("meat", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 500, 0, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -375, 0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightYellow");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		//You must select a link on the scripture text
		longPressScriptureByLink("blood", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 350, 0, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -390, 0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightGreen");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		//You must select a link on the scripture text
		longPressScriptureByLink("require", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 450, 50, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -400, 0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightBlue");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		//You must select a link on the scripture text
		longPressScriptureByLink("sheddeth", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 800, 0, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -100, 0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightDarkBlue");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		//You must select a link on the scripture text
		longPressScriptureByLink("fruitful", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 650, 0, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -150, 0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightPurple");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		//You must select a link on the scripture text
		longPressScriptureByLink("covenant", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 550, 0, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -250, 0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightPink");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		//You must select a link on the scripture text
		longPressScriptureByLink("flood", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 150, 0, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -175, -25, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightBrown");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		

		pressBackKey();
		clickButtonByXpath("Chapter10");
		
		Thread.sleep(2000);
		//You must select a link on the scripture text
		longPressScriptureByLink("sons", "WEBVIEW_2");
		Thread.sleep(1000);	
		//TextElement x, y, speed
		moveSlider("RightSlider", 600, 0, 5);
		Thread.sleep(1000);
		moveSlider("LeftSlider", -350, 0, 5);
		Thread.sleep(1000);
		
		//Change the color
		clickButtonByID("MenuItemHighlightColor");
		clickButtonByID("HighlightGray");
		Thread.sleep(1000);
		clickButtonByID("HighlightDone");
		Thread.sleep(1000);
		
		//Check the highlights under notes
		clickButtonByID("Home");
		Thread.sleep(1000);	
		clickButtonByXpath("Notes");
		Thread.sleep(2000);
		clickButtonByXpath("All");
		Thread.sleep(1000);
		
		checkNotesByID("MarkedSource", "Genesis 10:1");
		checkNotesByID("MarkedSource", "Genesis 9:11");
		checkNotesByID("MarkedSource", "Genesis 9:9");
		checkNotesByID("MarkedSource", "Genesis 9:7");
		checkNotesByID("MarkedSource", "Genesis 9:6");
		checkNotesByID("MarkedSource", "Genesis 9:5");
		checkNotesByID("MarkedSource", "Genesis 9:4");
		scrollDown("Genesis 9:6");
		checkNotesByID("MarkedSource", "Genesis 9:3");
		checkNotesByID("MarkedSource", "Genesis 9:2");
		checkNotesByID("MarkedSource", "Genesis 9:1");
		Thread.sleep(1000);
		
		clickButtonByID("Home");
		Thread.sleep(1000);	
		
		//Delete the marked scriptures
		goToChapter("OldTestament", "Genesis", "Chapter9");
		Thread.sleep(1000);
		//Choose the # of highlight mark you want to press 1 for the first one 2 for the second etc...
		for (int x = 1; x < 9; x++){
			clickHighlightMark(1);
			clickButtonByID("MenuItemDelete");
			Thread.sleep(1000);
		}
		
		pressBackKey();
		clickButtonByXpath("Chapter10");

		Thread.sleep(1000);
		clickHighlightMark(1);
		clickButtonByID("MenuItemDelete");
		Thread.sleep(1000);
		
		clickButtonByID("Home");
		Thread.sleep(1000);	
			
	}
	
	
	
	//**************************************************************
	//**************** Start of Methods ****************************
	//**************************************************************
	
	/** checkTextByXpath(String textElement, String textToCheck )
	 * Check the text of an element by xpath
	 * 
	 * @param textElement - xpath that must be in uiMap
	 * @param textToCheck - text to check
	 */
	private void checkTextByXpath(String textElement, String textToCheck ) {
		Assert.assertEquals(driver.findElement(By.xpath(this.prop.getProperty(textElement))).getText(),(textToCheck));	
	}

	
	/** checkTextByXpathReturn(String textElement, String textToCheck )
	 * Check the text of an element by xpath and return if found or not
	 * 
	 * @param textElement- xpath that must be in uiMap
	 * @param textToCheck - text to check
	 * @return - If the text is correct return found = 1 or not found = 0
	 */
	private int checkTextByXpathReturn(String textElement, String textToCheck ) {
		String myText;
		int myReturn = 0;
		myText = driver.findElement(By.xpath(this.prop.getProperty(textElement))).getText();
		if (myText.equals(textToCheck) ) {
			myReturn = 1;
		}
		return myReturn;
	}
	
	
	/** checkTextViewByXpath(String textToCheck)
	 * Check all text under the Xpath of //TextViiew
	 * 
	 * @param textToCheck - Text to check on
	 */
	private void checkTextViewByXpath(String textToCheck) {
		int myCounter;
		int myTextCheck = 0;
		//List<String> str = new ArrayList<String>();
		List<WebElement> options = driver.findElements(By.xpath("//TextView"));
		myCounter = options.size() - 1;
		//System.out.println(myCounter);
		//System.out.println(options.size());
		for(int i = 0;i <= myCounter; i++) {
			String str = options.get(i).getText();
			//System.out.println(i + str);
			if (str.equals(textToCheck)){
				Assert.assertEquals(str ,textToCheck);
				myTextCheck = 1;
			}
		}
		// if the text is not found print out the info
		if (myTextCheck == 0) {
			System.out.println("Text not found: " + textToCheck );
			System.out.println("In: ");
			for(int i = 0;i <= myCounter; i++) {
				String str = options.get(i).getText();
				System.out.println(i + str);
			}
		}

		Assert.assertTrue(myTextCheck == 1 );
	}

	
	/** checkNoElementXpathName(String textElement)
	 * Make sure that the text does not exist by searching the value of //TextView
	 * 
	 * @param textElement - Text to search for
	 */
	private void checkNoElementXpathName(String textElement) {
		int myCounter;
		int myTextCheck = 0;
		List<WebElement> options= driver.findElements(By.xpath("//TextView[@value='" + textElement + "']"));
		myCounter = options.size() - 1;
		for(int i = 0;i <= myCounter; i++) {
			if (options.get(i).isDisplayed()){
				String str = options.get(i).getText();
				//System.out.println(i + str);
				if (str.equals(textElement)){
					//Assert.assertEquals(str ,textElement);
					myTextCheck = 1;
				}
			}
		}
		Assert.assertTrue(myTextCheck == 0 );
	}

	/** checkElementTextViewReturn(String textElement)
	 * Check that element exists by XPATH TextView
	 * 
	 * @param textElement - text to search for
	 * @return return false if no element, true if element is found
	 */
	private Boolean checkElementTextViewReturn(String textElement) {
		Boolean myReturnStatus;
		List<WebElement> options= driver.findElements(By.xpath("//TextView[@value='" + textElement + "']"));
		if (options.isEmpty()) {
			myReturnStatus = false;
		} else {
			myReturnStatus = true;
		}
	
		return myReturnStatus;
	}


	/** checkTextByID(String textElement, String textToCheck ) 
	 * Check to see if the text is correct by id
	 *  
	 * @param textElement - ID element in uiMap
	 * @param textToCheck - Text to check
	 */
	private void checkTextByID(String textElement, String textToCheck ) {
		Assert.assertEquals(driver.findElement(By.id(this.prop.getProperty(textElement))).getText(),(textToCheck));
	}
	
	/** checkContainsTextByID(String textElement, String textToCheck )
	 * Check to see if the text of a ID element contains some text
	 * 
	 * @param textElement - ID element in uiMap
	 * @param textToCheck - Text to check
	 */
	private void checkContainsTextByID(String textElement, String textToCheck ) {
		Assert.assertThat(driver.findElement(By.id(this.prop.getProperty(textElement))).getText(), CoreMatchers.containsString(textToCheck));
	}

	/** checkElementIDReturn(String textElement)
	 * Check that element exists by ID
	 * 
	 * @param textElement - ID of element in uiMap
	 * @return - return found = 1 or not found = 0
	 */
	private int checkElementIDReturn(String textElement) {
		int myReturnStatus = 0;
		List<WebElement> options= driver.findElements(By.id(this.prop.getProperty(textElement)));
		if (options.isEmpty()) {
			myReturnStatus = 0;
			return myReturnStatus;
		}
		myReturnStatus = 1;
		return myReturnStatus;
	}

	/** checkElementXpathReturn(String textElement)
	 * 
	 * @param textElement
	 * @return - found = 1 or not found = 0
	 */
	private int checkElementXpathReturn(String textElement) {
		int myReturnStatus = 0;
		List<WebElement> options= driver.findElements(By.xpath(this.prop.getProperty(textElement)));
		if (options.isEmpty()) {
			myReturnStatus = 0;
			return myReturnStatus;
		}
		myReturnStatus = 1;
		return myReturnStatus;
	}
	
	/** checkBookMarkSubtitle(String textElement)
	 * Check to see if the bookmark subtitle is correct
	 * 
	 * @param textElement - Bookmark subtitle
	 */
	private void checkBookMarkSubtitle(String textElement) {
		Assert.assertEquals(driver.findElement(By.xpath("//TextView[@id='item_subtitle'][@value='" + textElement + "']")).getText(),(textElement));	
	}


	/** checkScriptureText(String textElement, String textToCheck, String WebView )
	 * Check the Scripture text 
	 * 
	 * @param textElement - Verse number ie. for verse 1 just pass "1" enter "head" for the heading
	 * @param textToCheck - The text to check within verse ie "1 And it came to pass " 
	 * @param WebView - Vaild entries WEBVIEW_1, WEBVIEW_2, WEBVIEW_3
	 * When you first click on a link the current page will be WEBVIEW_2 after you flick to another page 
	 * the current page will be WEBVIEW_1
	 */
	private void checkScriptureText(String textElement, String textToCheck, String WebView ) {
		String scriptureText;
		WebElement element;
		waitForContentToLoad();
	
		driver.context(WebView);
		//Selenium way
		//driver.switchTo().window(WebView);
		
		element = driver.findElement(By.id(textElement));
		scriptureText = element.getText();	
	
		//driver.switchTo().window("NATIVE_APP");
		driver.context("NATIVE_APP");
		
		
		//Check to see that the text is correct
		Assert.assertThat(scriptureText, CoreMatchers.containsString(textToCheck));
	}


	/** checkMagazineText(String textElement, String textToCheck, String WebView )
	 * Check the Magazine text 
	 * 
	 * @param textElement - Page number it seems to be p4 or p5 not sure what exactly is going on
	 * @param textToCheck - The text to check within magazine ie "And it came to pass " 
	 * @param WebView - Vaild entries WEBVIEW_1, WEBVIEW_2, WEBVIEW_3
	 * When you first click on a link the current page will be WEBVIEW_2 Unless you are
	 * Selecting the first article then the current page will be WEBVIEW_1
	 */
	private void checkMagazineText(String textElement, String textToCheck, String WebView ) {
		String scriptureText;
		WebElement element;
		waitForContentToLoadMag();
	
		driver.context(WebView);
		//Selenium way
		//driver.switchTo().window(WebView);
		
		element = driver.findElement(By.id(textElement));
		scriptureText = element.getText();	
	
		//driver.switchTo().window("NATIVE_APP");
		driver.context("NATIVE_APP");
		
		
		//Check to see that the text is correct
		Assert.assertThat(scriptureText, CoreMatchers.containsString(textToCheck));
	}


	/** checkHighlight(String textElement, String WebView)
	 * Check that the highlight exists
	 * 
	 * @param textElement - element of the highlight
	 * @param WebView WEBVIEW_1, WEBVIEW_2 or WEBVIEW_3
	 */
	private void checkHighlight(String textElement, String WebView) {
		driver.context(WebView);
		List<WebElement> options= driver.findElements(By.xpath("//div[@annotationid='" + textElement + "']"));
		driver.context("NATIVE_APP");
		Assert.assertFalse(options.isEmpty());
	}


	/** checkNoHighlight(String textElement, String WebView)
	 * Check that the highlight does NOT exists
	 * 
	 * @param textElement - element of the highlight
	 * @param WebView WEBVIEW_1, WEBVIEW_2 or WEBVIEW_3
	 */
	private void checkNoHighlight(String textElement, String WebView) {
		driver.context(WebView);
		List<WebElement> options= driver.findElements(By.xpath("//div[@annotationid='" + textElement + "']"));
		driver.context("NATIVE_APP");
		Assert.assertTrue(options.isEmpty());
	}

	/** checkNotesByID(String textElement, String textToCheck)
	 * Check the notes by ID
	 * 
	 * @param textElement - ID that is in uiMap
	 * @param textToCheck - Text to check
	 */
	private void checkNotesByID(String textElement, String textToCheck) {
		int myCounter;
		int myTextCheck = 0;
		//List<String> str = Arrays.asList("test1", "test2");
		List<WebElement> options = driver.findElements(By.id(this.prop.getProperty(textElement)));
		myCounter = options.size() - 1;
		for(int i = 0;i <= myCounter; i++) {
			String str = options.get(i).getText();
			//System.out.println(i + str);
			if (str.equals(textToCheck)){
				Assert.assertEquals(str ,textToCheck);
				myTextCheck = 1;
			}
		}
		Assert.assertTrue(myTextCheck == 1 );
		
	}

	/** checkNoNotesByID()
	 * Check that there are no notes
	 * 
	 */
	private void checkNoNotesByID() {
		List<WebElement> options= driver.findElements(By.id("related_content_source"));
		Assert.assertTrue(options.isEmpty());
	}


	/** checkTagName(String textElement)
	 * Check to see if text exists by xpath //TagEditText
	 * 
	 * @param textElement - text to check
	 */
	private void checkTagName(String textElement) {
		String foundText;
		//foundText = driver.findElement(By.xpath("//TagEditText[@value='" + textElement + "']")).getText();
		foundText = driver.findElement(By.xpath("//TagEditText")).getText();
		//System.out.println("Text Found: " + foundText );
		Assert.assertEquals(foundText, textElement);	
	}


	/** checkSearchAutoCompleteReturn(String textElement)
	 * Check that the text is found under //SearchAutoComplete
	 * 
	 * @param textElement - Text to check 
	 * @return - false if text is not found, true if the text is found
	 */
	private Boolean checkSearchAutoCompleteReturn(String textElement) {
		Boolean myReturnStatus;
		List<WebElement> options= driver.findElements(By.xpath("//SearchAutoComplete[@value='" + textElement + "']"));
		if (options.isEmpty()) {
			myReturnStatus = false;
		} else {
			myReturnStatus = true;
		}

		return myReturnStatus;
	}
	
	
	

	/** checkSearchText(String textToCheck)
	 * Search for the searched text
	 * 
	 * @param textToCheck - Text to check 
	 * example - checkSearchText("Old Testament");
	 */
	private void checkSearchText(String textToCheck) {
		int myCounter;
		int myTextCheck = 0;
		List<WebElement> options= driver.findElements(By.xpath("//TextView[@id='search_listing_text1']"));
		myCounter = options.size() - 1;
		for(int i = 0;i <= myCounter; i++) {
			String str = options.get(i).getText();
			//System.out.println(i + str);
			if (str.contains(textToCheck)){
				//Assert.assertEquals(str ,textElement);
				myTextCheck = 1;
			}
		}
		Assert.assertTrue(myTextCheck == 1 );
			
	}

	/** checkSearchText2(String textToCheck)
	 * Search for the searched text
	 * 
	 * @param textToCheck - Text to check 
	 * example - checkSearchText2("226 results");
	 */
	private void checkSearchText2(String textToCheck) {
		int myCounter;
		int myTextCheck = 0;
		List<WebElement> options= driver.findElements(By.xpath("//TextView[@id='search_listing_text2']"));
		myCounter = options.size() - 1;
		for(int i = 0;i <= myCounter; i++) {
			String str = options.get(i).getText();
			//System.out.println(i + str);
			if (str.contains(textToCheck)){
				//Assert.assertEquals(str ,textElement);
				myTextCheck = 1;
			}
		}
		Assert.assertTrue(myTextCheck == 1 );
		
	}

	/** checkRelatedContentText(String textToCheck)
	 * Check the text under releated content
	 * 
	 * @param textToCheck - Text to check
	 */
	private void checkRelatedContentText(String textToCheck) {
		int myCounter;
		int myTextCheck = 0;
		List<WebElement> options= driver.findElements(By.xpath("//LinkTextView[@id='related_content_text']"));
		myCounter = options.size() - 1;
		for(int i = 0;i <= myCounter; i++) {
			String str = options.get(i).getText();
			//System.out.println(i + str);
			if (str.contains(textToCheck)){
				//Assert.assertEquals(str ,textElement);
				myTextCheck = 1;
			}
		}
		Assert.assertTrue(myTextCheck == 1 );
	}


	/** clickButtonByID(String textElement )
	 * Click button by ID
	 * 
	 * @param textElement - ID of element must be in uiMap
	 */
	private void clickButtonByID(String textElement ) {
		driver.findElement(By.id(this.prop.getProperty(textElement))).click();
	}
	
	//TODO: Need to test more, I don't think it is waiting in all cases. 
	/** clickButtonByXpath(String textElement )
	 * Click on the element by xpath, It should wait for the item to be downloaded first
	 * 
	 * @param textElement - Xpath of the element must be in uiMap
	 */
	private void clickButtonByXpath(String textElement ) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.prop.getProperty(textElement))));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(this.prop.getProperty(textElement) + "/../download_progress")));
		
		driver.findElement(By.xpath(this.prop.getProperty(textElement))).click();
		
		//I don't really like this sleep but it seems to be needed 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/** clickButtonByXpathDownload(String textElement ) 
	 * Click on the Button by xpath to download then click on the downloaded item
	 * 
	 * @param textElement - Xpath of the element, must be in uiMap
	 */
	private void clickButtonByXpathDownload(String textElement ) {
		//WebElement element;
		//Click the Element
		driver.findElement(By.xpath(this.prop.getProperty(textElement))).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Wait for the element to be clickable
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.prop.getProperty(textElement))));
		//Wait for the download icon to be invisible 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(this.prop.getProperty(textElement) + "/ProgressBar")));
		//Click the element again	
		driver.findElement(By.xpath(this.prop.getProperty(textElement))).click();
		
		//I don't really like this sleep but it seems to be needed 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/** clickButtonByXpathTitleName(String textElement ) 
	 * Click on the element by the Title name
	 * Should wait for the download to finish before clicking
	 * 
	 * @param textElement - Text to click on
	 */
	private void clickButtonByXpathTitleName(String textElement ) {
		//WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//TextView[@value='" + textElement + "']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//TextView[@value='" + textElement + "']" + "/download_progress")));
		
		driver.findElement(By.xpath("//TextView[@value='" + textElement + "']")).click();
		
		//I don't really like this sleep but it seems to be needed 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	/** clickButtonByXpathTitleNameNoDownload(String textElement )
	 * Click on the element by the Title name
	 * Will not check for download status
	 * 
	 * @param textElement - Text to click on
	 */
	private void clickButtonByXpathTitleNameNoDownload(String textElement ) {
		driver.findElement(By.xpath("//TextView[@value='" + textElement + "']")).click();
		//I don't really like this sleep but it seems to be needed 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	/** clickButtonByXpathMenuInfoButton(String textElement ) 
	 * Click on the menu info button by xpath name 
	 * 
	 * @param textElement
	 */
	private void clickButtonByXpathMenuInfoButton(String textElement ) {
		driver.findElement(By.xpath("//TextView[@value='" + textElement + "']/../../ImageButton")).click();
		//I don't really like this sleep but it seems to be needed 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	/** clickButtonByXpathMenuBookMarkTitleReference(String textElement, String textRef)
	 * Click on the menu info button by xpath name 
	 * 
	 * @param textElement = "Go To", "Update", "Rename", "Delete"
	 * @param textRef - something like "Job 1" 
	 */
	private void clickButtonByXpathMenuBookMarkTitleReference(String textElement, String textRef) {
		driver.findElement(By.xpath("//TextView[@value='" + textElement + ": " + textRef + "']")).click();
		//I don't really like this sleep but it seems to be needed 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** clickHighlightMark(int textElement )
	 * Click on the Highlight mark
	 *  
	 * @param textElement - Number of the hightlight mark to click on (1)
	 */
	private void clickHighlightMark(int textElement ) {
		textElement = textElement - 1;
		WebElement element;
		waitForContentToLoad();
		String WebView = "WEBVIEW_2";
	
		driver.context(WebView);
		element = driver.findElement(By.xpath("//*[contains(@class,'stickyDisplay')]"));
		element.click();
		
	
		//List<String> str = new ArrayList<String>();
		List<WebElement> options = driver.findElements(By.xpath("//*[contains(@class,'stickyDisplay')]"));
		options.get(textElement).click();
	
		//driver.switchTo().window("NATIVE_APP");
		driver.context("NATIVE_APP");
		
		
		//I don't really like this sleep but it seems to be needed 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** clickSpinnerItem(String textElement )
	 * Click on the Spinner then click on the element
	 * 
	 * @param textElement - Xpath element in uiMap
	 */
	private void clickSpinnerItem(String textElement ) {
		driver.findElement(By.id(this.prop.getProperty("Spinner"))).click();
		driver.findElement(By.xpath(this.prop.getProperty(textElement))).click();
	}

	
	/** clickTagName(String textElement)
	 * Click on the Tag name
	 * 
	 * @param textElement - Name of the tag
	 */
	private void clickTagName(String textElement) {
		driver.findElement(By.xpath("//TextView[@id='text1'][@value='" + textElement + "']")).click();
	}

	/** clickRelatedContentText(String textElement)
	 * Click on the Releated content text
	 * 
	 * @param textElement - text to click on
	 */
	private void clickRelatedContentText(String textElement) {
		driver.findElement(By.xpath("//LinkTextView[contains(@value,'" + textElement +"')]")).click();
	}

	/** clearTextFieldID(String textElement)
	 * Clear the text field by ID
	 * 
	 * @param textElement - ID must be in the uiMap
	 */
	private void clearTextFieldID(String textElement) {
		WebElement myElement = driver.findElement(By.id(this.prop.getProperty(textElement)));
		myElement.clear();
	}

	//This is just for testing
	private void getInfoScriptureText(String textElement) {
		String scriptureText;
		WebElement element;
		waitForContentToLoad();
		String WebView = "WEBVIEW_2";

		driver.context(WebView);
		//Selenium way
		//driver.switchTo().window(WebView);
	
		
		//element = driver.findElement(By.id(textElement));
		element = driver.findElement(By.id("transitionElement"));
		//element = driver.findElement(By.xpath("//*[contains(@class,'stickyDisplay')][2]"));
		scriptureText = element.getText();
		
		System.out.println("Get Class of element");
		System.out.println(element.getClass()); 
		System.out.println("Get Tag Name");
		System.out.println(element.getTagName());
		System.out.println("Get Size");
		System.out.println(element.getSize());
		System.out.println("Get Attribute Class");
		System.out.println(element.getAttribute("class"));
		System.out.println("Get Attribute Value");
		System.out.println(element.getAttribute("value"));
		System.out.println("Get Attribute AnnotationID");
		System.out.println(element.getAttribute("annotationid"));
		Point myPoint = element.getLocation();
		System.out.println(myPoint);
		
		
		String elementHTML = element.getAttribute("outerHTML");
		System.out.println("Outer HTML ");
		System.out.println(elementHTML);
		
		String elementInnerHTML = element.getAttribute("innerHTML");
		System.out.println("Inner HTML ");
		System.out.println(elementInnerHTML);
		
	
		//driver.switchTo().window("NATIVE_APP");
		driver.context("NATIVE_APP");
		
		
		//Check to see that the text is correct
		//Assert.assertThat(scriptureText, CoreMatchers.containsString(textToCheck));
	}
	
	/** sendTextbyID(String textElement, String textToSend ) 
	 * Send text to element by ID
	 * 
	 * @param textElement - ID of element must be in uiMap
	 * @param textToSend - Text to send
	 */
	private void sendTextbyID(String textElement, String textToSend ) {
		driver.findElement(By.id(this.prop.getProperty(textElement))).sendKeys(textToSend);
	}
	
	/** sendTextbyXpath(String textElement, String textToSend )
	 * Send text to element by xpath
	 * 
	 * @param textElement - xpath of element, must be in uiMap
	 * @param textToSend - Text to send
	 */
	private void sendTextbyXpath(String textElement, String textToSend ) {
		driver.findElement(By.xpath(this.prop.getProperty(textElement))).sendKeys(textToSend);
	}

	/** flickRightToLeft()
	 * Flick or swipe from Right to left
	 * 
	 */
	private void flickRightToLeft(){
		WebElement pages = driver.findElement(By.id("pager"));
		//Smaller Devices
		//TouchActions flick = new TouchActions(driver).flick(pages, -1500, 0, 0);
		//Larger devices - seems to work for larger and smaller devices
		TouchActions flick = new TouchActions(driver).flick(pages, -2500, 0, 0);
		flick.perform();
	}
	
	/** flickLeftToRight()
	 * Flick or swipe from Left to Right
	 * 
	 */
	private void flickLeftToRight(){
		WebElement pages = driver.findElement(By.id("pager"));
		TouchActions flick = new TouchActions(driver).flick(pages, 5500, 0, 0);
		flick.perform();
	}

	/** flickUpOrDown(int yNumber)
	 * Flick or swipe up or down
	 * 
	 * @param yNumber - up is a -500 down is 500
	 */
	private void flickUpOrDown(int yNumber){
		WebElement pages = driver.findElement(By.id("pager"));
		TouchActions flick = new TouchActions(driver).flick(pages, 0, yNumber, 0);
		flick.perform();
	}
	
	/** moveSlider(String textElement, int xCords, int yCords, int moveSpeed ) 
	 * Move the slider
	 * 
	 * @param textElement - xpath of element, must be in uiMap
	 * @param xCords - side to side cords
	 * @param yCords - up or down cords 
	 * @param moveSpeed - move speed 
	 * 
	 * example moveSlider("RightSlider", 400, 0, 5);
	 */
	private void moveSlider(String textElement, int xCords, int yCords, int moveSpeed ) {
        WebElement objSlider = driver.findElement(By.xpath(this.prop.getProperty(textElement)));
        TouchActions drag = new TouchActions(driver).flick(objSlider, xCords, yCords, moveSpeed);
        drag.perform();
	}

	
	/** scrollDown(String textElement)
	 * Select text then scroll down
	 * 
	 * @param textElement - Text of a //TextView[@value="TEXT"]
	 */
	private void scrollDown(String textElement){
		WebElement myElement = driver.findElement(By.xpath("//TextView[@value='" + textElement + "']"));
		TouchActions actions = new TouchActions(driver);
		Point p=myElement.getLocation();
		actions.down(p.x, p.y);
		actions.move(p.x, p.y - 400);
		actions.up(p.x, p.y - 200);
		actions.perform();
	}
	
	/** scrollDownDistance(int scrollDistance )
	 * Select the first TextView then scroll down
	 * 
	 * @param scrollDistance - Distance to scroll
	 */
	private void scrollDownDistance(int scrollDistance ){
		WebElement myElement = driver.findElement(By.xpath("//TextView[3]"));
		//WebElement myElement = driver.findElement(By.id("pager"));
		TouchActions actions = new TouchActions(driver);
		Point p=myElement.getLocation();
		actions.down(p.x, p.y);
		actions.move(p.x, p.y - scrollDistance);
		actions.up(p.x, p.y );
		actions.perform();
	}
	
	/** longPressByXpath(String textElement)
	 * Do a long press by xpath
	 * 
	 * @param textElement - Xpath of element, must be in uiMap
	 */
	private void longPressByXpath(String textElement) {
		WebElement myElement = driver.findElement(By.xpath(this.prop.getProperty(textElement)));
		//This was doing a longpress on the wrong element
		//TouchActions longPress = new TouchActions(driver).longPress(myElement);
		//longPress.perform();
		TouchActions actions=new TouchActions(driver);
		Point p=myElement.getLocation();
		actions.down(p.x, p.y);
		actions.pause(2000);
		actions.up(p.x, p.y);
		actions.perform();
	}
	
	/** longPressByTextView(String textElement)
	 * Do a long press on text of //TextView
	 * 
	 * @param textElement - Text of a //TextView element
	 */
	private void longPressByTextView(String textElement) {
		WebElement myElement = driver.findElement(By.xpath("//TextView[@value='" + textElement + "']"));
		//This was doing a longpress on the wrong element
		//TouchActions longPress = new TouchActions(driver).longPress(myElement);
		//longPress.perform();
		TouchActions actions=new TouchActions(driver);
		Point p=myElement.getLocation();
		actions.down(p.x, p.y);
		actions.pause(2000);
		actions.up(p.x, p.y);
		actions.perform();
	}

	
	//This is not working... need to figure out a different way to do this. 
	private void longPressScriptureByID(String textElement, String WebView) {
		WebElement myElement;
		//Point myPoint;
		waitForContentToLoad();
		
		driver.context(WebView);

		myElement = driver.findElement(By.id(textElement));
		//System.out.println(myElement.getText()); 
		//myPoint = myElement.getLocation();
		//System.out.println(myPoint);
		//TouchActions longPress = new TouchActions(driver).longPress(myElement);
		//longPress.perform();
		//myElement.click();
		
		
		TouchActions actions=new TouchActions(driver);
		Point p=myElement.getLocation();
		actions.down(p.x, p.y);
		actions.pause(2000);
		actions.up(p.x, p.y);
		actions.perform();
		
		driver.context("NATIVE_APP");

	}
	
	/** longPressScriptureByLink(String textElement, String WebView)
	 * Do a long press on a scripture link
	 * 
	 * @param textElement - link text of a web element
	 * @param WebView - WEBVIEW_1, WEBVIEW_2, WEBVIEW_3
	 */
	private void longPressScriptureByLink(String textElement, String WebView) {
		WebElement myElement;
		Point myPoint;
		waitForContentToLoad();
		
		driver.context(WebView);

		myElement = driver.findElement(By.linkText(textElement));
		TouchActions actions=new TouchActions(driver);
		Point p=myElement.getLocation();
		actions.down(p.x, p.y);
		actions.pause(2000);
		actions.up(p.x, p.y);
		actions.perform();
		
		
		driver.context("NATIVE_APP");

	}
	
	
	/** waitForElementToDisappearID(String textElement, int myTimeOut)
	 * This will wait for an element to disappear 
	 * Used to wait for the sync to finish
	 * 
	 * @param textElement - element to check by xpath in uiMap
	 * @param myTimeOut - number of seconds to wait before giving up
	 */
	private void waitForElementToDisappearID(String textElement, int myTimeOut){
		int myCheck; 
		myCheck = checkElementIDReturn(textElement);
		if (myCheck ==1){
			WebDriverWait wait = new WebDriverWait(driver, myTimeOut);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(this.prop.getProperty(textElement))));
			clickButtonByID("DownloadAlertOK");
		}

	}
	
	
	
	/** waitForContentToLoad()
	 * Wait for content to load
	 * 
	 */
	private void waitForContentToLoad() {
		//WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ContentViewPager/ContentWebView[3]")));
	}
	
	/** waitForContentToLoadMag()
	 * Wait for magazine content to load
	 * 
	 */
	private void waitForContentToLoadMag() {
		//WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ContentViewPager/ContentWebView[2]")));
	}
	
	/** pressMenuKey()
	 * Press the Menu key
	 * 
	 */
	private void pressMenuKey() {
		new Actions(driver).sendKeys(SelendroidKeys.MENU).perform();
	}
	
	/** pressBackKey()
	 * Press the Back key
	 * 
	 */
	private void pressBackKey() {
		new Actions(driver).sendKeys(SelendroidKeys.BACK).perform();
	}
	
	/** pressHomeKey()
	 * Press the home key
	 */
	private void pressHomeKey() {
		new Actions(driver).sendKeys(SelendroidKeys.ANDROID_HOME).perform();
	}
	
	
	//************************************************************
	//*************** Start of command sequences *****************
	//************************************************************
	
	/** syncLogIn(String loginName, String loginPassword) 
	 * Log into lds sync
	 * 
	 * @param loginName - login name
	 * @param loginPassword - password
	 * @throws Exception
	 */
	private void syncLogIn(String loginName, String loginPassword)  throws Exception {
		//Sign in 
		pressMenuKey();
		clickButtonByXpath("Settings");
		Thread.sleep(1000);
		clickButtonByXpath("SignIn");
		Thread.sleep(1000);
		sendTextbyID("Username", loginName);
		sendTextbyID("Password", loginPassword);
		clickButtonByID("SignInButton");
		Thread.sleep(4000);
		//ToDo need a check to see if the login was successful. 
		
		clickButtonByID("OKButton");
		Thread.sleep(2000);
		
		checkTextViewByXpath(loginName);
		Thread.sleep(2000);
		
		//Go back to the home page
		clickButtonByID("Home");
	}
	

	/** (String scriptureName, String bookName, String chapter) 
	 * Go to a scripture chapter
	 * You need to be on the Library page
	 * 
	 * @param scriptureName - OldTestament, NewTestament, BookOfMormon, DoctrineAndCovenants, PearlOfGreatPrice
	 * @param bookName - Genesis, John, Philippians etc...
	 * @param chapter - Chapter1, Chapter2 etc...
	 * @throws Exception
	 */
	private void goToChapter(String scriptureName, String bookName, String chapter)  throws Exception {
		int myCheck;
		int myCounter = 1;
		Thread.sleep(2000);
		clickButtonByXpath("Scriptures");
		Thread.sleep(2000);
		//Select the Scripture book
		clickButtonByXpath(scriptureName);
		
		
		//Check for download popup then wait for it to disappear
		waitForElementToDisappearID("DownloadAlertCancel", 500 );
		
		
		if (!scriptureName.contentEquals("DoctrineAndCovenants")) {
			//clickButtonByXpath(bookName);
			
			myCheck = checkElementXpathReturn(bookName);
			while ((myCheck == 0) && (myCounter < 5 )) {
				scrollDownDistance(110);
				myCheck = checkElementXpathReturn(bookName);
				myCounter++;
				System.out.println("Counter " + myCounter);
			}
			clickButtonByXpath(bookName);
			
		}
		Thread.sleep(1000);
		clickButtonByXpath(chapter);
		Thread.sleep(1000);
	
	}
	
	/** enterNewNotebook(String notebookName)
	 * Enter a new notebook
	 * 
	 * @param notebookName - Note book name
	 * @throws Exception
	 */
	private void enterNewNotebook(String notebookName) throws Exception {
		//Go to the Notes page
		clickButtonByXpath("Notes");
		Thread.sleep(1000);
		clickButtonByXpath("Notebooks");
		Thread.sleep(1000);
		pressMenuKey();
		clickButtonByXpath("NewNotebook");
		Thread.sleep(1000);
		sendTextbyID("NotebookName", notebookName);
		clickButtonByID("NotebookOK");
		
		clearAnnotationMessage();
		
		checkTextViewByXpath(notebookName);
		//Go back to the home page
		clickButtonByID("Home");
	}
	
	/** enterNewJournal()
	 * Enter in a new Journal 
	 * 
	 * @throws Exception
	 */
	private void enterNewJournal() throws Exception {
		int journalButtonFound;
		
		journalButtonFound = checkElementIDReturn("MenuItemAddJournal");
		if (journalButtonFound == 1 ) {
			clickButtonByID("MenuItemAddJournal");
		} else {
			pressMenuKey();
			clickButtonByXpath("AddJournal");
		}
		Thread.sleep(1000);	
		
	}
	
	/** clearAnnotationMessage() 
	 * New for 3.2.3.0
	 * Clear the Annotation Message popup
	 * 
	 * @throws Exception
	 */
	private void clearAnnotationMessage() throws Exception {
		int myCheck;
		Thread.sleep(1000);
		//New for 3.2.3.0 - Alert for Annotations will not be saved
		myCheck = checkElementIDReturn("AlertTitleAnnotations");
		if (myCheck == 1) {
			clickButtonByID("AlertNoThanks");
			Thread.sleep(1000);
		}
	}
	

	@After
	public void teardown() {
		driver.quit();
	}
	
	
	@Before
	public void openGuiMap() {
		
		File file = new File("ConfigFiles/uiMap.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		this.prop = new Properties();
		
		try {
			prop.load(fileInput);
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	//Need this class to get the touch stuff to work with Appium - Android
	public class AppiumSwipeableDriver extends AppiumDriver implements HasTouchScreen{
		 public RemoteTouchScreen touch;
		 public AppiumSwipeableDriver(URL URL, Capabilities Cap) {
			 super(URL, Cap);
			 touch = new RemoteTouchScreen(getExecuteMethod());
		}

		 @Override
		 public TouchScreen getTouch() {
			 return touch;
		 }

		@Override
			public MobileElement scrollTo(String arg0) {
			return null;
		}

		@Override
			public MobileElement scrollToExact(String arg0) {
			return null;
		}
	}
	
	
	//Retry Test needed so the system will retry a failed test
    public class Retry implements TestRule {
	        private int retryCount;
	
	    public Retry(int retryCount) {
	        this.retryCount = retryCount;
	    }
	
	    public Statement apply(Statement base, Description description) {
	        return statement(base, description);
	    }
	
	    private Statement statement(final Statement base, final Description description) {
	        return new Statement() {
	            @Override
	            public void evaluate() throws Throwable {
	                Throwable caughtThrowable = null;
	
	                // implement retry logic here
	                for (int i = 0; i < retryCount; i++) {
	                    try {
	                        base.evaluate();
	                        return;
	                    } catch (Throwable t) {
	                        caughtThrowable = t;
	                        System.err.println(description.getDisplayName() + ": run " + (i+1) + " failed");
	                    }
	                }
	                System.err.println(description.getDisplayName() + ": giving up after " + retryCount + " failures");
	                throw caughtThrowable;
	            }
	        };
	    }
	    
    }
}
