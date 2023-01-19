package org.acme.filters;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;



public class DetectFace implements Filter{

    private String haarcascadeFilePath = null;

    public DetectFace(String haarCascadeFilePath){
        this.haarcascadeFilePath = haarCascadeFilePath;
    }

    @Override
    public Mat process(Mat src) {
        if(src != null) {
       // Mat img_gray = new BGR2Gray().process(src);
        MatOfRect faces = new MatOfRect();
        CascadeClassifier cc = new CascadeClassifier(haarcascadeFilePath);
        Mat dst = src;
        cc.detectMultiScale(dst,faces, 1.1f,5,2  , new Size(30,30));

        System.out.println(String.format("Detected %s faces",
                faces.toArray().length));

        // Drawing boxes
        for (Rect rect : faces.toArray()) {
            Imgproc.rectangle(
                    dst,
                    new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 0, 255),
                    3
            );
        }
            return dst;
        }
        else throw new IllegalArgumentException("Looking for Mat nothing found!, try passing org.opencv.core.Mat to process");
    }
}
