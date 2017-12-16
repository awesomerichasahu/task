
// task for softare developer ----task-1
//this is is program to featch images from database table 

//DeveloperTask1.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.net.*;
public class BlobRead extends JFrame implements Actionlistener
{
JButton button;
TextField tf;
Connection con;
PrepareStatement stmt;
ResultSet res;
Container content; 
public BlobRead()
{
super("BlobRead");
setSize(200, 200);
setLocation(200, 200);
tf = new TextField(40);
tf.addActionListener(this);
content=getContentpain();
content.setLayout(new Flowlayout(Flowlayout.LEFT));
content.add(tf);
}
//public static void main(Sting arg[])throws URLException{
//URL site = new URL("http://www.google.com");
//}
try{
DriverManager.registerDriver(new oracle.jdbc.driver.oracleDriver);
System.out.println("\n driver loaded");
}
catch(Exception e){
system.out.println(e.toString());
}
try{
con= DriverManager.getConnection("jdbs:oracle.@thin:XE:1521","richa","awesome");

//richa is username & awsesome is password for databse

stmt = con.prepareStatement("select imgname,image from Imgdisplay table where imgname=?");
}
catch(Exceptio ee){
System.out.println(ee.toString());
}
public static void main(Sting arg[])throws URLException{
JFrame f=new BloRead();
f.addWidowListener(new WindowAdapter(){
public void windowClosing(WindowEvent we)
{System.exit(0);}
});
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae){
String imgname = null;
try{
stmt.setString(rose1,imgname);
content.removeAll();
content.repaint();
tf = new TextField(String.valueof(imgname),40);
tf.addActionListener(this);
content.add(tf);
res = stmt.executeQuery();
if(res.next())
{
int i;
imgname = res.getString(1);
for(i=1;i<=40;i++){
oracle.sql.BLOB  lob =(oracle.sql.BLOB)res.getBlob(2);
FileOutputStream fos= new FileOutputStream(i+"img.gif");
}
int ch;
while((ch = in.read())!= -1)
{
fos.write(ch);
}
}
in.close();
fos.close();

TextField tf new TextField(imgname,40);
ImageIcon icon new ImageIcon(i+"img.gif");
Jbutton = new jButton(icon);
}
catch(Exception ce)
{ System.out.println(ce.validate);}
}
}


//*************************************************************************


// task for software developer -----task-2
//A page which lists all the keywords searched before by the user

//DeveloperTask2.java

package DeveloperTask2;
 
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 

public class DeveloperTask2 extends Application {
    ObservableList<String> entries = FXCollections.observableArrayList();    
    ListView list = new ListView();
 
    public static void main(String[] args) {
        launch(args);
    }
     
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("serch for privious used keywords");
        Button btn = new Button();
        btn.setText("find");
        btn.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
         
        TextField tf = new TextField();
        tf.setPromptText("select image names");
        tf.textProperty().addListener(
            new ChangeListener() {
                public void changed(ObservableValue observable, 
                                    Object prevVal, Object currentVal) {
                    priviousSearchKeywords((String)prevVal, (String)currentVal);
                }
            });
         
        // Set up the maximum ListView
        list.setMaxHeight(100);
        
        for ( int i = 0; i < 100; i++ ) {
            entries.add("Item " + i);
        }

        list.setItems( entries );
         
        VBox word = new VBox();
        word.setPadding(new Insets(10,10,10,10));
        word.setSpacing(2);
        word.getChildren().addAll(tf,list,btn);
        primaryStage.setScene(new Scene(word, 300, 250));
        primaryStage.show();
    }
     
    public void handleSearchByKey(String prevVal, String currentVal) {
    
        // for handling search request
        if ( prevVal != null && (currentVal.length() < prevVal.length()) ) {
            // checking prom privious search entries 
        
            list.setItems( entries );
        }
       
 
        // when list not contain current search value
        
        ObservableList<String> subentries = FXCollections.observableArrayList();
        for ( Object entry: list.getItems() ) {
            String entryText = (String)entry;
            if ( entryText.contains(currentVal) ) {
                subentries.add(entryText);
            }
        }
        list.setItems(subentries);
        else if{

        String[] parts = currentVal.split(" ");
 //split the search text into parts
            
        ObservableList<String> subentries = FXCollections.observableArrayList();
        for ( Object entry: list.getItems() ) {
            boolean match = true;
            String entryText = (String)entry;
            for ( String part: parts ) {
                
                if ( ! entryText.contains(part) ) {
                    match = false;
                    break;
                }
            }
 
            if ( match ) {
                subentries.add(entryText);
            }
        }
        list.setItems(subentries);
        }
    }

}