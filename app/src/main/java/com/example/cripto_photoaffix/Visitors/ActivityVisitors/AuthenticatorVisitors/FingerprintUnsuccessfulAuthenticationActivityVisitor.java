package com.example.cripto_photoaffix.Visitors.ActivityVisitors.AuthenticatorVisitors;

import com.example.cripto_photoaffix.Activities.GalleryActivities.GalleryActivity;
import com.example.cripto_photoaffix.Activities.GalleryActivities.ImageViewerActivity;
import com.example.cripto_photoaffix.Activities.GalleryActivities.VideoViewerActivity;
import com.example.cripto_photoaffix.Activities.LoginActivity;
import com.example.cripto_photoaffix.Visitors.ActivityVisitors.ActivityVisitor;

public class FingerprintUnsuccessfulAuthenticationActivityVisitor implements ActivityVisitor {

    @Override
    public void visit(LoginActivity activity) {
        activity.loginUnsuccessful();
    }

    @Override
    public void visit(GalleryActivity activity) {}

    @Override
    public void visit(ImageViewerActivity activity) {}

    @Override
    public void visit(VideoViewerActivity activity) {}
}
