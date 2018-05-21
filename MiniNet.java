import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Spinner;
import javafx.scene.control.ChoiceBox;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.stage.Modality;

/**
 * 
 * @author Benjamin R Donnelly [S3623483]
 * @version 1.1
 * @since 2018-03-18
 */
public class MiniNet extends Application {
	
	Driver2 useable = new Driver2();		//
	Scene frontPageScene;				//
	Scene addMemberScene;				//
	Scene selectProfileScene;			//
	Scene displayProfileScene;			//
	Scene queryConnectionScene;			//
	Scene addConnectionScene;			//
	Scene deleteMemberScene;			//
	Scene deleteConnectionScene;			//
	ListView<String> deleteUserIDListing;		//
	ListView<String> connectUserID1Listing;		//
	ListView<String> connectUserID2Listing;		//
	ListView<String> selectProfileIDListing;	//
	ListView<String> queryConnectionID1Listing;	//
	ListView<String> queryConnectionID2Listing;	//
	ListView<String> disconnectUserID1Listing;	//
	ListView<String> disconnectUserID2Listing;	//
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		launch(args);
		
	}
	
	@Override
	/**
	 * 
	 */
	public void start(Stage primaryStage) throws Exception {
		
		try {
			useable.populate();			
		}
		catch (FileNotFoundException ex) {
            inputErrorBox("Files(s) Not Found", "One or both of people.txt and relations.txt could not be located.\n"
            		+ "As such, members and connections have been hard-coded by the\npopulate2() method in Driver2 Class.");
            useable.populate2();
		}
		catch (InvalidParentException ipe) {
			inputErrorBox("Parents Not Listed Error", "One or more Child or Baby members did not have both parents listed.\n"
					+ "This violates MiniNet rules.\n"
					+ "As such, these members have been removed from MiniNet.");
		}
		catch (Exception e) {
			System.out.println("Not sure");
		}
		deleteUserIDListing = getListView();
		connectUserID1Listing = getListView();
		connectUserID2Listing = getListView();
		selectProfileIDListing = getListView();
		queryConnectionID1Listing = getListView();
		queryConnectionID2Listing = getListView();
		disconnectUserID1Listing = getListView();
		disconnectUserID2Listing = getListView();
		
		/*
		 * frontPageScene
		 */
		BorderPane frontPage = new BorderPane();
		frontPage.setPadding(new Insets(15, 20, 10, 10));
		
		// TOP
		Text textMainPage = new Text("Welcome to MiniNet");
		textMainPage.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		frontPage.setTop(textMainPage);
		BorderPane.setMargin(textMainPage, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(textMainPage, Pos.CENTER);
		
		// CENTER
		Text textMainMenu = new Text("Main Menu");
		textMainMenu.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		
		Button btnDisplayProfile = new Button("Display A Profile");
		btnDisplayProfile.setPadding(new Insets(5, 5, 5, 5));
		btnDisplayProfile.setMinWidth(200);
		btnDisplayProfile.setOnAction(e -> primaryStage.setScene(selectProfileScene));
		
		Button btnAddMember = new Button("Add A Member");
		btnAddMember.setPadding(new Insets(5, 5, 5, 5));
		btnAddMember.setMinWidth(200);
		btnAddMember.setOnAction(e -> primaryStage.setScene(addMemberScene));
		
		Button btnDeleteMember = new Button("Delete A Member");
		btnDeleteMember.setPadding(new Insets(5, 5, 5, 5));
		btnDeleteMember.setMinWidth(200);
		btnDeleteMember.setOnAction(e -> primaryStage.setScene(deleteMemberScene));
		
		Button btnAddConnection = new Button("Add Connection");
		btnAddConnection.setPadding(new Insets(5, 5, 5, 5));
		btnAddConnection.setMinWidth(200);
		btnAddConnection.setOnAction(e -> primaryStage.setScene(addConnectionScene));
		
		Button btnDeleteConnection = new Button("Delete Connection");
		btnDeleteConnection.setPadding(new Insets(5, 5, 5, 5));
		btnDeleteConnection.setMinWidth(200);
		btnDeleteConnection.setOnAction(e -> primaryStage.setScene(deleteConnectionScene));
		
		Button btnQueryConnection = new Button("Query Connection");
		btnQueryConnection.setPadding(new Insets(5, 5, 5, 5));
		btnQueryConnection.setMinWidth(200);
		btnQueryConnection.setOnAction(e -> primaryStage.setScene(queryConnectionScene));
		
		Button btnExit = new Button("Exit");
		btnExit.setPadding(new Insets(5, 5, 5, 5));
		btnExit.setMinWidth(200);
		btnExit.setOnAction(e -> primaryStage.close());
		
		VBox layoutCenter = new VBox(20);
		layoutCenter.getChildren().addAll(textMainMenu, btnDisplayProfile, btnAddMember, btnDeleteMember, btnAddConnection, btnDeleteConnection, btnQueryConnection, btnExit);
		frontPage.setCenter(layoutCenter);
		layoutCenter.setAlignment(Pos.CENTER);
		
		// BOTTOM
		Text frontPageAuthor = new Text("MiniNet is a social networking application brought to you by Benjamin Donnelly.");
		frontPageAuthor.setFont(Font.font("Verdana", 9));
		frontPage.setBottom(frontPageAuthor);
		BorderPane.setMargin(frontPageAuthor, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(frontPageAuthor, Pos.CENTER);
		BorderPane.setMargin(frontPageAuthor, new Insets(10, 10, 10, 10));
		
		frontPageScene = new Scene(frontPage, 750, 600);
		
		/*
		 * addMemberScene
		 */
		BorderPane addMember = new BorderPane();		
		addMember.setPadding(new Insets(15, 20, 10, 10));
		
		// TOP
		Text textAddMember = new Text("Add Member");
		textAddMember.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		addMember.setTop(textAddMember);
		BorderPane.setMargin(textAddMember, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(textAddMember, Pos.CENTER);
		
		// CENTER
		Text addMemberHeading = new Text("Enter Your Details");
		addMemberHeading.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		
		GridPane addMemberDetails = new GridPane();
		addMemberDetails.setAlignment(Pos.CENTER);
		addMemberDetails.setHgap(10);
		addMemberDetails.setVgap(10);
		Label labelUserID = new Label("UserID: * ");
		TextField userID = new TextField();
		Label labelFullName = new Label("Full Name: * ");
		TextField fullName = new TextField();
		Label labelAge = new Label("Age: ");
		Spinner<Integer> age = new Spinner<>(0, 150, 0);		
		Label labelGender = new Label("Gender: ");
		ChoiceBox<String> gender = new ChoiceBox<>();
		gender.getItems().addAll("M", "F");
		gender.getSelectionModel().select(0);
		Label labelStatus = new Label("Status: ");
		TextField status = new TextField();
		Label labelPhoto = new Label("Photo: ");
		TextField photo = new TextField();
		Label labelParent1 = new Label("Parent 1 UserID: # ");
		TextField parent1 = new TextField();
		Label labelParent2 = new Label("Parent 2 UserID: # ");
		TextField parent2 = new TextField();
		
		addMemberDetails.add(labelUserID, 0, 0, 1, 1);
		addMemberDetails.add(userID, 1, 0, 1, 1);
		addMemberDetails.add(labelFullName, 2, 0, 1, 1);
		addMemberDetails.add(fullName, 3, 0, 1, 1);
		addMemberDetails.add(labelAge, 0, 2, 1, 1);
		addMemberDetails.add(age, 1, 2, 1, 1);
		addMemberDetails.add(labelGender, 2, 2, 1, 1);
		addMemberDetails.add(gender, 3, 2, 1, 1);
		addMemberDetails.add(labelStatus, 0, 4, 1, 1);
		addMemberDetails.add(status, 1, 4, 1, 1);
		addMemberDetails.add(labelPhoto, 2, 4, 1, 1);
		addMemberDetails.add(photo, 3, 4, 1, 1);
		addMemberDetails.add(labelParent1, 0, 6, 1, 1);
		addMemberDetails.add(parent1, 1, 6, 1, 1);
		addMemberDetails.add(labelParent2, 2, 6, 1, 1);
		addMemberDetails.add(parent2, 3, 6, 1, 1);
		
		Button btnAdd = new Button("Add");
		btnAdd.setPadding(new Insets(5, 5, 5, 5));
		btnAdd.setMinWidth(200);
		btnAdd.setOnAction(e -> {
				String userIDInput = userID.getText().toUpperCase().trim();
				String fullNameInput = fullName.getText().trim();
				int ageInput = age.getValue();
				String genderInput = gender.getValue();
				String statusInput = status.getText().trim();
				if (statusInput.equals("")) {
					statusInput = "No Status";
				}
				String photoInput = photo.getText().trim();
				if (photoInput.equals("")) {
					photoInput = "No Photo";
				}
				String parent1Input = parent1.getText().toUpperCase().trim();
				String parent2Input = parent2.getText().toUpperCase().trim();
				try {
					useable.addMember(userIDInput, fullNameInput, ageInput, genderInput, photoInput, statusInput, parent1Input, parent2Input);
					deleteUserIDListing.getItems().add(userIDInput);
					connectUserID1Listing.getItems().add(userIDInput);
					connectUserID2Listing.getItems().add(userIDInput);
					selectProfileIDListing.getItems().add(userIDInput);
					queryConnectionID1Listing.getItems().add(userIDInput);
					queryConnectionID2Listing.getItems().add(userIDInput);
					userID.clear();
					fullName.clear();
					age.getValueFactory().setValue(0);
					gender.getSelectionModel().select(0);
					status.clear();
					photo.clear();
					parent1.clear();
					parent2.clear();
					inputErrorBox("Member Added", userIDInput + " has been successfully added to MiniNet.");
				}
				catch (InputErrorException iee) {
					inputErrorBox("Invalid Input", "userID and fullName can not be empty Strings.");
				}
				catch (ParentsRequiredException pre) {
					inputErrorBox("Invalid Input", "Both parents must be listed when age is less than 16.");
				}
				catch (UserIDInUseException uiue) {
					inputErrorBox("Invalid Input", userIDInput + " is already in use\nPlease try again.");
				}
				catch (InvalidParentException ipe) {
					inputErrorBox("Invalid Input", parent1Input + " & " + parent2Input + " is an invalid parent combination.");
				}
			}
		);
		
		Button btnAddMemberBack = new Button("Back");
		btnAddMemberBack.setPadding(new Insets(5, 5, 5, 5));
		btnAddMemberBack.setMinWidth(200);
		btnAddMemberBack.setOnAction(e -> {
				userID.clear();
				fullName.clear();
				age.getValueFactory().setValue(0);
				gender.getSelectionModel().select(0);
				status.clear();
				photo.clear();
				parent1.clear();
				parent2.clear();
				primaryStage.setScene(frontPageScene);
			}
		);
		
		Text asterisk = new Text("* UserID and Full Name must be completed for all members.");
		asterisk.setFont(Font.font("Verdana", 9.5));
		Text parents = new Text("# A valid parent combination must be entered for all new members under the ago of 16.");
		parents.setFont(Font.font("Verdana", 9.5));		
		
		VBox addMemberCenter = new VBox(20);
		addMemberCenter.getChildren().addAll(addMemberHeading, addMemberDetails, btnAdd, btnAddMemberBack, asterisk, parents);
		addMember.setCenter(addMemberCenter);
		addMemberCenter.setAlignment(Pos.CENTER);
		
		// BOTTOM
		Text addMemberAuthor = new Text("MiniNet is a social networking application brought to you by Benjamin Donnelly.");
		addMemberAuthor.setFont(Font.font("Verdana", 9));
		addMember.setBottom(addMemberAuthor);
		BorderPane.setMargin(addMemberAuthor, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(addMemberAuthor, Pos.CENTER);
		BorderPane.setMargin(addMemberAuthor, new Insets(10, 10, 10, 10));
		
		addMemberScene = new Scene(addMember, 750, 600);
		
		/*
		 * selectProfileScene
		 */
		BorderPane selectProfile = new BorderPane();		
		selectProfile.setPadding(new Insets(15, 20, 10, 10));
		
		// TOP
		Text textSelectProfile = new Text("Display Profile");
		textSelectProfile.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		selectProfile.setTop(textSelectProfile);
		BorderPane.setMargin(textSelectProfile, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(textSelectProfile, Pos.CENTER);
		
		// CENTER
		Text selectProfileHeading = new Text("Whose Profile Do You Wish To View?");
		selectProfileHeading.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		
		selectProfileIDListing.getSelectionModel().select(0);
		
		Button btnSelectProfileSelect = new Button("Select");
		btnSelectProfileSelect.setPadding(new Insets(5, 5, 5, 5));
		btnSelectProfileSelect.setMinWidth(200);
		btnSelectProfileSelect.setOnAction(e -> {
			String profileUserID = selectProfileIDListing.getSelectionModel().getSelectedItem();
			displayProfile(profileUserID + "'s MiniNetProfile", profileUserID);
			selectProfileIDListing.getSelectionModel().select(0);
			}
		);
		
		Button btnSelectProfileBack = new Button("Back");
		btnSelectProfileBack.setPadding(new Insets(5, 5, 5, 5));
		btnSelectProfileBack.setMinWidth(200);
		btnSelectProfileBack.setOnAction(e -> primaryStage.setScene(frontPageScene));
		
		VBox selectProfileCenter = new VBox(20);
		selectProfileCenter.getChildren().addAll(selectProfileHeading, selectProfileIDListing, btnSelectProfileSelect, btnSelectProfileBack);
		selectProfile.setCenter(selectProfileCenter);
		selectProfileCenter.setAlignment(Pos.CENTER);
		
		// BOTTOM
		Text selectProfileAuthor = new Text("MiniNet is a social networking application brought to you by Benjamin Donnelly.");
		selectProfileAuthor.setFont(Font.font("Verdana", 9));
		selectProfile.setBottom(selectProfileAuthor);
		BorderPane.setMargin(selectProfileAuthor, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(selectProfileAuthor, Pos.CENTER);
		BorderPane.setMargin(selectProfileAuthor, new Insets(10, 10, 10, 10));
		
		selectProfileScene = new Scene(selectProfile, 750, 600);
		
		/*
		 * deleteMemberScene
		 */
		BorderPane deleteMember = new BorderPane();
		deleteMember.setPadding(new Insets(15, 20, 10, 10));
		
		// TOP
		Text headingDeleteMember = new Text("Delete A Member");
		headingDeleteMember.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		deleteMember.setTop(headingDeleteMember);
		BorderPane.setMargin(headingDeleteMember, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(headingDeleteMember, Pos.CENTER);	
		
		// CENTER
		Text deleteMemberHeading = new Text("Which Member Do You Wish To Remove?");
		deleteMemberHeading.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		
		deleteUserIDListing.getSelectionModel().select(0);
		
		Button btnDelete = new Button("Remove");
		btnDelete.setPadding(new Insets(5, 5, 5, 5));
		btnDelete.setMinWidth(200);
		btnDelete.setOnAction(e -> {
				String deleteUserID = deleteUserIDListing.getSelectionModel().getSelectedItem();
				try {
					useable.remove(deleteUserID);
					updateListView(deleteUserIDListing, deleteUserID);
					updateListView(connectUserID1Listing, deleteUserID);
					updateListView(connectUserID2Listing, deleteUserID);
					updateListView(selectProfileIDListing, deleteUserID);
					updateListView(queryConnectionID1Listing, deleteUserID);
					updateListView(queryConnectionID2Listing, deleteUserID);
				}
				catch (NotToBeDeletedException ntbde) {
					alertBox("Deletion Unsuccessful", deleteUserID + " can not be deleted");
				}
			}
		);
		
		Button btnDeleteMemberBack = new Button("Back");
		btnDeleteMemberBack.setPadding(new Insets(5, 5, 5, 5));
		btnDeleteMemberBack.setMinWidth(200);
		btnDeleteMemberBack.setOnAction(e -> primaryStage.setScene(frontPageScene));
		
		VBox deleteMemberCenter = new VBox(20);
		deleteMemberCenter.getChildren().addAll(deleteMemberHeading, deleteUserIDListing, btnDelete, btnDeleteMemberBack);
		deleteMember.setCenter(deleteMemberCenter);
		deleteMemberCenter.setAlignment(Pos.CENTER);
		
		// BOTTOM
		Text deleteMemberAuthor = new Text("MiniNet is a social networking application brought to you by Benjamin Donnelly.");
		deleteMemberAuthor.setFont(Font.font("Verdana", 9));
		deleteMember.setBottom(deleteMemberAuthor);
		BorderPane.setMargin(deleteMemberAuthor, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(deleteMemberAuthor, Pos.CENTER);
		BorderPane.setMargin(deleteMemberAuthor, new Insets(10, 10, 10, 10));
		
		deleteMemberScene = new Scene(deleteMember, 750, 600);
		
		/*
		 * addConnectionScene
		 */
		BorderPane addConnection = new BorderPane();
		addConnection.setPadding(new Insets(15, 20, 10, 10));
		
		// TOP
		Text headingAddConnection = new Text("Add Connection");
		headingAddConnection.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		addConnection.setTop(headingAddConnection);
		BorderPane.setMargin(headingAddConnection, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(headingAddConnection, Pos.CENTER);
		
		// CENTER
		Text addConnectionHeading = new Text("Which Members Do You Wish To Connect?");
		addConnectionHeading.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		
		connectUserID1Listing.getSelectionModel().select(0);
		connectUserID1Listing.setMaxHeight(100);
		connectUserID2Listing.getSelectionModel().select(0);
		connectUserID2Listing.setMaxHeight(100);
		
		ListView<String> connectionType = new ListView<>();
		connectionType.getItems().addAll("Friend", "Classmate", "Colleague", "Couple");
		connectionType.getSelectionModel().select(0);
		connectionType.setMaxHeight(100);
		
		HBox connectListings = new HBox(20);
		connectListings.getChildren().addAll(connectUserID1Listing, connectUserID2Listing, connectionType);
		connectListings.setAlignment(Pos.CENTER);
		
		Button btnConnect = new Button("Connect");
		btnConnect.setPadding(new Insets(5, 5, 5, 5));
		btnConnect.setMinWidth(200);
		btnConnect.setOnAction(e -> {
			String connectUserID1 = connectUserID1Listing.getSelectionModel().getSelectedItem();
			String connectUserID2 = connectUserID2Listing.getSelectionModel().getSelectedItem();
			String connectType = connectionType.getSelectionModel().getSelectedItem();
			try {
				useable.addConnection(connectUserID1, connectUserID2, connectType);
				String connectionMessage = connectUserID1 + " & " + connectUserID2 + " are now connected as " + connectType;
				alertBox("Connection Successful", connectionMessage);
				connectUserID1Listing.getSelectionModel().select(0);
				connectUserID2Listing.getSelectionModel().select(0);
				connectionType.getSelectionModel().select(0);
			}
			catch (SamePersonException spe) {
				String speMessage = connectUserID1 + " & " + connectUserID2 + " are the same person.";
				alertBox("Connection Unsuccessful", speMessage);
			}
			catch (AlreadyConnectedException ace) {
				String aceMessage = connectUserID1 + " & " + connectUserID2 + " are already connected as " + connectType + ".";
				alertBox("Connection Unsuccessful", aceMessage);
			}
			catch (NotToBeFriendsException ntbfe) {
				String ntbfeMessage = connectUserID1 + " & " + connectUserID2 + " can not be friends on MiniNet.";
				alertBox("Connection Unsuccessful", ntbfeMessage);
			}
			catch (NotToBeClassmatesException ntbclasse) {
				String ntbclasseMessage = connectUserID1 + " " + connectUserID2 + " can not be classmates on MiniNet.";
				alertBox("Connection Unsuccessful", ntbclasseMessage);
			}
			catch (NotToBeColleaguesException ntbcolle) {
				String ntbcolleMessage = connectUserID1 + " & " + connectUserID2 + " can not be colleagues on MiniNet.";
				alertBox("Connection Unsuccessful", ntbcolleMessage);
			}
			catch (NotToBeCoupledException ntbce) {
				String ntbceMessage = connectUserID1 + " & " + connectUserID2 + " can not be in a couple on MiniNet.";
				alertBox("Connection Unsuccessful", ntbceMessage);
			}
			catch (NoAvailableException nae) {
				String naeMessage = "One (or both) of " + connectUserID1 + " & " + connectUserID2 + " are already in a relationship.";
				alertBox("ConnectionUnsuccessful", naeMessage);
			}
			}
		);
		
		Button btnAddConnectionBack = new Button("Back");
		btnAddConnectionBack.setPadding(new Insets(5, 5, 5, 5));
		btnAddConnectionBack.setMinWidth(200);
		btnAddConnectionBack.setOnAction(e -> {
				connectUserID1Listing.getSelectionModel().select(0);
				connectUserID2Listing.getSelectionModel().select(0);
				connectionType.getSelectionModel().select(0);
				primaryStage.setScene(frontPageScene);
			}
		);
		
		VBox addConnectionCenter = new VBox(20);
		addConnectionCenter.getChildren().addAll(addConnectionHeading, connectListings, btnConnect, btnAddConnectionBack);
		addConnection.setCenter(addConnectionCenter);
		addConnectionCenter.setAlignment(Pos.CENTER);
		
		// BOTTOM
		Text addConnectionAuthor = new Text("MiniNet is a social networking application brought to you by Benjamin Donnelly.");
		addConnectionAuthor.setFont(Font.font("Verdana", 9));
		addConnection.setBottom(addConnectionAuthor);
		BorderPane.setMargin(addConnectionAuthor, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(addConnectionAuthor, Pos.CENTER);
		BorderPane.setMargin(addConnectionAuthor, new Insets(10, 10, 10, 10));
		
		addConnectionScene = new Scene(addConnection, 750, 600);
		
		/*
		 * deleteConnectionScene
		 */
		BorderPane deleteConnection = new BorderPane();
		deleteConnection.setPadding(new Insets(15, 20, 10, 10));
		
		// TOP
		Text headingDeleteConnection = new Text("Delete Connection");
		headingDeleteConnection.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		deleteConnection.setTop(headingDeleteConnection);
		BorderPane.setMargin(headingDeleteConnection, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(headingDeleteConnection, Pos.CENTER);
		
		// CENTER
		Text deleteConnectionHeading = new Text("Which Members Do You Wish To Unconnect?");
		deleteConnectionHeading.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		
		disconnectUserID1Listing.getSelectionModel().select(0);
		disconnectUserID1Listing.setMaxHeight(100);
		disconnectUserID2Listing.getSelectionModel().select(0);
		disconnectUserID2Listing.setMaxHeight(100);
		
		ListView<String> disconnectType = new ListView<>();
		disconnectType.getItems().addAll("Friend", "Classmate", "Colleague");
		disconnectType.getSelectionModel().select(0);
		disconnectType.setMaxHeight(100);
		
		HBox disconnectListings = new HBox(20);
		disconnectListings.getChildren().addAll(disconnectUserID1Listing, disconnectUserID2Listing, disconnectType);
		disconnectListings.setAlignment(Pos.CENTER);
		
		Button btnDisconnect = new Button("Remove Connection");
		btnDisconnect.setPadding(new Insets(5, 5, 5, 5));
		btnDisconnect.setMinWidth(200);
		btnDisconnect.setOnAction(e -> {
			String disconnectUserID1 = disconnectUserID1Listing.getSelectionModel().getSelectedItem();
			String disconnectUserID2 = disconnectUserID2Listing.getSelectionModel().getSelectedItem();
			String disconnectionType = disconnectType.getSelectionModel().getSelectedItem();
			try {
				deleteConnection(disconnectUserID1, disconnectUserID2, disconnectionType);
				String disconnectionMessage = disconnectUserID1 + " & " + disconnectUserID2 + " are no longer connected as " + disconnectionType + ".";
				alertBox("Remove Connection Successful", disconnectionMessage);
				disconnectUserID1Listing.getSelectionModel().select(0);
				disconnectUserID2Listing.getSelectionModel().select(0);
				disconnectType.getSelectionModel().select(0);

			}
			catch (SamePersonException spe) {
				String speMessage = disconnectUserID1 + " & " + disconnectUserID2 + " are the same person.";
				alertBox("Remove Connection Unsuccessful", speMessage);
			}
			catch (InputErrorException iee) {
				String ieeMessage = "Can not remove this connection because " + disconnectUserID1 + "\n& " + disconnectUserID2 + " are not currently connected as " + disconnectionType + ".";
				alertBox("Remove Connection Unsuccessful", ieeMessage);
			}
			}
		);
		
		Button btnDeleteConnectionBack = new Button("Back");
		btnDeleteConnectionBack.setPadding(new Insets(5, 5, 5, 5));
		btnDeleteConnectionBack.setMinWidth(200);
		btnDeleteConnectionBack.setOnAction(e -> {
				disconnectUserID1Listing.getSelectionModel().select(0);
				disconnectUserID2Listing.getSelectionModel().select(0);
				disconnectType.getSelectionModel().select(0);
				primaryStage.setScene(frontPageScene);
			}
		);
		
		VBox deleteConnectionCenter = new VBox(20);
		deleteConnectionCenter.getChildren().addAll(deleteConnectionHeading, disconnectListings, btnDisconnect, btnDeleteConnectionBack);
		deleteConnection.setCenter(deleteConnectionCenter);
		deleteConnectionCenter.setAlignment(Pos.CENTER);
		
		// BOTTOM
		Text deleteConnectionAuthor = new Text("MiniNet is a social networking application brought to you by Benjamin Donnelly.");
		deleteConnectionAuthor.setFont(Font.font("Verdana", 9));
		deleteConnection.setBottom(deleteConnectionAuthor);
		BorderPane.setMargin(deleteConnectionAuthor, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(deleteConnectionAuthor, Pos.CENTER);
		BorderPane.setMargin(deleteConnectionAuthor, new Insets(10, 10, 10, 10));
		
		deleteConnectionScene = new Scene(deleteConnection, 750, 600);
		
		// queryConnectionScene
		BorderPane queryConnection = new BorderPane();
		
		queryConnection.setPadding(new Insets(15, 20, 10, 10));      
		
		// TOP
		Text headingQueryConnection = new Text("Query Connection");
		headingQueryConnection.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		queryConnection.setTop(headingQueryConnection);
		BorderPane.setMargin(headingQueryConnection, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(headingQueryConnection, Pos.CENTER);
		
		// CENTER
		Text queryConnectionHeading = new Text("Are These Members Connected?");
		queryConnectionHeading.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		
		queryConnectionID1Listing.getSelectionModel().select(0);
		queryConnectionID1Listing.setMaxHeight(100);
		queryConnectionID2Listing.getSelectionModel().select(0);
		queryConnectionID2Listing.setMaxHeight(100);
		
		HBox connectionListings = new HBox(20);
		connectionListings.getChildren().addAll(queryConnectionID1Listing, queryConnectionID2Listing);
		connectionListings.setAlignment(Pos.CENTER);
		
		Button btnFindOut = new Button("Find Out");
		btnFindOut.setPadding(new Insets(5, 5, 5, 5));
		btnFindOut.setMinWidth(200);
		btnFindOut.setOnAction(e -> {
			String queryUserID1 = queryConnectionID1Listing.getSelectionModel().getSelectedItem();
			String queryUserID2 = queryConnectionID2Listing.getSelectionModel().getSelectedItem();
			queryConnectionID1Listing.getSelectionModel().select(0);
			queryConnectionID2Listing.getSelectionModel().select(0);
			try {
				queryConnection("Query Successful", queryUserID1, queryUserID2);				
			}
			catch (InputErrorException iee) {
				inputErrorBox("Query Unsuccessful", "You have selected the same person in both lists.\nPlease select two different members of MiniNet to query.");
			}
			}
		);
		
		Button btnBack = new Button("Back");
		btnBack.setPadding(new Insets(5, 5, 5, 5));
		btnBack.setMinWidth(200);
		btnBack.setOnAction(e -> {
				queryConnectionID1Listing.getSelectionModel().select(0);
				queryConnectionID2Listing.getSelectionModel().select(0);
				primaryStage.setScene(frontPageScene);
			}
		);
		
		VBox queryConnectionCenter = new VBox(20);
		queryConnectionCenter.getChildren().addAll(queryConnectionHeading, connectionListings, btnFindOut, btnBack);
		queryConnection.setCenter(queryConnectionCenter);
		queryConnectionCenter.setAlignment(Pos.CENTER);
		
		// BOTTOM
		Text queryConnectionAuthor = new Text("MiniNet is a social networking application brought to you by Benjamin Donnelly.");
		queryConnectionAuthor.setFont(Font.font("Verdana", 9));
		queryConnection.setBottom(queryConnectionAuthor);
		BorderPane.setMargin(queryConnectionAuthor, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(queryConnectionAuthor, Pos.CENTER);
		BorderPane.setMargin(queryConnectionAuthor, new Insets(10, 10, 10, 10));
		
		queryConnectionScene = new Scene(queryConnection, 750, 600);
		
		// initialise window
		
		primaryStage.setTitle("MiniNet - A New Social Network");
		primaryStage.setScene(frontPageScene);
		primaryStage.show();
	}
	
	/**
	 * 
	 * @return
	 */
	private ListView<String> getListView() {
		ArrayList<String> userIDs = useable.getUserIDs();
		
		ListView<String> testing = new ListView<>();
		for (int i = 0; i < userIDs.size(); i++) {
			testing.getItems().add(userIDs.get(i));

		}
		return testing;
	}
	
	/**
	 * 
	 * @param title
	 * @param message
	 */
	private void alertBox(String title, String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Label label1 = new Label();
		label1.setText(message);
		label1.setTextAlignment(TextAlignment.CENTER);
		
		Button btnOK = new Button("Ok");
		btnOK.setOnAction(e -> window.close());
		
		VBox alertBoxLayout = new VBox(10);
		alertBoxLayout.getChildren().addAll(label1, btnOK);
		alertBoxLayout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(alertBoxLayout, 500, 125);
		window.setScene(scene);
		window.showAndWait();
	}
	
	/**
	 * 
	 * @param title
	 * @param message
	 */
	private void inputErrorBox(String title, String message) {
		Stage inputErrorWindow = new Stage();
		
		inputErrorWindow.initModality(Modality.APPLICATION_MODAL);
		inputErrorWindow.setTitle(title);
		
		Label label1 = new Label();
		label1.setText(message);
		label1.setTextAlignment(TextAlignment.CENTER);
		
		Button btnOK = new Button("Ok");
		btnOK.setOnAction(e -> inputErrorWindow.close());
		
		VBox inputErrorBoxLayout = new VBox(10);
		inputErrorBoxLayout.getChildren().addAll(label1, btnOK);
		inputErrorBoxLayout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(inputErrorBoxLayout, 500, 125);
		inputErrorWindow.setScene(scene);
		inputErrorWindow.showAndWait();
	}
	
	/**
	 * 
	 * @param title
	 * @param userID
	 */
	private void displayProfile(String title, String userID) {
		int index = useable.memberIndex(userID);
		ArrayList<Person> tempMembers = useable.getMembers();
		ArrayList<Connection> tempConnections = useable.getConnections();
		List<String> connectionUserIDs = new ArrayList<>();
		ListView<String> connectionListing = new ListView<>();
		
		for (int i = 0; i < tempConnections.size(); i++) {
			if (tempConnections.get(i).getPerson1().getUserID().equals(userID)) {
				connectionUserIDs.add(tempConnections.get(i).getPerson2().getUserID());
			}
			else if (tempConnections.get(i).getPerson2().getUserID().equals(userID)) {
				connectionUserIDs.add(tempConnections.get(i).getPerson1().getUserID());
			}
		}
		/*
		 * The following removes duplicates from connectionUserID's to ensure the profile displayed
		 * shows only unique connection entries.
		 */
		connectionUserIDs = connectionUserIDs.stream().distinct().collect(Collectors.toList());
		
		for (int i = 0; i < connectionUserIDs.size(); i++) {
			connectionListing.getItems().add(connectionUserIDs.get(i));
		}
		
		Stage displayProfileWindow = new Stage();
		
		displayProfileWindow.initModality(Modality.APPLICATION_MODAL);
		displayProfileWindow.setTitle(title);
		
		BorderPane displayProfile = new BorderPane();		
		displayProfile.setPadding(new Insets(15, 20, 10, 10));
		
		// TOP
		Text textDisplayProfile = new Text("Profile Viewer");
		textDisplayProfile.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		displayProfile.setTop(textDisplayProfile);
		BorderPane.setMargin(textDisplayProfile, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(textDisplayProfile, Pos.CENTER);
		
		// CENTER
		Text whoseProfile = new Text(userID + "'s MiniNet Profile");
		whoseProfile.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
				
		GridPane memberDetails = new GridPane();
		memberDetails.setHgap(10);
		memberDetails.setVgap(10);
		Text fullNameLabel = new Text("Full Name: ");
		Text fullName = new Text(tempMembers.get(index).getFullName());
		Text ageLabel = new Text("Age: ");
		Integer ageInteger = tempMembers.get(index).getAge();
		String ageString = ageInteger.toString();
		Text age = new Text(ageString);
		Text genderLabel = new Text("Gender: ");
		Text gender = new Text(tempMembers.get(index).getGender());
		Text statusLabel = new Text("Status: ");
		Text status = new Text(tempMembers.get(index).getStatus());
		Text photoLabel = new Text("Photo: ");
		Text photo = new Text(tempMembers.get(index).getPhoto());
		
		memberDetails.add(fullNameLabel, 25, 0, 1, 1);
		memberDetails.add(fullName, 26, 0, 1, 1);
		memberDetails.add(ageLabel, 25, 1, 1, 1);
		memberDetails.add(age, 26, 1, 1, 1);
		memberDetails.add(genderLabel, 25, 2, 1, 1);
		memberDetails.add(gender, 26, 2, 1, 1);
		memberDetails.add(statusLabel, 25, 3, 1, 1);
		memberDetails.add(status, 26, 3, 1, 1);
		memberDetails.add(photoLabel, 25, 4, 1, 1);
		memberDetails.add(photo, 26, 4, 1, 1);
		
		Text connectionListingLabel = new Text("Connections: ");
		connectionListingLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12.5));
		
		connectionListing.setMaxHeight(100);
		connectionListing.setMaxWidth(175);
		
		Button btnClose = new Button("Close");
		btnClose.setOnAction(e -> displayProfileWindow.close());
		
		Text notation = new Text();
		String s1 = "Displayed above are " + userID + "'s unique connections.";
		String s2 = "It is possible to have multiple connection types with the same person.";
		String s3 = "For example, two members can be connected as both colleagues and friends.";
		String s4 = "In this case, that person will appear only once on the members MiniNet Profile Page.";
		notation.setText(s1 + " " + s2 + " " + s3 + " " + s4);
		notation.setWrappingWidth(500);
		notation.setFont(Font.font("Verdana", 9));
		
		VBox displayProfileLayout = new VBox(10);
		displayProfileLayout.getChildren().addAll(whoseProfile, memberDetails, connectionListingLabel, connectionListing, btnClose, notation);
		displayProfile.setCenter(displayProfileLayout);
		displayProfileLayout.setAlignment(Pos.CENTER);
		
		// BOTTOM
		Text displayProfileAuthor = new Text("MiniNet is a social networking application brought to you by Benjamin Donnelly.");
		displayProfileAuthor.setFont(Font.font("Verdana", 10));
		displayProfile.setBottom(displayProfileAuthor);
		BorderPane.setMargin(displayProfileAuthor, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(displayProfileAuthor, Pos.CENTER);
		BorderPane.setMargin(displayProfileAuthor, new Insets(10, 10, 10, 10));
		
		Scene scene = new Scene(displayProfile, 750, 600);
		displayProfileWindow.setScene(scene);
		displayProfileWindow.showAndWait();
	}
	
	/**
	 * 
	 * @param userID1
	 * @param userID2
	 * @param type
	 * @throws SamePersonException
	 * @throws InputErrorException
	 */
	private void deleteConnection(String userID1, String userID2, String type) throws SamePersonException, InputErrorException {
		ArrayList<Connection> allConnections = useable.getConnections();
		Person disconnect1 = useable.getPerson(userID1);
		Person disconnect2 = useable.getPerson(userID2);
		
		if (userID1.equals(userID2)) {
			throw new SamePersonException("You are trying to connect the same person.");
		}
		
		boolean validConnection = useable.validConnection(userID1, userID2, type);
		
		if (validConnection == false) {
			throw new InputErrorException("Can not remove this connection because " + userID1 + " & " + userID2 + " are not currently connected as " + type);
		}
		
		for (int i = 0; i < allConnections.size(); i++) {
			if ((allConnections.get(i).getPerson1() == disconnect1 && allConnections.get(i).getPerson2() == disconnect2 && allConnections.get(i).getType().equals(type)) || (allConnections.get(i).getPerson1() == disconnect2 && allConnections.get(i).getPerson2() == disconnect1 && allConnections.get(i).getType().equals(type))) {
				useable.removeConnection(i);
			}
		}
		
	}
	
	/**
	 * 
	 * @param title
	 * @param userID1
	 * @param userID2
	 * @throws InputErrorException
	 */
	private void queryConnection(String title, String userID1, String userID2) throws InputErrorException {
		ArrayList<Connection> allConnections = useable.getConnections();
		ArrayList<String> connectionTypesAL = new ArrayList<>();
		ListView<String> connectionTypesLV = new ListView<>();
		Person queryConnection1 = useable.getPerson(userID1);
		Person queryConnection2 = useable.getPerson(userID2);
		Text connected = new Text();
		int counter = 0;
		
		if (userID1.equals(userID2)) {
			throw new InputErrorException("You are querying the same member");
		}
		
		for (int i = 0; i < allConnections.size(); i++) {
			if (allConnections.get(i).getPerson1() == queryConnection1 && allConnections.get(i).getPerson2() == queryConnection2) {
				connectionTypesAL.add(allConnections.get(i).getType());
				counter += 1;
			}
			else if (allConnections.get(i).getPerson2() == queryConnection1 && allConnections.get(i).getPerson1() == queryConnection2) {
				connectionTypesAL.add(allConnections.get(i).getType());
				counter += 1;
			}
		}
		
		for (int i = 0; i < connectionTypesAL.size(); i++) {
			connectionTypesLV.getItems().add(connectionTypesAL.get(i));
		}
		
		if (counter > 0) {
			connected.setText("Yes, " + userID1 + " & " + userID2 + " share " + counter + " connections"); 
		}
		else {
			connected.setText("No, " + userID1 + " & " + userID2 + " are not connected");
		}
		
		Stage queryConnectionWindow = new Stage();
		
		queryConnectionWindow.initModality(Modality.APPLICATION_MODAL);
		queryConnectionWindow.setTitle(title);
		
		BorderPane queryConnection = new BorderPane();		
		queryConnection.setPadding(new Insets(15, 20, 10, 10));
		
		// TOP
		Text textQueryConnection = new Text("Query Connection");
		textQueryConnection.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		queryConnection.setTop(textQueryConnection);
		BorderPane.setMargin(textQueryConnection, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(textQueryConnection, Pos.CENTER);
		
		// CENTER
		Text areTheyConnected = new Text("Are " + userID1 + " & " + userID2 + " connected?");
		areTheyConnected.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		
		Text differentConnections = new Text("The connections shared by " + userID1 + " & " + userID2 + " are as follows:");
		connectionTypesLV.setMaxHeight(100);
		connectionTypesLV.setMaxWidth(175);
		
		Button btnClose = new Button("Close");
		btnClose.setOnAction(e -> queryConnectionWindow.close());
		
		VBox queryConnectionLayout = new VBox(10);
		queryConnectionLayout.getChildren().addAll(areTheyConnected, connected, differentConnections, connectionTypesLV, btnClose);
		queryConnection.setCenter(queryConnectionLayout);
		queryConnectionLayout.setAlignment(Pos.CENTER);
		
		// BOTTOM
		Text queryConnectionAuthor = new Text("MiniNet is a social networking application brought to you by Benjamin Donnelly.");
		queryConnectionAuthor.setFont(Font.font("Verdana", 9));
		queryConnection.setBottom(queryConnectionAuthor);
		BorderPane.setMargin(queryConnectionAuthor, new Insets(10, 10, 10, 10));     
		BorderPane.setAlignment(queryConnectionAuthor, Pos.CENTER);
		BorderPane.setMargin(queryConnectionAuthor, new Insets(10, 10, 10, 10));
		
		Scene scene = new Scene(queryConnection, 750, 600);
		queryConnectionWindow.setScene(scene);
		queryConnectionWindow.showAndWait();
		
	}
	
	/**
	 * 
	 * @param list
	 * @param userID
	 */
	private void updateListView(ListView<String> list, String userID) {
		list.getItems().remove(userID);
	}
	
}

