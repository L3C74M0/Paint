package ui;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.IOException;

public class PaintController {

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private CheckBox eraser;
    
    @FXML
    private ComboBox<String> brushSize;

    
    /**
     * This method initializes the options to choose the pencil size and sets 
     * the pane to enable the user to paint or erase over it.
     */
    @FXML
    public void initialize() {
    	brushSize.setValue("12");
        brushSize.getItems().add("8");
        brushSize.getItems().add("9");
        brushSize.getItems().add("10");
        brushSize.getItems().add("11");
        brushSize.getItems().add("12");
        brushSize.getItems().add("14");
        brushSize.getItems().add("16");
        brushSize.getItems().add("18");
        brushSize.getItems().add("20");
        brushSize.getItems().add("22");
        brushSize.getItems().add("24");
        brushSize.getItems().add("26");
        brushSize.getItems().add("28");
        brushSize.getItems().add("32");
        brushSize.getItems().add("36");
        brushSize.getItems().add("40");
        brushSize.getItems().add("44");
        brushSize.getItems().add("48");
        brushSize.getItems().add("52");
        brushSize.getItems().add("60");
        brushSize.getItems().add("68");
        brushSize.getItems().add("72");
        brushSize.getItems().add("78");
        brushSize.getItems().add("82");
    	GraphicsContext g = canvas.getGraphicsContext2D();

    	canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getValue());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if (eraser.isSelected()) {
                g.clearRect(x, y, size, size);
            } else {
                g.setFill(colorPicker.getValue());
                g.fillRect(x, y, size, size);
            }
        });
	}
    
    /**
     * This method allows the user to choose an image from file system and add it to the canvas,
     * where it's possible to draw over it.
     * Pre: an image with .jgp or .png format has to be selected and the <<OK>> button in the 
     * file chooser has to be pressed, otherwise the image isn't going to be loaded.
     * Post: the image is going to be displayed in the canvas.
     * @param event the event received after clicking on the <<Load image>> button.
     */
    @FXML
    void loadImage(ActionEvent event) {
    	JFileChooser fc = new JFileChooser();
    	fc.addChoosableFileFilter(new FileNameExtensionFilter(".Images","jpg", "png", "PNG", "JPEG", "JPG"));
    	fc.setApproveButtonText("Load");
    	int result = fc.showSaveDialog(null);
    	if(result == JFileChooser.APPROVE_OPTION) {
    		Image img = new Image(fc.getSelectedFile().toURI().toString(), canvas.getWidth(), canvas.getHeight(), false, true);
        	canvas.getGraphicsContext2D().drawImage(img, 0, 0);
    	}
    }
    
    /**
     * This method allows to save the drawn image in the specified path.
     * Pre: the specified path has to exist in the file system.
     * Post: The image will be saved successfully.
     */
    public void onSave() {
        try {
            Image snapshot = canvas.snapshot(null, null);
            JFileChooser saveAs = new JFileChooser();
            saveAs.setApproveButtonText("Save");
            saveAs.showSaveDialog(null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File(saveAs.getSelectedFile()+".png"));
        } catch (IOException e) {
            System.out.println("Failed to save image");
        }
    }
    
    

    /**
     * This methods allows to close the program when the exit button is pressed.
     */
    public void onExit() {
        Platform.exit();
    }
}