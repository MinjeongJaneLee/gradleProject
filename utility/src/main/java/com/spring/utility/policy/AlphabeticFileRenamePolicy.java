package com.spring.utility.policy;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;


@Slf4j
public class AlphabeticFileRenamePolicy implements FileRenamePolicy {

    @Override
    public File rename(File file) {
        String filename = file.getName();
        String parent = file.getParent();
        String extension = FilenameUtils.getExtension(filename);

        File renameFile = null;
        while ((renameFile = randomFile(parent, extension)).exists()) {
            ;
        }
        log.debug("rename is {}", renameFile.getAbsolutePath());

        return renameFile;
    }


    private File randomFile(String parent, String extension) {
        return new File(parent, String.format("%s.%s", RandomStringUtils.randomAlphabetic(15).toLowerCase(), extension));
    }

}
