package org.acme.filters;


import java.io.IOException;



import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;

import org.opencv.videoio.VideoCapture;

public class VCapture implements Filter {

	private String haarcascadeFilePath = null;

    public VCapture(String haarCascadeFilePath){
        this.haarcascadeFilePath = haarCascadeFilePath;
    }
    
    @Override
    public Mat process(Mat src) {

		try{
			videoFace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return src;
	
	}

	public void videoFace() throws IOException {
		VideoCapture capture = new VideoCapture(0);
		Mat image = new Mat();
		int index = 0;
		if (capture.isOpened()) {
			while (true) {
				capture.read(image);
				HighGui.imshow("Face", getFace(image));
				index = HighGui.waitKey(1);
				if (index == 27) {
					break;
				}
			}
		}
	}


	public Mat getFace(Mat image) throws IOException {
		Mat df = new DetectFace(haarcascadeFilePath).process(image);
		if(df !=null)
			return df;
		 else throw new IllegalArgumentException("Looking for Mat nothing found!, try passing org.opencv.core.Mat to process");
	}

}
