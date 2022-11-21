import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickerMaker {
    public void make(InputStream inputStream, String fileName) throws Exception {

        // InputStream inputStream = new FileInputStream(new File("Entrada/Filme.jpg"));
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BNTM4NjIxNmEtYWE5NS00NDczLTkyNWQtYThhNmQyZGQzMjM0XkEyXkFqcGdeQXVyODk4OTc3MTY@.jpg").openStream();
        BufferedImage Original = ImageIO.read(inputStream);

        int width = Original.getWidth();
        int height = Original.getHeight();
        int newHeight = height + 450;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(Original,0, 0, null);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 300);
        graphics.setColor(Color.yellow);
        graphics.setFont(font);

        graphics.drawString("MIAU", 500, newHeight - 80);

        File dir = new File("C:/Users/vinic/Desktop/Imersao Alura/saida");
        dir.mkdir();

    ImageIO.write(newImage, "png", new File(dir, fileName));

    }

}

