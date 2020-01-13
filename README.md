#Old project since 2012
# XtendTradingIB

1	PURPOSE/JUSTIFICATION 

To build an automated stock trading system by providing stock trading signal web service (the website and the signal reader) and a desktop application (the signal executor robot) which consume the stock trading signal. User will use the signal executor robot to consume the automated trading signal provided by the website, and the signal executor robot will execute the signal by connecting to Interactive Broker’s Trader Workstation or Interactive Broker Gateway. Users must download and login into Interactive Broker’s Trader Workstation or Interactive Broker Gateway by themselves because of confidentiality policy.

2	OBJECTIVES

•	The website and design
•	The signal executor robot
•	The signal reader 

3	SCOPE DESCRIPTION

Deliverables of this project consist of 3 parts, the website, the signal executor, and the signal reader.
In Scope 
•	The website will allow user to register their account, and pay their subscription via paypal. After user successfully pays their subscription and become a valid member, the user can be able to download the signal executor robot and login to the signal executor robot using their registered account. The admin of the website can add / delete the user. User approval also managed by the admin of the website. The website and the signal reader is merged into one web service system.
•	The signal executor will execute trade using Interactive Broker’s Trader Workstation, or IB Gateway. User can login their registered and approved account into the signal executor, but not their Interactive Broker’s account, related to the confidentiality policy. They must login their Interactive Broker’s account into Interactive Broker’s Trader Workstation, or IB Gateway. The signal executor will consist of three features: trading active mode, transaction history, and signal list. Trading active mode means that the signal executor will request the newest signal from the website and trade based on the website’s response. When a valid trading request is received, the signal executor will give command to the Interactive Broker’s Trader Workstation, or IB Gateway to execute the trade. The signal executor will provide the transaction history that the signal executor has ever triggered, not the transaction history in user’s Interactive Broker’s account. And user can also review the signal provider list that the website provide and switch which signal provider that the user wants to use. The user only be able to use 1 signal provider per account.
•	The signal reader will read wsdl provided by the signal providers. Then the signal reader will parse the wsdl into command for the signal executor. When the signal executor request for the signal, the signal reader will return the newest signal based on the signal providers’ wsdl. The signal reader must be able to read more than one signal provider.



4	TECHNOLOGIES


•	JAVA for the Webstart app

•	J2EE for the website

•	ANDROID / IOS for the mobile app 

•	REST for webservice

•	Interactive Brokers API.

------------------------------

XtendTrading.com Ibbot Desktop Application Documentation

Package : com.ib.client
Contain library for Interactive Broker’s API

Package : com.xtendtrading.ibbot.main

MainFrame.java

Start from here, First it will register all controllers and views, so if you create another panel, it must be registered in here. The method to register all controllers and views is registerAllViews() & registerAllControllers(). These methods are called in constructor AbstractFrame(). All the panel is controlled in MainPanel.java.

MainPanel.java

	All of panels is put on CardLayout, so they can switch to another page easily. Remember when register a new panel, it must be registered in method registerAllViews(). Now let’s we go through each panel.
HomepagePanel.java

	layout() is the method which construct the homepagepanel. We are using GridBagLayout to construct the homepage.
	
This panel have 5 request methods. They are RequestConnect(), RequestDisconnect(), RequestLogin(), RequestLogout(), and doExit(). Basically homepagepanel is divided into two part, they are IB Gateway / TWS connection part, and XtendTrading login connection part. The logic of connection is put in HomepageController.java. To add / update the method of connecting, please refer to HomepageController. Each time you successfully login / connect, the symbol sign will turn green, means that you are pass their validation. If you have both successfully connecting to IB Gateway / TradeWorkstation, you will have two green mark, and then button continue will be appeared. Else the button continue will be disabled. demoConnect() only for demo purpose, please remove it when finalizing the application.

	And every interaction from HomepageController, it will call response methods in HomepagePanel, such as changing the symbol from red to green, change the status, revalidate the button continue. There are 3 response methods, they are setMessage(), setStatusandButton(), revalidateContinueButton(). setMessage() is to display if there is any error message related to the interaction from HomepageController. setStatusandButton() will be called to change validation status from red to green, et cetera. revalidateContinueButton will calculate the status and decide whether the button continue is allowed to displayed or not. 

DashboardPanel.java

	This panel is the core panel in this application. DashboardPanel contain 4 menu button, and a sidebarpanel. All Trading activities is put in sidebarpanel, while the menu button have each different purpose. First menu button is Trade, when the button is clicked, it will validate whether or not you have chosen the subscribed signal. When the subscribed signal is already checked, the trade mode will be automatically turned on and requesting to XtendTrading to obtain a trade signal. The status and information about signal is displayed on sidebarpanel. The second menu is Signal, when the button is clicked, the mainpanel will be select a new page panel that show different kinds of signal that can be used. And user can be able to show the full description of a certain signal. The third menu is History, when the button is clicked, user will be showed to a table contain of history transaction that the application have already done. The transaction history data is not obtained from IB Gateway / TradeWorkstation, but from XtendTrading.com itself. The fourth menu is a simply logout button. When it is clicked, the main panel will show us a homepage panel back. All of the 4 menus is not yet finished.
	The sidebar panel contain two parts, north and south sidebar panel. The north sidebar panel contain the status and active signal information when the trade mode is turned on. And the south sidebar panel will contain simpler history transaction. The button “more” in south sidebar panel have same action as the third menu History button have. All request method here is call DashboardController.java.
	
HistoryPanel.java

	This panel is showing the transaction history, with more complete information. This panel is not yet finished yet.
	
TradingPanel.java

	This is only the demo panel, to show how the application connect and communicate the command to execute a new trade via Interactive Broker’s API to the IB Gateway / TradeWorkstation.
	
LoginPanel.java & HomePanel.java

	These panels are the ancestor of Dashboard panel. I have thought two different pages for login and connecting, but I think it will be better to combine these two panels, into homepagePanel.java. These two panels is already not used.
	
Package : com.xtendtrading.ibbot.controller

HomepageController.java

	There are two parts here, they are Interactive Broker Gateway / TradeWorkstation connection part, and XtendTrading login connection part. ConnectingIBGateway() and DisconnectingIBGateway() are call Interactive Broker’s API to connect and disconnect into TradeWorkStation / IB Gateway. You will notice thate these methods will called IBController.java. A successful connection on ConnectingIBGateway(), will change status on HomepagePanel become green. Meanwhile ConnectingServerLogin() and DisconnectingServerLogin() will connect XtendTrading.com to validating the login information. A successful connection on ConnectingServerLogin (), will change status on HomepagePanel become green. And GoToNextPanel() will be executed when user click button continue on homepagepanel.
	
IBController.java

	This controller is basically implements EWrapper.java from IB API. This controller contain method to execute trade, connect / disconnect to IB Gateway / Tradeworkstation, show account status, and open a new transaction. More info can be obtained from IB API document guide. onConnect() is used to connect the IB Gateway / Tradeworkstation, and onDisconnect() is used to disconnect the connection. While placeOrder() is used to open a new Transaction. All the parameter of an order is put in Order.java, and Contract.java.
	
Package : com.xtendtrading.ibbot.helper

TableHelper.java

	This java class is used to construct a table that used in Transaction History feature. The class already contain method adjustColumnPreferredWidths() to readjusting the width of table column according to the table content. When displaying the smaller transaction history on sidebar panel, please use setSmallTableModel() and when displaying the larger and more complete transaction history table on historypanel, please use setCompleteTableModel(). 
	
Package : com.xtendtrading.ibbot.model

GBConstraints.java

	GBConstraints class is a helper to help us in designing layout using GridbagLayout. There is already a default setting and some methods to customize the gridbagconstraints we use.
 
XtendTrading.com Ibbot Website Database Documentation

•	Please setting the database postgre in file :

/ibbot-web/src/main/resources/data-source.properties

•	Create database in postgre contain 3 tables :

CREATE TABLE ib_roles
(
  role_id bigint NOT NULL,
  code text,
  name text,
  CONSTRAINT "role_idPK" PRIMARY KEY (role_id)
)

CREATE TABLE ib_user_roles
(
  ib_user_roles_id bigint NOT NULL,
  user_id bigint,
  role_id bigint,
  CONSTRAINT ib_user_roles_id PRIMARY KEY (ib_user_roles_id),
  CONSTRAINT "role_idFK" FOREIGN KEY (role_id)
      REFERENCES ib_roles (role_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "user_idFK" FOREIGN KEY (user_id)
      REFERENCES ib_users (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE ib_users
(
  first_name text,
  last_name text,
  user_id bigint NOT NULL,
  email text,
  phone text,
  mobile text,
  user_name text,
  password text,
  state bigint,
  is_lock boolean,
  updated_date timestamp without time zone,
  last_login_date timestamp without time zone,
  last_login_from text,
  last_logout_date timestamp without time zone,
  created_date timestamp without time zone,
  CONSTRAINT "user_idPK" PRIMARY KEY (user_id)
)

•	Package “com.ibbot.web.controller” contain all REST controllers. Separated by 3 main Controllers, AuthenticationController, HomeController, and SignalController.

•	Package “com.ibbot.web.dao” should contain methods to connect to the database postgre, while Package “com.ibbot.web.domain” is the vo.

---------------------------

DEMO:


1.	First you need IB Gateway / TWS from Interactive Brokers (for this demo I use TWS)
Here is the login form of TWS 

2.	Login the tws using demo account :
	a.	Username : edemo
	b.	Password : demouser

And then click login..  

3.	After that you are successfully connect to Interactive Broker via TWS.. So basically user need to download TWS / IB Gateway to use this application.. That’s the only way to use Interactive Broker API..


 
5.	This is the display when TWS is successfully connected..  

6.	Now let’s open our application.. XtendTrading Bot..

Here is the connection display : 

For now the IP Address, just leave blank, because we open TWS in same computer… 
Default port is 7496, to change the port, you can change it in your TWS / IB Gateway
Client ID is use when you want to use two application, but for now, just use 0

 
7.	After that, just press Connect.. If you don’t want to connect to TWS and just want to feel the application, just press “Demo Only”.. If your configuration correct, the TWS will read your request and ask for permission..
If you use IB Gateway, it will be directly connected without any permission..
 
 
8.	After that, the second display is login display.. this is used to validate whether the customer already subscribe into your xtendtrading or not.. if you click login you will connect to the web and the website will validate your username and password..
Because the feature is still not complete, we can just leave the username & password blank, and then press Login.  

 
9.	After that, the next display is Dashboard Display.. In the dashboard there are 4 menu (the current working menu is only start trading for now..)
 
10.	The webservice is still ongoing, haven’t finished yet, so to demo the connection to TWS / IB Gateway, I have created a simple form.. To experiment, just changed 5 field that I circled red..
Id mean Order ID (different with order ID in Tws)
Symbol mean the stock symbol
Action will be “BUY” or “SELL” 
Total Order Size will be the size of order
Limit Price is the price.  

 
11.	For example I will buy Coca cola stock, for size of 10, and the price is 38.0
 
12.	When we press submit, the TWS will automatically receive our request and create an order BUY..  





