package ui;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

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

    public void initialize() {
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
    
    
    /*
     * El metodo sirve para guardar la imagen que se ha dibujado
     * Se puede escoger la ruta donde sera guardado el archivo
     */
    public void onSave() {
        try {
            Image snapshot = canvas.snapshot(null, null);
            JFileChooser saveAs = new JFileChooser();
            saveAs.setApproveButtonText("Guardar");
            saveAs.showSaveDialog(null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File(saveAs.getSelectedFile()+""));
        } catch (IOException e) {
            System.out.println("Failed to save image");
        }
    }

    public void onExit() {
        Platform.exit();
    }
}