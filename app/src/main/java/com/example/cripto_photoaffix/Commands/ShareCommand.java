package com.example.cripto_photoaffix.Commands;

import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.example.cripto_photoaffix.Activities.MyActivity;
import com.example.cripto_photoaffix.ActivityTransferer;
import com.example.cripto_photoaffix.Factories.IntentsFactory.IntentFactory;
import com.example.cripto_photoaffix.Factories.IntentsFactory.ShareIntentFactory;
import java.io.File;

public abstract class ShareCommand extends Command {
    protected Intent createIntent(File file) {
        IntentFactory factory = new ShareIntentFactory();
        Intent intent = factory.create();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        MyActivity activity = ActivityTransferer.getInstance().getActivity();

        Uri path = FileProvider.getUriForFile(activity,
                "com.example.cripto_photoaffix.fileprovider", file);

        intent.putExtra(Intent.EXTRA_STREAM, path);

        return intent;
    }
}
