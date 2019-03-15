
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import package_ATM.Alert;



public class GUI extends Application {
    // int index=0;
     int count ;
    Account acc = new Account();
    Stage window;
    Scene sceneA,sceneC, sceneB,sceneD,sceneF,sceneE,sceneG;

    public static void main(String[] args){

        launch(args);
    }



    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("ATM");
        GridPane gridA = new GridPane();
        gridA.setPadding(new Insets(10, 10, 10, 10));
        gridA.setVgap(8);
        gridA.setHgap(10);

        Label pinNumber = new Label("PIN:");
        gridA.add(pinNumber, 0, 0);

        PasswordField pinText = new PasswordField();
        gridA.add(pinText, 2, 0);
        pinText.setText(null);

        Button b1 = new Button("Enter");
        gridA.add(b1, 1, 2);

        Label res = new Label();
        gridA.add(res, 1, 3);


        b1.setOnAction(e -> {

            if (acc.ValidatePin(pinText.getText())) {

                window.setScene(sceneB);
            } else
                res.setText("Invalid PIN");
        });

        sceneA = new Scene(gridA, 350, 200);




        GridPane pane = new GridPane();

        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(8);
        pane.setHgap(10);

        Label label1 = new Label("Please choose the method you would like to perform!");
        pane.add(label1, 2, 0);

        Button depositbtn = new Button("Deposit");
        pane.add (depositbtn, 2, 1);

        Button withdrawbtn = new Button("WithDraw");
        pane.add(withdrawbtn, 3, 1);

        Button balancebtn = new Button("Balance");
        pane.add(balancebtn, 3, 3);

        Button nextbtn = new Button("Next");
        pane.add(nextbtn, 3, 2);

        Button previousbtn = new Button("Previous");
        pane.add(previousbtn, 2, 2);

        Button exitbtn = new Button("Exit");

        Label prev = new Label();
        Label next = new Label();


         //count= acc.getSize()-1;
        pane.add(exitbtn, 2, 3);
        withdrawbtn.setOnAction(e -> window.setScene(sceneC));
        depositbtn.setOnAction(e -> window.setScene(sceneD));
        exitbtn.setOnAction(e -> acc.exit());

        // setting the button sizes//
        depositbtn.setPrefHeight(250);
        depositbtn.setPrefWidth(250);
        withdrawbtn.setPrefHeight(250);
        withdrawbtn.setPrefWidth(250);
        balancebtn.setPrefHeight(250);
        balancebtn.setPrefWidth(250);
        nextbtn.setPrefHeight(250);
        nextbtn.setPrefWidth(250);
        previousbtn.setPrefHeight(250);
        previousbtn.setPrefWidth(250);
        exitbtn.setPrefHeight(250);
        exitbtn.setPrefWidth(250);
        sceneB=new Scene(pane,400,400);


        GridPane depositLayout = new GridPane();
        depositLayout.setPadding(new Insets(10, 10, 10, 10));
        depositLayout.setVgap(8);
        depositLayout.setHgap(10);

        Label depLabel = new Label("Enter money you want to deposit: ");
        GridPane.setConstraints(depLabel, 0, 1);

        TextField depInput = new TextField("");
        GridPane.setConstraints(depInput, 2, 1);
         depInput.setText(null);
        Button depButton = new Button("Done");
        GridPane.setConstraints(depButton, 1, 2);

        Button back2 = new Button("Back");
        GridPane.setConstraints(back2, 2, 2);
       /* back2.setOnAction(e -> {
            count= acc.getSize()-1;
        });*/

        Label depLabel2 = new Label();
        GridPane.setConstraints(depLabel2, 2, 4);
        depButton.setOnAction(e -> {
            //double num1 =
            if ( Double.parseDouble(depInput.getText()) > 0) {
                acc.deposit(Double.parseDouble(depInput.getText()));
                depLabel2.setText("Your Transaction was done succesfully");

            } else {
                depLabel2.setText("Invalid Amount");
            }
           // acc.getHistory(1,Double.parseDouble(String.valueOf(depInput)));
        });
        back2.setOnAction(e ->

        {
        	
        	count= acc.getSize()-1;
            window.setScene(sceneB);
        });

        depositLayout.getChildren().addAll(depLabel, depInput, depButton, back2, depLabel2);
        sceneD = new Scene(depositLayout, 600, 200);
        //  Scene sceneC = new Scene(gridB, 350, 350);



        GridPane withdraw = new GridPane();
        withdraw.setPadding(new Insets(10, 10, 10, 10));
        withdraw.setVgap(8);
        withdraw.setHgap(10);
        Label drawLabel1 = new Label("Enter money you want to Withdraw: :");
        GridPane.setConstraints(drawLabel1, 0, 1);

        TextField drawInput = new TextField();
        GridPane.setConstraints(drawInput, 2, 1);
        drawInput.setText(null);
        Button drawButton = new Button("Done");
        GridPane.setConstraints(drawButton, 1, 2);

        Button back1 = new Button("Back");
        GridPane.setConstraints(back1, 2, 2);

        Label drawLabel2 = new Label();
        GridPane.setConstraints(drawLabel2, 2, 4);

        drawButton.setOnAction(e -> {
            //double y = Double.parseDouble(drawInput.getText());
            if (acc.withdrawal(Double.parseDouble(drawInput.getText())) && Double.parseDouble(drawInput.getText()) > 0)
                drawLabel2.setText("Your Transaction was done successfully");
            else
                drawLabel2.setText("Invalid Amount");
           // acc.getHistory(2,Double.parseDouble(String.valueOf(drawInput)));
        });

        back1.setOnAction(e ->{
            count= acc.getSize()-1;

            window.setScene(sceneB);
        });

        withdraw.getChildren().addAll(drawLabel1, drawInput, drawButton, back1, drawLabel2);

        sceneC = new Scene(withdraw, 600, 200);



        Button back3 = new Button("Back");
        balancebtn.setOnAction(e -> {

            // acc.getBalance();
        	
            GridPane grr = new GridPane();
            Label balanceres = new Label();
            balanceres.setText("Your current balance  " + acc.getBalance2());
            grr.add(balanceres, 5, 5);
            grr.add(back3, 6, 7);
            sceneG = new Scene(grr, 300, 300);
            window.setScene(sceneG);
        });
        back3.setOnAction(e -> {
        	count =acc.getSize()-1;
            window.setScene(sceneB);
            //acc.getHistory(3,acc.getBalance());
        });
        Button back4 = new Button("back");

        pane.add(prev,2,4);
        //Scene sceneH = new Scene(grr1, 400, 400);
        //window.setScene(sceneH);
         // GridPane grr1 = new GridPane();
        //pane.add(back4, 3, 5);
        //Label prev = new Label();
        previousbtn.setOnAction(e -> {
        	if (count  == 0 )
        		return;
        	count = count-1;
           String a= acc.getHistory(count);
            prev.setText(a);
           // GridPane grr1 = new GridPane();
            //Label prev = new Label();
           // prev.setText(a);
             //prev.setText(acc.getHistory( type, amount));
            /*grr1.add(back4, 3, 5);
            grr1.add(prev, 2, 4);
            Scene sceneH = new Scene(grr1, 400, 400);
            window.setScene(sceneH);*/
        });
        back4.setOnAction(e -> {
            window.setScene(sceneB);
        });
        Button back5 = new Button("back");
        nextbtn.setOnAction(e -> {
            //GridPane grr2 = new GridPane();
            //Label next = new Label();
        	if (count == 4 )
        		count =0;
            count = count+1;
           String a= acc.getHistory(count);
            prev.setText(a);

            // next.setText(acc.getHistory(type,); );
          /*  grr2.add(back5, 5, 5);
            grr2.add(next, 3, 3);
            Scene scene9 = new Scene(grr2, 300, 300);
            window.setScene(scene9);*/
        });
        back5.setOnAction(e -> {
            window.setScene(sceneB);
        });
        window.setScene(sceneA);
        window.show();

    }

}