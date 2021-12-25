import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.io.*;

public class Apps extends Application {
    TextField cat1_marks;
    TextField cat2_marks;
    TextField quiz1_marks;
    TextField quiz2_marks;
    TextField da_marks;
    TextField fat_marks;
    TextField labcat1_marks;
    TextField labcat2_marks;
    TextField ass1_marks;
    TextField ass2_marks;
    TextField ass3_marks;
    TextField labfat_marks;
    TextField review1_marks;
    TextField review2_marks;
    TextField review3_marks;
    GridPane theory() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label cat1 = new Label("CAT1 : ");
        grid.add(cat1, 0, 7);
        cat1_marks = new TextField();
        grid.add(cat1_marks, 1, 7);

        Label cat2 = new Label("CAT2 : ");
        grid.add(cat2, 0, 8);
        cat2_marks = new TextField();
        grid.add(cat2_marks, 1, 8);

        Label quiz1 = new Label("Quiz 1 : ");
        grid.add(quiz1, 0, 9);
        quiz1_marks = new TextField();
        grid.add(quiz1_marks, 1, 9);

        Label quiz2 = new Label("Quiz 2 : ");
        grid.add(quiz2, 0, 10);
        quiz2_marks = new TextField();
        grid.add(quiz2_marks, 1, 10);

        Label da = new Label("Digital Assignment : ");
        grid.add(da, 0, 11);
        da_marks = new TextField();
        grid.add(da_marks, 1, 11);

        Label fat = new Label("FAT : ");
        grid.add(fat, 0, 12);
        fat_marks = new TextField();
        grid.add(fat_marks, 1, 12);
        return grid;
    }

    GridPane lab() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label labcat1 = new Label("LabCAT1 : ");
        grid.add(labcat1, 0, 7);
        labcat1_marks = new TextField();
        grid.add(labcat1_marks, 1, 7);

        Label labcat2 = new Label("LabCAT2 : ");
        grid.add(labcat2, 0, 8);
        labcat2_marks = new TextField();
        grid.add(labcat2_marks, 1, 8);

        Label ass1 = new Label("Assessment 1 : ");
        grid.add(ass1, 0, 9);
        ass1_marks = new TextField();
        grid.add(ass1_marks, 1, 9);

        Label ass2 = new Label("Assessment 2 : ");
        grid.add(ass2, 0, 10);
        ass2_marks = new TextField();
        grid.add(ass2_marks, 1, 10);

        Label ass3 = new Label("Assessment 3 : ");
        grid.add(ass3, 0, 11);
        ass3_marks = new TextField();
        grid.add(ass3_marks, 1, 11);

        Label labfat = new Label("LabFAT : ");
        grid.add(labfat, 0, 12);
        labfat_marks = new TextField();
        grid.add(labfat_marks, 1, 12);

        return grid;
    }
    
    GridPane project() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label review1 = new Label("Review 1 : ");
        grid.add(review1, 0, 7);
        review1_marks = new TextField();
        grid.add(review1_marks, 1, 7);

        Label review2 = new Label("Review 2 : ");
        grid.add(review2, 0, 8);
        review2_marks = new TextField();
        grid.add(review2_marks, 1, 8);

        Label review3 = new Label("Review 3 : ");
        grid.add(review3, 0, 9);
        review3_marks = new TextField();
        grid.add(review3_marks, 1, 9);

        return grid;
    }

    public void start(Stage s) throws Exception 
    {
        s.setTitle("Vellore Institute of Technology, Vellore");
        Menu home = new Menu("Home");
        Menu courses = new Menu("Course Types");

        MenuItem home1 = new MenuItem("Faculty Info");
        MenuItem home2 = new MenuItem("Grading Schemes");

        MenuItem course1 = new MenuItem("TH - Theory Only");          
        MenuItem course2 = new MenuItem("LO - Lab Only");          
        MenuItem course3 = new MenuItem("ETL - Embedded Theory and Lab");         
        MenuItem course4 = new MenuItem("ETLP - Embedded Theory, Lab and Project");   

        home.getItems().addAll(home1, home2);
        courses.getItems().addAll(course1, course2, course3, course4);

        MenuBar mb = new MenuBar();
        mb.getMenus().addAll(home, courses);
    
        FileInputStream input = new FileInputStream("vit.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(750);

        Label l1 = new Label("", imageView);
        Label l2 = new Label("Welcome to Vellore Institute of Technology, Vellore");
        l2.setWrapText(true);
        l2.setPadding(new Insets(20));
        l2.setFont(Font.font ("Arial", 35));
        
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                String name = "Faculty Name: Jaisankar N\n";
                String empID = "Employee ID: 10247\n";
                String cabin = "Cabin Number: SJT-323-A\n";
                String designation = "Designation: Higher Academic Grade\n";
                String school = "School: SCOPE\n";
                String email = "Email: njaisankar@vit.ac.in";
                l2.setText("Faculty Information\n" + name + empID + cabin + designation + school + email);
            }
        };

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                String th = "\n\t1. TH – Theory Only (100%)\n";
                String lo = "\t2. LAB – Lab Only (100%)\n";
                String etl = "\t3. ETL – Theory (75%) + Lab (25%)\n";
                String etlp = "\t4. ETLP - Theory (50%) + Lab (25%) + Project (25%)";
                l2.setText("Types of courses along with weightage is given below :" + th + lo + etl + etlp);
            }
        };

        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                GridPane grid = theory();
                VBox vb = new VBox(mb, grid);
                Scene scene = new Scene(vb, 1000, 600);
                Text scenetitle = new Text("Theory Only Course - TH\nMark Entry: ");
                Label note = new Label("\n\n\nTheory Component (100%)\nMaximum marks for CATs are 30, Quizzes and Assignments are 10, and FAT is 60.");
                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                note.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                note.setWrapText(true);
                grid.add(scenetitle, 0, 0, 2, 1);
                grid.add(note, 0, 0, 2, 2);

                Label totals = new Label("TOTAL MARKS = 0");
                totals.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
                grid.add(totals, 0, 14, 2, 1);

                EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        double total = Double.parseDouble(cat1_marks.getText())/2 +
                                        Double.parseDouble(cat2_marks.getText())/2 +
                                        Double.parseDouble(quiz1_marks.getText()) +
                                        Double.parseDouble(quiz2_marks.getText()) +
                                        Double.parseDouble(da_marks.getText()) +
                                        ((Double.parseDouble(fat_marks.getText())/60)*40);
        
                        totals.setText("TOTAL MARKS = " + String.format("%.2f",total));
                    }
                };
                Button button = new Button("Calculate Total");
                button.setOnAction(event1);
                grid.add(button, 1, 13);
                s.setScene(scene);
            }
        };

        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                GridPane grid = lab();
                VBox vb = new VBox(mb, grid);
                Scene scene = new Scene(vb, 1000, 600);
                Text scenetitle = new Text("Lab Only Course - LO\nMark Entry: ");
                Label note = new Label("\n\n\nLab Component (100%)\nMaximum marks for LabCATs are 15, Assessments are 10, and LabFAT is 50.");
                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                note.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                note.setWrapText(true);
                grid.add(scenetitle, 0, 0, 2, 1);
                grid.add(note, 0, 0, 2, 2);

                Label totals = new Label("TOTAL MARKS = 0");
                totals.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
                grid.add(totals, 0, 14, 2, 1);

                EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        double total = Double.parseDouble(labcat1_marks.getText()) +
                                        Double.parseDouble(labcat2_marks.getText()) +
                                        Double.parseDouble(ass1_marks.getText()) +
                                        Double.parseDouble(ass2_marks.getText()) +
                                        Double.parseDouble(ass3_marks.getText()) +
                                        ((Double.parseDouble(labfat_marks.getText())/50)*40);
        
                        totals.setText("TOTAL MARKS = " + String.format("%.2f",total));
                    }
                };
                Button button = new Button("Calculate Total");
                button.setOnAction(event1);
                grid.add(button, 1, 13);
                s.setScene(scene);
            }
        };

        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Text scenetitle = new Text("\n   Embedded Theory and Lab Course - ETL\n   Mark Entry: ");
                Label note = new Label("Theory Component(75%) - Lab Component (25%)");
                Label th_note = new Label("Maximum marks for CATs are 30, Quizzes and Assignments are 10, and FAT is 60.");
                Label lab_note = new Label("Maximum marks for LabCATs are 15, Assessments are 10, and LabFAT is 50.");
                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                note.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                note.setPadding(new Insets(20,0,0,20));
                th_note.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                th_note.setPadding(new Insets(0,0,0,20));
                lab_note.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                lab_note.setPadding(new Insets(0,0,0,20));
                
                Label totals = new Label("TOTAL MARKS = 0");
                totals.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
                totals.setPadding(new Insets(20));

                EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        double total = ((Double.parseDouble(cat1_marks.getText())/2 + Double.parseDouble(cat2_marks.getText())/2 + Double.parseDouble(quiz1_marks.getText()) + Double.parseDouble(quiz2_marks.getText()) + Double.parseDouble(da_marks.getText()) + ((Double.parseDouble(fat_marks.getText())/60)*40))*0.75) +
                                ((Double.parseDouble(labcat1_marks.getText()) + Double.parseDouble(labcat2_marks.getText()) + Double.parseDouble(ass1_marks.getText()) + Double.parseDouble(ass2_marks.getText()) + Double.parseDouble(ass3_marks.getText()) + ((Double.parseDouble(labfat_marks.getText())/50)*40))*0.25);
        
                        totals.setText("TOTAL MARKS = " + String.format("%.2f",total));
                    }
                };
                Button button = new Button("Calculate Total");
                button.setOnAction(event1);

                HBox hbox = new HBox(theory(), lab());
                VBox vb = new VBox(mb,scenetitle, note, th_note, lab_note, hbox, button, totals);
                VBox.setMargin(button, new Insets(0,0,0,20));
                Scene scene = new Scene(vb, 1000, 600);
                s.setScene(scene);
            }
        };

        EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Text scenetitle = new Text("\n   Embedded Theory, Lab and Project Course - ETLP\n   Mark Entry: ");
                Label note = new Label("Theory Component(50%) - Lab Component (25%) - Project Component (25%)");
                Label th_note = new Label("Maximum marks for CATs are 30, Quizzes and Assignments are 10, and FAT is 60.");
                Label lab_note = new Label("Maximum marks for LabCATs are 15, Assessments are 10, and LabFAT is 50.");
                Label j_note = new Label("Maximum marks for Review 1 is 20, Review 2 is 30 and Review 3 is 50.");
                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                note.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                note.setPadding(new Insets(20,0,0,20));
                th_note.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                th_note.setPadding(new Insets(0,0,0,20));
                lab_note.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                lab_note.setPadding(new Insets(0,0,0,20));
                j_note.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                j_note.setPadding(new Insets(0,0,0,20));
                
                Label totals = new Label("TOTAL MARKS = 0");
                totals.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
                totals.setPadding(new Insets(20));

                EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        double total = ((Double.parseDouble(cat1_marks.getText())/2 + Double.parseDouble(cat2_marks.getText())/2 + Double.parseDouble(quiz1_marks.getText()) + Double.parseDouble(quiz2_marks.getText()) + Double.parseDouble(da_marks.getText()) + ((Double.parseDouble(fat_marks.getText())/60)*40))*0.5) +
                                ((Double.parseDouble(labcat1_marks.getText()) + Double.parseDouble(labcat2_marks.getText()) + Double.parseDouble(ass1_marks.getText()) + Double.parseDouble(ass2_marks.getText()) + Double.parseDouble(ass3_marks.getText()) + ((Double.parseDouble(labfat_marks.getText())/50)*40))*0.25) +
                                ((Double.parseDouble(review1_marks.getText()) + Double.parseDouble(review2_marks.getText()) + Double.parseDouble(review3_marks.getText()))*0.25);
        
                        totals.setText("TOTAL MARKS = " + String.format("%.2f",total));
                    }
                };
                Button button = new Button("Calculate Total");
                button.setOnAction(event1);

                HBox hbox = new HBox(theory(), lab(), project());
                VBox vb = new VBox(mb,scenetitle, note, th_note, lab_note, hbox, button, totals);
                VBox.setMargin(button, new Insets(0,0,0,20));
                Scene scene = new Scene(vb, 1000, 600);
                s.setScene(scene);
            }
        };
  
        home1.setOnAction(event1);
        home2.setOnAction(event2);

        course1.setOnAction(event3);
        course2.setOnAction(event4);
        course3.setOnAction(event5);
        course4.setOnAction(event6);
        
        VBox vb = new VBox(mb, l1, l2);
        Scene sc = new Scene(vb, 1000, 600);
        s.setScene(sc);
        s.show(); 
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
