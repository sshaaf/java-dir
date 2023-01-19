package org.acme.filters;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;



public class PyrUp implements Filter{

    @Override
    public Mat process(Mat src) {
        if(src != null) {
            Mat dst = src;
            Imgproc.pyrUp(src, dst);
            return dst;
        }
        else throw new IllegalArgumentException("Looking for Mat nothing found!, try passing org.opencv.core.Mat to process");
    }
}
