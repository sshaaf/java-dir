package org.acme;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.acme.filters.*;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;

@QuarkusMain
public class QMain implements QuarkusApplication {

    private static final Logger LOG = Logger.getLogger(QMain.class);

    // Set these in your application.properties
    @ConfigProperty(name = "cli.sourceImagePath")
    String testImage;

    // Set these in your application.properties
    @ConfigProperty(name = "cli.targetImagePath")
    String targetImage;

    // Set these in your application.properties
    @ConfigProperty(name = "haarcascade.filePath")
    String haarCascadeFilePath;


    @Override
    public int run(String... args) throws Exception {

        String current = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+current);
        LOG.info("Loading OpenCV "+Core.NATIVE_LIBRARY_NAME);
        LOG.info("Loading OpenCV "+Core.VERSION);
        Mat m = loadImage(testImage);
        m = detectFaces(m);
        saveImage(m, targetImage);

        videoCapture(m);
        LOG.info("Image processed and target lies here: "+targetImage);

        return 0;
    }


    /**
     * Loading the image
     */
    public Mat loadImage(String imagePath) {
        Imgcodecs imageCodecs = new Imgcodecs();
        return imageCodecs.imread(imagePath);
    }


    public Mat detectFaces(Mat imageMatrix){
        Mat df = new DetectFace(haarCascadeFilePath).process(imageMatrix);
        if(df != null)
            return df;
        else throw new IllegalArgumentException("Looking for Mat nothing found!, try passing org.opencv.core.Mat to process");
    }

    public Mat videoCapture(Mat imageMatrix){
        Mat  vc = new VCapture(haarCascadeFilePath).process(imageMatrix);
        if(vc != null)
            return vc;
        else throw new IllegalArgumentException("Looking for Mat nothing found!, try passing org.opencv.core.Mat to process");
    }

    public void saveImage(Mat imageMatrix, String targetPath) {
        Imgcodecs imgcodecs = new Imgcodecs();
        imgcodecs.imwrite(targetPath, imageMatrix);
    }

}