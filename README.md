# MiniNet

## COSC1295 Assignment 2 [Semester 1, 2018]

## Benjamin Donnelly [S3623483]

### GitHub Repository
https://github.com/S3623483/MiniNet_Assignment_2.

### Using The MiniNet Application
To run **MiniNet** from the command line, first ensure __***all***__ `.java` and both `.txt` files are all together in one folder. Also, please make sure both `.txt` files are titled `people.txt` and `relations.txt` as these titles are listed in the applications code. Finally, please ensure that any people and connections being added to the MiniNet application are done so in-line with the following conventions:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/PersonConstructor.png" width="700" height="75" />

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/ConnectionConstructor.png" width="500" height="75" />

Where `userID` in the person constructor is the unique identifier for each member of MiniNet. Once this has been done and you are in a terminal screen, change your working directory to the folder containing all of the files and run the following code:

`javac *.java`

`java MiniNet`

Once these commands have been executed, the MiniNet GUI should open and you are free to explore the social network. Please see [Walkthrough](#walkthrough) for a step-by-step guide to using my MiniNet application.

### Class Diagram

This is included in my submission as a separate file.

### Functionality

As set out in a the assignment specification, my MiniNet application supports the following functionality:
1. Display a members profile
2. Add a new member
3. Delete an existing member;
4. Create a new connection;
5. Delete an existing connection;
6. Query connection \[Found out if (and how) two existing members are connected\].
7. Exit \[Close the application\].

### Exceptions

We have created thirteen exceptions to be thrown, caught and handled throughout our application. These exception include __***all***__ of those specified in the assignment specification.

However, we do note that the `NoSuchAgeException` was never used in the application. This is because we used a `Spinner` object containing numbers from 0 to 150 (inclusive) from which the user would select the age of the new member. Furthermore, the `Spinner` had its initial value set to 0. Therefore, it is not possible for the user to enter an invalid age (`age < 0` or `age > 150`) when adding a new member to MiniNet. 

### Application Limitations

I was unable to properly set up the embedded database connection. I tried but could not get it to work prooperly. I did not include my `MiniNetDatabase.java` file in my submission because I was concerned it would affect compilation. However, the work I did complete towards establishing the embedded database connection can be found in my GitHub repository [here](https://github.com/S3623483/MiniNet_Assignment_2/blob/master/MiniNetDatabase.java).

While I did not fully complete the task, I hope the work I was able to complete might warrant being awarded partial marks for this component of the assignment.

Finally, if `person.txt` is not in the directory, then an error message is supplied to the screen (see below) with members and connections being populated through hard code.

### Walkthrough
Following are screenshots and explanation on how to navigate around my MiniNet Application.

#### Start Up Error
If the connections listed in `relations.txt` leave a Child and/or Baby member(s) without two parents, they are removed from `members` and the user is notified in a window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/StartUpError.png" width="500" height="250" />

The user must click the **Ok** button before they are taken to MiniNet's main GUI.

#### Main Menu
When running the application, the user is greeted with the following Main Menu:
<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/MainMenu.png" width="500" height="450" />

#### Display Profile
If the user clicks on the **Display A Profile** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/SelectProfile.png" width="500" height="450" />

The list includes __**all**__ current members of MiniNet. The user can select (click on) the `userID` of the member whose profile they wish to view and click the **Select** button. Please note that the first item in the member listing is automatically selected which avoids any non-selection errors being thrown. Once the **Select** button has been pressed, the *Profile Viewer* opens in a separate window and looks like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/DisplayProfile.png" width="500" height="450" />

The user must click the **Close** button in the *Profile Viewer* before they can re-commence using the main GUI.

#### Add A Member
If the user clicks in the **Add A Member** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddMember.png" width="500" height="450" />

The `Parent 1 UserID` and `Parent 2 UserID` are only required / read in when the user is adding either Child or Baby member. There are three possible exceptions the user can throw when completing this page:
1. `UserIDInUseException`: This Exception will be thrown if the user enters a `userID` that is being used by an existing member of MiniNet.
2. `InvalidInputException`: This Exception will be thrown if the user leaves the `userID` and/or `fullName` fields empty.
3. `InvalidParentException`: This Exception will be thrown if the user enters an invalid parent combination when adding either a Child or Baby member to MiniNet.

If one of the above Exceptions are thrown, the application will notify the user in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddMemberUnsuccessful.png" width="500" height="250" />

Otherwise, if valid details are entered for a new member, the user will be notified of the new addition in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddMemberSuccessful.png" width="500" height="250" />

#### Delete A Member

If the user clicks in the **Delete A Member** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/DeleteMember.png" width="500" height="450" />

The list includes __**all**__ current members of MiniNet. The user can select (click on) the `userID` of the member they wish to remove and click the **Remove** button. If the user were to select `GREEKFREAK` and click the **Remove** button, the screen immediately changes to the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/DeletedMember.png" width="500" height="450" />

#### Add Connection
If the user clicks on the **Add A Connection** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddConnection.png" width="500" height="450" />

As per the above image, the `Parent` option is not included in the listing of connection types. This is because this connection is established when a member of type Child or Baby is added to MiniNet and, once set, can not be changed.

The user trying to create an invalid connection (for example, trying to create a Friend connection between two members who are already friends) will result in the application notifying the user in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddConnectionUnsuccessful.png" width="500" height="250" />

Alternatively, if the user creates a valid new connection, the application will confirm the connection in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/AddConnectionSuccessful.png" width="500" height="250" />

#### Delete Connection

If the user clicks on the **Add A Connection** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/DeleteConnection.png" width="500" height="450" />

The user trying to delete a non-existent connection will result in the application notifying the user in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/DeleteConnectionUnsuccessful.png" width="500" height="250" />

Alternatively, if the user deletes an existing connection, the application will confirm the connection in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/DeleteConnectionSuccessful.png" width="500" height="250" />

#### Query Connection
If the user clicks on the **Query Connection** button, they are taken to the following screen:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/QueryConnection.png" width="500" height="450" />

An Exception is thrown if the user selects the same person in both lists and the user is notified of their error in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/QueryConnectionError.png" width="500" height="250" />

Otherwise, if two different people are selected, the user if notified if they are connected and, if so, a listing of the different connections is provided. This information is presented to the user in a separate window like the following:

<img src="https://github.com/S3623483/MiniNet_Assignment_2/blob/master/Screenshots/QueryConnectionResult.png" width="500" height="450" />

#### Exit
The GUI closes and the terminates when the **Exit** button is clicked.
