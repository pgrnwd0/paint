package com.paint;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.paint.Color;

/**
 * JavaFX App
 * Preston Greenwood
 * CSC 210, FALL 2024
 */
public class App extends Application {

    private static Scene scene;
    private Brush brush;
    public static void main(String[] args) {
        launch();
    }
    
    public void drawSquare(int x, int y, Group group) {
    	if (y > 35 && x > 50) {
    		Rectangle square = new Rectangle();
    		square.setX(x);
    		square.setY(y);
    		square.setWidth(brush.getSize());
    		square.setHeight(brush.getSize());
    		square.setFill(brush.getColor());
    		group.getChildren().add(square);
    	}
    }
    public void drawDot(int x, int y, Group group) {
    	if (y > 35 && x > 50) {
    		Circle circle = new Circle();
    		circle.setCenterX(x);
    		circle.setCenterY(y);
    		circle.setRadius(brush.getSize());
    		circle.setFill(brush.getColor());
    		group.getChildren().add(circle);
    	}
    }
    public void drawTriangle(int x, int y, Group group) {
    	if (y > 35 && x > 50) {
    		Polygon triangle = new Polygon();
    		triangle.getPoints().addAll(new Double[]{
    			    (double) x, (double) y,
    			    (double) x - brush.getSize(), (double) y + brush.getSize(),
    			    (double) x + brush.getSize(), (double) y + brush.getSize() });
    		triangle.setFill(brush.getColor());
    		group.getChildren().add(triangle);
    	}
    }
    

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Preston Greenwood");
        brush = new Brush();
        
        // set up the canvas
        Group root = new Group();

        // color select
        Button colorBlue = new Button("Blue");
        colorBlue.setLayoutX(200.0);
        colorBlue.setOnAction((e) -> {
        	brush.setColor(Color.BLUE);
        });
        Button colorBlack = new Button("Black");
        colorBlack.setOnAction((e) -> {
        	brush.setColor(Color.BLACK);
        });
        colorBlack.setLayoutX(245.0);
        
        Button colorRed = new Button("Red");
        colorRed.setLayoutX(300.0);
        colorRed.setOnAction((e) -> {
        	brush.setColor(Color.RED);
        });
        root.getChildren().add(colorBlack);
        root.getChildren().add(colorBlue);
        root.getChildren().add(colorRed);
        
        // change brush shape
        
        Button square = new Button("square");
        square.setOnAction((e) -> {
        	brush.changeShape("square");
        });
        square.setLayoutY(45.0);
        Button circle = new Button("circle");
        circle.setOnAction((e) -> {
        	brush.changeShape("circle");
        });
        circle.setLayoutY(90.0);
        Button triangle = new Button("triangle");
        triangle.setOnAction((e) -> {
        	brush.changeShape("triangle");
        });
        triangle.setLayoutY(135.0);
        
        root.getChildren().add(square);
        root.getChildren().add(circle);
        root.getChildren().add(triangle);
        // add plus and minus buttons
        Button plus = new Button("+");
        Button minus = new Button("-");
        plus.setLayoutX(100.0);
        minus.setLayoutX(130.0);
        root.getChildren().add(plus);
        root.getChildren().add(minus);
        
        // actions for plus and minus
        plus.setOnAction((ActionEvent) -> {
        	brush.setSize(brush.getSize() + 1);
        });
        
        minus.setOnAction((ActionEvent) -> {
        	brush.setSize(brush.getSize() - 1);
        });
        
        // clear button
        Button clear = new Button("CLEAR");
        clear.setOnAction((ActionEvent) -> {
        	root.getChildren().clear();
        	root.getChildren().add(clear);
        	root.getChildren().add(plus);
            root.getChildren().add(minus);
            root.getChildren().add(colorBlue);
            root.getChildren().add(colorBlack);
            root.getChildren().add(colorRed);
            root.getChildren().add(square);
            root.getChildren().add(circle);
            root.getChildren().add(triangle);
        });
        root.getChildren().add(clear);
        scene = new Scene(root, 640, 480);
        
        // mouse click event handler
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        	  public void handle(MouseEvent mouseEvent) {
        			  int x = (int) mouseEvent.getX();
        			  int y = (int) mouseEvent.getY();
        			  System.out.println(x + " " + y);
        			  if (brush.getShape().equals("circle")) {
        				 drawDot(x, y, root);
        			  }
        			  if (brush.getShape().equals("square")) {
        				  drawSquare(x,y,root);
        			  }
        			  if (brush.getShape().equals("triangle")) {
        				  drawTriangle(x,y,root);
        			  }
        	  }
        	});
        
        // mouse dragged event Handler
        scene.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent> () {
        	public void handle(MouseEvent mouseEvent) {
        		int x = (int) mouseEvent.getX();
  			  	int y = (int) mouseEvent.getY();
  			  	System.out.println(x + " " + y);
  			  	if (brush.getShape().equals("circle")) {
  			  		drawDot(x, y, root);
  			  	}
  			  	if (brush.getShape().equals("square")) {
  			  		drawSquare(x,y,root);
  			  	}
  			  	if (brush.getShape().equals("triangle")) {
  			  		drawTriangle(x,y,root);
  			  	}
        	}
        });
        
        stage.setScene(scene);
        stage.show();
    }
   
}