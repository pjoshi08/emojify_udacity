package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;


public class Emojifier {

    private static final String TAG = Emojifier.class.getSimpleName();

    // COMPLETED (1): Create a Java class called Emojifier
    // COMPLETED (2): Create a static method in the Emojifier class called detectFaces() which detects and logs the number of faces in a given bitmap.

    /**
     * Method to detect faces in a bitmap
     * */
    public static void detectFaces(Context context, Bitmap image){

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        if(detector.isOperational()) {

            Frame frame = new Frame.Builder().setBitmap(image).build();

            // Detect Faces
            SparseArray<Face> faces = detector.detect(frame);

            Log.d(TAG, "Faces Detected: " + faces.size());

            if (faces.size() == 0) Toast.makeText(context, "There are no faces in this image",
                    Toast.LENGTH_LONG).show();
        } else Log.d(TAG, "Detector is not operational");

        detector.release();
    }
}
