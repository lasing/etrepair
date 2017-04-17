package com.liveneo.etrepair.log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.CountingQuietWriter;
import org.apache.log4j.spi.LoggingEvent;

public class LVRollingFileAppender extends RollingFileAppender {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    private long             nextRollover     = 0;

    @Override
    public void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize) throws IOException {
        String newFileName = fileName.replace("[date]", simpleDateFormat.format(new Date()));
        int lastIdx = newFileName.lastIndexOf("/");
        File file = new File(newFileName.substring(0, lastIdx));
        if (!file.exists()) {
            file.mkdir();
        }
        super.setFile(newFileName, append, this.bufferedIO, this.bufferSize);
        if (append) {
            File f = new File(fileName);
            ((CountingQuietWriter) qw).setCount(f.length());
        }
    }

    @Override
    protected void subAppend(LoggingEvent event) {
        String directory = fileName.substring(0, fileName.lastIndexOf("/"));
        String newFilePath = directory.substring(0, directory.lastIndexOf("/") + 1) + simpleDateFormat.format(new Date());
        File newFile = new File(newFilePath);
        fileName = newFilePath + fileName.substring(fileName.lastIndexOf("/"));
        if (!newFile.exists()) {
            newFile.mkdirs();
            rollOver();
        }
        if (!new File(fileName).exists()) {
            rollOver();
        }
        super.subAppend(event);
        if (fileName != null && qw != null) {
            long size = ((CountingQuietWriter) qw).getCount();
            if (size >= maxFileSize && size >= nextRollover) {
                rollOver();
            }
        }
    }
}
