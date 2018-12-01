package quickresponseCodes.implementation;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import quickresponseCodes.Author;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Author(name="Ankit Sharma",date="28 June 2018")
public class Reader {
    public static String decodedText;

    public static String decodeQRCode(File qrCodeimage) throws IOException,NotFoundException{
        BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }

    public static void decode(String filename) {
        File file=new File(filename);
        try {
            decodedText = decodeQRCode(file);
        }
        catch (Exception h){h.printStackTrace();}
        System.out.println("Decoded text = " + decodedText);
    }
}