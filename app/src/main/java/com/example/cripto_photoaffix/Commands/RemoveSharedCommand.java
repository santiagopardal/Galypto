package com.example.cripto_photoaffix.Commands;

import com.example.cripto_photoaffix.FileManagement.FilesManager;
import com.example.cripto_photoaffix.Gallery.Media;
import java.util.List;

public class RemoveSharedCommand extends Command {
    @Override
    public void execute() {
        FilesManager manager = FilesManager.getInstance();
        List<String> media = manager.getShared();
        int size = media.size();

        for (int i = 0; i < size; i++)
            manager.removeFile(media.get(i));
    }

    /**
     * No añade la "media" para ahorrar espacio (muy poco) ya que no es necesario porque se va a
     * ejecutar sobre todos los archivos y no media.
     * @param media Media en la cual ejecutar la tarea.
     */
    public void addMedia(Media media) {}
}