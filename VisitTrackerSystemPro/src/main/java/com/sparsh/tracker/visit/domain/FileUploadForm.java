package com.sparsh.tracker.visit.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {

    private MultipartFile file;

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(final MultipartFile file) {
        this.file = file;
    }
}
