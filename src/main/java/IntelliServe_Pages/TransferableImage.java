package IntelliServe_Pages;

import java.awt.datatransfer.*;
import java.awt.*;

public class TransferableImage implements Transferable {

    private final Image image;

    public TransferableImage(Image img) {
        this.image = img;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) {
        return image;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] { DataFlavor.imageFlavor };
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return DataFlavor.imageFlavor.equals(flavor);
    }
}
