import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Music {
    Music() throws Exception {
        File file = new File("LoginPicture/hon.mp3");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream stream = new BufferedInputStream(fis);
        Player player = new Player(stream);
        player.play();

    }
}