package org.acme.filters;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;



public class Grey2RGB implements Filter{

    @Override
    public Mat process(Mat src) {
        if(src != null) {
            Mat dst = src;
            Imgproc.cvtColor(src, dst, Imgproc.COLOR_GRAY2RGB);

            return dst;
        }
        else throw new IllegalArgumentException("Looking for Mat nothing found!, try passing org.opencv.core.Mat to process");
    }
}
