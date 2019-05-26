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
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PaintController {
	
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private CheckBox eraser;
    
    @FXML
    private ComboBox<String> brushSize;
    
    @FXML
    private Circle circles1;
    
    //private ArrayList<Circle> circles;

    
    /**
     * This method initializes the options to choose the pencil size and sets 
     * the pane to enable the user to paint or erase over it.
     */
    @FXML
    public void initialize() {
    	brushSize.setValue("12");
    	brushSize.getItems().add("2");
    	brushSize.getItems().add("4");
    	brushSize.getItems().add("6");
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
    	FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG =  new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg =  new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG =  new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

        File file = fileChooser.showOpenDialog(null);
        
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            canvas.getGraphicsContext2D().drawImage(image, 0, 0);
        } catch (IOException e) {}
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