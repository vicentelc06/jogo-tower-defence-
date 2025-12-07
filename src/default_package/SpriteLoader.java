package default_package;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.awt.image.BufferedImage;




public class SpriteLoader {
    private static final HashMap<String, Image> cache = new HashMap<>();
    public static final String SPRITE_DIR = "sprites"; // pasta onde colocar os PNGs

    // nomes padrão que o código usa:
    // grass.png, empty.png, enemy.png, tower1.png, tower2.png, tower3.png, shot.png
    public static void loadDefaultSprites() {
        load("grass.png");
        load("empty.png");
        load("enemy.png");
        load("tower1.png");
        load("tower2.png");
        load("tower3.png");
        load("shot.png");
    }

    public static Image load(String fileName) {
        try {
            if (cache.containsKey(fileName)) return cache.get(fileName);
            Image img = new ImageIcon(SPRITE_DIR + "/" + fileName).getImage();
            cache.put(fileName, img);
            return img;
        } catch (Exception e) {
            // fallback: create a simple placeholder
            Image placeholder = createPlaceholder(fileName);
            cache.put(fileName, placeholder);
            return placeholder;
        }
    }

    private static Image createPlaceholder(String id) {
        int size = 48;
        Image img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) img.getGraphics();
        // pick color by id heuristics
        Color c = Color.MAGENTA;
        if (id.contains("grass") || id.contains("empty")) c = new Color(120, 200, 120);
        else if (id.contains("enemy")) c = new Color(200, 80, 80);
        else if (id.contains("tower")) c = new Color(80, 120, 200);
        else if (id.contains("shot")) c = new Color(240, 200, 80);

        g.setColor(c);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, size - 1, size - 1);
        g.dispose();
        return img;
    }

    public static Image getSpriteForChar(char c) {
        switch (c) {
            case 'Z':
                return load("enemy.png");
            case 'T':
                // default tower sprite
                return load("tower1.png");
            case '>':
                return load("shot.png");
            case '.':
            default:
                return load("grass.png");
        }
    }

    public static Image getTile(String name) {
        return load(name);
    }
}
