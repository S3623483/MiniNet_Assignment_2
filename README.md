# MiniNet

## COSC1295 Assignment 2

### Benjamin Donnelly [S3623483]

#### Assignment 2 for COSC1295 [Semester 1, 2018]

##### GitHub Repository
https://github.com/S3623483/MiniNet_Assignment_2.

See [Walkthrough](#walkthrough)

##Walkthrough
Following are screenshots and explanation on how to navigate around my MiniNet Application.

### Main Menu
When running the application, the user is greeted with the following Main Menu:
<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/MainMenu.png" width="500" height="450" />

### Add A Member
If the user clicks in the **Add A Member** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddMember.png" width="500" height="450" />

The `Parent 1 UserID` and `Parent 2 UserID` are only required / read in when the user is adding either Child or Baby member. There are three possible exceptions the user can throw when completing this page:
1. `UserIDInUseException`: This Exception will be thrown if the user enters a `userID` that is being used by an existing member of MiniNet.
2. `InvalidInputException`: This Exception will be thrown if the user leaves the `userID` and/or `fullName` fields empty.
3. `InvalidParentException`: This Exception will be thrown if the user enters an invalid parent combination when adding either a Child or Baby member to MiniNet.

If one of the above Exceptions are thrown, the application will notify the user in a separate window like the following:

Otherwise, if valid details are entered for a new member, the user will be notified of the new addition in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddMemberSuccessful.png" width="500" height="250" />

### Display Profile
If the user clicks on the **Display A Profile** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/SelectProfile.png" width="500" height="450" />

The list includes __**all**__ current members of MiniNet. The user must select (click on) the `userID` of the member whose profile they wish to view and click the **Select** button. Please note that the first item in the member listing is automatically selected which avoids any non-selection errors being thrown. Once the **Select** button has been pressed, the *Profile Viewer* opens in a separate window and looks like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/DisplayProfile.png" width="500" height="450" />

The user must click the **Close** button in the *Profile Viewer* before they can re-commence using the main GUI.

### Add A Connection
If the user clicks on the **Add A Connection** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddConnection.png" width="500" height="450" />

As per the above image, the `Parent` option is not included in the listing of connection types. This is because this connection is established when a member of type Child or Baby is added to MiniNet and, once set, can not be changed.

If the user tries to create an invalid (for example, trying to create a Friend connection between two members who are already friends), will result in the application notifying the user in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddConnectionUnsuccessful.png" width="500" height="250" />

Alternatively, if the user creates a valid new connection, the application will confirm the connection in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddConnectionSuccessful.png" width="500" height="250" />

### Query Connection
If the user clicks on the **Query Connection** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/QueryConnection.png" width="500" height="450" />

An Exception is thrown if the user selects the same person in both lists and the user is notified of their error in a separate window like the following:

Otherwise, if two different people are selected, the user if notified if they are connected and, if so, a listing of the different connections is provided. This information is presented to the user in a separate window like the following:


### Exit
The GUI closes and the terminates when the **Exit** button is clicked.
