package com.example.cripto_photoaffix.Activities.GalleryActivities;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.cripto_photoaffix.Factories.ButtonFactories.ButtonFactory;
import com.example.cripto_photoaffix.Factories.ButtonFactories.ViewerButtons.RotateLeftButtonFactory;
import com.example.cripto_photoaffix.Factories.ButtonFactories.ViewerButtons.RotateRightButtonFactory;
import com.example.cripto_photoaffix.R;
import com.example.cripto_photoaffix.Visitors.ActivityVisitors.ActivityVisitor;

public class ImageViewerActivity extends ContentViewerActivity {
    protected ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.imageView);

        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.delete_button).setOnTouchListener(mDelayHideTouchListener);
    }

    @Override
    public void onBackPressed() {
        imageView.setImageBitmap(null);

        super.onBackPressed();
    }

    @Override
    public void loadMedia() {
        imageView = (ImageView) mContentView;
        imageView.setImageBitmap(BitmapFactory.decodeFile(media.getFullPath()));
    }

    @Override
    protected void initializeButtons() {
        super.initializeButtons();
        View view = findViewById(R.id.fullscreen_content_controls);

        ButtonFactory factory = new RotateLeftButtonFactory(view, R.id.rotate_left_button);
        factory.create();

        factory = new RotateRightButtonFactory(view, R.id.rotate_right_button);
        factory.create();
    }

    public void rotateImage(float degrees) {
        imageView.setRotation(imageView.getRotation() + degrees);
    }

    @Override
    public void accept(ActivityVisitor visitor) {
        visitor.visit(this);
    }
}
