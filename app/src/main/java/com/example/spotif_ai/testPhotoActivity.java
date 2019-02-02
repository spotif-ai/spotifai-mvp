package com.example.spotif_ai;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.FaceDetector;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;
import com.google.protobuf.ByteString;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static android.graphics.Bitmap.CompressFormat.JPEG;

public class testPhotoActivity extends AppCompatActivity {
    ImageView mapImage;
    TextView smilingProb;
    FirebaseVisionFaceDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_photo);
        Intent data = getIntent();
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        mapImage = findViewById(R.id.map_image);
        mapImage.setImageBitmap(imageBitmap);

        smilingProb = findViewById(R.id.smiling_prob);

        FirebaseVisionFaceDetectorOptions highAccuracyOpts =
                new FirebaseVisionFaceDetectorOptions.Builder()
                        .setPerformanceMode(FirebaseVisionFaceDetectorOptions.ACCURATE)
                        .setLandmarkMode(FirebaseVisionFaceDetectorOptions.ALL_LANDMARKS)
                        .setClassificationMode(FirebaseVisionFaceDetectorOptions.ALL_CLASSIFICATIONS)
                        .build();
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(imageBitmap);
        detector = FirebaseVision.getInstance().getVisionFaceDetector(highAccuracyOpts);

//        Task<List<FirebaseVisionFace>> result =
//                detector.detectInImage(image)
//                        .addOnSuccessListener(
//                                new OnSuccessListener<List<FirebaseVisionFace>>() {
//                                    @Override
//                                    public void onSuccess(List<FirebaseVisionFace> faces) {
//                                        FirebaseVisionFace face = faces.get(0);
//                                        String prob = String.valueOf(face.getSmilingProbability());
//                                        smilingProb.setText(prob);
//                                    }
//                                })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        // Task failed with an exception
//                                        // ...
//                                    }
//                                });

    }


}
