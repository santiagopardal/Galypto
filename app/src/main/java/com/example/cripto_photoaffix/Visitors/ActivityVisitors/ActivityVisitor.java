package com.example.cripto_photoaffix.Visitors.ActivityVisitors;

import com.example.cripto_photoaffix.Activities.GalleryActivities.GalleryActivity;
import com.example.cripto_photoaffix.Activities.GalleryActivities.ImageViewerActivity;
import com.example.cripto_photoaffix.Activities.GalleryActivities.VideoViewerActivity;
import com.example.cripto_photoaffix.Activities.LoginActivity;

public interface ActivityVisitor {
    public void visit(LoginActivity activity);
    public void visit(GalleryActivity activity);
    public void visit(ImageViewerActivity activity);
    public void visit(VideoViewerActivity activity);
}
